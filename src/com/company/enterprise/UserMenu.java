package com.company.enterprise;

import com.company.enums.Journey;
import com.company.planes.Plane;
import java.util.Date;

public class UserMenu {

    public UserMenu() {
    }

    public Flight confirmFligth(Date date, Journey journey, Plane plane, User user, int passengers){
        double cost = ((journey.getDistance() * plane.getPricePerKm()) + (passengers * 3500) + plane.getRate());
        Flight flight = new Flight(date, journey, plane, user, passengers, cost);
        user.addTrips(flight);
        user.setBestCategory(plane.getClass().getSimpleName());
        return flight;
    }

    /*public Journey confirmJourney(String origin, String destination){

    }*/

    public boolean maxPassengers(int passengers, int max){
        if(passengers > max)
            return false;
        else
            return true;
    }


}
