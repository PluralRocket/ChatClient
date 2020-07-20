import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerConnection extends Thread {
    Socket server;
    BufferedReader in;

    public ServerConnection(Socket socket) throws IOException {
        this.server = socket;
        this.in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        start();
    }

    @Override
    public void run() {
        try {
            String serverResponse;
            while (true) {
                serverResponse = in.readLine();
                if (serverResponse == null) break;
                else if (serverResponse.equals("")) { }
                else System.out.println(serverResponse);
            }
        } catch (Exception e) {
            try {
                in.close();
                server.close();
                System.out.println("in closed");
                System.out.println("server closed");
            } catch (IOException ex) {
                System.out.println("caught in server ex");
            }
        }
    }
}
