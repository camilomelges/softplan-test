package com.softplan.starwarscharacters.usecases.services;

import com.softplan.starwarscharacters.usecases.entities.ResponseSwapiDTO;

public interface IRequestCharacterService {
    ResponseSwapiDTO getCharacter(final String search);
}
