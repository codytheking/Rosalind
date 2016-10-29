package rosalind;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Complimenting a Strand of DNA
 * 
 * Converts a strand of DNA into its reverse compliment.
 * The string is reversed with each symbol being replaced
 * with its respective compliment (A and T, G and C).
 * 
 * @author Cody King 
 * @date 10/27/2016
 */
public class ReverseCompliment
{
	// prints the reverse compliment of a strand of DNA
    public static void reverseCompliment(String file) throws IOException
    {
        String rev = new StringBuilder(strand(file)).reverse().toString();

        String revComp = "";

        for(int i = 0; i < rev.length(); i++)
        { 
            if(rev.charAt(i) == 'A')
            {
                revComp += "T";
            }

            else if(rev.charAt(i) == 'T')
            {
                revComp += "A";
            }

            else if(rev.charAt(i) == 'C')
            {
                revComp += "G";
            }

            else if(rev.charAt(i) == 'G')
            {
                revComp += "C";
            }
        }

        System.out.println(revComp);
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
