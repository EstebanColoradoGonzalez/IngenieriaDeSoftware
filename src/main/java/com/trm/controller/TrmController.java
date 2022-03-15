package com.trm.controller;

import com.trm.dto.Result;
import com.trm.service.TrmService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrmController {

    private final TrmService trmService;

    public TrmController (TrmService trmService) {
        this.trmService = trmService;
    }

    @RequestMapping("/trm")
    public Result get() {
        return this.trmService.get();
    }
}
