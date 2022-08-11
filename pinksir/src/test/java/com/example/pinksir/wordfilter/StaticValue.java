package com.example.pinksir.wordfilter;

import java.io.File;



public class StaticValue {
    private static XEyes ge = new XEyes();

    public static void initGoldenEyes() {
        ge = new XEyes();
        File file = new File("src/main/resources/static/sensitive.txt");
        ge.indexSensitiveFromFile(file);
        System.out.println("reload configure " + file.getAbsolutePath());
    }

    public static XEyes getGoldenEyes() {
        initGoldenEyes();
        return ge;
    }
}
