package edu.miu.cs.cs544.a202001.wind.service;

import edu.miu.cs.cs544.a202001.wind.domain.Session;
import edu.miu.cs.cs544.a202001.wind.repository.ISessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements ISessionService {

    private ISessionRepository sessionRepository;

    public SessionServiceImpl(ISessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public SessionServiceImpl() {
    }

    @Autowired
    public void setSessionRepository(ISessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void addSession(Session session) {
        sessionRepository.save(session);
    }

    @Override
    public Session getSessionById(Long id) {
        return sessionRepository.findById(id).get();
    }

    @Override
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    @Override
    public void updateSession(Session session) {
        sessionRepository.save(session);
    }

    @Override
    public void deleteSession(Session session) {
        sessionRepository.delete(session);
    }
}
