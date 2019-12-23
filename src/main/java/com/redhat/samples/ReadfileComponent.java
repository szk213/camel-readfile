package com.redhat.samples;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;

import org.apache.camel.support.DefaultComponent;

/**
 * Represents the component that manages {@link ReadfileEndpoint}.
 */
public class ReadfileComponent extends DefaultComponent {
    
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        Endpoint endpoint = new ReadfileEndpoint(uri, this);
        setProperties(endpoint, parameters);
        return endpoint;
    }
}
