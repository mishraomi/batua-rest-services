package com.firebolt.batua.batuarestservices.card;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CardsResource {

	@Autowired
	private CardHardCodedService cardService;
	
	@GetMapping("/users/{username}/cards")
	public List<Card> getAllCards(@PathVariable String username){
		return cardService.findAll();
	}
	
	@GetMapping("/users/{username}/cards/{id}")
	public Card getCard(@PathVariable String username, @PathVariable long id){
		return cardService.findById(id);
	}
	
	@DeleteMapping("/users/{username}/cards/{id}")
	public ResponseEntity<Void> deleteCard(@PathVariable String username, @PathVariable long id){
		Card card = cardService.deleteById(id);
		if(card != null) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
