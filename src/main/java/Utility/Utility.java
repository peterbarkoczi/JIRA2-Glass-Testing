package Utility;

import java.io.File;
import java.io.IOException;

public class Utility {

    private static String getBasePath() {
        String basePath;
        try {
            basePath = new File("./").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
            basePath = "We're not in Hawkins anymore...";
        } return basePath;
    }

    public static String getDriverPath(String driverFileName) {
        return getResourcePath("drivers", driverFileName);
    }

    public static String getResourcePath(String folderName, String fileName) {
        String resourcesRelPath = "/src/test/resources/";
        return getBasePath() + resourcesRelPath + folderName + "/" + fileName;
    }

}
