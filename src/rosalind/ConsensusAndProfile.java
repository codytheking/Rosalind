package rosalind;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Consensus and Profile
 * 
 * Given strands of DNA (of all equal length)
 * in FASTA format, return consensus string
 * and profile matrix.
 * 
 * @author Cody King
 * @date 10/29/2016
 */

public class ConsensusAndProfile 
{
	// prints consensus string and profile matrix
	public static void printConsensusProfile(String file) throws IOException
	{
		
		
	}
	
	// returns an ArrayList that has two ArrayLists of Strings (labels and strands)
	public static List<List<String>> strands(String file) throws IOException
	{
		Scanner inFile = new Scanner(new File(file));
		List<String> labels = new ArrayList<>();
		List<String> strands = new ArrayList<>();

		int i = -1;
		String str = "";

		while(inFile.hasNext())
		{
			str = inFile.next();

			if(str.charAt(0) != '>')
			{
				if(i > strands.size() - 1)
				{
					strands.add(str);
				}

				else
				{
					String currentStr = strands.get(i);
					strands.set(i, currentStr + str);
				}
			}

			else
			{
				i++;
				labels.add(str.substring(1));
			}
		}
		inFile.close();

		List<List<String>> together = new ArrayList<>();
		together.add(labels);
		together.add(strands);

		return together;
	}
}
