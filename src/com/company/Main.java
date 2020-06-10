package com.company;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) {

        String path = "C:\\Users\\menna\\Desktop\\AeroTaxi\\files\\planes.json";
        File planes = new File(path);
        Plane airbus = new Plane("Airbus A340",155040,300,214,914,"reaction");
        Plane airbus1 = new Plane("Airbus A341",155041,301,215,915,"reaction1");

        if(planes.exists()){
            try{
                Map<String,Plane> planeMap = new HashMap<>();
                planeMap.put("Airbus 1",airbus);
                planeMap.put("Airbus 2",airbus1);

                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(planes,planeMap);

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
        }

//        boolean res;
//        Plane vuelo = new Plane(null, "BSAS", "CORDOBA", 2);
//        res=vuelo.validarCiudad("BSS","BSS");
//        System.out.println(res);
//        for (City c: City.values()) {
//        System.out.println(c.toString());
//        }
    }
}