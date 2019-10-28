package com.mainacad.helper;

import com.mainacad.model.ConnectionInfo;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionHelperInfoTest {

    @org.junit.jupiter.api.Test
    void getRandomConnactionInfo() {
        ConnectionInfo testObj = ConnectionHelperInfo.getRandomConnactionInfo();
        assertNotNull(testObj);
        assertNotNull(testObj.getConnectionTime());
        assertNotNull(testObj.getIp());
        assertNotNull(testObj.getSessionId());
        assertTrue(testObj.getSessionId() > 10000 & testObj.getSessionId() < 9999);


    }
}