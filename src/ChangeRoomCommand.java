public class ChangeRoomCommand implements ClientCommand {

    private ClientHandler ch;
    private int roomNum;

    ChangeRoomCommand(ClientHandler ch){
        this.ch = ch;
    }

    @Override
    public String execute() {
        ch.out.println("Select room to move to: ");
        ch.out.println(new CommandHandler().doCommand(new ListRoomsCommand()));
        try {
            this.roomNum = Integer.parseInt(ch.in.readLine())-1;
        } catch (Exception e){
            return "Error";
        }
        if(ChatServerHandler.rooms.size()>roomNum) {
                ChatServerHandler.rooms.get(ch.roomIndex).remove(ch);
                ch.roomIndex = roomNum;
                ch.currentRoom = ChatServerHandler.rooms.get(roomNum);
                ChatServerHandler.rooms.get(roomNum).add(ch);
                return "Moved to new room";

        } else {
            return "Room does not exist";
        }
    }
}
