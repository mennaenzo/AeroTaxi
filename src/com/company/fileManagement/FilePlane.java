package com.company.fileManagement;

import com.company.enums.FilePath;
import com.company.planes.Bronze;
import com.company.planes.Gold;
import com.company.planes.Plane;
import com.company.planes.Silver;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class FilePlane extends Storage{

    public FilePlane() {
    }

  /*public static boolean checkPlaneInfile(ArrayList<Plane> completeList, Plane xSave){
            for (Plane plane: completeList) {
                if(plane.getIdPlane() == xSave.getIdPlane()){
                    return true;
                }
            }
        return false;
    }*/


    // Escribe en un archivo un ArrayList
    public static void writeFilePlane(ArrayList<Plane> xSave, String pathname) {

        ArrayList<ArrayList<Plane>> completeList = new ArrayList<>();
        //completeList = FilePlane.readFilePlane(pathname);
        ArrayList<Plane> saveSilver = new ArrayList<>();
        ArrayList<Plane> saveBronze = new ArrayList<>();
        ArrayList<Plane> saveGold = new ArrayList<>();

      for(int i = 0;i < xSave.size(); i++) {
          if (xSave.get(i) instanceof Bronze) {
              saveBronze.add(xSave.get(i));
          }
          if (xSave.get(i) instanceof Silver) {
              saveSilver.add(xSave.get(i));
          }
          if (xSave.get(i) instanceof Gold) {
              saveGold.add(xSave.get(i));
          }
      }
      completeList.add(0,saveBronze);
      completeList.add(1,saveSilver);
      completeList.add(2,saveGold);

      BufferedWriter bWriter = null;

      try {
          FileWriter fileWriter = new FileWriter(pathname);
          bWriter = new BufferedWriter(fileWriter);
          Gson gson = new GsonBuilder().setPrettyPrinting().create(); //Crea un gson con un diseño(de  lo que se imprime en consola) mas legible
          gson.toJson(completeList, completeList.getClass(), bWriter); // Escribe en el archivo
          System.out.println("La operacion de escritura en el archivo " + pathname + " se realizo correctamente.");
      } catch (IOException e) {
          System.out.println("Se produjo el siguiente error al escribir el archivo:" + e.getMessage());
      } finally {
          try {
              if (bWriter != null) {
                  bWriter.close();  //Se cierra el BufferedReader si es que contiene informacion.
              }
          } catch (IOException e) {
              System.out.println("No se pudo cerrar el arcivo" + pathname + " correctamente, error: " + e.getMessage());
          }
      }
    }


/*
public static void writeFilePlane(ArrayList<Plane> xSave, String pathname) {
        if(xSave != null) {
            ArrayList<Plane> completeList = (FilePlane.readFilePlane(pathname));
            for (Plane plane : xSave) {
                if (!FilePlane.checkPlaneInfile(completeList, plane) || completeList.isEmpty()) {
                    completeList.add(plane);
                    BufferedWriter bWriter = null;

                    try {
                        FileWriter fileWriter = new FileWriter(pathname);
                        bWriter = new BufferedWriter(fileWriter);
                        Gson gson = new GsonBuilder().setPrettyPrinting().create(); //Crea un gson con un diseño(de  lo que se imprime en consola) mas legible
                        gson.toJson(completeList, completeList.getClass(), bWriter); // Escribe en el archivo
                        //System.out.println("es   "+ gson.toJson(planeSave)); Devuelve un String de lo que hay se va a guardar en el archivo
                        System.out.println("La operacion de escritura en el archivo " + pathname + " se realizo correctamente.");
                    } catch (IOException e) {
                        System.out.println("Se produjo el siguiente error al escribir el archivo:" + e.getMessage());
                    } finally {
                        try {
                            if (bWriter != null) {
                                bWriter.close();  //Se cierra el BufferedReader si es que contiene informacion.
                            }
                        } catch (IOException e) {
                            System.out.println("No se pudo cerrar el arcivo" + pathname + " correctamente, error: " + e.getMessage());
                        }
                    }
                }
            }
        }
    }
 */

    // A partir de una ruta, lee un archivo.
    public static ArrayList<ArrayList<Plane>> readFilePlane(String pathname) {
        ArrayList<ArrayList<Plane>> list = new ArrayList<>();
        BufferedReader bReader = null;
        File file = new File(pathname);
        if(file.length()!=0){
            try {
                bReader = new BufferedReader(new FileReader(new File(pathname)));
                Gson gson = new Gson();
                // String planes = gson.toJson(FilePath.PLANES.getPathname());
                Type typeArrayPlanes = new TypeToken<ArrayList<ArrayList<Plane>>>() {}.getType(); // Se hace una referencia del tipo de dato, en este caso un ArrayList.
                list = gson.fromJson(bReader, typeArrayPlanes); // list almacena un ArrayList con a informacion del archivo.
                System.out.println("La operacion de lectura se realizo correctamente.");
            } catch (IOException e) {
                System.out.println("Se produjo el siguiente error al leer el archivo: " + e.getMessage());
            }
            finally {
                try {
                    if (bReader != null) {
                        bReader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            System.out.println("El archivo no contiene datos");
        }
        ArrayList<ArrayList<Plane>> listCast = new ArrayList<>();
        // Falta terminar
       /*  ArrayList<Bronze> listBronce = new ArrayList<>();
        ArrayList<Silver> listSilver = new ArrayList<>();
        ArrayList<Gold> listGold = new ArrayList<>();
       if(list != null){
            for(int i = 0; i < list.size(); i++) {
                for (int j = 0;  list.get(i).get(j) != null; j++){
                    if(i == 0){
                        listCast.add(0, (Plane) list.get(0).get(0));
                    }
                    if(i == 1){
                        listCast.get(1).add((Plane) list.get(i).get(j));
                    }
                    if(i == 2){
                       listCast.get(2).add((Plane) list.get(i).get(j));
                    }

                }
            }
        }
*/
        return list; // Devuelve el contenido del archivo
    }

    /*
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
                    if (bReader != null) {
                        bReader.close();
                    }
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
     */
    public static ArrayList<Plane> createDataPlane(String pathname){
        ArrayList<Plane> listSave = new ArrayList<>();
        Bronze learjet = new Bronze("Learjet 40", 2420, 300, 7, 859, "reaction");
        Gold kingAir = new Gold("King Air 250", 1653, 301, 10, 574, "helice");
        Silver pilatus = new Silver("Pilatus PC-12", 539, 301, 8, 500, "helice");
        Gold falcon = new Gold("Falcon 7X", 14448, 301, 16, 990, "reaction1");
        Silver g200 = new Silver("G200", 610, 301, 8, 900, "reaction");
        Bronze cessna = new Bronze("Cessna 550", 589, 301, 8, 746, "reaction1");
        listSave.add(learjet);
        listSave.add(kingAir);
        listSave.add(pilatus);
        listSave.add(falcon);
        listSave.add(g200);
        listSave.add(cessna);
        FilePlane.writeFilePlane(listSave, pathname);
        return listSave;
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

