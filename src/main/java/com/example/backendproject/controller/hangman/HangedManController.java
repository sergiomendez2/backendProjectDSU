package com.example.backendproject.controller.hangman;


import com.example.backendproject.controller.hangman.hangmanservice.HangManTurnService;
import com.example.backendproject.controller.hangman.hangmanservice.HangedManService;
import com.example.backendproject.model.HangManTurn;
import com.example.backendproject.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HangedManController {

	HangManTurnService hangManTurnService;
	HangedManService hangedManService = new HangedManService();
	int Max_attempts = 8;
    Player player = new Player();
	List<Player> players = new ArrayList<>();
	@PostMapping("/startGame")
	public ResponseEntity<HangManTurn> startGame(@RequestBody HangManTurn hangManTurn) {
		 Player playerGiver = players.stream().filter(p -> p.getId() == hangManTurn.getPlayerGiver().getId()).findFirst().get();
		 Player playerGuesser = players.stream().filter(p -> p.getId() == hangManTurn.getPlayerGuesser().getId()).findFirst().get();
		 String secretWord = hangManTurn.getSecreteWord();
		 hangManTurnService = new HangManTurnService(playerGiver, playerGuesser, secretWord);
		return new ResponseEntity<>(hangManTurn, HttpStatus.OK);
	}

	@PutMapping("/updateTurn")
	public ResponseEntity<HangManTurn> updateTurn(@RequestBody HangManTurn hangManTurn) {
		int turnId = hangManTurn.getId_turn();
		boolean finished = hangManTurn.isFinished();
		boolean hangedMan = hangManTurn.isHangedMan();
		if (Max_attempts == 0) {
			hangManTurn.setHangedMan(true);
		} else {
			hangManTurn.setHangedMan(false);
		}

		return new ResponseEntity<>(hangManTurn, HttpStatus.OK);
	}

}

