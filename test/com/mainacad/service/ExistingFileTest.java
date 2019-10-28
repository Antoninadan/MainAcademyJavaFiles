package com.mainacad.service;

import com.mainacad.helper.ConnectionHelperInfo;
import com.mainacad.model.ConnectionInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mainacad.helper.ConnectionHelperInfo;
import com.mainacad.model.ConnectionInfo;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExistingFileTest {
    private static final String FILE_NAME = "connection.txt";
    private List<ConnectionInfo> connectionInfoList;

    @BeforeEach
    void setUp(){
        connectionInfoList = FileService.readConnectionsFromFile(FILE_NAME);
    }

    @AfterAll
    void tearDown(){
        boolean append = false;
        for (ConnectionInfo connectionInfo:connectionInfoList){
            FileService.writeTextToFile(connectionInfo.toString(), FILE_NAME, append);
            append = true;
        }
    }

    @Test
    void testReadAndWriteObject(){
        ConnectionInfo connectionInfo = ConnectionHelperInfo.getRandomConnactionInfo();
        FileService.writeTextToFile(connectionInfo.toString(), FILE_NAME, false);
        List<ConnectionInfo> testObj = FileService.readConnectionsFromFile(FILE_NAME);
        assertEquals(testObj.get(0).getIp(), connectionInfo.getIp());
        assertEquals(testObj.get(0).getSessionId(), connectionInfo.getSessionId());
        assertEquals(testObj.get(0).getConnectionTime(), connectionInfo.getConnectionTime());
    }
}
