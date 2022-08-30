package com.example.backendproject.controller.hangman.hangmanservice;

import com.example.backendproject.controller.statisticservice.StatisticService;
import com.example.backendproject.model.HangManTurn;
import com.example.backendproject.model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HangManTurnService {
	HangManTurn turn;
	StatisticService statisticService;
	public static List<HangManTurn> turnList = new ArrayList<>();
	public void hangManTurn(Player playerGiver, Player playerGuesser, String SecretWord) {
		turn = new HangManTurn();
		turn.setId_turn(turnList.size() + 1);
		turn.setPlayerGiver(playerGiver);
		turn.setPlayerGuesser(playerGuesser);
		turn.setFinished(false);
		turn.setSecreteWord(SecretWord);
		turn.setHangedMan(false);
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
		HangManTurn result = new HangManTurn();
		result = turnList.stream().filter(t -> t.getId_turn() == turnId).findFirst().get();
		statisticService = new StatisticService();
		statisticService.saveStatistic(result);
	}

}
