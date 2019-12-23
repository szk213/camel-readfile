package com.redhat.samples;

import org.apache.camel.support.component.AbstractApiProducer;

import com.redhat.samples.internal.ReadfileApiName;
import com.redhat.samples.internal.ReadfilePropertiesHelper;

/**
 * The Readfile producer.
 */
public class ReadfileProducer extends AbstractApiProducer<ReadfileApiName, ReadfileConfiguration> {

    public ReadfileProducer(ReadfileEndpoint endpoint) {
        super(endpoint, ReadfilePropertiesHelper.getHelper());
    }
}
