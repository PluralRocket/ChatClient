import java.util.ArrayList;

public class CreateRoomCommand implements ClientCommand{

    @Override
    public String execute() {
        ArrayList<ClientHandler> newRoom = new ArrayList<>();
        ChatServerHandler.rooms.add(newRoom);
        return "New room added.";
    }
}
