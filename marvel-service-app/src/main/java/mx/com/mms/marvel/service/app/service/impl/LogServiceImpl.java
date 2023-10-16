package mx.com.mms.marvel.service.app.service.impl;

import mx.com.mms.marvel.service.app.exceptions.InternalException;
import mx.com.mms.marvel.service.app.exceptions.ResourceNotFoundException;
import mx.com.mms.marvel.service.app.models.entities.Log;
import mx.com.mms.marvel.service.app.repositories.LogRepository;
import mx.com.mms.marvel.service.app.service.ILogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LogServiceImpl implements ILogService {

    private final LogRepository repository;

    public LogServiceImpl(LogRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Log> getLogs() {
        try {
            List<Log> logs = repository.findAll();
            if (logs.isEmpty()) throw new ResourceNotFoundException("No logs found");
            return logs;
        } catch (Exception ex) {
            throw new InternalException("Error while getting logs");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Log getLog(String id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No log: " + id + " not found"));
    }

    @Override
    public Log createLog(Log log) {
        Log newLog = repository.save(log);
        return newLog;
    }
}
