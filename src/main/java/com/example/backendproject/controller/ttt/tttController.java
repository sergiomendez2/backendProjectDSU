package com.example.backendproject.controller.ttt;

import com.example.backendproject.controller.ttt.tttservice.tttTurnService;
import com.example.backendproject.controller.ttt.tttservice.tttService;
import com.example.backendproject.model.TTTTurn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/v1")
public class tttController {

    tttService tttService;
	@GetMapping("/notFinished")
	public Boolean checkIfFinished() {
		tttService= new tttService();
		boolean notfinished = tttService.isSecretWordSeparatedByLine();
		if(notfinished){
			return notfinished;
		}
		else{
			tttService.secretWordSeparatedByLine = null;
			return notfinished;
		}
	}
}

