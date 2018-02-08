package hangman;

import java.util.HashSet;
import java.util.Set;

public class HangmanLogic {

	HangmanLibrary library;

	public static final int mistakeLimit = 6;

	public Set<Character> usedCharSet = new HashSet<Character>();
	private Set<Character> wordCharSet = new HashSet<Character>();
	private Set<Integer> revealedLettersPosSet = new HashSet<Integer>();

	public String chosenWord = null;
	public int mistakes = 0;
	public int difficulty = 0;

	public boolean letterExistsFlag = false;
	public int winLoseFlag = 0;

	public HangmanLogic(int difficulty) {

		this.difficulty = difficulty;
		library = new HangmanLibrary();
		chosenWord = library.getValidWordFromLibrary(difficulty);
		for (int i=0; i<chosenWord.length(); i++) 
			wordCharSet.add(chosenWord.charAt(i));	
	}

	public int isValidLetter(char inputChar) {

		if (!Character.isLetter(inputChar))
			return 2;
		if (usedCharSet.contains(inputChar))
			return 3;

		return 1;
	}

	private int checkWinLose() {

		if(usedCharSet.containsAll(wordCharSet))
			return 1;
		if(mistakes == mistakeLimit)
			return -1;

		return 0;
	}

	public void takeTurn(char inputChar) {

		letterExistsFlag = false;
		usedCharSet.add(inputChar);

		if(wordCharSet.contains(inputChar)) {

			for(int i=0; i<chosenWord.length(); i++) {
				if(inputChar == chosenWord.charAt(i)) {
					revealedLettersPosSet.add(i);
					letterExistsFlag = true;
				}
			}
		} else
			mistakes++;

		winLoseFlag = checkWinLose();
	}
}
