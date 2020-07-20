import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class ChatServerHandler extends Thread {

    private int globalport;
    public static ArrayList<ClientHandler> clients = new ArrayList<>();
    public static ArrayList<ArrayList<ClientHandler>> rooms = new ArrayList<>();
    public static ServerSocket ss;

    public ChatServerHandler(int port) {
        globalport = port;
        this.rooms.add(clients);
        start();
    }

    @Override
    public void run() {

        try {
            System.out.println("[SERVER] Before...");
            ss = new ServerSocket(globalport);
            System.out.println("[SERVER] Listening...");

            while (true) {

                Socket client = ss.accept();
                System.out.println("[SERVER] Connected to client.");

                new PrintWriter(client.getOutputStream(), true);

                ClientHandler clientThread = new ClientHandler(client);
                rooms.get(0).add(clientThread);
                clientThread.update();

            }
        } catch (IOException e) {
            return;
        }
    }
}
