package com.aequilibrium.transforming;

import com.aequilibrium.transforming.entity.TransformerEntity;
import com.aequilibrium.transforming.entity.TransformerCriteriaEntity;
import com.aequilibrium.transforming.entity.TransformerTeamEntity;
import com.aequilibrium.transforming.repository.TransformerCriteriaRepository;
import com.aequilibrium.transforming.repository.TransformerRepository;
import com.aequilibrium.transforming.repository.TransformerTeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

@Slf4j
public class TransformingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransformingApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(TransformerRepository transformerRepository, TransformerTeamRepository transformerTeamRepository, TransformerCriteriaRepository transformerCriteriaRepository) {
        return (args) -> {

            TransformerTeamEntity autobots = TransformerTeamEntity.builder().id(1L).teamName("AUTOBOTS").build();
            transformerTeamRepository.save(autobots);
            transformerTeamRepository.save(TransformerTeamEntity.builder().id(2L).teamName("DECEPTICONS").build());

            TransformerCriteriaEntity transformerCriteriaEntity = TransformerCriteriaEntity.builder()
                    .strength(4)
                    .endurance(2)
                    .skill(3)
                    .build();
            transformerCriteriaRepository.save(transformerCriteriaEntity);

            TransformerEntity transformerEntity = TransformerEntity.builder()
                    .name("anand")
                    .transformerTeamEntity(autobots)
                    .transformerCriteriaEntity(transformerCriteriaEntity)
                    .build();

            transformerRepository.save(transformerEntity);
            log.info("Data inserted");
        };
    }

}
