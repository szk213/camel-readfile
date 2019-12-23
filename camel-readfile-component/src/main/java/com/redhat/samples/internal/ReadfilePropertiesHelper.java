package com.redhat.samples.internal;

import org.apache.camel.support.component.ApiMethodPropertiesHelper;

import com.redhat.samples.ReadfileConfiguration;

/**
 * Singleton {@link ApiMethodPropertiesHelper} for Readfile component.
 */
public final class ReadfilePropertiesHelper extends ApiMethodPropertiesHelper<ReadfileConfiguration> {

    private static ReadfilePropertiesHelper helper;

    private ReadfilePropertiesHelper() {
        super(ReadfileConfiguration.class, ReadfileConstants.PROPERTY_PREFIX);
    }

    public static synchronized ReadfilePropertiesHelper getHelper() {
        if (helper == null) {
            helper = new ReadfilePropertiesHelper();
        }
        return helper;
    }
}
