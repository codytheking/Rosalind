package rosalind;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Finding a Motif in DNA
 * 
 * Given a strand of DNA, returns
 * all indices (convention is 1 to size) 
 * where the motif is found.
 * 
 * @author Cody King
 * @version 10/28/2016
 */
public class FindingMotif
{
	// returns beginning indices where substring is found
    public static void printIndices(String file) throws IOException
    {
        String strand = strand(file)[0];
        String sub = strand(file)[1];
        List<Integer> indices = new ArrayList<>();
        
        for(int i = 0; i < strand.length() - sub.length(); i++)
        {
            if(sub.equals(strand.substring(i, i + sub.length())))
            {
                indices.add(i + 1);
            }
        }
        
        System.out.print("\n");
        
        for(int i = 0; i < indices.size(); i++)
        {
            System.out.print(indices.get(i) + " ");
        }
    }
    
    // reads in strand and motif and returns Strings in an array
    public static String[] strand(String file) throws IOException
    {
        Scanner inFile = new Scanner(new File(file));
        String[] strAndSub = new String[2];
        int i = 0;

        while(inFile.hasNext())
        {
            strAndSub[i] = inFile.next();
            i++;
        }
        inFile.close();

        return strAndSub;
    }
}
