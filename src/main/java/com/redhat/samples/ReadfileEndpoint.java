package com.redhat.samples;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.support.DefaultEndpoint;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriPath;

import java.util.concurrent.ExecutorService;

/**
 * Represents a Readfile endpoint.
 */
@UriEndpoint(firstVersion = "1.0-SNAPSHOT", scheme = "readfile", title = "Readfile", syntax="readfile:name", 
             consumerClass = ReadfileConsumer.class, label = "custom")
public class ReadfileEndpoint extends DefaultEndpoint {
    @UriPath @Metadata(required = true)
    private String name;
    @UriParam(defaultValue = "10")
    private int option = 10;

    public ReadfileEndpoint() {
    }

    public ReadfileEndpoint(String uri, ReadfileComponent component) {
        super(uri, component);
    }

    public Producer createProducer() throws Exception {
        return new ReadfileProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        return new ReadfileConsumer(this, processor);
    }

    public boolean isSingleton() {
        return true;
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

    /**
     * Some description of this option, and what it does
     */
    public void setOption(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }

    public ExecutorService createExecutor() {
        // TODO: Delete me when you implementy your custom component
        return getCamelContext().getExecutorServiceManager().newSingleThreadExecutor(this, "ReadfileConsumer");
    }
}
