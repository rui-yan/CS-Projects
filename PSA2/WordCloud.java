/* Header Comment 
 * Name: Rui Yan
 * Login: cs8bwaka 
 * Date: January 16, 2016
 * File: WordCloud.java 
 * Sources of Help: None  
 * 
 * This program will read in the words from a file, strip out any common words 
 * (i.e., the, a, an) and display the most occurring words in the input file 
 * to another output file or on console.
 * 
 */

import java.util.*;
import java.io.*;

/* 
 * Name: WordCloud
 * Purpose: This class contains several methods to find the n most frequent 
 *   words (exclude common words) and their counts of frequence in the 
 *   source file. 
 */

public class WordCloud {

	// The ArrayList to store the words and their associated counts
	ArrayList<WordPair> list;

	// construct the list
	public WordCloud() {
		list = new ArrayList<WordPair>();
	}

	/*
	 * Name: getWordsFromFile
	 * Purpose: This method constructs an ArrayList containing WordPairs 
	 *   for each word in the file. It will read all the words from the 
	 *   source file and update the Arraylist (add word into arraylist 
	 *   if the word is not in it and add the count of the word)
	 * Parameters: String filename, the name of the file which we wanna 
	 *   read from
	 * Return: void
	 */
	public void getWordsFromFile( String filename ) throws IOException {
		// Complete this method  TODO
		Scanner input = new Scanner(new File(filename));
		String s;
		while (input.hasNext()){ 
			//determine whether we should continue to read the input
			s = input.next();
			boolean exclude = true; 
			for (int i = 0; i < list.size(); i++){ 
				// for loop to update the list
				if (s.equalsIgnoreCase(list.get(i).getWord())){ 
					list.get(i).increment(); 
					//increase the value of count		
					exclude = false;
				}

			}
			if (exclude == true)	
				list.add(new WordPair(s)); 
			//add a new WordPair into the array
		}
	}

	/* 
	 * Name: getList 
	 * Purpose: An accessor method for the tester file(access to the 
	 *   arraylist) 
	 * Parameters: None. 
	 * Return: ArrayList<WordPair> list 
	 */
	public ArrayList<WordPair> getList(){
		return list;
	}

	/* 
	 * Name: findWordCount
	 * Purpose: This method will search for a word in the list and 
	 *   returns its count 
	 * Parameters: String word (the word to be searched in the ArrayList)
	 * Return: An integer which is the count of the input String word
	 */
	public int findWordCount(String word){
		// Complete this method TODO
		for(int i = 0; i < list.size(); i++){
			if (word.equalsIgnoreCase(list.get(i).getWord())){
				return list.get(i).getCount();
			}
		}
		return 0;
	}

	/* 
	 * Name: removeCommon 
	 * Purpose: This method will read each word from the specified file and 
	 * remove those words from the list. 
	 * Parameters: String omitFilename (the name of the file which contains 
	 *   commonly used words) 
	 * Return: void
	 */
	public void removeCommon( String omitFilename ) throws IOException {
		// Complete this method TODO
		Scanner in = new Scanner(new File(omitFilename));
		String omit;
		while (in.hasNext()){
			omit = in.next();
			for (int i = 0; i < list.size(); i++){
				if(omit.equalsIgnoreCase(list.get(i).getWord()))
				{
					list.remove(i);
					break;
					// restart the loop when we have 
					// removed a WordPair in the array
				}	
			}
		}
	}

	/* 
	 * Name: topNWords
	 * Purpose: This method finds the top n occurring words in the list 
	 * and returns it as an ArrayList. 
	 * Parameters: int n (n is the number of the most frequent words we 
	 * wanna get from the list)
	 * Return: an Arraylist<WordPair> that contains the most n frequent 
	 * words and their counts 
	 */
	public ArrayList<WordPair> topNWords(int n) {
		// Complete this method  TODO    
		ArrayList<WordPair> topWordsList = new ArrayList<WordPair>();  
		int count, index = 0;
		for (int k = 0; k < n; k++){
			int max = list.get(0).getCount();
			count = 0;
			index = 0;
			for (int i = 1; i < list.size(); i++){
				count = list.get(i).getCount();
				if (count > max){ // find a maximum count
					max = count;
					index = i;
				}
			}
			topWordsList.add(list.get(index));
			list.get(index).setCount(-1*list.get(index).getCount());		
		}	   
		// turn the negative count back to the original one
		for (int i = 0; i < list.size(); i++){
			count = list.get(i).getCount();
			if (list.get(i).getCount() < 0)
				list.get(i).setCount(-1*count);
		}

		return topWordsList;
		// You may need to use your own variable names
		// but max below is the WordPair to print
		//System.out.print(max.getWord() + "("+ max.getCount()+") ");
	}

	/* 
	 * Name: printWords
	 * Purpose: This method takes in an ArrayList of WordPairs and a 
	 * boolean printToFile. 
	 *   If printToFile is true, it should output the arraylist of wordpair 
	 *   with their counts to a file named myOutput.out. 
	 *   If printToFile is false, it should print the arraylist of wordpair 
	 *   with their counts on the console. 
	 * Parameters: ArrayList<WordPair>wordList (the arraylist of the 
	 *   wordpair we wanna print out); boolean printToFile (the boolean 
	 *   to decide whether we should print the arraylist on the console 
	 *   or to a file)
	 * Return: void
	 */
	public void printWords(ArrayList<WordPair>wordList,boolean printToFile)
		throws IOException{
		//Complete this method TODO

		if (printToFile == false){
			for (int i = 0; i < wordList.size(); i++)
				// print on console
				System.out.print(wordList.get(i).getWord()+
						"("+wordList.get(i).getCount()
						+")"+" ");
		}

		else if (printToFile == true){
			PrintWriter writer = new PrintWriter("myOutput.out");
			// write into text
			for (int i = 0; i < wordList.size(); i++){
				writer.print(wordList.get(i).getWord()+
						"("+wordList.get(i).getCount()
						+")"+" ");
			}
			writer.close();
		}
	}
}
