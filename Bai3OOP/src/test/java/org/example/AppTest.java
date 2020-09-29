package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void assertLog2Console() {
        Log log = new Log(1);
        log = (Log) log.inIt();
        String strAcutal = log.WriteLog("Nghia", "dep zai");
        String strExpect = "Log2ConsoleNghia dep zai";
        assertEquals(strAcutal,strExpect);

    }

    @Test
    public void assertLog2Email() {
        Log log = new Log(2);
        log = (Log) log.inIt();
        String strAcutal = log.WriteLog("Nghia", "dep zai");
        String strExpect = "Log2EmailNghia dep zai";
        assertEquals(strAcutal,strExpect);
    }

    @Test
    public void assertLog2File() {
        Log log = new Log(3);
        log = (Log) log.inIt();
        String strAcutal = log.WriteLog("Nghia", "dep zai");
        String strExpect = "Log2FileNghia dep zai";
        assertEquals(strAcutal,strExpect);
    }
}
