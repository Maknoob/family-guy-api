package com.codingmak.familyguyapi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingmak.familyguyapi.Exceptions.CharacterNotFound;
import com.codingmak.familyguyapi.Exceptions.EpisodeNotFound;
import com.codingmak.familyguyapi.Model.CharacterModel;
import com.codingmak.familyguyapi.service.CharacterService;

@RestController
@RequestMapping("rest/characters")
public class CharacterController {
	
	private CharacterService characterService;
	
	public CharacterController(CharacterService characterService) {
		this.characterService = characterService;
		
	}
	
	@GetMapping
	public List<CharacterModel> getAllCharacters() {
		return characterService.getAllCharacters();
	}
	
	@GetMapping ("/{id}")
	public CharacterModel getCharacterById(@PathVariable Integer id) {
		Optional<CharacterModel> character = characterService.getCharacterById(id);
		if(character.isPresent()) {
			return (CharacterModel) character.get();
		}
		return null;
	}
	
    @GetMapping("/age/{age}")
    public ResponseEntity<List<CharacterModel>> getCharacterByAge(@PathVariable Integer age) {
        try {
            List<CharacterModel> characters = characterService.getCharacterByAge(age);
            return ResponseEntity.ok(characters);
        } catch (CharacterNotFound e) {
            return ResponseEntity.status(404).body(null);
        }
    }
	
	@ExceptionHandler({CharacterNotFound.class})
	public ResponseEntity<String> handleCharacterNotFound(CharacterNotFound exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }


}
