package com.example.backendproject.controller.statisticservice;

import com.example.backendproject.model.HangManTurn;
import com.example.backendproject.model.Statistic;
import com.example.backendproject.model.TypeGame;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StatisticService {

	public static List<Statistic> statistics = new ArrayList<>();
	TypeGame typeGame = TypeGame.HANGMAN;
	TypeGame typeGame2 = TypeGame.TTT;

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
		stat.setId_hangmanTurn(hangManTurn.getId_turn());
	}

	public String showStatisticHangMan(){
		//show statistic for hangman
	 Set<Statistic> stat = statistics.stream().filter(s -> s.getTypeGame() == TypeGame.HANGMAN).collect(Collectors.toSet());
	  return stat.toString();

	}

	public String showStatistics(){
		String list = "";
		for (int i = 0; i<statistics.size(); i++){
			list = list + statistics.toString() + "\n";
		}
		return list;
	}

	public String showStatisticsByTypeGame(TypeGame type){
		String list = "";
		for (int i=0; i<statistics.size(); i++){
			if(statistics.get(i).getTypeGame()==type){
				list = list + statistics.get(i).toString() + "\n";
			}
		}
		return list;
	}
}
