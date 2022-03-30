package modelo;

import java.util.Arrays;
import java.util.ArrayList;

public class Hangman {

	private String word;
	private char [] mask;
	private int lives;
	
	public Hangman(String word) {
		this.word = word;
		this.mask = new char [word.length()];
		for (int i = 0; i < word.length(); i++) {
			mask[i] = '-';
		}
		this.lives = 6;
	}
	
	public Hangman() {
		String[] dictionary = { "BETIS", "OSASUNA", "ALAVES", "BARCELONA", "MADRID", "CADIZ", "SEVILLA", "VILLARREAL",
				"VALENCIA", "LEVANTE" };
		this.word = dictionary[(int)(Math.random()*10)];
		
		this.mask = new char [word.length()];
		for (int i = 0; i < word.length(); i++) {
			mask[i] = '-';
		}
		this.lives = 6;
	}
	
	@Override
	public String toString() {
		return "Hangman [word=" + word + ", mask=" + Arrays.toString(mask) + "]";
	}

	public String getWord() {
		return word;
	}

	public char[] getMask() {
		return mask;
	}

	public boolean checkLetter(char letter) {
		boolean esta = false;
		for (int i = 0; i < word.length(); i++) {
			if (letter == word.charAt(i) ) {
				mask[i] = letter;
				esta = true;
			}
		}

		return esta;
	}
	
	public boolean repeatLetters(char letter, String used) {	
			for (int i = 0; i < used.length(); i++) {
				if (letter == used.charAt(i))
					return true;
			}

			return false;
	}
	
	public int getLives() {
		return lives;
	}
	
	public void downLives (char letter) {
		this.lives--;
	}
	
	public boolean youWin() {
		for (int i = 0; i < mask.length; i++) {
			if (mask[i] == '-')
				return false;
		}
		
		return true;
	}
	
	public void draw(int lives) {// Muñeco hecho por mí
		switch (lives) {
		case 5:
			System.out.println(" ______________________________ ");
			System.out.println(" |                             |");
			System.out.println(" |                             |");
			System.out.println(" |                        _________");
			System.out.println(" |                        |  - -  |");
			System.out.println(" |                        |   o   |");
			System.out.println(" |                        |_______|");
			for (int i = 0; i < 20; i++) {
				System.out.println(" |");
			}
			System.out.println(" _________");
			break;
		case 4:
			System.out.println(" ______________________________ ");
			System.out.println(" |                             |");
			System.out.println(" |                             |");
			System.out.println(" |                         _________");
			System.out.println(" |                         |  - -  |");
			System.out.println(" |                         |   o   |");
			System.out.println(" |                         |_______|");
			for (int i = 0; i < 7; i++) {
				System.out.println(" |                             |");
			}
			for (int i = 0; i < 15; i++) {
				System.out.println(" |");
			}
			System.out.println(" _________");
			break;
		case 3:
			System.out.println(" ______________________________ ");
			System.out.println(" |                             |");
			System.out.println(" |                             |");
			System.out.println(" |                         _________");
			System.out.println(" |                         |  - -  |");
			System.out.println(" |                         |   o   |");
			System.out.println(" |                         |_______|");
			System.out.println(" |                             | ");
			System.out.println(" |                             | ");
			System.out.println(" |                           / | ");
			System.out.println(" |                          /  | ");
			System.out.println(" |                         /   | ");
			System.out.println(" |                        /    | ");
			System.out.println(" |                             |");
			for (int i = 0; i < 15; i++) {
				System.out.println(" |");
			}
			System.out.println(" _________");
			break;
		case 2:
			System.out.println(" ______________________________ ");
			System.out.println(" |                             |");
			System.out.println(" |                             |");
			System.out.println(" |                         _________");
			System.out.println(" |                         |  - -  |");
			System.out.println(" |                         |   o   |");
			System.out.println(" |                         |_______|");
			System.out.println(" |                             |");
			System.out.println(" |                             |");
			System.out.println(" |                           / | \\ ");
			System.out.println(" |                          /  |  \\");
			System.out.println(" |                         /   |   \\");
			System.out.println(" |                        /    |    \\");
			System.out.println(" |                             |");
			for (int i = 0; i < 10; i++) {
				System.out.println(" |");
			}
			System.out.println(" _________");
			break;
		case 1:
			System.out.println(" ______________________________ ");
			System.out.println(" |                             |");
			System.out.println(" |                             |");
			System.out.println(" |                         _________");
			System.out.println(" |                         |  - -  |");
			System.out.println(" |                         |   o   |");
			System.out.println(" |                         |_______|");
			System.out.println(" |                             |");
			System.out.println(" |                             |");
			System.out.println(" |                           / | \\ ");
			System.out.println(" |                          /  |  \\");
			System.out.println(" |                         /   |   \\");
			System.out.println(" |                        /    |    \\");
			System.out.println(" |                             |");
			System.out.println(" |                            / ");
			System.out.println(" |                           / ");
			System.out.println(" |                          / ");
			System.out.println(" |                         / ");
			System.out.println(" |                        / ");
			for (int i = 0; i < 5; i++) {
				System.out.println(" |");
			}
			System.out.println(" _________");
			break;
		case 0:
			System.out.println(" ______________________________ ");
			System.out.println(" |                             |");
			System.out.println(" |                             |");
			System.out.println(" |                         _________");
			System.out.println(" |                         |  X X  |");
			System.out.println(" |                         |   o   |");
			System.out.println(" |                         |_______|");
			System.out.println(" |                             |");
			System.out.println(" |                             |");
			System.out.println(" |                           / | \\ ");
			System.out.println(" |                          /  |  \\");
			System.out.println(" |                         /   |   \\");
			System.out.println(" |                        /    |    \\");
			System.out.println(" |                             |");
			System.out.println(" |                            / \\ ");
			System.out.println(" |                           /   \\ ");
			System.out.println(" |                          /     \\ ");
			System.out.println(" |                         /       \\ ");
			System.out.println(" |                        /         \\ ");
			for (int i = 0; i < 5; i++) {
				System.out.println(" |");
			}
			System.out.println(" _________");
			break;
		}
	}


	
}
