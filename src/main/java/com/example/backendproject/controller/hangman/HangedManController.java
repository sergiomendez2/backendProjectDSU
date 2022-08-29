package com.example.backendproject.controller.hangman;

import com.example.backendproject.model.HangManTurn;
import org.springframework.stereotype.Service;

import java.util.Random;


public class HangedManController {

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

