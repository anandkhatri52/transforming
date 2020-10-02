package com.aequilibrium.transforming.mapper;

import com.aequilibrium.transforming.entity.TransformerRatingEntity;
import com.aequilibrium.transforming.model.TransformerRating;
import com.aequilibrium.transforming.model.TransformerRequest;
import org.springframework.stereotype.Component;

@Component
public class TransformerRatingMapper {

    public TransformerRatingEntity map(TransformerRequest transformerRequest){
        return TransformerRatingEntity.builder()
                .strength(transformerRequest.getStrength())
                .intelligence(transformerRequest.getIntelligence())
                .speed(transformerRequest.getSpeed())
                .endurance(transformerRequest.getEndurance())
                .rank(transformerRequest.getRank())
                .courage(transformerRequest.getCourage())
                .skill(transformerRequest.getSkill())
                .firepower(transformerRequest.getFirepower())
                .build();
    }


    public TransformerRating mapToTransformerRating(TransformerRatingEntity transformerRatingEntity) {
        return TransformerRating.builder()
                .strength(transformerRatingEntity.getStrength())
                .intelligence(transformerRatingEntity.getIntelligence())
                .speed(transformerRatingEntity.getSpeed())
                .endurance(transformerRatingEntity.getEndurance())
                .rank(transformerRatingEntity.getRank())
                .courage(transformerRatingEntity.getCourage())
                .skill(transformerRatingEntity.getSkill())
                .firepower(transformerRatingEntity.getFirepower())
                .build();
    }
}
