package br.edu.uni7.tecnicasapp2.controller;

import br.edu.uni7.tecnicasapp2.model.Servico;
import br.edu.uni7.tecnicasapp2.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ServicoController {

    private final ServicoRepository repository;

    @Autowired
    public ServicoController(ServicoRepository repository) {
        this.repository = repository;
    }

    @ResponseBody
    @RequestMapping(value = "servico", method = RequestMethod.GET)
    public List<Servico> list() {
        return repository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "servico/{id}", method = RequestMethod.GET)
    public Servico findById(@PathVariable Integer id) {
        return repository.findById(id).get();
    }

    @ResponseBody
    @RequestMapping(value = "servico", method = RequestMethod.POST)
    public Servico create(@RequestBody Servico servico) {
        repository.save(servico);
        return servico;
    }

    @ResponseBody
    @RequestMapping(value = "servico/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Integer id, @RequestBody Servico servico) {
        repository.save(servico);
    }

    @ResponseBody
    @RequestMapping("servico/{id}")
    public void remove(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
