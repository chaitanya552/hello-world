import java.util.Scanner;
import java.util.Arrays;

public class HangmanGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean retval=false;
		Scanner scan = new Scanner(System.in);
		System.out.println("enter word to be guessed");
		String word = scan.next();
		//String word = "apple";
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
			//System.out.println(answer.length+"answer length");
			for (int j = 0; j < answer.length; j++) {
				if (guess == wordA[j]) {
					answer[j] = guess;
				}
			}
			for (int j = 0; j < answer.length; j++) {
				System.out.print(answer[j]);
			}
			

			 retval = Arrays.equals(wordA, answer);
			//System.out.println("arr1 and arr2 equal: " + retval);
			if (retval == true) {
				System.out.println("guessed the word");
				break;
			}
			

		}
		
		if (retval == false) {
			System.out.println("you couldnt guess it in given number of chances");
		}
	}

}
