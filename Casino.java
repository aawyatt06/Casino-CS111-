public class Casino {
    public static void main(String[] args) {
        // the number 1,000,000 for quicker typing
        int oneMillion = 1_000_000;

        // creats a new slotMachine array of one million
        SlotMachine[] slotMachines = new SlotMachine[oneMillion];

        // runs one million types
        for (int i = 0; i < oneMillion; i++) {
            // creates a new slot machine in the array
            slotMachines[i] = new SlotMachine();
            // checks the resault of each slotMachine
            slotMachines[i].isWinner();
        }
        // gets the number of player wins
        long totalPlayerWins = SlotMachine.getNumPlayerWins();
        // gets the number of house wins
        long totalHouseWins = SlotMachine.getNumHouseWins();
        // adds the house wins and the player wins to get the total number of rolls
        long totalRolls = totalHouseWins + totalPlayerWins;
        // gets the odds of winning by the equation (totalPlayerWins/totalRolls) * 100
        double oddsOfWinning = ((double) totalPlayerWins / totalRolls) * 100;

        // presents the information
        System.out.println("The Casino won " + totalHouseWins + " of times");
        System.out.println("The Player won " + totalPlayerWins + " of times");
        // uses printf to round to two decimal places
        System.out.printf("The chance of you winning is : %.2f%%\n", oddsOfWinning);

    }
}
