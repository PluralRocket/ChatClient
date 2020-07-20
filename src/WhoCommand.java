import java.util.ArrayList;

public class WhoCommand implements ClientCommand {

    @Override
    public String execute() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCurrently online:\n");

        for (int i=0; i<ChatServerHandler.rooms.size();i++) {
            ArrayList<ClientHandler> c = ChatServerHandler.rooms.get(i);
            sb.append(i+1 + " [");
            for (int j=0; j<c.size();j++){
                sb.append(" " + c.get(j).name + " ");
            }
            sb.append("]\n");
        }
        return String.valueOf(sb);
    }
}
