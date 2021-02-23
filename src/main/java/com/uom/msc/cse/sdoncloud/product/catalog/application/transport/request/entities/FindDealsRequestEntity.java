
package com.uom.msc.cse.sdoncloud.product.catalog.application.transport.request.entities;

import com.uom.msc.cse.sdoncloud.product.catalog.application.validator.RequestEntityInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FindDealsRequestEntity implements RequestEntityInterface {

    private String deviceId;
    private String imageLabels;

}
