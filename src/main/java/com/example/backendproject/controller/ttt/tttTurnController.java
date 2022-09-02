package com.example.backendproject.controller.ttt;


import com.example.backendproject.controller.ttt.tttservice.tttTurnService;
import com.example.backendproject.controller.playerservice.PlayerService;
import com.example.backendproject.model.TTTTurn;
import com.example.backendproject.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/v1")
public class tttTurnController {

	@Autowired
	tttTurnService tttTurnService;

	Player winner;

	@PostMapping("/startGameTTT")
	public ResponseEntity<TTTTurn> startGame(@RequestBody TTTTurn tttTurn) {
		Player playerX = PlayerService.listOfPlayers.stream().filter(p -> p.getId() == tttTurn.getPlayerX().getId()).findFirst().get();
		Player player0 = PlayerService.listOfPlayers.stream().filter(p -> p.getId() == tttTurn.getPlayerO().getId()).findFirst().get();
		TTTTurn turnCreated=tttTurnService.ticTacToeTurnService(playerX, player0);
		return new ResponseEntity<>(turnCreated, HttpStatus.OK);
	}

	@PutMapping("/updateTurnTTT")
	public ResponseEntity<String> updateTurn(@RequestBody TTTTurn tttTurn) {
		int turnId = tttTurn.getId_turn();
		boolean finished = tttTurn.isFinished();
		boolean isDraw = tttTurn.isDraw();

		if(isDraw) {
			winner = null;
		}else{
			winner = PlayerService.listOfPlayers.stream().filter(p -> p.getId() == tttTurn.getWinner().getId()).findFirst().get();
		}

		tttTurnService.updateTurn(turnId, finished, winner, isDraw);
		return new ResponseEntity<>("Game finished!", HttpStatus.OK);
	}

}



