import java.util.Random;


public class MachinePlayer extends Player
{


    //Constructor
    public MachinePlayer()
    {
        super();
    }

    public MachinePlayer(int range,boolean playerIsMachine)
    {
        super(range,playerIsMachine);

    }

    //Instance methods


    @Override
    public void setName()
    {
        System.out.println("Input a name for a machine player:");
        super.setName();
    }

    @Override
    public void setChessLabel()
    {
        System.out.println("Input one letter as chess label for the machine player "+this.getName()+" : ");
        super.setChessLabel();
    }

    @Override
    public void setCoordinateX()
    {
        Random random = new Random();
        super.setX(random.nextInt(getRange()));
    }

    @Override
    public void setCoordinateY()
    {
        Random random = new Random();
        super.setY(random.nextInt(getRange()));
    }
}
