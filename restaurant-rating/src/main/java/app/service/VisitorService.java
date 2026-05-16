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

    public List<Visitor> findAll() {
        return repository.findAll();
    }

    public Visitor findById(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    public Visitor save(Visitor visitor) {
        return repository.save(visitor);
    }

    public Visitor update(Long id, Visitor updated) {

        Visitor visitor = findById(id);

        visitor.setName(updated.getName());
        visitor.setAge(updated.getAge());
        visitor.setGender(updated.getGender());

        return repository.save(visitor);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
