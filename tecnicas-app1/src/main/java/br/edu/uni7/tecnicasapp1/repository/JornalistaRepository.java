package br.edu.uni7.tecnicasapp1.repository;

import br.edu.uni7.tecnicasapp1.model.Jornalista;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JornalistaRepository {

    private static Integer contador = 1;
    private final Map<Integer, Jornalista> jornalistaMap;

    public JornalistaRepository() {
        jornalistaMap = new HashMap<>();
    }

    public List<Jornalista> list() {
        return new ArrayList<>(jornalistaMap.values());
    }

    public Jornalista findById(Integer id) {
        return jornalistaMap.get(id);
    }

    public Jornalista update(Integer id, Jornalista jornalista) {
        if (!jornalistaMap.containsKey(id)) {
            throw new IllegalArgumentException("jornalista inexistente");
        }

        jornalistaMap.put(id, jornalista);
        return jornalista;
    }

    public Jornalista create(Jornalista jornalista) {
        int id = contador;
        contador++;

        jornalistaMap.put(id, jornalista);
        jornalista.setId(id);

        return jornalista;
    }

    public void delete(Integer id) {
        jornalistaMap.remove(id);
    }
}
