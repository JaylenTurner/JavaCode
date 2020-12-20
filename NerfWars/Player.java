public class Player {
    private int kills;
    private int deaths;
    private int amountOwed;
    private String firstName;
    private String lastName;
    private int houseHold;
    private Boolean hasTarget;
    private String address;

    public Player(String firstName, String lastName, String address){
        kills = 0;
        deaths = 0;
        amountOwed = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public void killed(Player victim){
        kills++;
        victim.died();
    }

    public void died(){
        deaths++;
    }

    public void buyBack(){
        amountOwed+=5;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getAmountOwed() {
        return amountOwed;
    }

    public String getFirstName() {
        return firstName;
    }
}
