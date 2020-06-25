import java.util.Scanner;

public class ConnectFour_JaylenTurner {
    public static void main(String[] args) {
        //objects
        Scanner keyboard = new Scanner(System.in);

        //variables
        int width = 8;
        int height = 8;
        //int bottomRow = width - 1;
        boolean notDone = true;
        String [][] board = new String[width][height];


        //MAIN CODE

        //creates board
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                board[i][j] = "_|";
            }
        }

        //printsBoard
        printBoard(width,height,board);

        //gameplay loop
        while (notDone){
            //reds turn
            redTurn(width,height,board,keyboard);
            printBoard(width,height,board);

            //checks if red won
            if (!checkR(width,height,board)){
                notDone = false;//ends game if red won
                break;//breaks loop
            }

            //blue turn
            blueTurn(width,height,board,keyboard);
            printBoard(width,height,board);

            //checks if blue won
            if (!checkB(width,height,board)){
                notDone = false;//ends game if blue won
                break;//breaks loop
            }
        }
    }

    public static void printBoard(int width, int height,String[][] board){
        for (int i = 0; i < width; i++){
            for (int j = 0;j < height; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.print("0|1|2|3|4|5|6|7|");
        System.out.println();
    }

    public static void redTurn(int width, int height, String[][] board, Scanner keyboard){
        //variables
        Boolean done = false;
        Boolean continuer = true;
        int result = 0;
        int counter = 1;

        System.out.println("Reds Turn!");
        while (!done){
            System.out.print("Please select a column:");
            String column = keyboard.nextLine();
            try{
                result = Integer.parseInt(column);
                if(result>7){
                    System.out.println("That number is invalid.");
                    done = false;
                }else if(result>-1){
                    done = true;
                }else {
                    System.out.println("That number is invalid.");
                    done = false;
                }
            }catch (NumberFormatException a){
                System.out.println("That number is invalid.");
                done = false;
            }
            //gives result / result = their column
        }
        while (continuer == true){
            if(board[width - 1][result] == "_|"){//checks to see if space is blank, puts an R if it is
                board[width - 1][result] = "R|";
                continuer = false;
            }else if (board[width - 1][result] == "R|" || board[width - 1][result] == "B|"){//if space isnt blank checks one above
                if (board[(width - 1) - counter][result] == "_|"){//puts R if blank
                    board[(width - 1) - counter][result] = "R|";
                    continuer = false;
                }
            }
            counter++;
        }
    }

    public static void blueTurn(int width,int height, String[][] board, Scanner keyboard) {
        //variables
        Boolean done = false;
        Boolean continuer = true;
        int result = 0;
        int counter = 1;

        System.out.println("Blues Turn!");
        while (!done) {
            System.out.print("Please select a column:");
            String column = keyboard.nextLine();
            try {
                result = Integer.parseInt(column);
                if (result > 7) {
                    System.out.println("That number is invalid.");
                    done = false;
                } else if (result > -1) {
                    done = true;
                } else {
                    System.out.println("That number is invalid.");
                    done = false;
                }
            } catch (NumberFormatException a) {
                System.out.println("That number is invalid.");
                done = false;
            }
            //gives result / result = their column
        }
        while (continuer == true) {
            if (board[width - 1][result] == "_|") {//checks to see if space is blank, puts an B if it is
                board[width - 1][result] = "B|";
                continuer = false;
            } else if (board[width - 1][result] == "R|" || board[width - 1][result] == "B|") {//if space isnt blank checks one above
                if (board[(width - 1) - counter][result] == "_|") {//puts B if blank
                    board[(width - 1) - counter][result] = "B|";
                    continuer = false;
                }
            }
            counter++;
        }
    }

    public static Boolean checkR(int width, int height, String[][] board){
        Boolean notDone = true;

        if (!checkRVertical(width,height,board) || !checkRHorizontal(width,height,board) || !checkRDiagonalBack(width,height,board) || !checkRDiagonalForward(width,height,board)){
            notDone = false;
        }
        return notDone;
    }

    public static Boolean checkB(int width,int height,String[][] board){
        Boolean notDone = true;

        if (!checkBVertical(width,height,board) || !checkBHorizontal(width,height,board) || !checkBDiagonalBack(width, height, board) || !checkBDiagonalForward(width,height,board)){
            notDone = false;
        }
        return notDone;
    }

    public static Boolean checkRHorizontal(int width,int height,String[][] board){
        Boolean notDone = true;
        int counter1 = 0;
        while(notDone){
            for (int i = 0; i < width;i++){
                for (int j = 0; j < height; j++){
                    if (board[i][j] == "R|"){//if t finds an r it adds one to counter
                        counter1++;
                    }else{
                        counter1 = 0;
                    }
                    if (counter1 >= 4){
                        System.out.println("Red wins!");
                        notDone = false;
                    }
                }
            }
            break;
        }
        return notDone;
    }

    public static Boolean checkBHorizontal(int width,int height,String[][] board){
        Boolean notDone = true;
        int counter1 = 0;
        while(notDone){
            for (int i = 0; i < width;i++){
                for (int j = 0; j < height; j++){
                    if (board[i][j] == "B|"){//if t finds an r it adds one to counter
                        counter1++;
                    }else{
                        counter1 = 0;
                    }
                    if (counter1 >= 4){
                        System.out.println("Blue wins!");
                        notDone = false;
                    }
                }
            }
            break;
        }
        return notDone;
    }

    public static Boolean checkRVertical(int width,int height,String[][] board){
        Boolean notDone = true;
        int counter1 = 0;
        while (notDone){
            for (int i = 0; i < height; i++){
                for (int j = 0; j < width; j++){
                    if (board[j][i] == "R|"){//if r then it adds to the counter
                        counter1++;
                    }else{
                        counter1 = 0;
                    }
                    if (counter1 >= 4){
                        System.out.println("Red wins!");
                        notDone = false;
                    }
                }
            }
            break;
        }
        return notDone;
    }

    public static Boolean checkBVertical(int width,int height,String[][] board){
        Boolean notDone = true;
        int counter1 = 0;
        while (notDone){
            for (int i = 0; i < height; i++){
                for (int j = 0; j < width; j++){
                    if (board[j][i] == "B|"){//if b then it adds to the counter
                        counter1++;
                    }else{
                        counter1 = 0;
                    }
                    if (counter1 >= 4){
                        System.out.println("Blue wins!");
                        notDone = false;
                    }
                }
            }
            break;
        }
        return notDone;
    }

    public static Boolean checkRDiagonalForward(int width,int height,String[][] board){
        //variables
        Boolean notDone = true;
        int counter1 = 0;
        Boolean check = false;
        int checkColumn = 1;
        int checkRow = 1;

        while (notDone){
            for (int i = 0; i < width; i++){
                for (int j = 0; j < height; j++){
                    if(board[i][j] == "R|"){//if r is found add one to counter then goto loop
                        counter1++;
                        check = true;
                        while(check){//goes through diagnoly lookings for Rs
                            if (checkColumn + i <= width - 1 && checkRow + j <= height - 1){
                                if(board[i + checkColumn][j + checkRow] == "R|"){//if r is found add one to counter
                                    counter1++;
                                }
                            }

                            //adds one to checkers
                            checkColumn++;
                            checkRow++;

                            if (checkColumn == width - 1 || checkRow == height - 1){//if outside of board break
                                check = false;
                                break;
                            }

                            if (counter1 >= 4){//if counter gets to four then red wins
                                System.out.println("Red Wins!");
                                check = false;
                                notDone = false;
                                break;
                            }
                        }
                    }
                    if (counter1 >= 4){
                        notDone = false;
                        break;
                    }

                    //resets counter and checkers
                    counter1 = 0;
                    checkColumn = 1;
                    checkRow = 1;
                }
            }
            break;
        }
        return notDone;
    }

    public static Boolean checkBDiagonalForward(int width, int height, String[][] board) {
        //variables
        Boolean notDone = true;
        int counter1 = 0;
        Boolean check = false;
        int checkColumn = 1;
        int checkRow = 1;

        while (notDone) {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (board[i][j] == "B|") {//if b is found add one to counter then goto loop
                        counter1++;
                        check = true;
                        while (check) {
                            if (checkColumn + i <= width - 1 && checkRow + j <= height - 1) {
                                if (board[i + checkColumn][j + checkRow] == "R|") {//if b is found add one to counter
                                    counter1++;
                                }
                            }

                            //adds one to checkers
                            checkColumn++;
                            checkRow++;

                            if (checkColumn == width - 1 || checkRow == height - 1) {//if outside of board break
                                check = false;
                                break;
                            }

                            if (counter1 >= 4) {//if counter gets to four then blue wins
                                System.out.println("Blue Wins!");
                                check = false;
                                notDone = false;
                                break;
                            }
                        }
                    }
                    if (counter1 >= 4) {
                        notDone = false;
                        break;
                    }

                    //resets counter and checkers
                    counter1 = 0;
                    checkColumn = 1;
                    checkRow = 1;
                }
            }
            break;
        }
        return notDone;
    }

    public static Boolean checkRDiagonalBack(int width, int height, String[][] board){
        //variables
        Boolean notDone = true;
        int counter1 = 0;
        Boolean check = false;
        int checkColumn = 1;
        int checkRow = 1;

        while (notDone) {//goes through until r is found3
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (board[i][j] == "R|") {//if r is found add one to counter then goto loop
                        counter1++;
                        check = true;
                        while (check) {//checks diagnolly for r
                            if (i - checkColumn >= 0 && j - checkRow >= 0) {
                                if (board[i - checkColumn][j - checkRow] == "R|"){
                                    counter1++;//if r is found adds to count
                                }
                            }

                            //adds 1 to checkers
                            checkColumn++;
                            checkRow++;

                            if ( checkColumn == 0 || checkRow == height - 1){//if outside of board break
                                check = false;
                                break;
                            }

                            if (counter1>=4){
                                System.out.println("Red Wins!");//if counter hits 4 then red wins
                                check = false;
                                notDone = false;
                                break;
                            }
                        }
                    }
                    if (counter1 >= 4){
                        notDone = false;
                        break;
                    }

                    //resets counters
                    counter1 = 0;
                    checkColumn = 1;
                    checkRow = 1;
                }
            }
            break;
        }
        return notDone;
    }

    public static Boolean checkBDiagonalBack(int width, int height, String[][] board){
            //variables
            Boolean notDone = true;
            int counter1 = 0;
            Boolean check = false;
            int checkColumn = 1;
            int checkRow = 1;

            while (notDone) {//goes through until b is found
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        if (board[i][j] == "B|") {//if b is found add one to counter then goto loop
                            counter1++;
                            check = true;
                            while (check) {//checks diagnolly for b
                                if (i - checkColumn >= 0 && j - checkRow >= 0) {
                                    if (board[i - checkColumn][j - checkRow] == "B|"){
                                        counter1++;//if b is found adds to count
                                    }
                                }

                                //adds 1 to checkers
                                checkColumn++;
                                checkRow++;

                                if ( checkColumn == 0 || checkRow == height - 1){//if outside of board break
                                    check = false;
                                    break;
                                }

                                if (counter1>=4){
                                    System.out.println("Blue Wins!");//if counter hits 4 then blue wins
                                    check = false;
                                    notDone = false;
                                    break;
                                }
                            }
                        }
                        if (counter1 >= 4){
                            notDone = false;
                            break;
                        }

                        //resets counters
                        counter1 = 0;
                        checkColumn = 1;
                        checkRow = 1;
                    }
                }
                break;
            }
            return notDone;
        }
}
