package com.example.backendproject.controller.hangman;

import com.example.backendproject.model.HangManTurn;
import com.example.backendproject.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class TurnController {

	HangManTurn turn;

	public static List<HangManTurn> turnList;

	public TurnController(Player playerGiver, Player playerGuesser, String SecretWord) {
		turn = new HangManTurn();
		int id = turnList.size() + 1;
		turn.setPlayerGiver(playerGiver);
		turn.setPlayerGuesser(playerGuesser);
		turn.setFinished(false);
		turn.setSecreteWord(SecretWord);
		turn.setHangedMan(false);
		turn.setId_turn(id);
		turnList.add(turn);
	}

	public HangManTurn getTurnById(int id) {
		HangManTurn turn = new HangManTurn();
		turn = turnList.stream().filter(t -> t.getId_turn() == id).findFirst().get();
		return turn;
	}

	public void updateTurn(int turnId, boolean finished, boolean hangedMan) {
		HangManTurn turn = new HangManTurn();
		turn  = getTurnById(turnId);
		turn.setFinished(finished);
		turn.setHangedMan(hangedMan);
	}

}



