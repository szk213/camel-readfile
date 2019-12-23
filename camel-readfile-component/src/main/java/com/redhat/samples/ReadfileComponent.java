package com.redhat.samples;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.support.component.AbstractApiComponent;

import com.redhat.samples.internal.ReadfileApiCollection;
import com.redhat.samples.internal.ReadfileApiName;

/**
 * Represents the component that manages {@link ReadfileEndpoint}.
 */
public class ReadfileComponent extends AbstractApiComponent<ReadfileApiName, ReadfileConfiguration, ReadfileApiCollection> {

    public ReadfileComponent() {
        super(ReadfileEndpoint.class, ReadfileApiName.class, ReadfileApiCollection.getCollection());
    }

    public ReadfileComponent(CamelContext context) {
        super(context, ReadfileEndpoint.class, ReadfileApiName.class, ReadfileApiCollection.getCollection());
    }

    @Override
    protected ReadfileApiName getApiName(String apiNameStr) throws IllegalArgumentException {
        return ReadfileApiName.fromValue(apiNameStr);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String methodName, ReadfileApiName apiName,
                                      ReadfileConfiguration endpointConfiguration) {
        ReadfileEndpoint endpoint = new ReadfileEndpoint(uri, this, apiName, methodName, endpointConfiguration);
        endpoint.setName(methodName);
        return endpoint;
    }

    /**
     * To use the shared configuration
     */
    @Override
    public void setConfiguration(ReadfileConfiguration configuration) {
        super.setConfiguration(configuration);
    }

}
