package com.pentalog.project.module2.model.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GameDto {

    private String name;

    private String releaseDate;

    private String description;

    private String imageUrl;

    private String trailerUrl;

    private String genre;

    private String platform;

    private String publisher;

    private String developer;

    private String rating;

    private double price;
}
