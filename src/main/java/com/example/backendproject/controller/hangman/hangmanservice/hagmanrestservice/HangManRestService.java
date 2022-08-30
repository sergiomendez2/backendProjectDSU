package com.example.backendproject.controller.hangman.hangmanservice.hagmanrestservice;

import com.example.backendproject.controller.hangman.HangedManController;
import com.example.backendproject.controller.hangman.HangManTurnController;
import com.example.backendproject.model.Player;
import com.example.backendproject.model.TypePlayer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app/v1/hangman")
public class HangManRestService {


	HangManTurnController turnController;
	HangedManController hangedManController;

	Player player = new Player();
	TypePlayer typePlayer = new TypePlayer();


	@GetMapping("/start")
	ResponseEntity<Player> start() {
		typePlayer.setId(1);
		typePlayer.setName("Boot");
		player.setId(1);
		player.setName("sergio");
		player.setTypePlayer(typePlayer);
		return ResponseEntity.ok(player);
	}

}
