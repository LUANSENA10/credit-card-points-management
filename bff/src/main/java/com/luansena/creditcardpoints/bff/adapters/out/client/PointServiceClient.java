package com.luansena.creditcardpoints.bff.adapters.out.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.math.BigDecimal;

@FeignClient(name = "point-service", url = "${point.service.url}")
public interface PointServiceClient {
    @GetMapping("/accounts/{cardId}/points")
    BigDecimal getPoints(@PathVariable("cardId") Long cardId);
}

