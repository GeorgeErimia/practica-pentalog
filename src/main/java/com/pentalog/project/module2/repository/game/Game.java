package com.pentalog.project.module2.repository.game;


import com.pentalog.project.module2.repository.store.Store;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

    @NotBlank
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
        private String name;

        private String releaseDate = "none";

        private String description = "none";

        private String imageUrl = "none";

        private String trailerUrl = "none";

        private String genre = "none";

        private String platform = "none";

        private String publisher = "none";

        private String developer = "none";

        private String rating = "none";

        private double price = 0.0;

}
