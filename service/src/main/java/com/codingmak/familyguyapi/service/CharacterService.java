package com.codingmak.familyguyapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingmak.familyguyapi.Model.CharacterModel;

@Service
public class CharacterService {
	
	private List<CharacterModel> charList;

	
	public CharacterService() {
		charList = new ArrayList<>();
		
		CharacterModel peter = new CharacterModel(1, "Peter Griffin", 45, "Mexico", "Brewary", "Griffins");
		CharacterModel lois = new CharacterModel(2, "Lois Griffin", 43, "USA Denver", "Housewife", "Griffins");
		CharacterModel chris = new CharacterModel(3, "Chris Griffin", 14, "Quahog", "School", "Griffins");
		CharacterModel stewie = new CharacterModel(4, "Stewie Griffin", 1, "Quahog", "-", "Griffins");
		CharacterModel meg = new CharacterModel(5, "Meg Griffin", 16, "Quahog", "School", "Griffins");
		
		charList.addAll(Arrays.asList(peter,lois,chris,stewie,meg));
	}



	public Optional<CharacterModel> getCharacter(Integer id) {
		Optional<CharacterModel> optional = Optional.empty();
		for (CharacterModel characterModel : charList) {
			
			if (id == characterModel.getId()) {
				optional = Optional.of(characterModel);
				return optional;
			}
		}
		return optional;
	}

}
