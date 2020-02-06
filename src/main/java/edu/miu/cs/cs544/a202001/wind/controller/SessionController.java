package edu.miu.cs.cs544.a202001.wind.controller;
import edu.miu.cs.cs544.a202001.wind.domain.Session;
import edu.miu.cs.cs544.a202001.wind.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    private ISessionService sessionService;

    @GetMapping(value = "/")
    public List<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @GetMapping(value = "/{id}")
    public Session getSession(@PathVariable Long id) {
        return sessionService.getSessionById(id);
    }


    @PostMapping(value = "/add")
    public void addSession(@RequestBody Session session){
        sessionService.addSession(session);
    }

    @PutMapping(value = "/update")
    public void updateSession(@RequestBody Session session) {
        sessionService.updateSession(session);
    }

    @DeleteMapping(value = "/delete")
    public void deleteSession(@RequestBody Session session) {
        sessionService.deleteSession(session);
    }


    public SessionController() {
    }

    public ISessionService getSessionService() {
        return sessionService;
    }
    @Autowired
    public void setSessionService(ISessionService sessionService) {
        this.sessionService = sessionService;
    }
}
