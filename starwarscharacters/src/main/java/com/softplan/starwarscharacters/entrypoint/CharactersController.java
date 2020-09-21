package com.softplan.starwarscharacters.entrypoint;

import com.softplan.starwarscharacters.usecases.entities.StarWarsCharacterDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharactersController {

    @GetMapping
    public StarWarsCharacterDTO get(final @RequestParam("search") String search) {
        return new StarWarsCharacterDTO();
    }
}
