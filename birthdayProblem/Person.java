import java.util.Random;

public class Person
{
    private int birthday; //days of the year, such that 1 = jan 1, 365 = dec 31. 
    private Random rng = new Random();
    
    public Person() //default constructor
    {
        birthday = 1; 
    }
    
    public Person(int chosenBirthday) //constructor to initialize person with specific birthday
    {
        birthday = chosenBirthday;
    }
    
    public void setBirthday(int newBirthday) //setter: modifies birthday after person object constructed
    {
        birthday = newBirthday;
    }
    
    public int getBirthday() //returns birthday as int
    {
        return birthday;
    }
    
    public void generateBirthday() //sets birthday using random object
    {
        setBirthday(rng.nextInt(365) + 1); //generates number 1-365
    }
}
