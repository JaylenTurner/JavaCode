import java.util.*;
import java.util.stream.Collectors;

public class Main {
    //main loop for game
    public static void main(String[] args) {
        //PL = Player List
        AllPlayers PL = new AllPlayers();


        //Before day 1 everyone gets a name
        for (int i = 0; i < PL.masterHousehold.length; i++){
            newName(PL.masterHousehold[i],PL);
        }
        System.out.println("\nAll names distributed.");


        //Day 1
        PL.kim.killed(PL.jaylen);
        PL.jayda.killed(PL.jaylen);
        PL.jayda.killed(PL.jaylen);

        newName(PL.kim,PL);
        System.out.println();
        leaderBoard(PL);
    }

    static void newName(Player player,AllPlayers playerList){
        Random rand = new Random();
        int random1 = rand.nextInt((playerList.masterHousehold.length - 0));

        System.out.println();
        System.out.println("This message is encrypted so you and only you may know your target. To unencypt your target," +
                " \nplease match the number for each character with the correct letter from the ASCII table," +
                "\nyou can find the ASCII table with a simple google search");
        System.out.println(player.getFirstName() + " has " + encrypt(playerList.masterHousehold[random1].getFirstName()));
    }

    static void leaderBoard(AllPlayers playerList){
        HashMap<String, Integer> playersNames = new HashMap<>();

        for (int k = 0; k < playerList.masterHousehold.length; k++){
            playersNames.put(playerList.masterHousehold[k].getFirstName(), playerList.masterHousehold[k].getKills());
        }

        playersNames.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
    }

    static String encrypt(String name){
        StringBuilder sb = new StringBuilder();
        char[] array = name.toCharArray();
        int[] intArray = new int[array.length];

        for (int i = 0; i < array.length; i++){
            intArray[i] = (int)array[i];
            sb.append(intArray[i] + " ");
        }
        return sb.toString();
    }
}
