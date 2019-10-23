package com.mainacad.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    public static final String MAIN_DIR = System.getProperty("user.dir");
    public static final String SEP = System.getProperty("file.separator");
    public static final String FILES_DIR = MAIN_DIR + SEP + "files";

    // work with text
    public static void writeTextToFile(String text, String fileName) {
        checkTargetDir();

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FILES_DIR + SEP + fileName);
            fileWriter.write(text);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void checkTargetDir() {
        File file = new File(FILES_DIR);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public static String readTextFromFile(String fileName) {
        String out = "";
        return out;
    }
}
