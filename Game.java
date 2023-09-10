import java.util.Scanner;
import java.util.Random;

class Building {
    int floor, room;
    Scanner sc = new Scanner(System.in);
    public Building(int floor, int room) {
        super();
        this.floor = floor;
        this.room = room;
    }

    public void printGameStatus(int turn, String arr[][]) {
        System.out.println("\nTurn " + turn + ":");
        System.out.println(" --- --- --- ---");
        for (int i = 0; i < floor; i++) {
            System.out.print("| ");
            for (int j = 0; j < room; j++) {
                System.out.print(arr[i][j] + " | ");
            }
            System.out.println("\n --- --- --- ---");
        }
    }

    public int getroom(String arr[][], int f, int r, String p, int ch) {
        int flag = 0;
        if (p.equals("1"))
            flag = 1;
        // Left
        if (ch == 1) {
            if (r - 1 < 0) {
                System.out.println("Can't go there");
                return 0;
            } else if (arr[f][r - 1].equals("12")) {
                if (flag == 1)
                    arr[f][r] = "2";
                else if (flag == 0)
                    arr[f][r] = "1";
                arr[f][r - 1] = p;
            } else if (arr[f][r - 1].equals("0")) {
                arr[f][r] = "0";
                arr[f][r - 1] = p;
            } else if (arr[f][r - 1].equals("*")) {
                arr[f][r] = "0";
                arr[f][r - 1] = p + "*";
            } else if (arr[f][r - 1].equals("1") || arr[f][r - 1].equals("2")) {
                arr[f][r] = "0";
                arr[f][r - 1] = "12";
            }
        }
        // Right
        else if (ch == 2) {
            if (r + 1 >= room) {
                System.out.println("Can't go there");
                return 0;
            } else if (arr[f][r + 1].equals("12")) {
                if (flag == 1)
                    arr[f][r] = "2";
                else if (flag == 0)
                    arr[f][r] = "1";
                arr[f][r + 1] = p;
            } else if (arr[f][r + 1].equals("0")) {
                arr[f][r] = "0";
                arr[f][r + 1] = p;
            } else if (arr[f][r + 1].equals("*")) {
                arr[f][r] = "0";
                arr[f][r + 1] = p + "*";
            } else if (arr[f][r + 1].equals("1") || arr[f][r + 1].equals("2")) {
                arr[f][r] = "0";
                arr[f][r + 1] = "12";
            }
        }
        // Down
        else if (ch == 3) {
            if (f + 1 >= floor) {
                System.out.println("Can't go there");
                return 0;
            } else if (arr[f + 1][r].equals("12")) {
                if (flag == 1)
                    arr[f][r] = "2";
                else if (flag == 0)
                    arr[f][r] = "1";
                arr[f + 1][r] = p;
            } else if (arr[f + 1][r].equals("0")) {
                arr[f][r] = "0";
                arr[f + 1][r] = p;
            } else if (arr[f + 1][r].equals("*")) {
                arr[f][r] = "0";
                arr[f + 1][r] = p + "*";
            } else if (arr[f + 1][r].equals("1") || arr[f + 1][r].equals("2")) {
                arr[f][r] = "0";
                arr[f + 1][r] = "12";
            }
        }
        // Up
        else if (ch == 4) {
            if (f - 1 < 0) {
                System.out.println("Can't go there");
                return 0;
            } else if (arr[f - 1][r].equals("12")) {
                if (flag == 1)
                    arr[f][r] = "2";
                else if (flag == 0)
                    arr[f][r] = "1";
                arr[f - 1][r] = p;
            } else if (arr[f - 1][r].equals("0")) {
                arr[f][r] = "0";
                arr[f - 1][r] = p;
            } else if (arr[f - 1][r].equals("*")) {
                arr[f][r] = "0";
                arr[f - 1][r] = p + "*";
            } else if (arr[f - 1][r].equals("1") || arr[f - 1][r].equals("2")) {
                arr[f][r] = "0";
                arr[f - 1][r] = "12";
            }
        }
        return 1;
    }

    public void searchPuppy(String arr[][], int pf, int pr, int hf, int hr, int rf, int rr, int turn) {
        printGameStatus(turn, arr);
        if (hf == pf && hr == pr) {
            System.out.println("Player 1 found the puppy and wins!");
            return;
        } else if (rf == pf && rr == pr) {
            System.out.println("Player 2 found the puppy and wins!");
            return;
        }
        if (turn % 2 == 1) {
            // Player 1's turn
            System.out.println("Player 1's turn :");
            System.out.println("Enter your choice: 1.Left 2.Right 3.Down 4.Up");
            int ch = sc.nextInt();
            if (ch == 1) {
                if (getroom(arr, hf, hr, "1", ch) == 1)
                    hr--;
            } else if (ch == 2) {
                if (getroom(arr, hf, hr, "1", ch) == 1)
                    hr++;
            } else if (ch == 3) {
                if (getroom(arr, hf, hr, "1", ch) == 1)
                    hf++;
            } else if (ch == 4) {
                if (getroom(arr, hf, hr, "1", ch) == 1)
                    hf--;
            }
            searchPuppy(arr, pf, pr, hf, hr, rf, rr, turn + 1);
        } else {
            // Player 2's turn
            System.out.println("Player 2's turn :");
            System.out.println("Enter your choice: 1.Left 2.Right 3.Down 4.Up");
            int ch = sc.nextInt();
            if (ch == 1) {
                if (getroom(arr, rf, rr, "2", ch) == 1)
                    rr--;
            } else if (ch == 2) {
                if (getroom(arr, rf, rr, "2", ch) == 1)
                    rr++;
            } else if (ch == 3) {
                if (getroom(arr, rf, rr, "2", ch) == 1)
                    rf++;
            } else if (ch == 4) {
                if (getroom(arr, rf, rr, "2", ch) == 1)
                    rf--;
            }
            searchPuppy(arr, pf, pr, hf, hr, rf, rr, turn + 1);
        }
    }
}

public class Game {

    public static void main(String[] args) {
        int floor, room;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter floor: ");
        floor = sc.nextInt();
        System.out.print("Enter room: ");
        room = sc.nextInt();

        // create an instance of Random class
        Random rand = new Random();

        String arr[][] = new String[floor][room];
        for (int i = 0; i < floor; i++) {
            for (int j = 0; j < room; j++) {
                arr[i][j] = "0";
            }
        }
        String puppy = "*";
        String harry = "1";
        String ron = "2";
        // Generate random integers in the range 0 to floor, room
        int hf = rand.nextInt(floor), hr = rand.nextInt(room);
        int rf = rand.nextInt(floor), rr = rand.nextInt(room);
        int pf = rand.nextInt(floor), pr = rand.nextInt(room);

        arr[pf][pr] = puppy;
        arr[hf][hr] = harry;
        arr[rf][rr] = ron;

        Building obj = new Building(floor, room);
        obj.searchPuppy(arr, pf, pr, hf, hr, rf, rr, 1);
    }
}