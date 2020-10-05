package org.example;

public class XuLyChuoi {
    public String xuLyChuoi(String chuoi) {
        if (chuoi == null || chuoi.isEmpty()) {
            return null;
        }
        String[] words = chuoi.split(" ");

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
            String wordBegin = words[i].substring(0, 1).toUpperCase();
            words[i] = wordBegin + words[i].substring(1);
        }
        String result = String.join(" ", words);
        return result;
    }
}
