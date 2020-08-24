package com.emall.authorizationserver.event;

import com.emall.authorizationserver.service.IResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "resource-queue")
@Slf4j
public class ResourceEventReceive {

    @Autowired
    private IResourceService resourceService;

    public void handleMessage(ResourceMessage resourceMessage) {
        resourceService.saveResource(resourceMessage);
    }

}
