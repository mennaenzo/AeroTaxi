package com.company;

import java.io.File;
import java.io.IOException;

public abstract class Storage {

    public Storage() {
    }

    public static void createFiles(String pathname) {
        File files = new File(pathname);

        try{
            files.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
