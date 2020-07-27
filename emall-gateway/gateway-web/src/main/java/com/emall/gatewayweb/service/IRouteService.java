package com.emall.gatewayweb.service;

import org.springframework.cloud.gateway.route.RouteDefinition;

import java.util.Collection;

public interface IRouteService {
    Collection<RouteDefinition> getRouteDefinitions();

    void save(RouteDefinition routeDefinitionMono);

    void delete(String routeId);
}
