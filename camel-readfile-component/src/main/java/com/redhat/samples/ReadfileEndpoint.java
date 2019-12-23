package com.redhat.samples;

import java.util.Map;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriPath;
import org.apache.camel.support.component.AbstractApiEndpoint;
import org.apache.camel.support.component.ApiMethod;
import org.apache.camel.support.component.ApiMethodPropertiesHelper;

import com.redhat.samples.api.ReadfileFileHello;
import com.redhat.samples.api.ReadfileJavadocHello;
import com.redhat.samples.internal.ReadfileApiCollection;
import com.redhat.samples.internal.ReadfileApiName;
import com.redhat.samples.internal.ReadfileConstants;
import com.redhat.samples.internal.ReadfilePropertiesHelper;

/**
 * Represents a Readfile endpoint.
 */
@UriEndpoint(firstVersion = "1.0-SNAPSHOT", scheme = "readfile", title = "Readfile", syntax="readfile:name", 
             consumerClass = ReadfileConsumer.class, label = "custom")
public class ReadfileEndpoint extends AbstractApiEndpoint<ReadfileApiName, ReadfileConfiguration> {

    @UriPath @Metadata(required = true)
    private String name;

    // TODO create and manage API proxy
    private Object apiProxy;

    public ReadfileEndpoint(String uri, ReadfileComponent component,
                         ReadfileApiName apiName, String methodName, ReadfileConfiguration endpointConfiguration) {
        super(uri, component, apiName, methodName, ReadfileApiCollection.getCollection().getHelper(apiName), endpointConfiguration);

    }

    public Producer createProducer() throws Exception {
        return new ReadfileProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        // make sure inBody is not set for consumers
        if (inBody != null) {
            throw new IllegalArgumentException("Option inBody is not supported for consumer endpoint");
        }
        final ReadfileConsumer consumer = new ReadfileConsumer(this, processor);
        // also set consumer.* properties
        configureConsumer(consumer);
        return consumer;
    }

    @Override
    protected ApiMethodPropertiesHelper<ReadfileConfiguration> getPropertiesHelper() {
        return ReadfilePropertiesHelper.getHelper();
    }

    protected String getThreadProfileName() {
        return ReadfileConstants.THREAD_PROFILE_NAME;
    }

    @Override
    protected void afterConfigureProperties() {
        // TODO create API proxy, set connection properties, etc.
        switch (apiName) {
            case HELLO_FILE:
                apiProxy = new ReadfileFileHello();
                break;
            case HELLO_JAVADOC:
                apiProxy = new ReadfileJavadocHello();
                break;
            default:
                throw new IllegalArgumentException("Invalid API name " + apiName);
        }
    }

    @Override
    public Object getApiProxy(ApiMethod method, Map<String, Object> args) {
        return apiProxy;
    }

    /**
     * Some description of this option, and what it does
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
