package rosalind;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Calculating Expected Offspring
 * 
 * Given number of couples possessing each of
 * the six combined phenotypes, given number
 * of expected offspring pairs.
 * 
 * @author Cody King
 * @date 11/1/2016
 *
 */

public class ExpectedOffspring 
{
	// print number of expected offspring pairs
	public static void printNumExpOffspring(String file) throws IOException
	{
		int[] numCouples = nums(file);
		double[] probs = {1.0, 1.0, 1.0, 0.75, 0.5, 0.0};
		
		double total = 0;
		
		for(int i = 0; i < numCouples.length; i++)
		{
			total += numCouples[i] * 2 * probs[i];
		}
		
		System.out.println(total);
	}
	
	// returns 6 integers from file in an integer array
    public static int[] nums(String file) throws IOException
    {
        Scanner inFile = new Scanner(new File(file));
        int[] nums = new int[6];
        int i = 0;

        while(inFile.hasNext())
        {
            nums[i++] = inFile.nextInt();
        }
        inFile.close();

        return nums;
    }  
}
