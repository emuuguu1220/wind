package edu.miu.cs.cs544.a202001.wind.controller.rest;

import edu.miu.cs.cs544.a202001.wind.service.ILocationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    private ILocationService service;
}
