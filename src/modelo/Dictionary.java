package modelo;

import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.util.Scanner;

public class Dictionary {
	
	private String dictName; // Nombre del fichero que contiene las palabras
	private Scanner dict;
	private ArrayList<String> wordList;
	
	public Dictionary() {
	}

	public Dictionary(String myDict) throws Exception{
		this.dictName = myDict;
		dict = new Scanner(new File(this.dictName));
		wordList = new ArrayList<String>();
		
		while(dict.hasNext()) {
			wordList.add(dict.next());
		}
		
	}
	
	public String getRandomWord() {
		 Random r = new Random();
		
		return wordList.get(r.nextInt(wordList.size()));
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictionary) {
		this.dictName = dictionary;
	}
	
	
	
}
