package com.example.backendproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


import com.example.backendproject.controller.statisticservice.StatisticService;
import com.example.backendproject.model.Player;
import com.example.backendproject.model.Statistic;
import com.example.backendproject.model.TypeGame;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/v1")
public class StatisticsController {
    @Autowired
    StatisticService statisticService;
	TypeGame typeGame;
    @GetMapping("/getStatisticList")
    public ResponseEntity<String> getStatistics(){
        return new ResponseEntity<>(statisticService.showStatistics(), HttpStatus.OK);
    }

    @GetMapping("/getStatisticsByTypeGame/{typeName}")
    public List<Statistic> getStatisticsByTypeGame(@PathVariable String typeName){
		if(typeName.equalsIgnoreCase("HangMan")){
			typeGame = TypeGame.HANGMAN;
		}else if(typeName.equalsIgnoreCase("TicTacToe")){
			typeGame = TypeGame.TTT;
		}
        return statisticService.showStatisticsByTypeGame(typeGame);
    }


}
