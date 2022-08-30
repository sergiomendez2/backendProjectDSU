package com.example.backendproject.controller;

import com.example.backendproject.controller.playerservice.PlayerService;
import com.example.backendproject.model.Player;
import com.example.backendproject.model.TypePlayer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/v1")
public class PlayerController {

	PlayerService playerService = new PlayerService();
	TypePlayer typePlayer = new TypePlayer();
	@PostMapping("/createPlayer")
	public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
		Player newPlayer = new Player();
		String name = player.getName();
		int id = player.getId();
		typePlayer = playerService.getTypePlayer(player.getTypePlayer().getName());
		playerService.createPlayer(id,name, typePlayer);
		return new ResponseEntity<>(player, HttpStatus.OK);
	}

	@PostMapping("/updatePlayer")
	public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
		playerService.updatePlayer(player);
		return new ResponseEntity<>(player, HttpStatus.OK);
	}

	@DeleteMapping("/deletePlayer/{name}")
	public ResponseEntity<String> deletePlayer(@PathVariable String name) {
	 	playerService.deletePlayer(name);
		return new ResponseEntity<>("Player deleted", HttpStatus.OK);
	}

	@GetMapping("/getPlayerByName/{name}")
	public ResponseEntity<Player> getPlayerByName(@PathVariable String name){
		Player player = playerService.getPlayerByName(name);
		return new ResponseEntity<>(player, HttpStatus.OK);
	}

	@GetMapping("/getPlayerById/{id}")
	public ResponseEntity<Player> getPlayerById(@PathVariable int id){
		Player player = playerService.getPlayerById(id);
		return new ResponseEntity<>(player, HttpStatus.OK);
	}

	@GetMapping("/getListOfPlayers")
	public ResponseEntity<String> getListOfPlayers(){
		return new ResponseEntity<>(playerService.getListOfPlayers(), HttpStatus.OK);
	}
}
