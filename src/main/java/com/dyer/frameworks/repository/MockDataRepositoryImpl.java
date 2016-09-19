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
 * Mock {@link DataRepository} implementation returns in-memory result.
 */
@Repository("mockDataRepository")
public class MockDataRepositoryImpl implements DataRepository {

    private Map<Integer, List<DataResult>> mockResults = new HashMap<Integer, List<DataResult>>() {{
        put(3, Arrays.asList(
                new DataResult("I eat my data with cheese."),
                new DataResult("Don't forget to water the cats.")
        ));
        put(4, Arrays.asList(
                new DataResult("Sharks are enemies not pets."),
                new DataResult("Nemo isn't lost I saved him.")
        ));
    }};

    @Async
    @Override
    public Future<List<DataResult>> findById(Integer identifier) {
        return new AsyncResult<>(mockResults.get(identifier));
    }

}
