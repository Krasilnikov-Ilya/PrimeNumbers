import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class GsonJson {
    void writeJsonFromList(List<Integer> list) {

        try (Writer writer = new FileWriter("src/test/resources/test.json")) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<Integer> readFromJson(String file) {

        Gson gson = new Gson();

        Type listType = new TypeToken<List<Integer>>() {}.getType();

        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<Integer> list = gson.fromJson(reader, listType);

        return list;
    }
}
