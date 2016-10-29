package rosalind;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Counting Point Mutations
 * 
 * Calculates the Hamming distance, which
 * is the number of differences between
 * indices of two DNA strands.
 * 
 * @author Cody King 
 * @version 10/28/2016
 */

public class CountingPointMutations
{
	// prints the number of differences found between two strands
    public static void hammingDistance(String file) throws IOException
    {
        String[] strands = strands(file);
        int diffs = 0;
        
        for(int i = 0; i < strands[0].length(); i++)
        {
            if(strands[0].charAt(i) != strands[1].charAt(i))
            {
                diffs++;
            }
        }
        
        System.out.println(diffs);
    }
    
    // returns two DNA strands in an array
    public static String[] strands(String file) throws IOException
    {
        Scanner inFile = new Scanner(new File(file));
        String[] strands = new String[2];
        int i = 0;

        while(inFile.hasNext())
        {
            strands[i] = inFile.next();
            i++;
        }
        inFile.close();

        return strands;
    }
}
