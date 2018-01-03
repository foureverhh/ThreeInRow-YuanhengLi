public class Board
{
    private int rowAndCol;
    private int blockAmount;
    private int x,y;
    private String[][] board;


    //Constructor
    public Board(int rowAndCol)
    {
        this.rowAndCol = rowAndCol;
        this.blockAmount = rowAndCol*rowAndCol;
        this.board = new String[rowAndCol][rowAndCol];
    }

    //Instance methods
    public void newBoard()                         //create a new board
    {
        for(int i = 0;i<rowAndCol;i++)
            for(int j = 0; j<rowAndCol;j++)
                board[i][j]=" ";

        this.blockAmount = rowAndCol*rowAndCol;    //initialise full blocks amount
    }

    public void printBoard()        //print out a key board with X and Y coordinate
    {
        System.out.println();
        System.out.println("Enjoy your game,and good luck!");
        System.out.println();
        System.out.print("    ");
        for(int i=0;i<board.length;i++)
        {
            System.out.print(" Y:"+(i+1)+" ");
        }
        System.out.println();

        System.out.print("    ");
        for(int i=0;i<board.length;i++)
        {
            System.out.print(" ----");
        }
        System.out.println();

        for(int i=0;i<board.length;i++)
        {

            System.out.print("X:"+(i+1)+" ");
            for(int j=0;j<board.length;j++)
            {
                System.out.print("| "+board[i][j]+"  ");
            }
            System.out.println("|  ");
            System.out.print("    ");
            for(int k=0;k<board.length;k++)
            {
                System.out.print(" ----");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void getChess(Player p)     //Get the chess place that the player want to have
    {
        p.setCoordinateX();
        p.setCoordinateY();

        while(!board[p.getX()][p.getY()].equals(" ") && !board[p.getX()][p.getY()].isEmpty())
        {
            if(!p.isPlayerIsMachine())
            {
                System.out.println(p.getName()+", the place you chose is taken, try again.");
            }
            p.setCoordinateX();
            p.setCoordinateY();
        }
        board[p.getX()][p.getY()]=p.getChessLabel();
    }

    public String playerMove(Player p)
    {
        getChess(p);
        blockAmount--;
        printBoard();

        if(!checkWinnerHorizontally(p).equals("")) {
            p.setPoint();
            return checkWinnerHorizontally(p);
        }
        if(!checkWinnerVertically(p).equals("")) {
            p.setPoint();
            return checkWinnerVertically(p);
        }
        if(!checkWinnerDiagonallySlash(p).equals("")) {
            p.setPoint();
            return checkWinnerDiagonallySlash(p);
        }
        if(!checkWinnerDiagonallyBackSlash(p).equals("")) {
            p.setPoint();
            return checkWinnerDiagonallyBackSlash(p);
        }
        return "";
    }

    private String checkWinnerHorizontally(Player p)
    {
        int i=0;
        while(i<rowAndCol)
        {
            int k=0;
            for (int j = 0; j < rowAndCol; j++)
            {
                if(!board[i][j].equals(p.getChessLabel()))
                {
                    break;
                }else
                {
                    k++;
                }
            }
            if(k==rowAndCol){
                return p.getName();
            }
            i++;
        }
        return "";
    }

    private String checkWinnerVertically(Player p)
    {
        int i=0;
        while(i<rowAndCol)
        {
            int k=0;
            for (int j = 0; j < rowAndCol; j++)
            {
                if(!board[j][i].equals(p.getChessLabel()))
                {
                    break;
                }else
                {
                    k++;
                }
            }
            if(k==rowAndCol){
                return p.getName();
            }
            i++;
        }
        return "";
    }

    private String checkWinnerDiagonallySlash(Player p)
    {
        int k=0;
        for (int i = 0; i < rowAndCol; i++)
        {
            if(!board[i][rowAndCol-i-1].equals(p.getChessLabel()))
            {
                break;
            }else
            {
                k++;
            }
        }
        if(k==rowAndCol){
            return p.getName();
        }else{
            return "";
        }
    }

    private String checkWinnerDiagonallyBackSlash(Player p)
    {
        int k=0;
        for (int i = 0; i < rowAndCol; i++)
        {
            if(!board[i][i].equals(p.getChessLabel()))
            {
                break;
            }else
            {
                k++;
            }
        }
        if(k==rowAndCol){
            return p.getName();
        }else{
            return "";
        }
    }

    public int getBlockAmount() {
        return blockAmount;
    }
}

