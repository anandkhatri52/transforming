package com.aequilibrium.transforming.mapper;

import com.aequilibrium.transforming.entity.TransformerEntity;
import com.aequilibrium.transforming.enums.TransformerTeams;
import com.aequilibrium.transforming.model.TransformerListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TransformerMapper {

    private final TransformerRatingMapper transformerRatingMapper;

    public List<TransformerListResponse> map(List<TransformerEntity> transformerEntityList){
        return transformerEntityList.stream().map(this::mapTransformer).collect(Collectors.toList());

    }

    private TransformerListResponse mapTransformer(TransformerEntity transformerEntity) {
        return TransformerListResponse.builder()
                .id(transformerEntity.getId())
                .name(transformerEntity.getName())
                .team(TransformerTeams.valueOf(transformerEntity.getTransformerTeamEntity().getTeamName()))
                .transformerRating(transformerRatingMapper.mapToTransformerRating(transformerEntity.getTransformerRatingEntity()))
                .build();
    }
}
