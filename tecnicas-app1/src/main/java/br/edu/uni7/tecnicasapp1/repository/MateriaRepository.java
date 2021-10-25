package br.edu.uni7.tecnicasapp1.repository;


import br.edu.uni7.tecnicasapp1.model.Materia;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class MateriaRepository {

    private final List<Materia> materias;

    public MateriaRepository() {
        materias = new ArrayList<>();
    }

    public void create(Materia materia) {
        materias.add(materia);
    }

    public List<Materia> read() {
        return materias;
    }

    public void update(Integer id, Materia novaMateria) {
        for (int i = 0; i < materias.size(); i++) {
            if (Objects.equals(materias.get(i).getId(), id)) {
                materias.remove(i);
                materias.add(i, novaMateria);
                break;
            }
        }
    }

    public void delete(Integer id) {
        Materia toDelete = null;
        for (Materia materia : materias) {
            if (Objects.equals(id, materia.getId())) {
                toDelete = materia;
                break;
            }
        }

        if (toDelete != null) {
            materias.remove(toDelete);
        }
    }

    public Materia findById(Integer id) {
        for (Materia materia : materias) {
            if (Objects.equals(id, materia.getId())) {
                return materia;
            }
        }

        return null;
    }
}
