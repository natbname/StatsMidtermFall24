import java.util.Random;

public class GameSim
{
    private Random rng = new Random();
    private double winCount; 
    private boolean gameResult;
       
    public void gameSim() //blank constructor
    {
       winCount = 0; 
       gameResult = false;
    }
    
    public boolean game(boolean changeDoor) //boolean changedoor: after third curtain is opened, will they switch their choice?
    {
        int win = rng.nextInt(3); //winning "curtain"
        int select = rng.nextInt(3); //chosen "curtain"
        
        if (win == select)
        {
            if(!changeDoor)
            {
                gameResult = true;
            }
            else
            {
                gameResult = false;
            }
        }
        else if(win != select)
        {
            if(changeDoor)
            {
                gameResult = true;
            }
            else 
            {
                gameResult = false;
            }
        }
        return gameResult;
    }
    
    public double loop(boolean changeDoor)
    {
        winCount = 0;
        for(int i = 0; i < 10000; i++) //to generate % probability value, run 10k times
        {
            if (game(changeDoor))
            {
                winCount++; 
            }
        }
        return winCount/100; //divding by 100 so that it formats as a %
    }
}
