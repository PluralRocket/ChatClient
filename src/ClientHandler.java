import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

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
        try{
                name = in.readLine();
            while (true){
                String request = in.readLine();
                if(request == null) {
                    ChatServerHandler.clients.remove(this);
                }
                if(request.equals("who")){
                    for (ClientHandler c : ChatServerHandler.clients) {
                        out.println(c.name);
                    }
                } else{
                for (ClientHandler c : ChatServerHandler.clients) {
                    c.out.println(this.name + ": " + request);
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