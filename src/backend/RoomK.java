/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author khantil
 */
public class RoomK {
    int roomNo;
    int roomTypeID;
    int hotelID;
    double roomRates;
    int maxAllowedOccupancy;

    public RoomK(int roomNo, int roomTypeID, int hotelID, double roomRates, int maxAllowedOccupancy) {
        this.roomNo = roomNo;
        this.roomTypeID = roomTypeID;
        this.hotelID = hotelID;
        this.roomRates = roomRates;
        this.maxAllowedOccupancy = maxAllowedOccupancy;
    }
    
    
}
