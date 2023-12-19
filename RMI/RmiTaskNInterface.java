import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiTaskNInterface extends Remote {
    String sayHello() throws RemoteException;
}
