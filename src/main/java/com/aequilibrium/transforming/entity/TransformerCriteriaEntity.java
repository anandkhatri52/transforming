package com.aequilibrium.transforming.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transformer_criteria")
public class TransformerCriteriaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Integer strength;
    private Integer intelligence;
    private Integer speed;
    private Integer endurance;
    private Integer firepower;
    private Integer rank;
    private Integer courage;
    private Integer skill;

}
