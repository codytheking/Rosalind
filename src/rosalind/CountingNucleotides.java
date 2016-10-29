package rosalind;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Write a description of class CountingNucleotides here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class CountingNucleotides
{
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
