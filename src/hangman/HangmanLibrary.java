package hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HangmanLibrary {

	private static final String filePath = "C:\\Users\\Admin\\Desktop\\words.txt";
	private List<String> libraryList = new ArrayList<String>();

	private static final int easyLength = 4;
	private static final int mediumLength = 7;
	private static final int hardLength = 10;

	public HangmanLibrary() {
		readInLibrary();
	}

	private void readInLibrary() {

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(filePath);
			bufferedReader = new BufferedReader(fileReader);

			String readLine = null;
			while ((readLine = bufferedReader.readLine()) != null) {
				libraryList.add(readLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileReader != null)
					fileReader.close();
				if (bufferedReader != null)
					bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getValidWordFromLibrary(int difficulty) {

		String currentWord = null;
		int maxWordLength = hardLength;
		int minWordLength = 0;

		switch (difficulty) {
		case 1:	
			minWordLength = 0;
			maxWordLength = easyLength;
			break;
		case 2:	
			minWordLength = easyLength;
			maxWordLength = mediumLength;
			break;
		case 3:
			minWordLength = mediumLength;
			maxWordLength = hardLength;
			break;
		}



		do {
			currentWord = libraryList.get(new Random().nextInt(libraryList.size()));
			currentWord = currentWord.toLowerCase();
		} while (!currentWord.matches("[a-z]+") || currentWord.length() > maxWordLength || currentWord.length() <= minWordLength);
		return currentWord;
	}

}
