package intango.test.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import intango.test.ColorVote;
import intango.test.exceptions.VoteException;
import intango.test.service.ColorVoteService;




@CrossOrigin
@RestController
@RequestMapping("/squares")
public class VoteController {
	
	@Autowired
	private ColorVoteService colorVoteService;
	
	
	@PostMapping("/add-square")
	public ResponseEntity<?> addSquare(@RequestBody ColorVote colorVote ) {

		try {
			colorVoteService.addColorVote(colorVote);
			return ResponseEntity.ok(colorVote);
		} catch (VoteException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}

	}
	
	@GetMapping("/get-votes")
	public ResponseEntity<?> getVote(){
		Set<ColorVote> set;
		try {
			set = colorVoteService.getColorVotes();
			return ResponseEntity.ok(set);
		} catch (VoteException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}

}
