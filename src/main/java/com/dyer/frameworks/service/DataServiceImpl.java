package com.dyer.frameworks.service;

import com.dyer.frameworks.annotation.ProtectedCircuit;
import com.dyer.frameworks.domain.DataResult;
import com.dyer.frameworks.exception.ServiceUnavailableException;
import com.dyer.frameworks.exception.TrippedBreakerException;
import com.dyer.frameworks.repository.DataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Simple {@link DataService} implementation returns a predictable
 * result.
 */
@Service
public class DataServiceImpl implements DataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataService.class);
    private static final String LOG_MESSAGE = "Unable to access data due to: %s";

    @Autowired
    @Qualifier("realDataRepository")
    private DataRepository dataRepository;

    @Autowired
    @Qualifier("mockDataRepository")
    private DataRepository mockDataRepository;

    @Override
    public List<DataResult> getDataById(Integer identifier) {
        List<DataResult> results = null;

        try {
            results = dataRepository.findById(identifier).get();
            if (results == null || results.size() == 0) {
                /*
                 * Throwing an exception to blatantly trigger the pattern.
                 */
                throw new TrippedBreakerException("Breaker Tripped!");
            }
        } catch (InterruptedException | ExecutionException exception) {
            LOGGER.error(String.format(LOG_MESSAGE, exception.getClass()), exception);
        }

        return results;
    }

    @Override
    public List<DataResult> getMockDataById(Integer identifier) {
        List<DataResult> results = null;

        try {
            results = mockDataRepository.findById(identifier).get();
            if (results == null || results.size() == 0) {
                throw new ServiceUnavailableException("Service unavailable.");
            }
        } catch (InterruptedException | ExecutionException exception) {
            LOGGER.error(String.format(LOG_MESSAGE, exception.getClass()), exception);
        }

        return results;
    }

}