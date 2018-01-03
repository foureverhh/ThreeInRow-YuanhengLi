import java.util.Scanner;


public abstract class Player {

        private String name;
        private String chessLabel;
        private int range;
        private int point;
        private int x,y;
        private boolean playerIsMachine;

        //Constructor
        public Player()
        {

        }

        public Player(int range)                          //Human player constructor
        {
            this.range = range;
        }

        public Player(int range,boolean playerIsMachine) //Machine player constructor
        {
            this.range = range;
            this.playerIsMachine = true;
        }

        //Instance methods
        public abstract void setCoordinateX();   //Abstract class for player to set chess coordinate X

        public abstract void setCoordinateY();   //Abstract class for player to set chess coordinate Y

        public boolean isPlayerIsMachine() {
            return playerIsMachine;
        }

        public void setPlayerIsMachine() {
            this.playerIsMachine = true;
        }

        public void setX(int x)
        {
            this.x=x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setName()
        {
            Scanner scanner = new Scanner(System.in);
            this.name=inputString(scanner);
        }

        public void setChessLabel()
        {
            Scanner scanner = new Scanner(System.in);
            this.chessLabel=inputChessLabel(scanner);
        }

        public String getName()
        {
            return name;
        }

        public void setPoint()
        {
            this.point++;
        }

        public int getPoint()
        {
            return point;
        }

        public String getChessLabel() {
            return chessLabel;
        }

        public int getRange()
        {
            return range;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        private String inputString(Scanner sc)
        {
            while(true) {
                try {
                    String str = sc.next();
                    if (str==null||str.equals(""))
                    {
                        throw new Exception();
                    } else  {
                        return str;
                    }
                } catch (Exception e) {
                    System.out.println("Input as required please");
                }
            }
        }

        private String inputChessLabel(Scanner sc)
        {
            while(true)
            {
                try
                {
                    String str = sc.next();
                    if (str==null||str.equals(" "))
                    {
                        throw new StringIsNullException();
                    } else if (str.length()!=1)
                    {
                        throw new Exception();
                    }else {
                        return str;
                    }
                }catch(StringIsNullException e)
                {
                    System.out.println("Input should not be empty!");
                }
                catch (Exception e)
                {
                    System.out.println("Input just one letter please.");
                }
            }
        }

        public  int inputRangedNumber(Scanner sc)
        {
            while(true)
            {
                try
                {
                    String str = sc.nextLine();
                    int a = Integer.parseInt(str);
                    if(a >=1 && a <= range)
                    {
                        return a;
                    }
                    else
                    {
                        throw new Exception();
                    }
                }catch (Exception e)
                {
                    System.out.println("Input a number between 1 and row amount, please.");
                }
            }
        }
}


