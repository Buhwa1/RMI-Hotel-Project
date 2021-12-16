import java.util.*;
import java.rmi.*;
import java.rmi.server.*;
import java.io.*;  // Import the File class
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.Map;

public class HotelClient 
{

    public static void main(String argv[])
    {   
        try {
            //looking up the remote object name in the registry
            RoomManager RM = (RoomManager) Naming.lookup("rmi://localhost:1099/RoomManagerService"); 

            //if no command is entered this executes and prints list of commands to use
            if(argv.length == 0){
                System.out.println("\nUse the following commands to access hotel Services: \n java HotelClient list <server address> to list the available number of rooms in each price range \n java HotelClient guests <server address> lists the names of all the registered guests\n java HotelClient revenue <server address> prints the revenue breakdown based on"+
                "the booked rooms and their types.\n java HotelClient book <server address> <room type> <guest name> \n");
            }
            //if 2 commands are entered this executes
            else if(argv.length == 2){
                String a = argv[0];
                String b = argv[1];
                    //if argument a=list then this executes
                if(a.equals("list")){
                    System.out.println("\n\t\tRoom List\n");
                    //invokes the object rooms() which prints out a current list of available rooms  
                    System.out.println(RM.rooms());     
                }

                //if argument a=guests then this executes
                else if(a.equals("guests")){
                    System.out.println("\n\t\tGUEST LIST\n");
                    //invokes the object guests() which prints out the current guest list  
                    for (String i : RM.guests().keySet()) {
                        System.out.println("\t\t"+i);
                      } 
                      System.out.println("\n");
                }

                
                //if argument a=revenue then this executes
                else if(a.equals("revenue")){
                    //invokes the object revenue() which prints out the current revenue list according to room type  
                    System.out.println(RM.revenue());
                    }   
            }
                //if 4 arguments are entered this executes
            else if(argv.length == 4){
                String a = argv[0];
                String b = argv[1];
                String c = argv[2];
                String d = argv[3];
               // a=book then this executes
                if(a.equals("book")){
                    //invokes the object bookedGuests which reserves a room for the guest in the chosen room type   
                    System.out.println(RM.bookedGuests(d,Integer.parseInt(c)));
                }
            }
            
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        
    }

}