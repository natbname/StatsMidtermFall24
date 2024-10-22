public class GameTester
{
    public static void main(String[] args)
    {
        GameSim firstGame = new GameSim();
        System.out.println("Chance of success over 10,000 trials, without changing curtain: "+ firstGame.loop(false) + "%");
        System.out.println("Chance of success over 10,000 trials, when changing curtian: " + firstGame.loop(true) + "%");
    
        /**
          Textbook page 34, question 2.20:
          a. If the contestant choses a curtain at random, they have around a 1/3, or 33% chance of picking the curtain with the 
             prize.
          b. The host reveals an empty curtian, and gives the contestant a chance to change their door choice. 
              i. If the contestant stays with their orginial choice, they have the same probability of winning (33%).
              ii. If they switch curtains, after selecting the one with the prize, they will not win the prize.
              iii. However, if they initially picked an empty curtian, changing their choice allows them to win the prize. 
              iv. In general, switching curtians gives the contestant a 2/3, or 67%, chance of winning. 
              v. As shown by the above program, switching curtains greatly increases the probability of winning the prize. 
         */
    
    }
}
