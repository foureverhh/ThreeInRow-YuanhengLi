import java.util.Scanner;

public class Game {
    public static void main(String[] args)
    {
        int rowAndCol;
        boolean gameGoesOn=true;
        String winner = "";

        //Create a game board
        rowAndCol = rowAmount();
        Board board = new Board(rowAndCol);

        //Create players
        Player player1 = new HumanPlayer();
        Player player2 = new HumanPlayer();

        //Set game mode
        gamePattern();
        System.out.println("Decide your game pattern please?(0-3)");
        Scanner scanner = new Scanner(System.in);
        int choice=inputGameChoice(scanner);
        switch (choice)
        {
            case 1:
                player1 = new HumanPlayer(rowAndCol);
                player2 = new MachinePlayer(rowAndCol,true);
                player2.setPlayerIsMachine();
                break;
            case 2:
                player1 = new HumanPlayer(rowAndCol);
                player2 = new HumanPlayer(rowAndCol);
                break;
            case 3:
                player1 = new MachinePlayer(rowAndCol,true);
                player2 = new MachinePlayer(rowAndCol,true);
                break;
            case 0:
                System.exit(0);
        }

        //Set name and chess label for both players.
        configurePlayer(player1);
        configurePlayer(player2);
        while(player2.getChessLabel().equals(player1.getChessLabel()))
        {
            System.out.println("Input a different chess label to player2.");
            player2.setChessLabel();
        }

        //Create a new board.
        board.newBoard();
        board.printBoard();

        //Two while-loops to check winner and control restart.
        while(gameGoesOn)
        {
            while(true)
            {
                if(checkPlayerMove(player1,player2,board,winner))
                    break;
                else if(checkPlayerMove(player2,player1,board,winner))
                    break;
            }
            gameGoesOn = restartGame(player1,player2,board);
        }
    }

    //If here is a winner or all blocks are used up return true, then end the inner while-loop
    private static boolean checkPlayerMove(Player player,Player otherPlayer, Board board,String winner)
    {
        winner = board.playerMove(player);
        if (winner.equals(player.getName()))     //Check whether here is a winner first
        {
            System.out.println("Winner is "+ winner +"\n"+
                    player.getName()+" wins "+ player.getPoint()+" times."+"\n"+
                    otherPlayer.getName()+" wins "+ otherPlayer.getPoint()+" times."+"\n");

            return true;
        }
        if (board.getBlockAmount() == 0)          //Check whether all blocks are taken then
        {
            System.out.println("Even! No winner this round"+"\n"+
                    player.getName()+" wins "+ player.getPoint()+" times."+"\n"+
                    otherPlayer.getName()+" wins "+ otherPlayer.getPoint()+" times."+"\n");

            return true;
        }
        return false;
    }

    private static boolean restartGame(Player player,Player otherPlayer,Board board)
    {
        System.out.println("Game continues?(Y/N)");
        Scanner scanner = new Scanner(System.in);
        if(scanner.next().toLowerCase().equals("n")) //If players do not want to continue show final result.
        {
            System.out.println("Game is over!"+"\n"+
                    player.getName()+" won "+ player.getPoint()+" times."+"\n"+
                    otherPlayer.getName()+" won "+ otherPlayer.getPoint()+" times."+"\n");
            return false;
        }else                                        //Otherwise start a new game.
        {
            board.newBoard();    //Create a new board and initialise block amount.
            board.printBoard();  //Print out board.
            return true;
        }

    }

    private static void configurePlayer(Player player){
        player.setName();
        player.setChessLabel();
    }

    private static void gamePattern()
    {
        System.out.println("Choose your game pattern as follow:");
        System.out.println("Input 1 to play with a machine.");
        System.out.println("Input 2 to play with your friend.");
        System.out.println("Input 3 to see two machines play with each other.");
        System.out.println("Input 0 to quit the game.");
    }

    private static int inputGameChoice(Scanner sc)
    {
        while(true)
        {
            try {
                String str = sc.nextLine();
                int value = Integer.parseInt(str);
                if (value >= 0 && value <= 3) {
                    return value;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Input a number as required, please.");
            }
        }
    }

    private static int rowAmount()
    {
        System.out.println("How many rows do you want to have on the board?(A number >= 3)");
        Scanner scanner = new Scanner(System.in);
        return inputRowAndCol(scanner);

    }

    private static int inputRowAndCol(Scanner sc)
    {
        while(true)
        {
            try
            {
                String str = sc.nextLine();
                int value = Integer.parseInt(str);
                if(value >=3)
                {
                    return value;
                }else {
                    throw new Exception();
                }
            } catch (Exception e)
            {
                System.out.println("Input a number which is bigger or equals 3.");
            }
        }

    }

}


