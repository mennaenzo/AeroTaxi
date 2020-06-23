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

public class FileUser extends Storage {
    public FileUser() {
    }

    public static boolean checkUserInfile(ArrayList<User> completeList, User xSave) {
        for (User user : completeList) {
            if (user.getDni() == xSave.getDni()) {
                return true;
            }
        }
        return false;
    }

    public static void writeFileUser(ArrayList<User> xSave, String pathname) {
        if (xSave != null) {
            ArrayList<User> completeList = (FileUser.readFileUser(pathname));
            for (User user : xSave) {
                if (!FileUser.checkUserInfile(completeList, user) || completeList.isEmpty()) {
                    completeList.add(user);
                    BufferedWriter bWriter = null;

                    try {
                        FileWriter fileWriter = new FileWriter(pathname);
                        bWriter = new BufferedWriter(fileWriter);
                        Gson gson = new GsonBuilder().setPrettyPrinting().create(); //Crea un gson con un diseño(de  lo que se imprime en consola) mas legible
                        gson.toJson(completeList, completeList.getClass(), bWriter); // Escribe en el archivo
                        //System.out.println("es   "+ gson.toJson(planeSave)); Devuelve un String de lo que hay se va a guardar en el archivo
                        System.out.println("La operacion de escritura se realizo correctamente.");
                    } catch (IOException e) {
                        System.out.println("Se produjo el siguiente error al escribir el archivo:" + e.getMessage());
                    } finally {
                        try {
                            if (bWriter != null) {
                                bWriter.close();  //Se cierra el BufferedReader si es que contiene informacion.
                            }
                        } catch (IOException e) {
                            System.out.println("No se pudo cerrar el arcivo correctamente, error: " + e.getMessage());
                        }
                    }
                }
            }
        }
    }

    public static ArrayList<User> readFileUser(String pathname) {
        ArrayList<User> list = new ArrayList<>();
        BufferedReader bReader = null;
        File file = new File(pathname);
        if (file.length() != 0) {  //Se verifica si el archivo tiene informacion.
            try {
                bReader = new BufferedReader(new FileReader(new File(pathname)));
                Gson gson = new Gson();
                // String planes = gson.toJson(FilePath.PLANES.getPathname());
                Type typeArrayUsers = new TypeToken<ArrayList<User>>() {}.getType(); // Se hace una referencia del tipo de dato, en este caso un ArrayList.
                list = gson.fromJson(bReader, typeArrayUsers); // list almacena un ArrayList con a informacion del archivo.
                System.out.println("La operacion de lectura se realizo correctamente.");


            } catch (IOException e) {
                System.out.println("Se produjo el siguiente error al leer el archivo: " + e.getMessage());
            } finally {
                try {
                    if (bReader != null) {
                        bReader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("El archivo no contiene datos");
        }
        return list; // Devuelve el contenido del archivo
    }

    public static ArrayList<User> createDataUser(String pathname) {
        ArrayList<User> listSave = new ArrayList<>();
        User admin = new User("Admin", "", 0, 0);
        User enzo = new User("Enzo", "Menna", 39341231, 26);
        User martin = new User("Martin", "Gomez Vega", 41429427, 21);
        listSave.add(admin);
        listSave.add(enzo);
        listSave.add(martin);
        FileUser.writeFileUser(listSave, pathname);
        return listSave;
    }

    public boolean checkData(ArrayList<User> userList) {  //por arametro mando la list que retorna el readFile
        ArrayList<User> firsList = FileUser.createDataUser(FilePath.USERS.getPathname());
        for (User user : userList) {
            for (User userCompare : firsList) {
                if (user.getName().equals(userCompare.getName()) && user.getSurname().equals(userCompare.getSurname())) {
                    if (user.getAge() == userCompare.getAge() && user.getDni() == userCompare.getDni()) {
                        return true;
                    }
                }
            }
        }
        return false;
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

