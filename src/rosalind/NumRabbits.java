package rosalind;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Rabbits and Recurrence Relations
 * 
 * Finds the number of rabbit pairs in a population
 * after n months given initial k rabbit pairs.
 * 
 * @author Cody King 
 * @version 10/27/2016
 */
public class NumRabbits
{
	// given an array with two integers (n and k)
	// prints the number of rabbit pairs after n months with k initial pairs
    public static void numRabbits(String file) throws IOException
    {
    	int[] nums = nums(file);
    	int n = nums[0];
    	int k = nums[1];
        int nMinus2 = 1 + k;
        int nMinus1 = 1 + 2 * k;

        for(int i = 0; i < n - 3; i++)
        {
            int tmp2 = nMinus2;
            int tmp1 = nMinus1;

            nMinus2 = tmp1;
            nMinus1 = tmp1 + tmp2 * k;
        }

        System.out.println(nMinus2);
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
