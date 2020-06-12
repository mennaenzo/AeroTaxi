package com.company;
import com.company.fileManagement.Storage;
import com.company.planes.Plane;


public class Main {

    public static void main(String[] args) {

        Storage.createFiles("files\\planes.json");
        Storage.createFiles("files\\users.json");
        Storage.createFiles("files\\flights.json");

        Plane airbus = new Plane("Airbus A340",155040,300,214,914,"reaction");
        Plane airbus1 = new Plane("Airbus A341",155041,301,215,915,"reaction1");



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
    }
}