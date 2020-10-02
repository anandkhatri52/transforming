package com.aequilibrium.transforming.model;

import com.aequilibrium.transforming.enums.TransformerTeams;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class TransformerRequest {

    private Long id;

    @NotBlank
    private String name;

    private TransformerTeams team;

    @Min(value = 1, message = "strength should be between 1 to 10")
    @Max(value = 10, message = "strength should be between 1 to 10")
    private Integer strength;

    @Min(value = 1)
    @Max(value = 10)
    private Integer intelligence;

    @Min(value = 1)
    @Max(value = 10)
    private Integer speed;

    @Min(value = 1)
    @Max(value = 10)
    private Integer endurance;

    @Min(value = 1)
    @Max(value = 10)
    private Integer firepower;

    @Min(value = 1)
    @Max(value = 10)
    private Integer rank;

    @Min(value = 1)
    @Max(value = 10)
    private Integer courage;

    @Min(value = 1)
    @Max(value = 10)
    private Integer skill;
}
