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

    HangedManService hangedManService = new HangedManService();
	@GetMapping("/guessLetter")
	public ResponseEntity<char[]> guessLetter(@RequestBody char letter, HangManTurn hangManTurn) {
		char letterGuessed = letter;
		HangManTurn hangManTurnGuessed = HangManTurnService.turnList.stream().filter(turn -> turn.getId_turn() == hangManTurn.getId_turn()).findFirst().get();
		hangedManService.compareLetterToSecretWord(letterGuessed, hangManTurn);
		return new ResponseEntity <> (HangedManService.secretWordSeparatedByLine, HttpStatus.OK);
	}

	@GetMapping("/checkIfFinished")
	public ResponseEntity<Boolean> checkIfFinished() {
		boolean finished = hangedManService.isSecretWordSeparatedByLine();
		if(finished==true){

			return new ResponseEntity<>(finished, HttpStatus.OK);
		}
		else{
			HangedManService.secretWordSeparatedByLine = null;
			return new ResponseEntity<>(finished, HttpStatus.OK);
		}
	}
}

