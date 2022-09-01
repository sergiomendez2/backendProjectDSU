package com.example.backendproject.controller.hangman;


import com.example.backendproject.controller.hangman.hangmanservice.HangManTurnService;
import com.example.backendproject.controller.hangman.hangmanservice.HangedManService;
import com.example.backendproject.controller.playerservice.PlayerService;
import com.example.backendproject.model.HangManTurn;
import com.example.backendproject.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/v1")
public class HangManTurnController {

	@Autowired
	HangManTurnService hangManTurnService;
	@Autowired
	HangedManService hangedManService;


	@PostMapping("/startGame")
	public ResponseEntity<HangManTurn> startGame(@RequestBody HangManTurn hangManTurn) {
		Player playerGiver = PlayerService.listOfPlayers.stream().filter(p -> p.getId() == hangManTurn.getPlayerGiver().getId()).findFirst().get();
		Player playerGuesser = PlayerService.listOfPlayers.stream().filter(p -> p.getId() == hangManTurn.getPlayerGuesser().getId()).findFirst().get();
		String secretWord = hangManTurn.getSecreteWord();
		hangedManService.separateSecretWordInLine(secretWord);
		hangManTurnService.hangManTurn(playerGiver, playerGuesser, secretWord);
		return new ResponseEntity<>(hangManTurn, HttpStatus.OK);
	}


	@GetMapping("/getWord")
	public ResponseEntity<char[]> getWord(){
		return new ResponseEntity<>(HangedManService.secretWordSeparatedByLine, HttpStatus.OK);
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



