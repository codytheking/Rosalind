package rosalind;

import java.util.Scanner;
import java.io.IOException;

/**
 * Write a description of class CountingNucleotides here.
 * 
 * @author King 
 * @version 10/27/2016
 */

public class RosalindRunner
{
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Your file should be in the root directory of the project. \nWhat is the file name? ");
        String fileName = input.next();
        input.close();

        CountingNucleotides.printOccur(fileName);
        //DNAtoRNA.replaceT(fileName);
        //ReverseCompliment.reverseCompliment(fileName);
        //NumRabbits.numRabbits(NumRabbits.nums(fileName)[0], NumRabbits.nums(fileName)[1]);
        //GcContent.gcContent(fileName);
        //CountingPointMutations.hammingDistance(fileName);
        //MendelsInheritance.dominantProb(fileName);
        //FindingMotif.printIndices(fileName);
    }
}
