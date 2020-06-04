import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServerHandler extends Thread{

    int globalport;
    public ChatServerHandler (int port) throws IOException {
        globalport = port;
        start();
    }

    @Override
    public void run() {
        try {
            System.out.println("testa");
            ServerSocket ss = new ServerSocket(globalport);
            System.out.println("[SERVER] Listening...");

            while(true){

                Socket client = ss.accept();
                System.out.println("[SERVER] Connected to client.");

                ClientHandler clientThread = new ClientHandler(client);

           /*for (ClientHandler c : clients) {
                System.out.println(c.toString());
            }*/
            }
        } catch (IOException e) {

        }
    }
}
