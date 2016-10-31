package rosalind;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Mortal Fibonacci Rabbits
 * 
 * Rabbits live m months and create a pair of
 * offspring each month after living for one month.
 * This program gives the number of living rabbits
 * after n months.
 * 
 * @author Cody King
 * @date 10/29/2016
 *
 */

public class MortalRabbits 
{
	// Holds number of rabbits of each age (in months) in an array
	// Prints total rabbits living (die after m months) after n months
	public static void numRabbits(String file) throws IOException
	{
		int n = nums(file)[0];
		int m = nums(file)[1];
		
		BigInteger[] rabbitAges = new BigInteger[m];
		BigInteger[] holder = new BigInteger[m];
		
		Arrays.fill(rabbitAges, BigInteger.ZERO);
		Arrays.fill(holder, BigInteger.ZERO);
		rabbitAges[0] = BigInteger.ONE;
		
		for(int month = 2; month <= n; month++)
		{
			for(int i = 0; i < rabbitAges.length; i++)
			{
				if(i != 0)
				{
					holder[0] = holder[0].add(rabbitAges[i]);
				}
				
				if(i != rabbitAges.length - 1)
				{
					holder[i + 1] = holder[i + 1].add(rabbitAges[i]);
				}
			}
			
			System.arraycopy(holder, 0, rabbitAges, 0, holder.length);
			Arrays.fill(holder, BigInteger.ZERO);
			
			System.out.println(month);
		}
		
		BigInteger numRabbits = BigInteger.ZERO;
		
		for(int i = 0; i < rabbitAges.length; i++)
		{
			numRabbits = numRabbits.add(rabbitAges[i]);
		}
		
		System.out.println(numRabbits);
	}
	
	// returns two integers from file in an integer array
    public static int[] nums(String file) throws IOException
    {
        Scanner inFile = new Scanner(new File(file));
        int[] nums = new int[2];
        int i = 0;

        while(inFile.hasNext())
        {
            nums[i++] = inFile.nextInt();
        }
        inFile.close();

        return nums;
    }
}
