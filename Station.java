/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package riyadhmetroproject;

/**
 *
 * @author Sarah
 */
public class Station {
    
   private String name;
   private int travelTime; 
    private int counterpass; 

    public int getCounterpass() {
        return counterpass;
    }

    public void incmentCounterpass() {
        counterpass++;
    }

    public Station( String name, int travelTime, int par1, String parking_Restrooms, String wheelchair_access_Elevators, int par2, String __2330, int par3) {
        
        this.name = name;
        this.travelTime = travelTime;
        
    }


    

    public void setName(String name) {
        this.name = name;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

 
   

    public String getName() {
        return name;
    }

    public int getTravelTime() {
        return travelTime;
    }

    @Override
    public String toString() {
        return  name + " M: " + travelTime + ")";
    } 
}


