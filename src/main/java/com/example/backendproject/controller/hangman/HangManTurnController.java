package com.example.backendproject.controller.hangman;


import com.example.backendproject.controller.hangman.hangmanservice.HangManTurnService;
import com.example.backendproject.controller.hangman.hangmanservice.HangedManService;
import com.example.backendproject.controller.playerservice.PlayerService;
import com.example.backendproject.model.HangManTurn;
import com.example.backendproject.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class HangManTurnController {

	HangManTurnService hangManTurnService;
	HangedManService hangedManService = new HangedManService();
	int Max_attempts = 8;
	Player player = new Player();

	@PostMapping("/startGame")
	public ResponseEntity<HangManTurn> startGame(@RequestBody HangManTurn hangManTurn) {
		Player playerGiver = PlayerService.listOfPlayers.stream().filter(p -> p.getId() == hangManTurn.getPlayerGiver().getId()).findFirst().get();
		Player playerGuesser = PlayerService.listOfPlayers.stream().filter(p -> p.getId() == hangManTurn.getPlayerGuesser().getId()).findFirst().get();
		String secretWord = hangManTurn.getSecreteWord();
		hangManTurnService = new HangManTurnService(playerGiver, playerGuesser, secretWord);
		return new ResponseEntity<>(hangManTurn, HttpStatus.OK);
	}


	@PutMapping("/updateTurn")
	public ResponseEntity<HangManTurn> updateTurn(@RequestBody HangManTurn hangManTurn) {
		int turnId = hangManTurn.getId_turn();
		boolean finished = hangManTurn.isFinished();
		boolean hangedMan = hangManTurn.isHangedMan();
		hangManTurnService.updateTurn(turnId, finished, hangedMan);
		return new ResponseEntity<>(hangManTurn, HttpStatus.OK);
	}

}



