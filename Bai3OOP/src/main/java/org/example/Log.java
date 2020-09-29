package org.example;

public class Log {
    public int conflig;

    public Log() {

    }

    public String WriteLog(String type, String content) {
        return(type + " " + content);
    }

    public Log(int conflig) {
        this.conflig = conflig;
    }

    public Object inIt() {
        if (conflig == 1) {
            return new Log2Console();
        }
        if (conflig == 2) {
            return new Log2Email();
        }
        if (conflig == 3) {
            return new Log2File();
        } else {
            return null;
        }

    }
}

