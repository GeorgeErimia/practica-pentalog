package com.pentalog.project.module2.model.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class StoreDto {

    @NotBlank
    private String name;

    private String website;

    @NotBlank
    private String location;

    private List<GameDto> games = new ArrayList<>();
}
