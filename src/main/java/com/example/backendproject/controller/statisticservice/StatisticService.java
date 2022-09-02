package com.example.backendproject.controller.statisticservice;

import com.example.backendproject.model.HangManTurn;
import com.example.backendproject.model.Statistic;
import com.example.backendproject.model.TypeGame;

import java.util.ArrayList;
import java.util.List;

public class StatisticService {

	public static List<Statistic> statistics = new ArrayList<>();
	TypeGame typeGame = TypeGame.HANGMAN;
	public void saveStatistic(HangManTurn hangManTurn) {
		Statistic stat = new Statistic();
		stat.setIdStatistic(statistics.size() + 1);
		stat.setId_hangmanTurn(hangManTurn.getId_turn());
		if(!hangManTurn.isHangedMan()){
			stat.setWinner(hangManTurn.getPlayerGuesser());
			stat.setLoser(hangManTurn.getPlayerGiver());
		}
		else {
			stat.setWinner(hangManTurn.getPlayerGiver());
			stat.setLoser(hangManTurn.getPlayerGuesser());
		}
		stat.setTypeGame(typeGame);
	}
}
