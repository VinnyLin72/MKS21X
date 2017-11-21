import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class WordSearch{
    
    private char[][]data;
    private ArrayList<String>wordsToAdd;
    private ArrayList<String>wordsAdded;
    private Random randgen;
 
    public WordSearch(int rows, int cols, String fileName){
	wordsToAdd = new ArrayList<String>(0);
	wordsAdded = new ArrayList<String>(0);
	try{
	    File words = new File(fileName);
	    Scanner in = new Scanner(words);
	    while(in.hasNext()){
		String word = in.next();
		wordsToAdd.add(word);
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(1);
	}
	data = new char[rows][cols];
	clear();
	addAllWords();
	fillin();
    }
    
    public WordSearch(int rows, int cols, String fileName, int randSeed){
	wordsToAdd = new ArrayList<String>(0);
	wordsAdded = new ArrayList<String>(0);
	try{
	    File words = new File(fileName);
	    Scanner in = new Scanner(words);
	    while(in.hasNext()){
		String word = in.next();
		wordsToAdd.add(word);
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found");
	}
	data = new char[rows][cols];
	randgen = new Random(randSeed);
	clear();
	addAllWords();
	fillin();
    }
    public WordSearch(int rows, int cols, String filename, int randSeed, String answer){
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
	try {
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    while (in.hasNext()){
		String word = in.next();
		wordsToAdd.add(word);
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found: " + filename);
	    System.exit(1);
	}
	data = new char[rows][cols];
	randgen = new Random(randSeed);
	clear();
	addAllWords();
	if (answer != "key") System.out.println("To view answers, please enter 'key'");
    }

    private void fillin(){
	String str = "abcdefghijklmnopqrstuvwxyz";
	for(int r = 0; r < data.length; r ++){
	    for(int c = 0; c < data[r].length; c ++){
		if (data[r][c] == '_')data[r][c] = str.charAt(Math.abs(randgen.nextInt() % 26));
	    }
	}
    }

    private boolean addAllWords(){
	int i = 0;
	while(i < wordsToAdd.size()){
	    if (addWord(wordsToAdd.get(i), Math.abs(randgen.nextInt() % data.length),  Math.abs(randgen.nextInt() % data[0].length))){
		wordsAdded.add(wordsToAdd.get(i));
		wordsToAdd.remove(i);
	    }
	    wordsToAdd.trimToSize();
	    wordsAdded.trimToSize();
	}
	return true;
    }

    private boolean addWord(String word, int r, int c){
	if (randgen.nextInt() % 2 == -1) return addWordHorizontal(word, r ,c);
	if (randgen.nextInt() % 2 == 0) return addWordVertical(word, r ,c);
	if (randgen.nextInt() % 2 == 1) return addWordDiagonal(word, r ,c);
	return false;
    }

    private void clear(){
	for (int r = 0; r < data.length; r ++){
	    for (int c = 0; c < data[r].length; c ++){
		data[r][c] = '_';
	    }
	}
    }

    public String toString(){
	String str = "";
	for (int r = 0; r < data.length; r ++){
	    for (int c = 0; c < data[r].length; c ++){
		str += data[r][c] + " ";
	    }
	    str += "\n";
	}
	str += "\n";
	for (int x = 0; x < wordsAdded.size(); x++){
	    str += wordsAdded.get(x) + " ";
	}
	return str;
    }

    public boolean addWordHorizontal(String word,int row, int col){
	int fcol = col-1;
	if (data[row].length > col + word.length()){
	    for (int c = 0; c < word.length();c ++){
		if (data[row][col+c] == '_' || data[row][col+c] == word.charAt(c)){
		    data[row][col+c] = word.charAt(c);
		    fcol ++;
		}
		else{
		    for (int c2 = fcol; c2 >= col; c2 --){
			data[row][c2] = '_';
		    }
		    return false;
		}
	    }
	    return true;
	}
	return false;
    }

    public boolean addWordVertical(String word,int row, int col){
	int frow = row-1;
	if (data.length > row + word.length()){
	    for (int r = 0; r < word.length(); r ++){
		if (data[row+r][col] == '_' || data[row+r][col] == word.charAt(r)){
		    data[row+r][col] = word.charAt(r);
		    frow ++;
		}
		else{
		    for (int r2 = frow; r2 >= row; r2 --){
			data[r2][col] = '_';
		    }
		    return false;
		}
	    }
	    return true;
	}
	return false;
    }
    public boolean addWordDiagonal(String word, int row, int col){
	int f = -1;
	if (data.length > row+word.length() && data[row].length > col+word.length()){
	    for (int i = 0; i < word.length(); i ++){
		if ((data[row+i][col+i] == '_' || data[row+i][col+i] == word.charAt(i))){
		    data[row+i][col+i] = word.charAt(i);
		    f ++;
		}
		else{
		    for (int i2 = f; i2 >= 0; i2 --){
			data[row+i2][col+i2] = '_';
		    }
		    return false;
		}
	    }
	    return true;
	}
	return false;
    }

    public static void main(String[]args){
	if (args.length < 3){
	    System.out.println("Please insert parameters as follows:");
	    System.out.println(" java WordSearch row col filename [seed [key]]");
	    System.out.println(" row col and seed must be integers");
	    System.out.println(" filename should be the name of a file containing words to add to the puzzle");
	    System.out.println(" enter 'key' only if you would like to see the ansewers");
	}
	else {
	    try {
		Integer.parseInt(args[0]);
		Integer.parseInt(args[1]);
	    }
	    catch(NumberFormatException e) {
		System.out.println("row and col must be integers");
		System.exit(1);
	    }
	    if (args.length == 3){
		int seed = (int)(Math.random()*100000);
		WordSearch a = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], seed);
		System.out.println(a);
		System.out.println("\nThe seed is " + seed);
	    }
	    else if (args.length >= 4){
		try{
		    Integer.parseInt(args[3]);
		}
		catch(NumberFormatException e){
		    System.out.println("the seed must be an integer");
		    System.exit(1);
		}
		if (args.length >= 5 && args[4].equals("key")){
		    WordSearch b = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]), args[4]);
		    System.out.println(b);
		}
		else {
		    WordSearch c = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
		    System.out.println(c);
		}
	    }
	}
    }
}
