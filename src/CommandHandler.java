public abstract class CommandHandler {

    public static String executeCommand(ClientHandler ch, String request){

        ClientCommand c;

        switch (request) {
            case "who":
                c = new WhoCommand();
                break;
            case "create room":
                c = new CreateRoomCommand();
                break;
            case "rooms":
                c = new ListRoomsCommand();
                break;
            case "change room":
                c = new ChangeRoomCommand(ch);
                break;
            default:
                for (ClientHandler clientHandler : ch.currentRoom) {
                    clientHandler.out.println(ch.name + ": " + request + " [" + ch.rqstTime + "]");
                }
                return "";
        }
        return c.execute();
    }

    public static String doCommand(ClientCommand c){
        return c.execute();
    }
}
