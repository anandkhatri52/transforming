package com.aequilibrium.transforming.model;

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
public class TransformerRating {

    private Integer strength;
    private Integer intelligence;
    private Integer speed;
    private Integer endurance;
    private Integer firepower;
    private Integer rank;
    private Integer courage;
    private Integer skill;
}
