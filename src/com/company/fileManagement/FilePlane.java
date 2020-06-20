package com.company.fileManagement;

import com.company.planes.Plane;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class FilePlane extends Storage{

    public FilePlane() {
    }

    // Escribe en un archivo un ArrayList
    public static void writeFilePlane(ArrayList<Plane> xSave, String pathname) {
        ArrayList<Plane> completeList = (FilePlane.readFilePlane(pathname));
        completeList.addAll(xSave);
        BufferedWriter bWriter= null;
        try {
            FileWriter fileWriter = new FileWriter(pathname);
            bWriter = new BufferedWriter(fileWriter);
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
    public static ArrayList<Plane> readFilePlane(String pathname) {
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


            } catch (IOException e) {
                System.out.println("Se produjo el siguiente error al leer el archivo: " + e.getMessage());
            }
            finally {
                try {
                    bReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            System.out.println("El archivo no contiene datos");
        }
        return list; // Devuelve el contenido del archivo
    }

    @Override
    public boolean createFile(String pathname) {
        return super.createFile(pathname);
    }

    @Override
    public void emptyFile(String pathname) {
        super.emptyFile(pathname);
    }
}

