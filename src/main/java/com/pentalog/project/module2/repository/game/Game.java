package com.pentalog.project.module2.repository.game;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

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
