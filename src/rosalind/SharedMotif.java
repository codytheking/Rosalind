package rosalind;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Finding a Shared Motif
 * 
 * Returns the longest common substring
 * among the DNA strands in the file given
 * in FASTA format.  
 * 
 * @author cking
 * @date 11/4/2016
 */

public class SharedMotif 
{
	// finds and prints longest common substring
	public static void printLongestSub(String file) throws IOException
	{
		List<String> strands = strands(file);
		String longest = "";
		String sub = "";
		int count = 0;

		for(int j = 0; j < strands.get(0).length() - 1; j++)
		{
			for(int k = j + 1 + longest.length(); k < strands.get(0).length(); k++)
			{
				sub = strands.get(0).substring(j, k);

				for(int s = 0; s < strands.size(); s++)
				{
					if(strands.get(s).indexOf(sub) != -1)
					{
						count++;
					}
				}

				if(count == strands.size() && sub.length() > longest.length())
				{
					longest = sub;
				}

				count = 0;
			}
		}

		System.out.println(longest);
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
