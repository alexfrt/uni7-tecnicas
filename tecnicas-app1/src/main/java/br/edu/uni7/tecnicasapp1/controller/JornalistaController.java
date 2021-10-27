package br.edu.uni7.tecnicasapp1.controller;

import br.edu.uni7.tecnicasapp1.model.Jornalista;
import br.edu.uni7.tecnicasapp1.repository.JornalistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JornalistaController {

    private final JornalistaRepository repository;

    @Autowired
    public JornalistaController(JornalistaRepository repository) {
        this.repository = repository;
    }

    @ResponseBody
    @RequestMapping(value = "jornalista", method = RequestMethod.GET)
    public List<Jornalista> list() {
        return repository.list();
    }

    @ResponseBody
    @RequestMapping(value = "jornalista/{id}", method = RequestMethod.GET)
    public Jornalista findById(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "jornalista/{id}", method = RequestMethod.PUT)
    public Jornalista update(Integer id, Jornalista jornalista) {
        return repository.update(id, jornalista);
    }

    @ResponseBody
    @RequestMapping(value = "jornalista", method = RequestMethod.POST)
    public Jornalista create(Jornalista jornalista) {
        return repository.create(jornalista);
    }

    @ResponseBody
    @RequestMapping(value = "jornalista/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        repository.delete(id);
    }

}

