package com.softplan.starwarscharacters.entrypoint;

import com.softplan.starwarscharacters.usecases.entities.StarWarsCharacterDTO;
import com.softplan.starwarscharacters.usecases.services.IRequestCharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharactersController {

    private final IRequestCharacterService requestCharacterService;

    public CharactersController(final IRequestCharacterService requestCharacterService) {
        this.requestCharacterService = requestCharacterService;
    }

    @GetMapping
    public StarWarsCharacterDTO get(final @RequestParam("search") String search) {
        if (search.isEmpty() || search.isBlank()) {
            throw new RuntimeException("Search cannot be empty");
        }

        return requestCharacterService.getCharacter(search).getResults().get(0);
    }
}
