package com.pentalog.project.module1.tema2;

public interface GameInterface {

    String iGetInfo();

    default String iDefaultInfo(){
        return "This is just a game";
    }
}
