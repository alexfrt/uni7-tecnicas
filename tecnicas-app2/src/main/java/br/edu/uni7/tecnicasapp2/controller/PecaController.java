package br.edu.uni7.tecnicasapp2.controller;

import br.edu.uni7.tecnicasapp2.model.Peca;
import br.edu.uni7.tecnicasapp2.service.PecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PecaController {

    private final PecaService service;

    @Autowired
    public PecaController(PecaService service) {
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "peca", method = RequestMethod.GET)
    public List<Peca> list() {
        return service.list();
    }

    @ResponseBody
    @RequestMapping(value = "peca/{id}", method = RequestMethod.GET)
    public Peca findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "peca/fabricante/{fabricante}", method = RequestMethod.GET)
    public List<Peca> findById(@PathVariable String fabricante) {
        return service.findByFabricante(fabricante);
    }

    @ResponseBody
    @RequestMapping(value = "peca", method = RequestMethod.POST)
    public Peca create(@RequestBody Peca peca) {
        return service.create(peca);
    }

    @ResponseBody
    @RequestMapping(value = "peca/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Integer id, @RequestBody Peca peca) {
        service.update(peca);
    }

    @ResponseBody
    @RequestMapping("peca/{id}")
    public void remove(@PathVariable Integer id) {
        service.remove(id);
    }

}
