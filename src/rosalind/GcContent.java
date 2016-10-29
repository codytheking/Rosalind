package rosalind;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

/**
 * Computing GC Content
 * 
 * Gives ID of DNA strand with highest GC-content
 * and gives the calculated percentage.
 * 
 * @author Cody King 
 * @date 10/28/2016
 */
public class GcContent
{
	// given DNA strings in FASTA format
	// returns id of DNA of highest GC-content along with that percentage.
	public static void gcContent(String file) throws IOException
	{
		List<String> labels = strands(file).get(0); 
		List<String> strands = strands(file).get(1);
		int high = 0;
		double highPerc = 0;
		double gcCount = 0;

		for(int j = 0; j < labels.size(); j++)
		{
			for(int c = 0; c < strands.get(j).length(); c++)
			{
				if(strands.get(j).charAt(c) == 'G' || strands.get(j).charAt(c) == 'C')
				{
					gcCount++;
				}
			}

			if(gcCount / strands.get(j).length() >= highPerc)
			{
				highPerc = gcCount / strands.get(j).length();
				high = j;
			}

			gcCount = 0;
		}

		System.out.println(labels.get(high));
		System.out.println(highPerc * 100);
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
