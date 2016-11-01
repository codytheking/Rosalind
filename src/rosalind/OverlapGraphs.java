package rosalind;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Overlap Graphs
 * 
 * 
 * 
 * @author Cody King
 * @date 10/31/2016
 */

public class OverlapGraphs 
{
	// prints adjacency list
	public static void adjList(String file) throws IOException
	{
		List<String> labels = strands(file).get(0); 
		List<String> strands = strands(file).get(1);
		int k = 3;
		String str1 = "", str2 = "";
		
		for(int i = 0; i < strands.size(); i++)
		{
			for(int j = 0; j < strands.size(); j++)
			{
				str1 = strands.get(i);
				str2 = strands.get(j);
				if(!str1.equals(str2) && 
						str1.substring(str1.length() - k).equals(str2.substring(0, k)))
				{
					System.out.println(labels.get(i) + " " + labels.get(j));
				}
			}
		}
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
