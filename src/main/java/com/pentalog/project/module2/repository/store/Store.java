package com.pentalog.project.module2.repository.store;

import com.pentalog.project.module2.repository.game.Game;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Column(unique = true)
    private String name;

    private String website;

    @NotBlank
    private String location;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "store_game",
//            joinColumns = @JoinColumn(name = "store_id"),
//            inverseJoinColumns = @JoinColumn(name = "game_id"))
//    private List<Game> games = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private List<Game> games = new ArrayList<>();

}
