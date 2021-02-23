
package com.uom.msc.cse.sdoncloud.product.catalog.application.controller;

import com.uom.msc.cse.sdoncloud.product.catalog.application.transformer.ResponseEntityTransformer;
import com.uom.msc.cse.sdoncloud.product.catalog.application.transport.request.entities.FindDealsRequestEntity;
import com.uom.msc.cse.sdoncloud.product.catalog.application.transport.response.transformers.SampleResponseTransformer;
import com.uom.msc.cse.sdoncloud.product.catalog.application.validator.RequestEntityValidator;
import com.uom.msc.cse.sdoncloud.product.catalog.domain.entities.dto.SampleDomainRequestEntity;
import com.uom.msc.cse.sdoncloud.product.catalog.domain.entities.dto.SampleDomainResponseEntity;
import com.uom.msc.cse.sdoncloud.product.catalog.domain.service.SampleManageService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("${base-url.context}")
@Log4j2
public class CatalogController extends BaseController {
    @Autowired
    SampleManageService sampleManageService;

    @Autowired
    ResponseEntityTransformer responseEntityTransformer;

    @Autowired
    SampleResponseTransformer sampleResponseTransformer;

    @Autowired
    private RequestEntityValidator validator;

    @PostMapping(value="/find-deals", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findDeals(@Validated @RequestBody(required = true) FindDealsRequestEntity findDealsRequestEntity, HttpServletRequest request)throws Exception{

//        TODO: set UUID
        setLogIdentifier(request);
//        TODO: validate the request
        validator.validate(findDealsRequestEntity);
//        logger.info("Request validation success");

//        TODO: request object map to domain entity object
        SampleDomainRequestEntity sampleDomainRequestEntity = new ModelMapper().map(findDealsRequestEntity, SampleDomainRequestEntity.class);

//        TODO: call domain business logic
        SampleDomainResponseEntity sampleDomainResponseEntity = sampleManageService.process(sampleDomainRequestEntity);

//        TODO: transform domain response
        Map trResponse = responseEntityTransformer.transform(sampleDomainResponseEntity,sampleResponseTransformer);
//        logger.info("Transformed response : "+trResponse.toString());

//        TODO: return response
         return ResponseEntity.status(HttpStatus.OK).body(trResponse);
    }
}
