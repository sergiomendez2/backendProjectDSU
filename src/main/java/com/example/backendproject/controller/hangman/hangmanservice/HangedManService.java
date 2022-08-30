package com.example.backendproject.controller.hangman.hangmanservice;

import com.example.backendproject.model.HangManTurn;
import org.springframework.stereotype.Service;


@Service
public class HangedManService {

	public static char[] secretWordSeparatedByLine;
	public Boolean compareLetterToSecretWord(char letter, HangManTurn HangManTurn){
		String word = HangManTurn.getSecreteWord();
		boolean correct = false;

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == letter) {
				secretWordSeparatedByLine[i] = letter;
				correct = true;
			}
		}

		return correct;
	}

	public String getSecreteWord(HangManTurn HangManTurn) {
		String word = HangManTurn.getSecreteWord();
		return word;
	}

	public char[] separateSecretWordInLine(String secretWord) {
		int lengthOfSecretWord = secretWord.length();
		secretWordSeparatedByLine = new char[lengthOfSecretWord];
		for (int i = 0; i < secretWordSeparatedByLine.length; i++) {
			secretWordSeparatedByLine[i] = '_';
		}
		return secretWordSeparatedByLine;
	}

	public  boolean isSecretWordSeparatedByLine() {
		for(char letter : secretWordSeparatedByLine) {
			if(letter == '_') return true;
		}
		return false;
	}

}
