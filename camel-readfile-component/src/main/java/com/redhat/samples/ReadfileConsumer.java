package com.redhat.samples;

import org.apache.camel.Processor;
import org.apache.camel.support.component.AbstractApiConsumer;

import com.redhat.samples.internal.ReadfileApiName;

/**
 * The Readfile consumer.
 */
public class ReadfileConsumer extends AbstractApiConsumer<ReadfileApiName, ReadfileConfiguration> {

    public ReadfileConsumer(ReadfileEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

}
