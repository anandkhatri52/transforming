package com.aequilibrium.transforming;

import com.aequilibrium.transforming.entity.TransformerEntity;
import com.aequilibrium.transforming.entity.TransformerRatingEntity;
import com.aequilibrium.transforming.entity.TransformerTeamEntity;
import com.aequilibrium.transforming.repository.TransformerRatingRepository;
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
    public CommandLineRunner demo(TransformerRepository transformerRepository, TransformerTeamRepository transformerTeamRepository, TransformerRatingRepository transformerRatingRepository) {
        return (args) -> {

            TransformerTeamEntity autobots = TransformerTeamEntity.builder().id(1L).teamName("AUTOBOTS").build();
            transformerTeamRepository.save(autobots);
            transformerTeamRepository.save(TransformerTeamEntity.builder().id(2L).teamName("DECEPTICONS").build());

            TransformerRatingEntity transformerRatingEntity = TransformerRatingEntity.builder()
                    .strength(4)
                    .endurance(2)
                    .skill(3)
                    .build();
            transformerRatingRepository.save(transformerRatingEntity);

            TransformerEntity transformerEntity = TransformerEntity.builder()
                    .name("anand")
                    .transformerTeamEntity(autobots)
                    .transformerRatingEntity(transformerRatingEntity)
                    .build();

            transformerRepository.save(transformerEntity);
            log.info("Data inserted");
        };
    }

}
