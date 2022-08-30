package com.example.backendproject.controller.playerservice;

import com.example.backendproject.model.Player;
import com.example.backendproject.model.TypePlayer;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {

	public PlayerService() {
		int id = 1;
		int id2 = 2;
		String name = "Bot";
		String name2 = "Human";

		TypePlayer typePlayer = new TypePlayer();
		typePlayer.setId(id);
		typePlayer.setName(name);

		TypePlayer TypePlayer2 = new TypePlayer();
		TypePlayer2.setId(id2);
		TypePlayer2.setName(name2);

		TypePlayer.listOfTypesPlayer.add(typePlayer);
		TypePlayer.listOfTypesPlayer.add(TypePlayer2);
	}
	public static List<Player> listOfPlayers = new ArrayList<>();

    Player player = new Player();
	TypePlayer typePlayer = new TypePlayer();


	public  void createPlayer(int id,String name, TypePlayer typePlayer) {
		Player p = new Player();
		p.setId(id);
		p.setName(name);
		p.setTypePlayer(typePlayer);
		listOfPlayers.add(p);
		listOfPlayers
				.stream()
				.forEach(Player -> System.out.println(
						Player.getId() + " " + Player.getName() + " " + Player.getTypePlayer().getName()));
	}


  public void deletePlayer(String name) {
		player = getPlayerByName(name);
		listOfPlayers.remove(player);

  }

	public Player getPlayerByName(String name) {
		Player player = new Player();
		player = listOfPlayers.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().get();
		return player;
	}


	public TypePlayer getTypePlayer(String name) {
		TypePlayer typePlayer = new TypePlayer();
		typePlayer = TypePlayer.listOfTypesPlayer.stream().filter(type -> type.getName().equalsIgnoreCase(name)).findFirst().get();
		return typePlayer;
	}

}
