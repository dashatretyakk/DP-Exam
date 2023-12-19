import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRmiTaskN extends UnicastRemoteObject implements RmiTaskNInterface {

    public ServerRmiTaskN() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Hello from RMI Server!";
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099); // RMI default port
            ServerRmiTaskN server = new ServerRmiTaskN();
            registry.bind("RmiTaskNService", server);
            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
