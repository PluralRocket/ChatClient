import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

    private static final int TCP_PORT = 9090;
    private static ArrayList<ClientHandler> clients = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(TCP_PORT);
        System.out.println("[SERVER] Listening...");

        while(true){

            Socket client = ss.accept();
            System.out.println("[SERVER] Connected to client.");

            ClientHandler clientThread = new ClientHandler(client);
            clients.add(clientThread);

           /*for (ClientHandler c : clients) {
                System.out.println(c.toString());
            }*/
        }
    }

    public static Socket createSocket(int port) throws IOException {

        ServerSocket ss = new ServerSocket(port);
        System.out.println("[SERVER] Listening...");

        while(true){

            Socket client = ss.accept();
            System.out.println("[SERVER] Connected to client.");

            ClientHandler clientThread = new ClientHandler(client);
            clients.add(clientThread);

        }
    }

}
