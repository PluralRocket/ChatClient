import java.io.IOException;
import java.net.Socket;

public class SocketBuilder {

    private String IP_Address;
    private int Port_Number;

    public SocketBuilder(int port) {
        this.Port_Number = port;
    }

    public SocketBuilder withIP(String ip) {
        this.IP_Address = ip;
        return this;
    }

    public Socket build() throws IOException {
        Socket sock = new Socket(this.IP_Address, this.Port_Number);
        return sock;
    }

}
