package com.example.backendproject.controller.ttt.tttservice;

import com.example.backendproject.controller.statisticservice.StatisticService;
import com.example.backendproject.model.TTTTurn;
import com.example.backendproject.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class tttTurnService {
	TTTTurn turn;

	@Autowired
	StatisticService statisticService;
	public static List<TTTTurn> tttturnList = new ArrayList<>();
	public TTTTurn ticTacToeTurnService(Player playerX, Player player0) {
		turn = new TTTTurn();
		turn.setId_turn(tttturnList.size() + 1);
		turn.setPlayerX(playerX);
		turn.setPlayerO(player0);
		turn.setFinished(false);
		tttturnList.add(turn);
		return turn;
	}
	public TTTTurn getTurnById(int id) {
		TTTTurn turn = new TTTTurn();
		turn = tttturnList.stream().filter(t -> t.getId_turn() == id).findFirst().get();
		return turn;
	}

	public TTTTurn updateTurn(int turnId, boolean finished, Player winnerPlayer, boolean isDraw) {
		TTTTurn turn = new TTTTurn();
		turn  = getTurnById(turnId);
		turn.setFinished(finished);
		turn.setWinner(winnerPlayer);
		turn.setDraw(isDraw);

		TTTTurn result = new TTTTurn();
		result = tttturnList.stream().filter(t -> t.getId_turn() == turnId).findFirst().get();
		statisticService = new StatisticService();
		statisticService.saveStatisticTictacToe(result);
		return turn;
	}

}
