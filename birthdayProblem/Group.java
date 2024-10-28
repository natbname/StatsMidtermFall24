import java.util.ArrayList;

public class Group
{
    private int groupSize;
    ArrayList<Person> group;
    
    public Group() 
    {
        groupSize = 0; 
        group = new ArrayList<Person>();
    }
    
    public Group(int chosenGroupSize) //constructor to initialize person with specific birthday
    {
        groupSize = chosenGroupSize;
        group = new ArrayList<Person>();
    }
    
    public void makeGroup()
    {
        for (int i = 0; i < groupSize; i++)
        {
            group.add(new Person()); //adds new person group
            group.get(i).generateBirthday(); //gives added person random birthday
        }
    }
    
    public void reset()
    {
        for (int i = groupSize-1; i > 0; i--)
        {
            group.remove(i);
        }
    }
    
    public boolean checkBirthdays()
    {
        for (int i = 0; i < groupSize; i++)
        {
            for (int j = i+1; j < groupSize; j++)
            {
                if (group.get(i).getBirthday() == group.get(j).getBirthday())
                {
                    return true; //gives true on first matching birthday.
                }
            }
        }
        return false; //no matching birthdays if all matches are gone through.
    }
    
    public void runProblem(int numRuns) //groups methods together for tester, loops for numRuns
    {
        double tally = 0;
        for (int i = 0; i < numRuns; i++)
        {
            makeGroup(); 
            if(checkBirthdays())
            {
                tally++;
            }
            reset();
        }
        double result = ((double)(tally/numRuns)*100); 
        System.out.println("The probability of a shared birthday in a group of "+ (int)groupSize + " people is "+result+"%."); 
    }
}
