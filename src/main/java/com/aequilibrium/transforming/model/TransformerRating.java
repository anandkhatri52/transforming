package com.aequilibrium.transforming.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class TransformerRating {

    @ApiModelProperty(notes = "Transformer Strength", example = "8", required = true)
    private Integer strength;

    @ApiModelProperty(notes = "Transformer Intelligence", example = "8", required = true)
    private Integer intelligence;

    @ApiModelProperty(notes = "Transformer Speed", example = "8", required = true)
    private Integer speed;

    @ApiModelProperty(notes = "Transformer Endurance", example = "8", required = true)
    private Integer endurance;

    @ApiModelProperty(notes = "Transformer Firepower", example = "8", required = true)
    private Integer firepower;

    @ApiModelProperty(notes = "Transformer Rank", example = "8", required = true)
    private Integer rank;

    @ApiModelProperty(notes = "Transformer Courage", example = "8", required = true)
    private Integer courage;

    @ApiModelProperty(notes = "Transformer Skill", example = "8", required = true)
    private Integer skill;
}
