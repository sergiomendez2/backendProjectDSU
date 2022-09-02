package com.example.backendproject.controller;

import com.example.backendproject.controller.playerservice.PlayerService;
import com.example.backendproject.model.Player;
import com.example.backendproject.model.TypePlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/v1")
public class PlayerController {

	@Autowired
	PlayerService playerService;

	@PostMapping("/createPlayer")
	public ResponseEntity<String> createPlayer(@RequestBody Player player) {
		TypePlayer typePlayer = new TypePlayer();
		Player newPlayer = new Player();
		String name = player.getName();
		int id = player.getId();
		typePlayer = playerService.getTypePlayer(player.getTypePlayer().getName());
		Player existingPlayer;
		existingPlayer = playerService.getPlayerById(id);
		if(existingPlayer != null){
			return new ResponseEntity<String>("Player already exists", HttpStatus.BAD_REQUEST);
		}else{
			playerService.createPlayer(id,name, typePlayer);
		}

		return new ResponseEntity<>("Player Created", HttpStatus.OK);
	}

	@PutMapping("/updatePlayer")
	public ResponseEntity<String> updatePlayer(@RequestBody Player player){
		playerService.updatePlayer(player);
		return new ResponseEntity<>("Player updated", HttpStatus.OK);
	}

	@DeleteMapping("/deletePlayer/{id}")
	public ResponseEntity<String> deletePlayer(@PathVariable int id) {
	 	playerService.deletePlayer(id);
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
	public List<Player> getListOfPlayers(){
		return playerService.getListOfPlayers();
	}
}
