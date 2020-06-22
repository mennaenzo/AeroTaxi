package com.company;
import com.company.enterprise.SystemAero;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        SystemAero system = new SystemAero();
        system.menu();

/*
        Date today = new Date();
        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(today);
        System.out.println(currentDate.getTime());
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm");
        System.out.println(simpleDate.format(date));
*/
/*
        Plane planeGold = new Gold("King Air 250", 1653, 301, 10, 574, "helice");
        System.out.println(planeGold.getRate());
        Scanner scanner = new Scanner(System.in);
        String dates = scanner.nextLine();
        try {
            date = simpleDate.parse(dates);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dates);

        SystemAero test = new SystemAero();
        test.setUp();
*/


/*
            FilePlane filePlane = new FilePlane();
            FileUser fileUsers = new FileUser();
            FileFlight fileFlight = new FileFlight();
            // Se crean los archivos
            filePlane.createFile("files\\planes.json");
            fileUsers.createFile("files\\users.json");
            fileFlight.createFile("files\\flights.json");
            ///  testeos  sobre el manejo de archivos en plane y user

            Bronze learjet = new Bronze(1,"Learjet 40", 2420, 300, 7, 859, "reaction");
            Gold kingAir = new Gold(2,"King Air 250", 1653, 301, 10, 574, "helice");
            Silver pilatus = new Silver(3,"Pilatus PC-12", 539, 301, 8, 500, "helice");
            Gold falcon = new Gold(4,"Falcon 7X", 14448, 301, 16, 990, "reaction1");
            Silver g200 = new Silver(5,"G200", 610, 301, 8, 900, "reaction");
            Bronze cessna = new Bronze(7,"Cessna 550", 589, 301, 8, 746, "reaction1");

            ArrayList<Plane> planeListSave = new ArrayList<>();
            planeListSave.add(falcon);
            planeListSave.add(g200);
            planeListSave.add(cessna);
            FilePlane.writeFilePlane(planeListSave,FilePath.PLANES.getPathname());
            ArrayList<ArrayList<Plane>> test = FilePlane.readFilePlane(FilePath.PLANES.getPathname());
            System.out.println(test.get(0).get(0).getClass().getSimpleName());
             */

//            SystemAero test = new SystemAero();
//            test.setUp();
//            ArrayList<User> testFileUser.readFileUser(FilePath.USERS.getPathname());

  /*
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
