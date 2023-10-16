package mx.com.mms.marvel.service.app.service;

import mx.com.mms.marvel.service.app.models.entities.Log;

import java.util.List;

public interface ILogService {

    List<Log> getLogs();

    Log getLog(String id);

    Log createLog(Log log);



}
