package com.dyer.frameworks.repository;

import com.dyer.frameworks.domain.DataResult;

import java.util.List;
import java.util.concurrent.Future;

/**
 * Simple repository class to hand data back from a store.
 */
public interface DataRepository {

    Future<List<DataResult>> findById(Integer identifier);

}