package com.aequilibrium.transforming.service;

import com.aequilibrium.transforming.entity.TransformerCriteriaEntity;
import com.aequilibrium.transforming.entity.TransformerEntity;
import com.aequilibrium.transforming.entity.TransformerTeamEntity;
import com.aequilibrium.transforming.mapper.TransformerCriteriaMapper;
import com.aequilibrium.transforming.mapper.TransformerMapper;
import com.aequilibrium.transforming.model.TransformerListResponse;
import com.aequilibrium.transforming.model.TransformerRequest;
import com.aequilibrium.transforming.repository.TransformerCriteriaRepository;
import com.aequilibrium.transforming.repository.TransformerRepository;
import com.aequilibrium.transforming.repository.TransformerTeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransformerService {

    private final TransformerRepository transformerRepository;
    private final TransformerTeamRepository transformerTeamRepository;
    private final TransformerCriteriaRepository transformerCriteriaRepository;

    private final TransformerMapper transformerMapper;
    private final TransformerCriteriaMapper transformerCriteriaMapper;


    public List<TransformerListResponse> getTransformers() {
        log.info("Retrieve list of transformers service called");
        return transformerMapper.map(transformerRepository.findAll());
    }

    public void createTransformer(TransformerRequest transformerRequest) {
        log.info("Create and update transformer service called");
        TransformerTeamEntity teamEntity = transformerTeamRepository.findByTeamName(transformerRequest.getTeam().name());
        TransformerCriteriaEntity transformerCriteriaEntity = transformerCriteriaRepository.save(transformerCriteriaMapper.map(transformerRequest));
        TransformerEntity transformerEntity = TransformerEntity.builder()
                .id(transformerRequest.getId())
                .name(transformerRequest.getName())
                .transformerTeamEntity(teamEntity)
                .transformerCriteriaEntity(transformerCriteriaEntity)
                .build();
        transformerRepository.save(transformerEntity);
    }

    public void deleteTransformer(Long transformerId) {
        log.info("Delete transformer service called");
        transformerRepository.delete(TransformerEntity.builder().id(transformerId).build());
        log.info("Requested transformer id {} deleted", transformerId);
    }

}
