package com.aequilibrium.transforming.service;

import com.aequilibrium.transforming.entity.TransformerRatingEntity;
import com.aequilibrium.transforming.entity.TransformerEntity;
import com.aequilibrium.transforming.entity.TransformerTeamEntity;
import com.aequilibrium.transforming.mapper.TransformerRatingMapper;
import com.aequilibrium.transforming.mapper.TransformerMapper;
import com.aequilibrium.transforming.model.TransformerListResponse;
import com.aequilibrium.transforming.model.TransformerRequest;
import com.aequilibrium.transforming.repository.TransformerRatingRepository;
import com.aequilibrium.transforming.repository.TransformerRepository;
import com.aequilibrium.transforming.repository.TransformerTeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransformerService {

    private final TransformerRepository transformerRepository;
    private final TransformerTeamRepository transformerTeamRepository;
    private final TransformerRatingRepository transformerRatingRepository;

    private final TransformerMapper transformerMapper;
    private final TransformerRatingMapper transformerRatingMapper;


    public List<TransformerListResponse> getTransformers() {
        log.info("Retrieve list of transformers service called");
        return transformerMapper.map(transformerRepository.findAll());
    }

    public void createTransformer(TransformerRequest transformerRequest) {
        log.info("Create and update transformer service called");
        TransformerTeamEntity teamEntity = transformerTeamRepository.findByTeamName(transformerRequest.getTeam().name());
        TransformerRatingEntity transformerRatingEntity = transformerRatingRepository.save(transformerRatingMapper.map(transformerRequest));
        TransformerEntity transformerEntity = TransformerEntity.builder()
                .id(transformerRequest.getId())
                .name(transformerRequest.getName())
                .transformerTeamEntity(teamEntity)
                .transformerRatingEntity(transformerRatingEntity)
                .build();
        transformerRepository.save(transformerEntity);
    }

    public void deleteTransformer(Long transformerId) {
        log.info("Delete transformer service called");
        transformerRepository.delete(TransformerEntity.builder().id(transformerId).build());
        log.info("Requested transformer id {} deleted", transformerId);
    }

}
