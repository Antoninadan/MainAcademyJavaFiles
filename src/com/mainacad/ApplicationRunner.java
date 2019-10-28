package com.mainacad;

import com.mainacad.helper.ConnectionHelperInfo;
import com.mainacad.model.ConnectionInfo;
import com.mainacad.service.FileService;

import java.util.logging.Logger;

public class ApplicationRunner {
    private static final Logger LOGGER = Logger.getLogger(ApplicationRunner.class.getName());

    public static void main(String[] args) {
//        String text = "some text \nI want to be written\n"; // at the end \n
//        FileService.writeTextToFile(text, "test01.txt");
//        String input = FileService.readTextFromFile("test01.txt");
//        LOGGER.info("\n" + input);
//
//        FileService.copeFile("cat.jpg", "cat_cope.jpg");
//        FileService.moveFileToFolder("cat.jpg", "filescopy");

        for (int i = 0; i < 5; i++) {
            ConnectionInfo connectionInfo = ConnectionHelperInfo.getRandomConnactionInfo();
            FileService.writeTextToFile(connectionInfo.toString(), "connection.txt", true);
        }

    }


}
