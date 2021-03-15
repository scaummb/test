//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Utils;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Date;

public class GsonJacksonDateAdapter implements JsonDeserializer<Date>, JsonSerializer<Date> {
	public GsonJacksonDateAdapter() {
	}

	public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
		return src != null ? new JsonPrimitive(src.getTime()) : null;
	}

	public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		Long time = json.getAsLong();
		return time != null ? new Date(time) : null;
	}
}
