import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerConnection extends Thread {
    Socket server;
    BufferedReader in;
    private String clientName;

    public ServerConnection(Socket socket, String name) throws IOException {
        this.server = socket;
        this.clientName = name;
        this.in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        start();
    }

    @Override
    public void run() {
        try {
            String serverResponse=null;
            while(true){
            serverResponse = in.readLine();
            if(serverResponse.startsWith(clientName))
            { } else{
            System.out.println(serverResponse);
            }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
