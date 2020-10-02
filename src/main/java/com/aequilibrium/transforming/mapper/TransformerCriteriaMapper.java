package com.aequilibrium.transforming.mapper;

import com.aequilibrium.transforming.entity.TransformerCriteriaEntity;
import com.aequilibrium.transforming.model.TransformerCriteria;
import com.aequilibrium.transforming.model.TransformerRequest;
import org.springframework.stereotype.Component;

@Component
public class TransformerCriteriaMapper {

    public TransformerCriteriaEntity map(TransformerRequest transformerRequest){
        return TransformerCriteriaEntity.builder()
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


    public TransformerCriteria mapToTransformerCriteria(TransformerCriteriaEntity transformerCriteriaEntity) {
        return TransformerCriteria.builder()
                .strength(transformerCriteriaEntity.getStrength())
                .intelligence(transformerCriteriaEntity.getIntelligence())
                .speed(transformerCriteriaEntity.getSpeed())
                .endurance(transformerCriteriaEntity.getEndurance())
                .rank(transformerCriteriaEntity.getRank())
                .courage(transformerCriteriaEntity.getCourage())
                .skill(transformerCriteriaEntity.getSkill())
                .firepower(transformerCriteriaEntity.getFirepower())
                .build();
    }
}
