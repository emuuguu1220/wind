package edu.miu.cs.cs544.a202001.wind.service;

import edu.miu.cs.cs544.a202001.wind.domain.Session;

import java.util.List;

public interface ISessionService {
    public abstract void addSession(Session session);
    public abstract Session getSessionById(Long id);
    public abstract List<Session> getAllSessions();
    public abstract void updateSession(Session session);
    public abstract void deleteSession(Session session);
}
