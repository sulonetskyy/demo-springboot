package com.example.demospringboot.controller;

import com.example.demospringboot.service.InfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController()
public class InfoController {

    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/info")
    public Map<String, String> info() {
        return this.infoService.getInfo();
    }

    @GetMapping("/info/name")
    public String name() {
        return this.infoService.getName();
    }

    @GetMapping("/info/version")
    public String version() {
        return this.infoService.getVersion();
    }
}
