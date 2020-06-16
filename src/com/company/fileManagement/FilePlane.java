package com.company.fileManagement;

import com.company.enums.FilePath;
import com.company.planes.Plane;
import com.google.gson.*;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarOutputStream;

public   class  FilePlane extends Storage{

    public FilePlane() {
    }

    // Escribe en un archivo un ArrayList


    public  void writeFilePlane(ArrayList<Plane> xSave, String pathname) {

        FilePlane filePlane = new FilePlane();
        ArrayList<Plane> completeList = (filePlane.readFilePlane(pathname)); //Lee el archivo antes de escribir, para no sobreecribirlo.
        completeList.addAll(xSave);
        BufferedWriter bWriter= null;
        try {
            FileWriter fileWriter = new FileWriter(pathname);
            bWriter=new BufferedWriter(fileWriter);
            Gson gson = new GsonBuilder().setPrettyPrinting().create(); //Crea un gson con un diseño(de  lo que se imprime en consola) mas legible
            gson.toJson(completeList,completeList.getClass(),bWriter); // Escribe en el archivo
            //System.out.println("es   "+ gson.toJson(planeSave)); Devuelve un String de lo que hay se va a guardar en el archivo
            System.out.println("La operacion de escritura en el archivo "+ pathname + " se realizo correctamente.");
        } catch (IOException e) {
            System.out.println("Se produjo el siguiente error al escribir el archivo:"+ e.getMessage());
        }
        finally {
            try {
                if(bWriter!= null){
                    bWriter.close();  //Se cierra el BufferedReader si es que contiene informacion.
                }
            } catch (IOException e) {
                System.out.println("No se pudo cerrar el arcivo"+ pathname + " correctamente, error: "+e.getMessage());
            }
        }
    }

    // A partir de una ruta, lee un archivo.

    public  ArrayList readFilePlane (String pathname) {

        ArrayList<Plane> list = new ArrayList<>();
        BufferedReader bReader = null;
        File file = new File(pathname);
        if(file.length()!=0){
            try {
                bReader = new BufferedReader(new FileReader(new File(pathname)));
                Gson gson = new Gson();
                // String planes = gson.toJson(FilePath.PLANES.getPathname());
                Type typeArrayPlanes = new TypeToken<ArrayList<Plane>>() {}.getType(); // Se hace una referencia del tipo de dato, en este caso un ArrayList.
                list = gson.fromJson(bReader, typeArrayPlanes); // list almacena un ArrayList con a informacion del archivo.
                System.out.println("La operacion de lectura se realizo correctamente.");
                bReader.close();

            } catch (IOException e) {
                System.out.println("Se produjo el siguiente error al leer el archivo: " + e.getMessage());
            }
        }
        else{
            System.out.println("El archivo no contiene datos");
        }
        return list; // Devuelve el contenido del archivo
    }
}


/*
public static void writeFilePlane(ArrayList<Plane> planeSave) {

    BufferedWriter bWriter= null;
        try {
            FileWriter fileWriter = new FileWriter(FilePath.PLANES.getPathname());
            bWriter=new BufferedWriter(fileWriter);
            Gson gson = new GsonBuilder().setPrettyPrinting().create(); //Crea un gson con un diseño(de  lo que se imprime en consola) mas legible
            gson.toJson(planeSave,planeSave.getClass(),bWriter); // Escribe en el archivo
            //System.out.println("es   "+ gson.toJson(planeSave)); Devuelve un String de lo que hay se va a guardar en el archivo
            System.out.println("La operacion de escritura se realizo correctamente.");
        } catch (IOException e) {
            System.out.println("Se produjo el siguiente error al escribir el archivo:"+ e.getMessage());
        }
        finally {
            try {
                if(bWriter!= null){
                    bWriter.close();  //Se cierra el BufferedReader si es que contiene informacion.
                }
            } catch (IOException e) {
                System.out.println("No se pudo cerrar el arcivo correctamente, error: "+e.getMessage());
            }
        }
}

public static ArrayList  readFilePlane () {

    ArrayList<Plane> planeList = new ArrayList<>();
    BufferedReader bReader = null;
    File file = new File(FilePath.PLANES.getPathname());
    if(file.length()!=0){
        System.out.println("oko");
        try {
            bReader = new BufferedReader(new FileReader(new File(FilePath.PLANES.getPathname())));
            Gson gson = new Gson();
            // String planes = gson.toJson(FilePath.PLANES.getPathname());
            Type typeArrayPlanes = new TypeToken<ArrayList<Plane>>() {
            }.getType();
            planeList = gson.fromJson(bReader, typeArrayPlanes);
            System.out.println(planeList.size());
            System.out.println("La operacion de lectura se realizo correctamente.");
            bReader.close();

        } catch (IOException e) {
            System.out.println("Se produjo el siguiente error al leer el archivo:" + e.getMessage());
        }
    }
    else{
        System.out.println("El archivo no contiene datos");
    }
    return planeList; // Devuelve el contenido del archivo
}
}
*/
/* ArrayList<Plane> planeListSave = new ArrayList<>();
    planeListSave.add(planeSave);
    try {
        FileWriter fileWriter = new FileWriter(FilePath.PLANES.getPathname());
        Gson gson = new Gson();
        String plane = gson.toJson(planeListSave);
       //Plane planes = gson.fromJson(plane,Plane.class);
        fileWriter.write(plane);
        fileWriter.close();

    } catch (IOException e) {
        e.printStackTrace();
    }*/