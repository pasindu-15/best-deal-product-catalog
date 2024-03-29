
package com.uom.msc.cse.sdoncloud.product.catalog.application.transport.response.transformers;

import com.uom.msc.cse.sdoncloud.product.catalog.application.transformer.ResponseEntityInterface;
import com.uom.msc.cse.sdoncloud.product.catalog.domain.entities.dto.SampleDomainResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class SampleResponseTransformer implements ResponseEntityInterface {
    @Override
    public Map transform(Object entity) {
        SampleDomainResponseEntity offerResponse = (SampleDomainResponseEntity)entity;
        Map<String,Object> mapping = new HashMap<>();
        mapping.put("resCode",offerResponse.getResCode());
        mapping.put("resDesc",offerResponse.getResDesc());

        return mapping;
    }
}
