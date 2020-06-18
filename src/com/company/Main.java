package com.company;
import com.company.enterprise.User;
import com.company.enterprise.UserMenu;
import com.company.enums.City;
import com.company.enums.FilePath;
import com.company.fileManagement.FileFlight;
import com.company.fileManagement.FilePlane;
import com.company.fileManagement.FileUser;
import com.company.fileManagement.Storage;
import com.company.planes.Bronze;
import com.company.planes.Gold;
import com.company.planes.Plane;
import com.company.planes.Silver;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Main {

    public static void main(String[] args) throws IOException {

        /*Date date = new Date(2020,05,10,12,50);
        SimpleDateFormat simpleDate = new SimpleDateFormat();
        System.out.println(simpleDate.format(date));
        Plane planeGold = new Gold("King Air 250", 1653, 301, 10, 574, "helice");
        System.out.println(planeGold.getRate());*/



/*
            FilePlane filePlane = new FilePlane();
            FileUser fileUsers = new FileUser();
            FileFlight fileFlight = new FileFlight();
            // Se crean los archivos
            filePlane.createFiles("files\\planes.json");
            fileUsers.createFiles("files\\users.json");
            fileFlight.createFiles("files\\flights.json");
            ///  testeos  sobre el manejo de archivos en plane y user

            Bronze learjet = new Bronze("Learjet 40", 2420, 300, 7, 859, "reaction");
            Gold kingAir = new Gold("King Air 250", 1653, 301, 10, 574, "helice");
            Silver pilatus = new Silver("Pilatus PC-12", 539, 301, 8, 500, "helice");
            Gold falcon = new Gold("Falcon 7X", 14448, 301, 16, 990, "reaction1");
            Silver g200 = new Silver("G200", 610, 301, 8, 900, "reaction");
            Bronze cessna = new Bronze("Cessna 550", 589, 301, 8, 746, "reaction1");
            //filePlane.emptyFile("files\\planes.json");  // vacia el contenido del archivo
            ArrayList<Plane> planeListSave = new ArrayList<>();
            planeListSave.add(learjet);
            planeListSave.add(kingAir);
            planeListSave.add(pilatus);
            planeListSave.add(falcon);
            planeListSave.add(g200);
            planeListSave.add(cessna);

            filePlane.writeFilePlane(planeListSave, FilePath.PLANES.getPathname());

            User enzo = new User("Enzo","Menna",39341231,26);
            User martin = new User("Martin","Gomez Vega",41429427,21);
            ArrayList<User> userList = new ArrayList<>();
            userList.add(enzo);
            userList.add(martin);
            FileUser fileUser=new FileUser();
            fileUser.writeFileUser(userList,FilePath.USERS.getPathname());
            //planeListSave = Storage.readFile(FilePath.PLANES.getPathname()); // Devuelve un ArrayList de lo que ay en el archivo
*/

    }
}
                 // intento fallido
        //ArrayList<Plane> planeList = FilePlane.readFilePlane();
        // System.out.println(planeList.size());

        /*if(planes.exists()){
            try{
                ArrayList<Plane> planeList = new ArrayList<>();
                planeList.add(airbus);
                planeList.add(airbus1);

                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(planes,planeList);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                planes.createNewFile();
                System.out.println("Archivo "+ planes.getName() + "creado con exito.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
