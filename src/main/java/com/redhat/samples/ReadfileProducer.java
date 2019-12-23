package com.redhat.samples;

import org.apache.camel.Exchange;
import org.apache.camel.support.DefaultProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Readfile producer.
 */
public class ReadfileProducer extends DefaultProducer {
    private static final Logger LOG = LoggerFactory.getLogger(ReadfileProducer.class);
    private ReadfileEndpoint endpoint;

    public ReadfileProducer(ReadfileEndpoint endpoint) {
        super(endpoint);
        this.endpoint = endpoint;
    }

    public void process(Exchange exchange) throws Exception {
        System.out.println(exchange.getIn().getBody());    
    }

}
