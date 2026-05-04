package app.service;

import app.entity.Visitor;
import app.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorService {

    private final VisitorRepository repository;

    public void save(Visitor v) {
        repository.save(v);
    }

    public void remove(Visitor v) {
        repository.remove(v);
    }

    public List<Visitor> findAll() {
        return repository.findAll();
    }
}
