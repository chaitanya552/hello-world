import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class HangmanGame {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// ***********dictionary is loaded here*******************
		
		Random rand = new Random();
		List<String> wordsList = new ArrayList<>();
		List<String> easyList = new ArrayList<>();
		List<String> mediumList = new ArrayList<>();
		String[] data = null;
		File file = new File(
				"C:/Users/gkneerukonda/Desktop/hangman game/words.txt");
		try {

			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			String line;

			while ((line = br.readLine()) != null) {

				// trims the data so that there are no extra spaces
				// adding the data to lists
				wordsList.add(line.trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] words = new String[wordsList.size()];
		words = wordsList.toArray(words);
		// *********all the words are in the string array named words
		// System.out.println(words[49]);
		// ***********picking a random word***********
		String randomWord;
		for (int k = 0; k < words.length; k++) {
			if (words[k].length() == 4) {
				easyList.add(words[k]);
			}
		}
		String easyWord = easyList.get(rand.nextInt(easyList.size()));
		System.out.println(easyWord+"  easy word");
			randomWord = words[(int) (Math.random() * words.length)];
			System.out.println(randomWord+ "   random");
			// System.out.println(name);

			boolean retval = false;
			Scanner scan = new Scanner(System.in);
			System.out.println("enter word to be guessed");
			String word = scan.next();
			// String word = "apple";
			char[] wordA = word.toCharArray();
			// System.out.println(wordA[2]);
			char[] answer = new char[wordA.length];
			String letter;
			for (int i = 0; i < answer.length; i++) {
				answer[i] = '_';
			}
			// System.out.println(answer[0]);

			System.out.println("enter no of chances");

			int chances = scan.nextInt();
			for (int i = 0; i < chances; i++) {
				System.out.println("enter letter");
				letter = scan.next();
				char guess = letter.charAt(0);
				// System.out.println(answer.length+"answer length");
				for (int j = 0; j < answer.length; j++) {
					if (guess == wordA[j]) {
						answer[j] = guess;
					}
				}
				for (int j = 0; j < answer.length; j++) {
					System.out.print(answer[j]);
				}

				retval = Arrays.equals(wordA, answer);
				// System.out.println("arr1 and arr2 equal: " + retval);
				if (retval == true) {
					System.out.println("guessed the word");
					break;
				}

			}

			if (retval == false) {
				System.out
						.println("you couldnt guess it in given number of chances");
			}
		}

	}

