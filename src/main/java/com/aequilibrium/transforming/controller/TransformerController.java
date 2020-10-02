package com.aequilibrium.transforming.controller;

import com.aequilibrium.transforming.model.TransformerListResponse;
import com.aequilibrium.transforming.model.TransformerRequest;
import com.aequilibrium.transforming.service.TransformerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
@Validated
@ApiResponses({
        @ApiResponse(code = 400, message = "BadRequest", response = Exception.class),
        @ApiResponse(code = 200, message = "Success", response = Exception.class)
})
public class TransformerController {

    private final TransformerService transformerService;

    @ApiOperation(nickname = "getTransformer", value = "Retrieve list of transformer", response = TransformerListResponse.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Transformers have been retrieved successfully", response = TransformerListResponse.class)
    })
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TransformerListResponse>> getTransformer() {
        return ResponseEntity.ok(transformerService.getTransformers());
    }

    @ApiOperation(nickname = "createUpdateTransformer", value = "Create and Update the transformer")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Transformer have been updated successfully"),
            @ApiResponse(code = 201, message = "Transformer have been created successfully")
    })
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT}, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity createUpdateTransformer(@Valid @RequestBody TransformerRequest transformerRequest) {
        transformerService.createTransformer(transformerRequest);
        return ResponseEntity.status(transformerRequest.getId() == null ? CREATED : OK).build();
    }

    @ApiOperation(nickname = "deleteTransformer", value = "Delete the requested transformer")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Transformer have been deleted successfully")
    })
    @DeleteMapping("/{transformerId}")
    public ResponseEntity deleteTransformer(@PathVariable Long transformerId){
        transformerService.deleteTransformer(transformerId);
        return ResponseEntity.status(OK).build();
    }


}
