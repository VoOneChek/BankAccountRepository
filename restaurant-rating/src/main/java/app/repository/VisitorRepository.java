package app.repository;

import app.entity.Visitor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class VisitorRepository {

    private final List<Visitor> list = new ArrayList<>();

    public void save(Visitor v) {
        list.add(v);
    }

    public void remove(Visitor v) {
        list.remove(v);
    }

    public List<Visitor> findAll() {
        return list;
    }
}
