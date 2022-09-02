package com.example.backendproject.controller.hangman;



import com.example.backendproject.controller.hangman.hangmanservice.HangManTurnService;
import com.example.backendproject.controller.hangman.hangmanservice.HangedManService;
import com.example.backendproject.model.HangManTurn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/v1")
public class HangedManController {

    HangedManService hangedManService;
	@PostMapping("/guessLetter/{letter}")
	public ResponseEntity<Boolean> guessLetter(@PathVariable String letter, @RequestBody HangManTurn hangManTurn) {
		char letterGuessed = letter.charAt(0);
		HangManTurn hangManTurnGuessed = HangManTurnService.turnList.stream().filter(turn -> turn.getId_turn() == hangManTurn.getId_turn()).findFirst().get();
		hangedManService= new HangedManService();
		Boolean exist = hangedManService.compareLetterToSecretWord(letterGuessed, hangManTurnGuessed);
		return new ResponseEntity <> (exist, HttpStatus.OK);
	}

	@GetMapping("/StillNotWinner")
	public Boolean checkIfFinished() {
		hangedManService= new HangedManService();
		boolean notfinished = hangedManService.isSecretWordSeparatedByLine();
		if(notfinished){
			return notfinished;
		}
		else{
			HangedManService.secretWordSeparatedByLine = null;
			return notfinished;
		}
	}
}

