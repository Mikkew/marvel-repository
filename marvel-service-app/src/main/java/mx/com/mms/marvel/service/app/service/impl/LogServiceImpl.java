package mx.com.mms.marvel.service.app.service.impl;

import lombok.extern.slf4j.Slf4j;
import mx.com.mms.marvel.service.app.exceptions.InternalException;
import mx.com.mms.marvel.service.app.exceptions.ResourceNotFoundException;
import mx.com.mms.marvel.service.app.models.entities.Log;
import mx.com.mms.marvel.service.app.repositories.LogRepository;
import mx.com.mms.marvel.service.app.service.ILogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class LogServiceImpl implements ILogService {

    private final LogRepository repository;

    public LogServiceImpl(LogRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Log> getLogs() {
        LOGGER.info("Starting service LogService for getLogs");
        List<Log> logs = null;

        try {
            logs = repository.findAll();
            if (logs.isEmpty()) throw new ResourceNotFoundException("No logs found");
        } catch (Exception ex) {
            throw new InternalException("Error while getting logs");
        }
        LOGGER.info("Ending service LogService for getLogs");
        return logs;
    }

    @Override
    @Transactional(readOnly = true)
    public Log getLog(String id) {
        LOGGER.info("Starting service LogService for getLogById");
        final Log log = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No log: " + id + " not found"));
        LOGGER.info("Ending service LogService for getLogById");
        return log;
    }

    @Override
    public Log createLog(Log log) {
        LOGGER.info("Starting service LogService for Save Log");
        final Log newLog = repository.save(log);
        LOGGER.info("Ending service LogService for Save Log");
        return newLog;
    }
}
