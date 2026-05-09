package app.repository;

import app.entity.Visitor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class VisitorRepository {

    private final List<Visitor> list = new ArrayList<>();

    public void save(Visitor visitor) {
        list.add(visitor);
    }

    public List<Visitor> findAll() {
        return list;
    }

    public Optional<Visitor> findById(Long id) {

        return list.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
    }

    public void deleteById(Long id) {

        list.removeIf(v -> v.getId().equals(id));
    }

    public void update(Visitor updatedVisitor) {

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getId().equals(updatedVisitor.getId())) {

                list.set(i, updatedVisitor);
                return;
            }
        }
    }
}