import java.math.BigInteger;

public class Functions 
{  
    public double findMean(double[] userInput) 
    {
        double sum = 0;
        for(int i = 0; i < userInput.length; i++)
        {
            sum = userInput[i] + sum;
        }
        double result = sum / userInput.length;
        return result;
    }      
    
    public double findMedian(int[] userInput) 
    {
        double result;
        if(userInput.length%2 != 0)//odd length 
        {
            int medIndex = userInput.length/2; //rounds up (.5)
            result = userInput[medIndex];
        }
        else //even length, need to find mean of two middle. requires double return value
        {
            double first = userInput.length/2;
            double second = userInput.length/2 + 1;
            
            double[] middleNums = {first, second};
            result = findMean(middleNums);
        }
        return result;        
    }
    
    public int findMode(int[] userInput) 
    {
        int count;
        int maxCount = 0;
        int maxNum = 0;
        int[] counts = new int[userInput.length];
        
        for(int i = 0; i < userInput.length; i++)
        {
            count = 0;
            for(int j = 0; j < userInput.length; j++)
            {
                if(userInput[i] == userInput[j])
                {
                    count++;
                }
            }
            if(count > maxCount)
            {
                maxCount = count;
                maxNum = userInput[i];
            }
        }
        return maxNum;
    }
    
    public void remove(int index, int[] input)
    {
        int k = 0;
        for (int i = index+1; i < input.length; i++)
        {
            input[i-1] = input[i];
            k++;
        }
        input[index+k] = 0;
    }
    
    public int[] union(int[] set1, int set2[]) //used for reference: https://stackoverflow.com/questions/51113134/union-or-intersection-of-java-sets
    {
        int[] temp = new int[set1.length+set2.length];
        for(int i = 0; i < set1.length; i++)
        {
            temp[i] = set1[i];
        }
        int k = 0;
        for(int i = set1.length; i < temp.length-1; i++)
        {
            temp[i] = set2[k];
            k++;
        }
            
        for (int i = 0; i < set1.length; i++) 
        {
            for(int j = 0; j < set2.length; j++)
            {
                if(temp[i] == (temp[j]) && i != j) 
                {
                    remove(i, temp);
                }
            }
        }
        return temp;
    }
    
    public int[] intersection(int[] set1, int[] set2) 
    {
        int k = 0;
        int[] temp = new int[set1.length];
        for(int i = 0; i < set1.length; i++)
        {
            for(int j = 0; j < set2.length; j++)
            {
                if(set1[i] == set2[j]) 
                {
                    temp[k] = set1[i];
                    k++;
                }
            }
        }
        return temp;
    }
    
    public int[] complement(int[] set, int[] sample)
    {
        int[] temp = new int[sample.length];
        for(int i = 0; i < set.length; i++)
        {
            temp[i] = sample[i];
        }
        for(int i = 0; i < set.length; i++)
        {
           for(int j = 0; j < set.length; j++)
           {
               if(temp[i] == set[j])
               {
                   remove(i, temp);
               }
           }  
        }
        return temp;
    }
    
    public void printArray(double[] input)
    {
        System.out.print("[");
        for(int i = 0; i < input.length-1; i++)
        {
            System.out.print(input[i]);
            System.out.print(",");
        }
        System.out.print(input[input.length-1]+"]");
    }
    
    public double findVariance(double[] userInput)
    {
        double firstMean = findMean(userInput);
        double sum = 0;
        for(int i=0; i < userInput.length; i++)
        {
            sum = sum + (Math.pow((userInput[i] - firstMean),2));
        }
        return sum /(userInput.length - 1);
    }
    
    public double findStandardDev(double[] userInput)
    {
        return Math.sqrt(findVariance(userInput));
    }
    
    public double conditionalProb(int[] A, int[] B)
    {
        double probIntersect = ((intersection(A,B).length)/(B.length+A.length));
        double probB = (B.length/(B.length+A.length));
        return probB;
    }
    
    public boolean isIndependent(int[] A, int[] B)
    {
        double probA = (A.length/(A.length+B.length)); //this fraction gives % of elements in set a+b that belong to a
        double probB = (B.length/(B.length+A.length)); //% of elements in set that belong to b.
        
        if(conditionalProb(A,B)!= probA) 
        {
            return false;
        }
        if (conditionalProb(B,A) != probB)
        {
            return false;
        }
        if(intersection(A,B).length != (probA*probB))
        {
            return false;      
        }
        else //elif all above are true, independent is true.
        {
            return true;
        }
    }
    
    public BigInteger bigFactorial(int num)
    {
        BigInteger Temp = BigInteger.valueOf(1); //holds total factorial. initalized at 1 to handle 0!
        BigInteger I = BigInteger.valueOf(1); //holds i value. starts at first loop val 1
        for(int i = 1; i <= num; i++)
        {
            I = I.valueOf(i); //this loop's factor
            Temp = Temp.multiply(I); //previous temp * i
        }
        return Temp;
    }
    
    public long longFactorial(int num) //bigFactorial() modified to handle longs. used for rest of methods
    {
        Long temp = (long)1; //holds total factorial. initalized at 1 to handle 0!
        Long iVal = (long)1; //holds i value. starts at first loop val 1
        for(int i = 1; i <= num; i++)
        {
            iVal = (long)i; //casting i to long, this loop's factor
            temp = temp*i; //previous temp * i
        }
        return temp;
    }
    
    public long permutation(int n, int r) 
    {
        return longFactorial(n)/longFactorial(n-r); 
    }
    
    public long combination(int n, int r) 
    {
        return longFactorial(n)/(longFactorial(r)*longFactorial(n-r));
    }
    
    public double binomialDist(int n, int y, double p, double q) 
    {
        return combination(n,y)*Math.pow(p,y)*Math.pow(q,(n-y));
    }
    
    public double binomialExpected(int n, double p) 
    {
        return n*p;
    }
    
    public double binomialVariance(int n, double p, double q) 
    {
        return n*p*q;
    }
    
    public double geometricDist(int y, double p, double q) 
    {
        return Math.pow(q, y-1)*p;
    }
    
    public double geometricExpected(double p) 
    {
        return 1/p;
    }
    
    public double geometricVariance(double p) 
    {
        return (1-p)/Math.pow(p,2);
    }
}