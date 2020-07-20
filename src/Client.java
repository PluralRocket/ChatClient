import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final String IP_ADDRESS = "127.0.0.1";
    private static String name;
    private static int port;

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Client.port = port;
    }

    public static void setName(String name) {
        Client.name = name;
    }

    public static String getName() {
        return name;
    }

    public static void main(String[] args) throws IOException {


        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String request;

        System.out.print("Enter port: ");
        setPort(Integer.parseInt(keyboard.readLine()));

        new ChatServerHandler(port);

        Socket socket = new SocketBuilder(port).withIP(IP_ADDRESS).build();

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        ServerConnection sc = new ServerConnection(socket);

        System.out.print("Enter your name: ");
        setName(keyboard.readLine());
        out.println(getName());

        while (true) {
            request = keyboard.readLine();
            if (request.equals("quit")) {
                break;
            }
            else {
                out.println(request);
            }
        }

        out.close();
        socket.close();

//       System.exit(0);
    }

}
