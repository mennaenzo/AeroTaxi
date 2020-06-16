package com.company.fileManagement;

import com.company.enterprise.User;
import com.company.enums.FilePath;
import com.company.planes.Plane;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public abstract class Storage {

    public Storage() {
    }

    // A partir de una ruta, crea un archivo si es que no existe.
    public  void createFiles(String pathname) {
        File files = new File(pathname);
        if (!files.exists()) {
            try {
                files.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo " + files.getPath().toString() + " ya existe.");
        }
    }

    // Vacia toda la informacion que hay en el archivo

    public void emptyFile(String pathname) {
        // Vacia el archivo que se manda por parametro, si es que existe el mismo
        File file = new File(pathname);
        if (file.exists()) {
            try {
                BufferedWriter bWriter = new BufferedWriter(new FileWriter(pathname));
                bWriter.write("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}