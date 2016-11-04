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
		List<String> strands = strands(file);
		int numStrands = strands.size();
		int strandLength = strands.get(0).length();
		int[][] profileMatrix = new int[4][strandLength];
		char[] consensusString = new char[strandLength];

		for(int r = 0; r < 4; r++)
		{
			for(int c = 0; c < strandLength; c++)
			{
				for(int s = 0; s < numStrands; s++)
				{
					if(strands.get(s).indexOf(symbol(r), c) == c)
					{
						profileMatrix[r][c]++;
					}
				}

			}
		}

		int max = 0;

		for(int c = 0; c < strandLength; c++)
		{
			for(int r = 0; r < 4; r++)
			{
				if(profileMatrix[r][c] > max)
				{
					max = profileMatrix[r][c];
					consensusString[c] = symbol(r);
				}
			}
			
			max = 0;
		}

		for(int i = 0; i < strandLength; i++)
		{
			System.out.print(consensusString[i]);
		}
		
		for(int r = 0; r < 4; r++)
		{
			System.out.print("\n" + symbol(r) + ": ");

			for(int c = 0; c < strandLength; c++)
			{
				System.out.print(profileMatrix[r][c] + " ");
			}
		}
	}

	public static char symbol(int c)
	{
		char s = 'T';

		if(c == 0)
		{
			s = 'A';
		}

		else if(c == 1)
		{
			s = 'C';
		}

		else if(c == 2)
		{
			s = 'G';
		}

		return s;
	}

	// returns an ArrayList that has the DNA strands
	public static List<String> strands(String file) throws IOException
	{
		Scanner inFile = new Scanner(new File(file));
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
			}
		}
		inFile.close();

		return strands;
	}
}
