import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServerHandler extends Thread{

    int globalport;
    public static ArrayList<ClientHandler> clients = new ArrayList<>();

    public ChatServerHandler (int port) {
        globalport = port;
        start();
    }

//    public static void printMembers(){
//
//        for (ClientHandler c : clients) {
//            System.out.println(c.toString());
//        }
//    }

    @Override
    public void run() {

        try {
            System.out.println("[SERVER] Before...");
            ServerSocket ss = new ServerSocket(globalport);
            System.out.println("[SERVER] Listening...");

            while(true){

                Socket client = ss.accept();
                System.out.println("[SERVER] Connected to client.");

                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                ClientHandler clientThread = new ClientHandler(client);
                clients.add(clientThread);

           /*for (ClientHandler c : clients) {
                System.out.println(c.toString());
            }*/
            }
        } catch (IOException e) {

        }
    }
}
