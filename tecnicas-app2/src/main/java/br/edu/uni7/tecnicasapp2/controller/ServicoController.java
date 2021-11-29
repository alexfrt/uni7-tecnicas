package br.edu.uni7.tecnicasapp2.controller;

import br.edu.uni7.tecnicasapp2.model.Servico;
import br.edu.uni7.tecnicasapp2.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ServicoController {

    private final ServicoService service;

    @Autowired
    public ServicoController(ServicoService service) {
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "servico", method = RequestMethod.GET)
    public List<Servico> list() {
        return service.list();
    }

    @ResponseBody
    @RequestMapping(value = "servico/{id}", method = RequestMethod.GET)
    public Servico findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "servico", method = RequestMethod.POST)
    public Servico create(@RequestBody Servico servico) {
        return service.create(servico);
    }

    @ResponseBody
    @RequestMapping(value = "servico/{id}", method = RequestMethod.PUT)
    public Servico update(@PathVariable Integer id, @RequestBody Servico servico) {
        return service.update(servico);
    }

    @ResponseBody
    @RequestMapping("servico/{id}")
    public void remove(@PathVariable Integer id) {
        service.remove(id);
    }

}
