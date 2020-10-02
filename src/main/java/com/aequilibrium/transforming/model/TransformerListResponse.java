package com.aequilibrium.transforming.model;

import com.aequilibrium.transforming.enums.TransformerTeams;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransformerListResponse {

    private Long id;

    private String name;

    private TransformerTeams team;

    private TransformerRating transformerRating;
}
