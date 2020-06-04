import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewClient {

    public static void main(String[] args) throws IOException {


        ChatServer cs = new ChatServer();
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String request = keyboard.readLine();
        }

    }

}

