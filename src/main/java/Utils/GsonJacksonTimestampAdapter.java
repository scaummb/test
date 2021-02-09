//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Utils;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.sql.Timestamp;

public class GsonJacksonTimestampAdapter implements JsonDeserializer<Timestamp>, JsonSerializer<Timestamp> {
    public GsonJacksonTimestampAdapter() {
    }

    public JsonElement serialize(Timestamp src, Type typeOfSrc, JsonSerializationContext context) {
        return src != null ? new JsonPrimitive(src.getTime()) : null;
    }

    public Timestamp deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Long time = json.getAsLong();
        return time != null ? new Timestamp(time) : null;
    }
}
