package com.aequilibrium.transforming.model;

import com.aequilibrium.transforming.enums.TransformerTeams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel
public class TransformerRequest {

    private Long id;

    @NotBlank
    @ApiModelProperty(notes = "Name of the transformer", example = "Predaking", required = true)
    private String name;

    @ApiModelProperty(notes = "Team name that transformer belongs to", example = "AUTOBOTS", required = true)
    private TransformerTeams team;

    @Min(value = 1, message = "strength should be between 1 to 10")
    @Max(value = 10, message = "strength should be between 1 to 10")
    @ApiModelProperty(notes = "Transformer Strength", example = "8", required = true)
    private Integer strength;

    @Min(value = 1)
    @Max(value = 10)
    @ApiModelProperty(notes = "Transformer Intelligence", example = "8", required = true)
    private Integer intelligence;

    @Min(value = 1)
    @Max(value = 10)
    @ApiModelProperty(notes = "Transformer Speed", example = "8", required = true)
    private Integer speed;

    @Min(value = 1)
    @Max(value = 10)
    @ApiModelProperty(notes = "Transformer Endurance", example = "8", required = true)
    private Integer endurance;

    @Min(value = 1)
    @Max(value = 10)
    @ApiModelProperty(notes = "Transformer Firepower", example = "8", required = true)
    private Integer firepower;

    @Min(value = 1)
    @Max(value = 10)
    @ApiModelProperty(notes = "Transformer Rank", example = "8", required = true)
    private Integer rank;

    @Min(value = 1)
    @Max(value = 10)
    @ApiModelProperty(notes = "Transformer Courage", example = "8", required = true)
    private Integer courage;

    @Min(value = 1)
    @Max(value = 10)
    @ApiModelProperty(notes = "Transformer Skill", example = "8", required = true)
    private Integer skill;
}
