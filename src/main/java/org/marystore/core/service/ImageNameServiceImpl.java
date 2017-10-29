package org.marystore.core.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class ImageNameServiceImpl implements ImageNameService {

    private final AtomicLong sequence = new AtomicLong(System.currentTimeMillis() / 1000);

    @Override
    public String getNextName(String originalFileName) {
        String[] items = originalFileName.split("\\.");
        if(items.length < 2) {
            throw new IllegalArgumentException("illegal filename " + originalFileName);
        }
        String extension = items[items.length - 1];
        return Long.toHexString(sequence.incrementAndGet()).toLowerCase() + "." + extension.toLowerCase();
    }
}
