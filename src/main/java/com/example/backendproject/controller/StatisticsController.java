package com.example.backendproject.controller;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.RestController;


=======
import com.example.backendproject.controller.statisticservice.StatisticService;
import com.example.backendproject.model.Player;
import com.example.backendproject.model.Statistic;
import com.example.backendproject.model.TypeGame;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/v1")
>>>>>>> b4007ad (Adding updates for statistics)
public class StatisticsController {
    StatisticService statisticService = new StatisticService();

<<<<<<< HEAD
=======
    @GetMapping("/getStatisticList")
    public ResponseEntity<String> getStatistics(){
        return new ResponseEntity<>(statisticService.showStatistics(), HttpStatus.OK);
    }

    @GetMapping("/getStatisticsByTypeGame/{type}")
    public ResponseEntity<String> getStatisticsByTypeGame(@PathVariable TypeGame type){
        return new ResponseEntity<>(statisticService.showStatisticsByTypeGame(type), HttpStatus.OK);
    }
>>>>>>> b4007ad (Adding updates for statistics)
}
