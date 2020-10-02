package com.aequilibrium.transforming.controller;

import com.aequilibrium.transforming.model.TransformerListResponse;
import com.aequilibrium.transforming.model.TransformerRequest;
import com.aequilibrium.transforming.service.TransformerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/transformer")
@RequiredArgsConstructor
@Valid
public class TransformerController {

    private final TransformerService transformerService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TransformerListResponse>> getTransformer() {
        return ResponseEntity.ok(transformerService.getTransformers());
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT}, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity createTransformer(@Valid @RequestBody TransformerRequest transformerRequest) {
        transformerService.createTransformer(transformerRequest);
        return ResponseEntity.status(transformerRequest.getId() == null ? CREATED : OK).build();
    }

    @DeleteMapping("/{transformerId}")
    public ResponseEntity deleteTransformer(@PathVariable Long transformerId){
        transformerService.deleteTransformer(transformerId);
        return ResponseEntity.status(OK).build();
    }


}
