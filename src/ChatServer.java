import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

    private static final int TCP_PORT = 9090;
    public static ArrayList<ClientHandler> clients = new ArrayList<>();

    // throws declaration

    /*public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(TCP_PORT);

        while(true){

        System.out.println("[SERVER] Listening...");

        Socket client = ss.accept();
        clients.add(client);
        clientCounter++;

        System.out.println("[SERVER] Connected to client.");

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        try{
            while (true){
                String request = in.readLine();
                if(request.contains("date")) {
                    String today = new Date().toString();
                    out.println(today);
                } else {
                    out.println("Request a date");
                }
            }
    } catch(NullPointerException e){
            out.close();
            client.close();
        }
        finally {
            out.close();
            client.close();
    }
        }
    }*/

    // try-with-resources
    /*public static void main(String[] args) {

        try (ServerSocket ss = new ServerSocket(TCP_PORT); Socket client = ss.accept(); PrintWriter out = new PrintWriter(client.getOutputStream(), true)){

        System.out.println("[SERVER] Connected to client.");

        String today = new Date().toString();
        out.println(today);

        System.out.println("Date " + today + " sent.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

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

           /*for (ClientHandler c : clients) {
                System.out.println(c.toString());
            }*/
        }
    }

}
