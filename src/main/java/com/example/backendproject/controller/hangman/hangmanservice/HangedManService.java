package com.example.backendproject.controller.hangman.hangmanservice;

import com.example.backendproject.model.HangManTurn;
import org.springframework.stereotype.Service;


public class HangedManService {

	public Boolean compareLetterToSecretWord(char letter, HangManTurn HangManTurn){
		String word = HangManTurn.getSecreteWord();
		boolean correct;
		CharSequence charSequence = Character.toString(letter);
		if(word.contains(charSequence)){
			correct = true;
		}
		else {
			correct = false;
		}
		return correct;
	}
}
