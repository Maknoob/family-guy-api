package com.codingmak.familyguyapi.Controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingmak.familyguyapi.Model.CharacterModel;
import com.codingmak.familyguyapi.service.CharacterService;

@RestController
public class CharacterController {
	
	private CharacterService characterService;
	
	public CharacterController(CharacterService characterService) {
		this.characterService = characterService;
		
	}
	
	@GetMapping ("/characters")
	public CharacterModel getName(@RequestParam Integer id) {
		Optional<CharacterModel> character = characterService.getName(id);
		if(character.isPresent()) {
			return (CharacterModel) character.get();
		}
		return null;
	}


}
