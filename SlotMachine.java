import java.util.Random;

public class SlotMachine {
    // number of wins for the house and player
    private static int numPlayerWins = 0;
    private static int numHouseWins = 0;
    // the reels of the slot
    private int[][] reels;

    // runs automaticlly
    public SlotMachine() {
        // sets the reels up as a 3x3 gird
        this.reels = new int[3][3];

        // runs gambleMachine
        this.gambleMachine();
    }

    public void gambleMachine() {
        // creates a random object
        Random rng = new Random();
        // runs 3 times
        for (int i = 0; i < 3; i++) {
            // runs 3 times
            for (int j = 0; j < 3; j++) {
                // goes trough each reel, i, j and assigns a number 1-9
                reels[i][j] = rng.nextInt(9) + 1;
            }
        }
    }

    // checks if it was a winning roll
    public boolean isWinner() {
        // start by assuming it wasn't
        boolean won = false;

        // runs 3 times
        for (int i = 0; i < 3; i++) {
            /*
             * checks the reel i with each row of the reel. EX: [i][0]
             * the first time around is checking [0][0], which is the top left
             * cornner of the gird, [0][1] the top middle, and [0][2] the top right.
             */
            if (this.reels[i][0] == this.reels[i][1] && this.reels[i][1] == this.reels[i][2]) {
                // if all three in a row is equal won = true.
                won = true;
            }
        }
        // if no horzinatal wins it then checks for diagonal wins
        if (!won) {
            // checks the if the top right, middle, and bottom left is equal.
            if (this.reels[0][2] == this.reels[1][1] && this.reels[1][1] == this.reels[2][0]) {
                won = true;
                // checks if the top left, middle, and bottom right is equal.
            } else if (this.reels[0][0] == this.reels[1][1] && this.reels[1][1] == this.reels[2][2]) {
                won = true;
            } else {
                // if not won = false.
                won = false;
            }
        }

        // counts the number of house and player wins.
        if (won) {
            // if won player wins + 1.
            numPlayerWins += 1;
        } else {
            // if lost(!won) house wins + 1.
            numHouseWins += 1;
        }

        // returns the boolean won.
        return won;

    }

    // returns the number of players wins when called as a long.
    public static long getNumPlayerWins() {
        return numPlayerWins;
    }

    // returns the number of house wins when called as a long.
    public static long getNumHouseWins() {
        return numHouseWins;
    }
}
