package com.codingmak.familyguyapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.codingmak.familyguyapi.model.CharacterModel;
import com.codingmak.familyguyapi.exceptions.CharacterNotFound;




@Service
public class CharacterService {
	
	private List<CharacterModel> charList;

	
	public CharacterService() {
		charList = new ArrayList<>();
		
		CharacterModel peter = new CharacterModel(1, "Peter Griffin", 45, "Mexico", "Brewary", "Griffins");
		CharacterModel lois = new CharacterModel(2, "Lois Griffin", 43, "USA Denver", "Housewife", "Griffins");
		CharacterModel chris = new CharacterModel(3, "Chris Griffin", 14, "Quahog", "School", "Griffins");
		CharacterModel chris2 = new CharacterModel(4, "Chriss Griffin", 14, "Quahog", "School", "Griffins");
		CharacterModel stewie = new CharacterModel(5, "Stewie Griffin", 1, "Quahog", "-", "Griffins");
		CharacterModel meg = new CharacterModel(6, "Meg Griffin", 16, "Quahog", "School", "Griffins");
		
		charList.addAll(Arrays.asList(peter,lois,chris,stewie,meg, chris2));
	}



	public Optional<CharacterModel> getCharacterById(Integer id) {
        return charList.stream()
                .filter(character -> id.equals(character.getId()))
                .findFirst()
                .or(() -> {
                    throw new CharacterNotFound("Character not found with ID: " + id);
                });
    
	}



	public List<CharacterModel> getAllCharacters() {
		
		return charList;
	}



	public List<CharacterModel> getCharacterByAge(Integer age) {
        List<CharacterModel> characters = charList.stream()
                .filter(character -> age.equals(character.getAge()))
                .collect(Collectors.toList());
        if (characters.isEmpty()) {
        	throw new CharacterNotFound("Character not found with AGE: " + age);
        }
        return characters;
                
    }

}
