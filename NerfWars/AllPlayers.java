import java.util.ArrayList;

public class AllPlayers {
    public Player jaylen = new Player("Jaylen","Turner", "2020 Forest Hills Drive");
    public Player kim = new Player("Kim","Bridges","2020 Forest Hills Drive");
    public Player jayda = new Player("Jayda", "Turner","2020 Forest Hills Drive");

    public Player[] masterHousehold = {jaylen,
                                        kim,
                                        jayda};

    public Player getJaylen() {
        return jaylen;
    }
    public Player getKim() {
        return kim;
    }
    public Player getJayda() {
        return jayda;
    }
}
