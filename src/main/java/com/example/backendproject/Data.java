package com.example.backendproject;

import com.example.backendproject.controller.playerservice.PlayerService;
import com.example.backendproject.model.Player;
import com.example.backendproject.model.TypePlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Data {
	private static final Logger log = LoggerFactory.getLogger(Data.class);

	@Bean
	CommandLineRunner initDatabase() {
		return args -> {


			int id = 1;
			int id2 = 2;
			String name = "Bot";
			String name2 = "Human";

			TypePlayer typePlayer1 = new TypePlayer();
			typePlayer1.setId(id);
			typePlayer1.setName(name);

			TypePlayer TypePlayer2 = new TypePlayer();
			TypePlayer2.setId(id2);
			TypePlayer2.setName(name2);

			TypePlayer.listOfTypesPlayer.add(typePlayer1);
			TypePlayer.listOfTypesPlayer.add(TypePlayer2);

			TypePlayer typePlayer = TypePlayer.listOfTypesPlayer.stream().filter(type -> type.getName().equalsIgnoreCase("bot")).findFirst().get();
			Player bot1 = new Player();
			Player bot2 = new Player();

			bot1.setId(1);
			bot1.setName("Galaxy");
			bot1.setTypePlayer(typePlayer);

			bot2.setId(2);
			bot2.setName("Celestial");
			bot2.setTypePlayer(typePlayer);

           PlayerService.listOfPlayers.add(bot1);
		   PlayerService.listOfPlayers.add(bot2);
		};
	}
}
