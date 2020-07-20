public class CommandHandler {

    private ClientCommand c;

    public String executeCommand(ClientHandler ch, String request){
        if (request.equals("who")) {
            this.c = new WhoCommand();
            return c.execute();
        } else if (request.equals("create room")) {
            this.c = new CreateRoomCommand();
            return c.execute();
        } else if (request.equals("rooms")) {
            this.c = new ListRoomsCommand();
            return c.execute();
        } else if (request.equals("change room")) {
            this.c = new ChangeRoomCommand(ch);
            return c.execute();
        } else {
            for (ClientHandler c : ch.currentRoom) {
                c.out.println(ch.name + ": " + request + " [" + ch.rqstTime + "]");
            }
            return "";
        }
    }

    public String doCommand(ClientCommand c){
        return c.execute();
    }
}
