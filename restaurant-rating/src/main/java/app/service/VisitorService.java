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

    public void save(Visitor visitor) {
        repository.save(visitor);
    }

    public List<Visitor> findAll() {
        return repository.findAll();
    }

    public Visitor findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void update(Visitor visitor) {
        repository.update(visitor);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
