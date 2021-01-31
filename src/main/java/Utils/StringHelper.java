//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.io.*;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidParameterException;
import java.sql.Timestamp;
import java.util.*;
import java.util.Map.Entry;

public class StringHelper {
    private static Gson gson;

    public StringHelper() {
    }

    public static String toJsonString(Object obj) {
        return gson.toJson(obj);
    }

    public static Object fromJsonString(String jsonString, Class<?> clz) {
        return gson.fromJson(jsonString, clz);
    }

    public static String toObjectSerializedString(Serializable object) {
        assert object != null;

        ByteArrayOutputStream bs = new ByteArrayOutputStream();

        try {
            ObjectOutputStream os = new ObjectOutputStream(bs);
            os.writeObject(object);
            os.close();
            bs.close();
            return Base64.encodeBase64URLSafeString(bs.toByteArray());
        } catch (IOException var3) {
            throw new RuntimeException("Unable to serialize: " + object, var3);
        }
    }

    public static Object fromObjectSerializedString(String base64EncodedString) {
        if (base64EncodedString == null) {
            return null;
        } else {
            byte[] content = Base64.decodeBase64(base64EncodedString);
            ByteArrayInputStream bs = new ByteArrayInputStream(content);

            try {
                ObjectInputStream is = new ObjectInputStream(bs);
                Object obj = is.readObject();
                is.close();
                bs.close();
                return obj;
            } catch (IOException var5) {
                throw new RuntimeException("Unable to deserialize: " + base64EncodedString, var5);
            } catch (ClassNotFoundException var6) {
                throw new RuntimeException("Unable to deserialize: " + base64EncodedString, var6);
            }
        }
    }

    public static String toObjectSerializedHexString(Serializable object) {
        assert object != null;

        ByteArrayOutputStream bs = new ByteArrayOutputStream();

        try {
            ObjectOutputStream os = new ObjectOutputStream(bs);
            os.writeObject(object);
            os.close();
            bs.close();
            return toHexString(bs.toByteArray());
        } catch (IOException var3) {
            throw new RuntimeException("Unable to serialize: " + object, var3);
        }
    }

    public static Object fromObjectSerializedHexString(String hexString) {
        if (hexString == null) {
            return null;
        } else {
            byte[] content = fromHexString(hexString);
            ByteArrayInputStream bs = new ByteArrayInputStream(content);

            try {
                ObjectInputStream is = new ObjectInputStream(bs);
                Object obj = is.readObject();
                is.close();
                bs.close();
                return obj;
            } catch (IOException var5) {
                throw new RuntimeException("Unable to deserialize: " + hexString, var5);
            } catch (ClassNotFoundException var6) {
                throw new RuntimeException("Unable to deserialize: " + hexString, var6);
            }
        }
    }

    public static String toHexString(byte[] data) {
        return data == null ? null : Hex.encodeHexString(data);
    }

    public static byte[] fromHexString(String hexString) {
        if (hexString == null) {
            return null;
        } else {
            try {
                return Hex.decodeHex(hexString.toCharArray());
            } catch (DecoderException var2) {
                throw new InvalidParameterException("Invalid hex string format");
            }
        }
    }

    public static String getterNameFromProperty(String propertyName) {
        assert propertyName != null && propertyName.length() > 1;

        return "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
    }

    public static String setterNameFromProperty(String propertyName) {
        assert propertyName != null && propertyName.length() > 1;

        return "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
    }

    public static void toStringMap(String prefix, Object obj, Map<String, String> map) {
        assert map != null;

        if (obj != null) {
            Class<?> clz = obj.getClass();
            if (clz.isPrimitive() || Number.class.isAssignableFrom(clz) || String.class == clz || Date.class.isAssignableFrom(clz) || Timestamp.class == clz || clz.isEnum()) {
                if (Date.class.isAssignableFrom(clz)) {
                    map.put(prefix, String.valueOf(((Date)obj).getTime()));
                    return;
                } else if (Timestamp.class == clz) {
                    map.put(prefix, String.valueOf(((Timestamp)obj).getTime()));
                    return;
                } else {
                    map.put(prefix, obj.toString());
                    return;
                }
            }

            int i;
            Object item;
            if (List.class.isAssignableFrom(clz)) {
                for(i = 0; i < ((List)obj).size(); ++i) {
                    item = ((List)obj).get(i);
                    toStringMap(prependWith(prefix, String.format("[%d]", i), false), item, map);
                }

                return;
            }

            if (Map.class.isAssignableFrom(clz)) {
                Iterator var11 = ((Map)obj).keySet().iterator();

                while(var11.hasNext()) {
                    item = var11.next();
                    toStringMap(prependWith(prefix, String.format("[%s]", item.toString()), false), ((Map)obj).get(item), map);
                }

                return;
            }

            if (clz.isArray()) {
                for(i = 0; i < ((Object[])((Object[])obj)).length; ++i) {
                    item = ((Object[])((Object[])obj))[i];
                    toStringMap(prependWith(prefix, String.format("[%d]", i), false), item, map);
                }

                return;
            }

            List<Field> fields = ReflectionHelper.getFlattenFields(obj.getClass());
            Iterator var5 = fields.iterator();

            while(var5.hasNext()) {
                Field field = (Field)var5.next();
                if ((field.getModifiers() & 8) == 0) {
                    Object val = null;

                    try {
                        field.setAccessible(true);
                        val = field.get(obj);
                    } catch (Exception var9) {
                        throw new RuntimeException("Unexpected exception", var9);
                    }

                    if (val != null) {
                        toStringMap(prependWith(prefix, field.getName(), true), val, map);
                    }
                }
            }
        }

    }

