package rosalind;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Counting DNA Nucleotides
 * 
 * Counts the number of times each
 * symbol (A, C, G, and T) occur in
 * a given DNA strand.
 * 
 * @author Cody King 
 * @date 10/27/2016
 */

public class CountingNucleotides
{
	// prints the number of occurrences of A, C, G, and T
    public static void printOccur(String file) throws IOException
    {
        int a = 0, c = 0, g = 0, t = 0;

        for(int i = 0; i < strand(file).length(); i++)
        {
            if(strand(file).charAt(i) == 'A')
            {
                a++;
            }

            else if(strand(file).charAt(i) == 'C')
            {
                c++;
            }

            else if(strand(file).charAt(i) == 'G')
            {
                g++;
            }

            else if(strand(file).charAt(i) == 'T')
            {
                t++;
            }
        }

        System.out.println(a + " " + c + " " + g + " " + t);
    }
    
    // returns DNA strand from file as String
    public static String strand(String file) throws IOException
    {
        Scanner inFile = new Scanner(new File(file));
        String str = "";

        while(inFile.hasNext())
        {
            str = inFile.next();
        }
        inFile.close();

        return str;
    }
}
