package com.example.backendproject.controller.ttt;


import com.example.backendproject.controller.ttt.tttservice.tttTurnService;
import com.example.backendproject.controller.ttt.tttservice.tttService;
import com.example.backendproject.controller.playerservice.PlayerService;
import com.example.backendproject.model.TTTTurn;
import com.example.backendproject.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/v1")
public class tttTurnController {

	tttTurnService tttTurnService;
	tttService tttService;
	Player player = new Player();

	@PostMapping("/startGameTTT")
	public ResponseEntity<TTTTurn> startGame(@RequestBody TTTTurn tttTurn) {
		Player playerX = PlayerService.listOfPlayers.stream().filter(p -> p.getId() == tttTurn.getId_playerX().getId()).findFirst().get();
		Player player0 = PlayerService.listOfPlayers.stream().filter(p -> p.getId() == tttTurn.getId_playerO().getId()).findFirst().get();
		tttService = new tttService();
		tttTurnService = new tttTurnService(playerX, player0);
		return new ResponseEntity<>(tttTurn, HttpStatus.OK);
	}

	@PutMapping("/updateTurnTTT")
	public ResponseEntity<TTTTurn> updateTurn(@RequestBody TTTTurn tttTurn) {
		int turnId = tttTurn.getId_turn();
		boolean finished = tttTurn.isFinished();
		/*tttTurnService.updateTurn(turnId, finished);*/
		return new ResponseEntity<>(tttTurn, HttpStatus.OK);
	}

}



