package za.ac.cput.repository;

import za.ac.cput.domain.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectRepository implements ISubjectRepository {
    private static SubjectRepository repository = null;
    private final List<Subject> subjects;

    public static SubjectRepository getRepository() {
        if (repository == null) repository = new SubjectRepository();
        return repository;
    }

    //constructor
    private SubjectRepository() {
        this.subjects = new ArrayList<>();
    }

    @Override
    public List<Subject> getAll() {
        return List.of();
    }

    @Override
    public Subject create(Subject subject) {
        if (subject != null) {

            if (subjects.contains(subject)) {
                return null;
            } else {
                subjects.add(subject);
                return subject;
            }
        }
        return null;
    }

    @Override
    public Subject read(Integer id) {
        if (subjects.contains(id)) {
            return subjects.get(id);
        }
        return null;

    }

    @Override
    public Subject update(Subject subject) {
        if (subjects.contains(subject)) {
            subjects.set(subjects.indexOf(subject), subject);
            return subject;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        if (subjects.contains(id)) {
            subjects.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deactivate(Integer integer) {
        // TODO implement

        return false;
    }
}
