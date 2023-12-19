import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                new ServerClientThread(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

class ServerClientThread extends Thread {
    private Socket socket;

    public ServerClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            String text;
            do {
                text = reader.readLine();
                System.out.println("Server received: " + text);
                writer.println("Echo from server: " + text);
            } while (!text.equals("bye"));

            socket.close();
        } catch (IOException ex) {
            System.out.println("Server thread exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
