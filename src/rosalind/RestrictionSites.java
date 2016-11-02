package rosalind;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Locating Restriction Sites
 * 
 * A DNA string is a reverse palindrome 
 * if it is equal to its reverse complement.
 * We find all reverse palindromes within
 * the DNA strand of length between 4 and 12.
 * 
 * @author Cody King
 * @date 11/1/2016
 *
 */

public class RestrictionSites 
{
	// print indices of occurrence with length 
	public static void printIndices(String file) throws IOException
	{
		String strand = strand(file);

		for(int i = 0; i < strand.length(); i++)
		{
			for(int l = 4; l <= 12; l++)
			{
				if(i + l <= strand.length() && isRevComp(strand.substring(i, i + l)))
				{
					System.out.println(i + 1 + " " + l);
				}
			}
		}
	}

	// pre: takes a DNA strand as String
	// post: returns true if strand is a reverse compliment, false otherwise.
	public static boolean isRevComp(String strand)
	{
		String rev = new StringBuilder(strand).reverse().toString();

		String revComp = "";

		for(int i = 0; i < rev.length(); i++)
		{ 
			if(rev.charAt(i) == 'A')
			{
				revComp += "T";
			}

			else if(rev.charAt(i) == 'T')
			{
				revComp += "A";
			}

			else if(rev.charAt(i) == 'C')
			{
				revComp += "G";
			}

			else if(rev.charAt(i) == 'G')
			{
				revComp += "C";
			}
		}
		
		if(revComp.equals(strand))
		{
			return true;
		}
		
		return false;
	}

	// returns an ArrayList that has the DNA strands
	public static String strand(String file) throws IOException
	{
		Scanner inFile = new Scanner(new File(file));
		String strand = "";
		String str = "";

		while(inFile.hasNext())
		{
			str = inFile.next();

			if(str.charAt(0) != '>')
			{
				strand += str;
			}
		}

		inFile.close();

		return strand;
	}
}
