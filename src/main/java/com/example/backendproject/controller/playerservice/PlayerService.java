package com.example.backendproject.controller.playerservice;

import com.example.backendproject.model.Player;
import com.example.backendproject.model.TypePlayer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

	public static List<Player> listOfPlayers = new ArrayList<>();

    Player player = new Player();
	TypePlayer typePlayer = new TypePlayer();


	public void createPlayer(int id, String name, TypePlayer typePlayer) {
		Player p = new Player();
		p.setId(id);
		p.setName(name);
		p.setTypePlayer(typePlayer);
		listOfPlayers.add(p);
	}

	public Player getPlayerById(int id){
		try{
			Player p = new Player();
			p = listOfPlayers.stream().filter(t -> t.getId() == id).findFirst().get();
			return p;
		}
		catch (Exception e){
			return null;
		}

	}

	public void updatePlayer(Player playerUpdated){
		typePlayer = TypePlayer.listOfTypesPlayer.stream().filter(t -> t.getId() == playerUpdated.getTypePlayer().getId()).findFirst().get();
		player= listOfPlayers.stream().filter(t -> t.getId() == playerUpdated.getId()).findFirst().get();
		player.setName(playerUpdated.getName());
		player.setTypePlayer(typePlayer);
		System.out.println("Player was updated successfully");
	}

  public void deletePlayer(int id) {
		player = getPlayerById(id);
		listOfPlayers.remove(player);
  }

  public List<Player>  getListOfPlayers(){
		List<Player> players = new ArrayList<>();
		for (int i = 0; i<listOfPlayers.size(); i++){
			players.add(listOfPlayers.get(i));
		}
		return players;
  }

	public Player getPlayerByName(String name) {
		player = listOfPlayers.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().get();
		return player;
	}

	public TypePlayer getTypePlayer(String name) {
		typePlayer = TypePlayer.listOfTypesPlayer.stream().filter(type -> type.getName().equalsIgnoreCase(name)).findFirst().get();
		return typePlayer;
	}

}
