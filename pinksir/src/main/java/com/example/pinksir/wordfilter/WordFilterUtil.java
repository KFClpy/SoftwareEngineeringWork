package com.example.pinksir.wordfilter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class WordFilterUtil {
    private static XEyes ge = new XEyes();

    String filePath;
    public  void initGoldenEyes() {
        ge = new XEyes();
//        String path ="F:\\BaiduNetdiskDownload\\" +
//                "SoftwareEngineeringWork\\pinksir\\src\\main\\resources\\conf\\sensitive.txt";
        String path="//home//files//sensitive.txt";
        File file = new File(path);
        ge.indexSensitiveFromFile(file);
        System.out.println("reload configure " + file.getAbsolutePath());
    }

    public  XEyes getGoldenEyes() {
        initGoldenEyes();
        return ge;
    }
}

