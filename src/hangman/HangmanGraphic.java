package hangman;

public class HangmanGraphic {

	public static final String mistakeNone =
					" |_________         \n"+
					" |         |        \n"+
					" |                  \n"+
					" |                  \n"+
					" |                  \n"+
					" |_____             \n";

	public static final String mistakeOne =
			" |_________         \n"+
					" |         |        \n"+
					" |         O        \n"+
					" |                  \n"+
					" |                  \n"+
					" |_____             \n";

	public static final String mistakeTwo =
			" |_________         \n"+
					" |         |        \n"+
					" |         O        \n"+
					" |         |        \n"+
					" |                  \n"+
					" |_____             \n";

	public static final String mistakeThree =
			" |_________         \n"+
					" |         |        \n"+
					" |         O        \n"+
					" |         |\\       \n"+
					" |                  \n"+
					" |_____             \n";

	public static final String mistakeFour =
			" |_________         \n"+
					" |         |        \n"+
					" |         O        \n"+
					" |        /|\\       \n"+
					" |                  \n"+
					" |_____             \n";

	public static final String mistakeFive =
			" |_________         \n"+
					" |         |        \n"+
					" |         O        \n"+
					" |        /|\\       \n"+
					" |          \\        \n"+
					" |_____             \n";
	public static final String mistakeSix =
					" |_________         \n"+
					" |         |        \n"+
					" |         O        \n"+
					" |        /|\\       \n"+
					" |        / \\       \n"+
					" |_____             \n";

	public static String printMistakeGraphic(int mistakes) {

		switch (mistakes) {

		case 1:
			return mistakeOne;
		case 2:
			return mistakeTwo;
		case 3:
			return mistakeThree;
		case 4:
			return mistakeFour;
		case 5:
			return mistakeFive;
		case 6:
			return mistakeSix;	
		}
		return mistakeNone;
	}

}

