package org.example;

public class Log2File extends Log {
    @Override
    public String WriteLog(String type, String content) {
        String strLog = super.WriteLog(type, content);
        return ("Log2File" + strLog);
    }
}
