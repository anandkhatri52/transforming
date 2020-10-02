package com.aequilibrium.transforming.model;

import com.aequilibrium.transforming.enums.TransformerTeams;
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
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class TransformerListResponse {

    @ApiModelProperty(notes = "Transformer id", example = "10", required = true)
    private Long id;

    @ApiModelProperty(notes = "Name of transformer", example = "10", required = true)
    private String name;

    @ApiModelProperty(notes = "Team name that transformer belongs to", example = "AUTOBOTS", required = true)
    private TransformerTeams team;

    @ApiModelProperty(notes = "Transformer rating details", required = true)
    private TransformerRating transformerRating;
}
