import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.util.*;
import java.applet.*;
import java.awt.*;
import java.text.DecimalFormat;


public class RoomManagerImpl extends UnicastRemoteObject implements RoomManager
{
    //static variable to store available rooms
    public static int type0 = 10;
    public static int type1 = 20;
    public static int type2 = 5;
    public static int type3 = 3;
    public static int type4 = 2;

    public static int count0 = 0;
    public static int count1 = 0;
    public static int count2 = 0;
    public static int count3 = 0;
    public static int count4 = 0;

    public static String noRooms;



    public static HashMap<String,Integer> guests = new HashMap<String,Integer>();

    public RoomManagerImpl() throws RemoteException
    {
        super(); 
    }

    //guests() this prints out a guest list that was stored in a HashMap
    public HashMap<String,Integer> guests() throws RemoteException{
        return guests;
    }

    //rooms() this prints out a list of available rooms and their types
    public String rooms() throws RemoteException{
        return type0+" rooms of type 0 are available for 50,000UGX per night\n" + type1+" rooms of type 1 are available for 75,000UGX per night\n"+type2+" rooms of type 2 are available for 80,000UGX per night\n"
        +type3+" rooms of type 3 are available for 150,000UGX per night\n"+type4+" rooms of type 4 are available for 230,000UGX per night\n";
    }

    //bookedGuests() this reserves rooms for a guest according to room type
    //
    public String bookedGuests(String m,int n) throws RemoteException{
        //insert guestname and roomtype into guests hashmap
        //check roomtype according to booking and reduce number of available rooms 
        //while increasing number of booked rooms by type
        if(n == 0){
            if(type0>0){
                type0--;
                count0++;
                guests.put(m,n);
            }
            else{
               noRooms = "No more rooms of type "+ n;
               return noRooms;
            }
        }
        if(n == 1){
            if(type1>0){
                type1--;
                count1++;
                guests.put(m,n);
            }
            else{
               noRooms = "No more rooms of type "+ n;
               return noRooms;
            }
        }
        if(n == 2){
            if(type2>0){
                type2--;
                count2++;
                guests.put(m,n);
            }
            else{
               noRooms = "No more rooms of type "+ n;
               return noRooms;
            }
        }
        if(n == 3){
            if(type3>0){
                type3--;
                count3++;
                guests.put(m,n);

            }
            else{
               noRooms = "No more rooms of type "+ n;
               return noRooms;
            }
        }if(n == 4){
            if(type4>0){
                type4--;
                count4++;
                guests.put(m,n);
            }
            else{
               noRooms = "No more rooms of type "+ n;
               return noRooms;
            }
        }
        return "Room type "+n+ " booked by "+m;
    }

    //revenue() this prints out the revenue of booked rooms and their types
    public String revenue() throws RemoteException{
            //calculate revenue according to number of rooms booked by type and price respectively
            return "type 0 revenue = "+count0*50000+"\ntype 1 revenue = "+count1*75000+"\ntype 2 revenue = "+count2*80000+"\ntype 3 revenue = "+count3*150000+"\ntype 4 revenue = "+count4*230000+"\n" ;
    }

}