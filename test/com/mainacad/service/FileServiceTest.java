package com.mainacad.service;

import com.mainacad.helper.ConnectionHelperInfo;
import com.mainacad.model.ConnectionInfo;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {
    private static final String TEXT_FILE_NAME = "test_text_file.txt";
    private static final String BYTES_FILE_NAME = "test_bytes_file.obj";

    @BeforeAll
    static void setUpBeforeAll(){
        byte[] testBytes = FileService.getBytesFromFile("cat.jpg");
        FileService.writeBytesToFile(testBytes, BYTES_FILE_NAME);
    }

    @BeforeEach
    void setUp() {
        FileService.writeTextToFile("", TEXT_FILE_NAME, false);
        FileService.writeBytesToFile(new byte[0], BYTES_FILE_NAME);

        ConnectionInfo connectionInfo = ConnectionHelperInfo.getRandomConnactionInfo();
        FileService.writeTextToFile(connectionInfo.toString(), TEXT_FILE_NAME, false);
    }

    @AfterEach
    void tearDown() {
        File testTextFile = new File(FileService.FILES_DIR + FileService.SEP + TEXT_FILE_NAME);
        testTextFile.delete();
    }

    @AfterAll
    static void tearDownAfterAll() {
        File testBytesFile = new File(FileService.FILES_DIR + FileService.SEP + BYTES_FILE_NAME);
        testBytesFile.delete();
    }

    @Test
    void readTextFromFile() {
        String testText = FileService.readTextFromFile(TEXT_FILE_NAME);
        assertNotNull(testText);
        assertTrue(testText.contains(" "));
        assertTrue(testText.length() > 22);
    }

    @Test
    void readConnectionsFromFile() {
        List<ConnectionInfo> testObj = FileService.readConnectionsFromFile(BYTES_FILE_NAME);
        assertNotNull(testObj);
        assertTrue(testObj.size() > 0);
//        assertNotNull
        assertTrue(testObj.contains(" "));
//        assertTrue(testText.length() > 22);
    }

    @Test
    void getBytesFromFile() {
        byte[] testBytes = FileService.getBytesFromFile(BYTES_FILE_NAME);

    }
}