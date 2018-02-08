package hangman;

import java.util.Scanner;

public class HangmanGame {

	HangmanLogic logic;
	Scanner sc = new Scanner(System.in);

	boolean playAgainFlag = true;

	private void setupGame(){		

		System.out.println("Welcome to Hangman!");
		System.out.println("Difficulty Levels:");
		System.out.println("\t1 - \tEasy");
		System.out.println("\t2 - \tMedium");
		System.out.println("\t3 - \tHard");
		System.out.print("> Choose Difficulty: ");

		int difficulty = Integer.parseInt(sc.nextLine());

		logic = new HangmanLogic(difficulty);
		System.out.println("\nBeginning game!");
		System.out.println("Your word is "+logic.chosenWord.length()+" characters long.\n");
	}

	private void playGame(){

		char inputChar = ' ';
		int isValidLetterResult = 0;

		while(logic.winLoseFlag == 0) {

			printGraphic(logic.mistakes);
			System.out.println("Guesses Remaining: "+Integer.toString(HangmanLogic.mistakeLimit - logic.mistakes)+"!");
			printWordStatus();

			System.out.print("> Enter a letter: ");

			isValidLetterResult = 0;
			while (isValidLetterResult != 1) {
				inputChar = sc.nextLine().charAt(0);
				isValidLetterResult = logic.isValidLetter(inputChar);
				if (isValidLetterResult == 2)
					System.out.println("Invalid input: Not a Letter!");
				else if (isValidLetterResult == 3)
					System.out.println("Invalid input: Letter already used!");
			}
			logic.takeTurn(inputChar);
			if(logic.letterExistsFlag)
				System.out.println("\nLetter Found!");
			else
				System.out.println("\nLetter Not Found!");
		}
	}

	private void printGraphic(int mistakes) {
		System.out.println(HangmanGraphic.printMistakeGraphic(mistakes));
	}

	private void printWordStatus() {
		
		System.out.print("Word status: ");
		for (int i=0; i<logic.chosenWord.length(); i++) {
			char currentLetter = logic.chosenWord.charAt(i);
			if(logic.usedCharSet.contains(currentLetter))
				System.out.print(" "+currentLetter+" ");
			else
				System.out.print(" _ ");
		}
		System.out.println("\n");
		
	}

	private void showResults() {
		if(logic.winLoseFlag == 1) {
			System.out.println("You won!");
			System.out.println("Your word was "+logic.chosenWord+".");
		} else {
			printGraphic(logic.mistakes);
			System.out.println("You lost!");
			System.out.println("Your word was "+logic.chosenWord+".");
		}
	}

	private void askForPlayAgain() {

		boolean isValidLetterResult = false;
		char inputChar = ' ';

		System.out.print("\n> Play Again? (Y or N): ");

		while (!isValidLetterResult) {
			inputChar = sc.nextLine().charAt(0);
			if ( Character.toLowerCase(inputChar) != 'y' && Character.toLowerCase(inputChar) != 'n')
				System.out.print("\n> Please select with Y or N: ");
			else 
				isValidLetterResult = true;
		}

		if (inputChar == 'y') {
			playAgainFlag = true;
		} else
			System.out.println("\nExiting...");

	}

	public void launchGame(){

		while (playAgainFlag) {
			playAgainFlag = false;
			setupGame();
			playGame();
			showResults();
			askForPlayAgain();
		}

	}

}
