package com.dnu.warehouse.web.controller;

import com.dnu.warehouse.core.dto.GoodDto;
import com.dnu.warehouse.core.dto.GoodSellRequest;
import com.dnu.warehouse.core.dto.GoodSellResponse;
import com.dnu.warehouse.core.facade.GoodFacade;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/good/")
@AllArgsConstructor
@PreAuthorize("hasAnyAuthority('default')")
public class GoodController {

    private GoodFacade goodFacade;

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<GoodDto> findGoods(
            @RequestParam(name = "className")String className,
            @RequestParam(name = "start", required = false) Long start,
            @RequestParam(name = "end", required = false)Long end) {
        return goodFacade.findByClassAndDeliveryDateRange(className, start, end);
    }


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/sell")
    public GoodSellResponse sell(@RequestBody GoodSellRequest sellRequest) {
        return goodFacade.sell(sellRequest);
    }
}