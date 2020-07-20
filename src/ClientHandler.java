import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ClientHandler extends Thread {

    private Socket client;
    protected BufferedReader in;
    protected PrintWriter out;
    protected String name;
    protected int roomIndex = 0;
    protected ArrayList<ClientHandler> currentRoom;
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("HH:mm");
    protected String rqstTime;

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
                this.rqstTime = java.time.LocalTime.now().format(DTF);

                if (request == null) {
                    ChatServerHandler.rooms.get(roomIndex).remove(this);
                }

                out.println(new CommandHandler().executeCommand(this, request));
            }
        } catch (Exception e) {

            e.printStackTrace();

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