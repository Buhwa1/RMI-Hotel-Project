import java.rmi.Naming;
public class HotelServer {
    public HotelServer () {
        try {
        // The RoomManager creates an RoomManagerImpl object
                    RoomManager RMI = new RoomManagerImpl();
        // It binds (registers) to the rmiregistry
        Naming.rebind("rmi://localhost:1099/RoomManagerService",RMI);
       
} catch (Exception e) {
            System.out.println("Trouble: _" + e);
            
        }
}

public static void main (String args [] ) { 
    
    new HotelServer ();
    System.out.println("Server started"); 
    System.out.println("Server: Ready...");
}
 }