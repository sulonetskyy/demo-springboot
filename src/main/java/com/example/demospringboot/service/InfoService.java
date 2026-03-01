package com.example.demospringboot.service;

import java.util.Map;

public interface InfoService {

    Map<String, String> getInfo();

    String getName();

    String getVersion();

}
