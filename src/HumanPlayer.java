import java.util.Scanner;

public class HumanPlayer extends Player
{
    //Constructor
    public HumanPlayer()
    {
        super();
    }

    public HumanPlayer(int range)
    {
        super(range);

    }

    //Instance methods
    @Override
    public void setName()
    {
        System.out.println("Player, input your name here:");
        super.setName();
    }

    @Override
    public void setChessLabel()
    {
        System.out.println(this.getName()+", input your chess label here:");
        super.setChessLabel();
    }

    @Override
    public void setCoordinateX()
    {
        System.out.println(this.getName()+", your turn to input your coordinate for x:");
        Scanner scanner = new Scanner(System.in);
        super.setX(inputRangedNumber(scanner)-1);
    }

    @Override
    public void setCoordinateY()
    {
        System.out.println(this.getName()+", your turn to input your coordinate for y:");
        Scanner scanner = new Scanner(System.in);
        super.setY(inputRangedNumber(scanner)-1);
    }
}

