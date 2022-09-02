package com.example.backendproject.controller.statisticservice;

import com.example.backendproject.model.HangManTurn;
import com.example.backendproject.model.Statistic;
import com.example.backendproject.model.TypeGame;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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

	public String showStatistics(){
		String list = "";
		for (int i = 0; i<statistics.size(); i++){
			list = list + statistics.get(i).toString() + "\n";
		}
		return list;
	}

	public List<Statistic> showStatisticsByTypeGame(TypeGame type){
		List<Statistic> stat = new ArrayList<>();
		for (int i = 0; i<statistics.size(); i++){
			if (statistics.get(i).getTypeGame() == type){
				stat.add(statistics.get(i));
			}
		}
		return stat;
	}

}
