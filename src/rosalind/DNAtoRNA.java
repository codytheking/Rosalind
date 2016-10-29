package rosalind;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Transcribing DNA to RNA
 * 
 * This converts a DNA strand into RNA
 * by replacing all T symbols with U
 * 
 * @author Cody King 
 * @date 10/27/2016
 */
public class DNAtoRNA
{
	// prints the converted RNA strand where all occurrences
	// of T have been replaced with U
    public static void replaceT(String file) throws IOException
    {
        String newStr = "";

        for(int i = 0; i < strand(file).length(); i++)
        { 
            if(strand(file).charAt(i) == 'T')
            {
                newStr += "U";
            }

            else
            {
                newStr += strand(file).substring(i, i + 1);
            }
        }

        System.out.println(newStr);
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
