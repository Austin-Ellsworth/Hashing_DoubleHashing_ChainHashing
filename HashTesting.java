//Author: Austin Ellsworth

//this program is a test for each hash table that was created, including Table.java, TableDoubleHash.java and TableChainHash.java

import java.io.*; //to read in names.txt
import java.util.Scanner;

public class HashTesting {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner keyboard = new Scanner(System.in);
		Integer key;
		String name;
		int count = 0;
		double linearAve = 0, doubleAve = 0, chainAve = 0;
		File inFile = new File("names.txt");
		Scanner fromFile = new Scanner(inFile);
		
		Table<Integer, String> table1 = new Table<Integer, String>(241);
		TableDoubleHash<Integer, String> table2 = new TableDoubleHash<Integer, String>(241);
		TableChainHash<Integer, String> table3 = new TableChainHash<Integer, String>(241);
		
		System.out.println("Attempt    linear    double    chain");
		while(fromFile.hasNextLine()) {
			count++;
			name = fromFile.next();
			key = fromFile.nextInt();
			table1.put(key, name);
			table2.put(key, name);
			table3.put(key, name);
			System.out.print(count + "            ");
			System.out.print(table1.getCollisionCount() + "            ");
			System.out.print(table2.getCollisionCount() + "            ");
			System.out.println(table3.getCollisionCount() + "            ");
			linearAve += table1.getCollisionCount();
			doubleAve += table2.getCollisionCount();
			chainAve += table3.getCollisionCount();
		}

		System.out.println("Average for Linear = " + linearAve/200);
		System.out.println("Average for Double = " + doubleAve/200);
		System.out.println("Average for Chain = " + chainAve/200);
	}

}
