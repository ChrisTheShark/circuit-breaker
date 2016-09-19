package com.dyer.frameworks.repository;

import com.dyer.frameworks.domain.DataResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * {@link DataRepository} implementation returns in-memory result.
 */
@Repository("realDataRepository")
public class DataRepositoryImpl implements DataRepository {

    private Map<Integer, List<DataResult>> actualResults = new HashMap<Integer, List<DataResult>>() {{
        put(1, Arrays.asList(
                new DataResult("I eat my data with peanut butter."),
                new DataResult("Don't forget to water the dogs.")
        ));
        put(2, Arrays.asList(
                new DataResult("Sharks are friends not pets."),
                new DataResult("Nemo isn't lost I ate him.")
        ));
    }};

    @Async
    @Override
    public Future<List<DataResult>> findById(Integer identifier) {
        return new AsyncResult<>(actualResults.get(identifier));
    }

}
