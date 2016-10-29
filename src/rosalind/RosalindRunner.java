package rosalind;

import java.util.Scanner;
import java.io.IOException;

/**
 * This is the runner class for 
 * all of the Rosalind code from
 * http://rosalind.info/problems/list-view/
 * 
 * @author Cody King 
 * @date 10/27/2016
 */

public class RosalindRunner
{
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Your file should be in the root directory of the project. \nWhat is the file name? ");
        String fileName = input.next();
        input.close();

        // Method calls
        
        //CountingNucleotides.printOccur(fileName);
        //DNAtoRNA.replaceT(fileName);
        //ReverseCompliment.reverseCompliment(fileName);
        //NumRabbits.numRabbits(fileName);
        GcContent.gcContent(fileName);
        //CountingPointMutations.hammingDistance(fileName);
        //MendelsInheritance.dominantProb(fileName);
        //FindingMotif.printIndices(fileName);
    }
}
