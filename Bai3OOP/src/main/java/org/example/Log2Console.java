package org.example;

public class Log2Console extends Log {

    public Log2Console() {


    }

    public String WriteLog(String type, String content) {
        String strLog = super.WriteLog(type, content);
        return ("Log2Console"+strLog);
    }
}
