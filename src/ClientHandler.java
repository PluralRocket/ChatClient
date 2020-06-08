import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ClientHandler extends Thread{

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private String name;
    private ArrayList<ClientHandler> currentRoom = new ArrayList<>();

    public ClientHandler(Socket socket) throws IOException {
        this.client = socket;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
        currentRoom = ChatServerHandler.clients;
        start();
    }

    public void update(){
        currentRoom = currentRoom = ChatServerHandler.clients;
    }

    @Override
    public void run() {
        try{
                name = in.readLine();
            while (true){
                String request = in.readLine();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
                String rqstTime = java.time.LocalTime.now().format(dtf);

                if(request == null) {
                    ChatServerHandler.clients.remove(this);
                }
                if(request.equals("who")){
                    out.println("Chat Server Handler");
                    for (ClientHandler c : ChatServerHandler.clients) {
                        out.println(c.name);
                    }
                    out.println("CurrentRoom");
                    for (ClientHandler c : currentRoom) {
                        out.println(c.name);
                    }
                }
                else if(request.startsWith("room")){

                    ChatServerHandler.clients.remove(this);
                    this.currentRoom = ChatServerHandler.room1;
                    ChatServerHandler.room1.add(this);
                }
                else{
                for (ClientHandler c : currentRoom) {
                    c.out.println(this.name + ": " + request + " [" + rqstTime + "]");
                }
            }
            }
        } catch (Exception e) {
            out.close();
            try {
                client.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        finally {
            out.close();
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}