package com.dyer.frameworks.domain;

import java.util.Date;

/**
 * Simple domain object to represent a {@code DataResult}.
 */
public final class DataResult {

    private final String result;

    private final Date resultCreationDate;

    public DataResult(String result) {
        this.result = result;
        this.resultCreationDate = new Date();
    }

    public String getResult() {
        return result;
    }

    public Date getResultCreationDate() {
        return resultCreationDate;
    }

}
