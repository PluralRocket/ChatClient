import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ClientHandler extends Thread {

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private String name;
    private int roomIndex = 0;
    private ArrayList<ClientHandler> currentRoom;
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("HH:mm");

    public ClientHandler(Socket socket) throws IOException {
        this.client = socket;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
        currentRoom = ChatServerHandler.clients;
        start();
    }

    public void update() {
        currentRoom = ChatServerHandler.rooms.get(0);
    }

    @Override
    public void run() {
        try {
            name = in.readLine();
            while (true) {
                String request = in.readLine();
                String rqstTime = java.time.LocalTime.now().format(DTF);

                if (request == null) {
                    ChatServerHandler.rooms.get(roomIndex).remove(this);
                } else if (request.equals("who")) {
                    out.println("Currently in room:");
                    for (ClientHandler c : currentRoom) {
                        out.println(c.name);
                    }
                } else if (request.equals("create room")) {
                    ArrayList<ClientHandler> newRoom = new ArrayList<>();
                    ChatServerHandler.rooms.add(newRoom);
                    for (ArrayList <ClientHandler> c : ChatServerHandler.rooms) {
                        out.print("[");
                        for (int i=0; i<c.size();i++){
                        out.print(" " + c.get(i).name + " ");
                        }
                        out.println("]");
                    }
                } else if (request.equals("rooms")) {

                        for (int i=0; i<ChatServerHandler.rooms.size();i++){
                            out.print("[");
                            out.print("Room " + i);
                            out.println("]");
                        }
                } else if (request.startsWith("room ")) {
                    int newRoomIndex = Integer.parseInt(request.substring(5));
                    if(newRoomIndex<10) {
                        if(ChatServerHandler.rooms.size()>newRoomIndex) {
                            ChatServerHandler.rooms.get(roomIndex).remove(this);
                            roomIndex = newRoomIndex;
                            this.currentRoom = ChatServerHandler.rooms.get(newRoomIndex);
                            ChatServerHandler.rooms.get(newRoomIndex).add(this);
                        }
                    } else {
                            out.println("Room does not exist");
                        }
                } else {
                    for (ClientHandler c : currentRoom) {
                        c.out.println(this.name + ": " + request + " [" + rqstTime + "]");
                    }
                }
            }
        } catch (Exception e) {

            System.out.println("ClientHandler caught");

        } finally {
            try {
                currentRoom.remove(this);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.close();
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("finally");
        }

    }

}