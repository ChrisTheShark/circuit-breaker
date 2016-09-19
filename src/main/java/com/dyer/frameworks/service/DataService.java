package com.dyer.frameworks.service;

import com.dyer.frameworks.annotation.ProtectedCircuit;
import com.dyer.frameworks.domain.DataResult;

import java.util.List;

/**
 * Simple interface to represent some data provider.
 */
public interface DataService {

    /**
     * Get data from some provider by identifier.
     *
     * @param identifier the {@link Integer} identifier
     * @return a {@link List} containing one to many {@link DataResult}s.
     */
    @ProtectedCircuit(failOverMethod = "getMockDataById")
    List<DataResult> getDataById(Integer identifier);

    /**
     * Get data from some mock provider by identifier.
     *
     * @param identifier the {@link Integer} identifier
     * @return a {@link List} containing one to many {@link DataResult}s.
     */
    List<DataResult> getMockDataById(Integer identifier);

}