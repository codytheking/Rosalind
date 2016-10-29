package rosalind;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Mendel's First Law
 * 
 * Given three integers k, m, and n, representing a 
 * population containing k+m+n organisms: k individuals 
 * are homozygous dominant for a factor, m are heterozygous, 
 * and n are homozygous recessive, finds the probability 
 * that two randomly selected mating organisms will produce 
 * an individual possessing a dominant allele.
 * 
 * @author Cody King 
 * @version 10/28/2016
 */
public class MendelsInheritance
{
    // prints probability that two randomly selected mating organisms 
	// will produce an individual possessing a dominant allele.
    public static void dominantProb(String file) throws IOException
    {
        int[] nums = strand(file);
        
        // probabilities of combinations yielding dominant offspring
        // using Punnett squares (never changes)
        final double[] probs = {1.0, 1.0, 1.0, 1.0, 0.75, 0.5, 1.0, 0.5, 0.0}; 
        
        double[] orgProbs = new double[nums.length * nums.length];
        double prob = 0;
        double totalOrgs = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            totalOrgs += nums[i];
        }
        
        for(int i = 0; i < nums.length * nums.length; i++)
        {
            if(i / 3 == i % 3)
            {
                orgProbs[i] = (nums[i / 3] / totalOrgs) * ((nums[i % 3] - 1) / (totalOrgs - 1));
            }
            
            else
            {
                orgProbs[i] = (nums[i / 3] / totalOrgs) * (nums[i % 3] / (totalOrgs - 1));
            }
            
            prob += orgProbs[i] * probs[i];
        }
        
        System.out.println(prob);
    }
    
    // reads in three integers from file and returns them in an array
    public static int[] strand(String file) throws IOException
    {
        Scanner inFile = new Scanner(new File(file));
        int[] nums = new int[3];
        int i = 0;

        while(inFile.hasNext())
        {
            nums[i] = inFile.nextInt();
            i++;
        }
        inFile.close();

        return nums;
    }
}