    private static String prependWith(String prefix, String name, boolean separator) {
        if (prefix != null) {
            return separator ? prefix + "." + name : prefix + name;
        } else {
            return name;
        }
    }

    public static String interpolate(String source) {
        return interpolate(source, new Mapper() {
            public String map(String s) {
                return System.getenv(s);
            }
        });
    }

    public static String interpolate(String source, final Map<String, String> lookupMap) {
        return interpolate(source, new Mapper() {
            public String map(String s) {
                return lookupMap != null ? (String)lookupMap.get(s) : null;
            }
        });
    }

    public static String interpolate(String source, Mapper mapper) {
        if (source != null && !source.isEmpty()) {
            StringBuffer sbToken = new StringBuffer();
            StringBuffer sb = new StringBuffer();
            int i = 0;

            for(boolean matchingInProgress = false; i < source.length(); ++i) {
                if (matchingInProgress) {
                    if (source.charAt(i) != '}') {
                        sbToken.append(source.charAt(i));
                    } else {
                        String interpolated = mapper.map(sbToken.toString().trim());
                        if (interpolated != null) {
                            sb.append(interpolated);
                        }

                        matchingInProgress = false;
                    }
                } else if (source.charAt(i) == '$') {
                    if (i < source.length() - 1 && source.charAt(i + 1) == '{') {
                        matchingInProgress = true;
                        sbToken = new StringBuffer();
                        ++i;
                    } else {
                        sb.append(source.charAt(i));
                    }
                } else {
                    sb.append(source.charAt(i));
                }
            }

            return sb.toString();
        } else {
            return source;
        }
    }

    public static String join(String separator, String... tokens) {
        assert separator != null;

        assert tokens != null;

        StringBuffer sb = new StringBuffer();
        int i = 0;
        String[] var4 = tokens;
        int var5 = tokens.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String token = var4[var6];
            if (i++ > 0) {
                sb.append(separator).append(token);
            } else {
                sb.append(token);
            }
        }

        return sb.toString();
    }

    public static String toCamelCase(String value) {
        StringTokenizer toekn = new StringTokenizer(value, "_");
        StringBuilder str = new StringBuilder(toekn.nextToken());

        while(toekn.hasMoreTokens()) {
            String s = toekn.nextToken();
            str.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1));
        }

        return str.toString();
    }

    public static boolean hasContent(String val) {
        return val != null && !val.isEmpty();
    }

    public static String normalizeSpace(String str) {
        if (!hasContent(str)) {
            return str;
        } else {
            int size = str.length();
            char[] newChars = new char[size];
            int count = 0;
            int whitespacesCount = 0;
            boolean startWhitespaces = true;

            for(int i = 0; i < size; ++i) {
                char actualChar = str.charAt(i);
                boolean isWhitespace = Character.isWhitespace(actualChar);
                if (!isWhitespace) {
                    startWhitespaces = false;
                    newChars[count++] = actualChar == 160 ? 32 : actualChar;
                    whitespacesCount = 0;
                } else {
                    if (whitespacesCount == 0 && !startWhitespaces) {
                        newChars[count++] = " ".charAt(0);
                    }

                    ++whitespacesCount;
                }
            }

            if (startWhitespaces) {
                return "";
            } else {
                return (new String(newChars, 0, count - (whitespacesCount > 0 ? 1 : 0))).trim();
            }
        }
    }

    public static String concatenateUrl(String base, String relative) {
        if (base == null) {
            return relative;
        } else {
            StringBuffer sb = new StringBuffer(base);
            if (!base.endsWith("/")) {
                sb.append("/");
            }

            if (relative != null) {
                if (relative.startsWith("/")) {
                    sb.append(relative.substring(1));
                } else {
                    sb.append(relative);
                }
            }

            return sb.toString();
        }
    }

    public static void queryStringToParamMap(String queryString, Map<String, String> paramMap) {
        if (hasContent(queryString)) {
            String[] tokens = queryString.split("&");
            String[] var3 = tokens;
            int var4 = tokens.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String token = var3[var5];
                String[] param = token.split("=");
                if (param.length == 2) {
                    try {
                        paramMap.put(URLDecoder.decode(param[0], "UTF-8"), URLDecoder.decode(param[1], "UTF-8"));
                    } catch (UnsupportedEncodingException var9) {
                        assert false;
                    }
                }
            }

        }
    }

    public static String paramMapToQueryString(Map<String, String> paramMap) {
        StringBuffer sb = new StringBuffer();
        Iterator var2 = paramMap.entrySet().iterator();

        while(var2.hasNext()) {
            Entry<String, String> entry = (Entry)var2.next();
            if (sb.length() > 0) {
                sb.append("&");
            }

            try {
                sb.append(URLEncoder.encode((String)entry.getKey(), "UTF-8")).append("=").append(URLEncoder.encode((String)entry.getValue(), "UTF-8"));
            } catch (UnsupportedEncodingException var5) {
                sb.append(URLEncoder.encode((String)entry.getKey())).append("=").append(URLEncoder.encode((String)entry.getValue()));
            }
        }

        return sb.toString();
    }

    static {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new GsonJacksonDateAdapter());
        builder.registerTypeAdapter(Timestamp.class, new GsonJacksonTimestampAdapter());
        gson = builder.create();
    }

    public interface Mapper {
        String map(String var1);
    }
}
