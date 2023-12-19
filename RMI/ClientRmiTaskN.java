import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRmiTaskN {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RmiTaskNInterface stub = (RmiTaskNInterface) registry.lookup("RmiTaskNService");
            String response = stub.sayHello();
            System.out.println("Response from server: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
