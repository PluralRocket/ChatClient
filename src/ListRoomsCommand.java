public class ListRoomsCommand implements ClientCommand {

    @Override
    public String execute() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<ChatServerHandler.rooms.size();i++){
            sb.append('[');
            sb.append("Room " + (i+1));
            sb.append("]");
        }
        return String.valueOf(sb);
    }
}
