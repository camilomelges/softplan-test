package com.softplan.starwarscharacters.usecases.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarWarsCharacterDTO {
    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private URL homeworld;
    private Set<URL> films = new HashSet<>();
    private Set<URL> species = new HashSet<>();
    private Set<URL> vehicles = new HashSet<>();
    private Set<URL> starships = new HashSet<>();
    private Timestamp created;
    private Timestamp edited;
    private URL url;
}
