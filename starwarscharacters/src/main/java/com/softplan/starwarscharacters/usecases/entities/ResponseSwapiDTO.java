package com.softplan.starwarscharacters.usecases.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSwapiDTO {
    private Integer count;
    private Integer next;
    private Integer previous;
    private List<StarWarsCharacterDTO> results = new ArrayList<>();
}
