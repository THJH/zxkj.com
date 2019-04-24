package com.zxkj.utils;

import java.util.UUID;

public class ZxkjUtil {
    public static String genRandFilename(String filename) {//abc.jpg
        String suffix = filename.substring(filename.lastIndexOf('.'));
        return UUID.randomUUID().toString() + suffix;
    }

    public static void main(String[] args) {
        System.out.println(genRandFilename("abc.jpg"));
    }
}
