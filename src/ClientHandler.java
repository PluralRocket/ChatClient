import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread{

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private String name;

    public ClientHandler(Socket socket) throws IOException {
        this.client = socket;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
        start();
    }

    @Override
    public void run() {

        try {
            this.name=(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            while (true){
                String request = in.readLine();
                if(request == null) break;
                for (ClientHandler c : ChatServer.clients) {
                    c.out.println(name+":"+request);
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