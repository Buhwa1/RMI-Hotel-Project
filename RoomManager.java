import java.rmi.*;
import java.io.*;
import java.util.*;

public interface RoomManager extends Remote{

    //bookedGuests() this reserves rooms for a guest according to room type
    public String bookedGuests(String m,int n) throws RemoteException;
    //guests() this prints out a guest list
    public HashMap<String,Integer> guests() throws RemoteException;
    //rooms() this prints out a list of available rooms and their types
    public String rooms() throws RemoteException;
    //revenue() this prints out the revenue of booked rooms and their types
    public String revenue() throws RemoteException;
    
}
