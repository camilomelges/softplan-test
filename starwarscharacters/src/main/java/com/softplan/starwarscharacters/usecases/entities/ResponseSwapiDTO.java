package com.softplan.starwarscharacters.usecases.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSwapiDTO {
    private Integer count;
    private Integer next;
    private Integer previous;
    private Set<StarWarsCharacterDTO> results = new HashSet<>();
}
