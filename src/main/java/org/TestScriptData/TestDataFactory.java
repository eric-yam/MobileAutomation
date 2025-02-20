package org.TestScriptData;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDataFactory {
    public static JsonObject readJson(String filepath) {
        File file = new File(filepath);
        JsonObject jsonObj = null;
        try {
            JsonElement jsonElement = JsonParser.parseReader(new FileReader(file));
            jsonObj = jsonElement.getAsJsonObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return jsonObj;
    }

    private static <T> List<T> mapJsonToClass(JsonObject jsonObj, Class<T> currentClass) {
        List<T> deserializedObjs = new ArrayList<>();
        Gson gson = new Gson();

        //Convert JSON object into Java object
        for (String key : jsonObj.keySet()) {
            String jsonObjAsString = jsonObj.get(key).toString();
            //Document how gson works here
            //how to pass in class type in java
            deserializedObjs.add(gson.fromJson(jsonObjAsString, currentClass));
        }

        return deserializedObjs;
    }


    @DataProvider(name = "AppiumSetupData")
    public static Iterator<AppiumSetupData> appiumSetupDataProvider() {
        JsonObject jsonObj = readJson("src/test/resources/TestData/appium_setup_data.json");
        List<AppiumSetupData> asdList = mapJsonToClass(jsonObj, AppiumSetupData.class);

        return asdList.iterator();
    }

//        Alternative Approach For return type Iterator<Object[]> or Object[][] for DataProviders
    @DataProvider(name = "LoginTest")
    public static Iterator<Object[]> loginTestDataProvider() {
        JsonObject jsonObj = readJson("src/test/resources/TestData/login_test_data.json");

        Object[] temporary = mapJsonToClass(jsonObj, LoginTestData.class).toArray();
        List<Object[]> list = new ArrayList<>();

        for (Object obj : temporary) {
            list.add(new Object[]{obj});
        }

        return list.iterator();
    }
}
