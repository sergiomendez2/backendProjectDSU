package com.example.backendproject.controller.statisticservice;

import com.example.backendproject.model.HangManTurn;
import com.example.backendproject.model.Statistic;
import com.example.backendproject.model.TTTTurn;
import com.example.backendproject.model.TypeGame;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticService {

	public static List<Statistic> statistics = new ArrayList<>();
	TypeGame typeGame = TypeGame.HANGMAN;
	TypeGame typeGame2 = TypeGame.TicTacToe;
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
		statistics.add(stat);
	}


	public void saveStatisticTictacToe(TTTTurn tttTurn) {
		Statistic stat = new Statistic();
		stat.setIdStatistic(statistics.size() + 1);
		stat.setId_tttTurn(tttTurn.getId_turn());

		if(tttTurn.getPlayerO().getId() ==tttTurn.getWinner().getId()){
			stat.setWinner(tttTurn.getPlayerO());
			stat.setLoser(tttTurn.getPlayerX());
		}
		else {
			stat.setWinner(tttTurn.getPlayerX());
			stat.setLoser(tttTurn.getPlayerO());
		}
		stat.setTypeGame(typeGame2);
		statistics.add(stat);

	}

	public List<Statistic> showStatistics(){
		return new ArrayList<Statistic>(statistics);
	}

	public List<Statistic> showStatisticsByTypeGame(TypeGame type){
		List<Statistic> stat = new ArrayList<>();
		for (Statistic statistic : statistics) {
			if (statistic.getTypeGame() == type) {
				stat.add(statistic);
			}
		}
		return stat;
	}

}
