package br.edu.uni7.tecnicasapp1.controller;

import br.edu.uni7.tecnicasapp1.model.Materia;
import br.edu.uni7.tecnicasapp1.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class MateriaController {

    private final MateriaRepository materiaRepository;

    @Autowired
    public MateriaController(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    @ResponseBody
    @RequestMapping(value = "materia/{id}", method = RequestMethod.GET)
    public Materia encontrarMateria(@PathVariable Integer id) {
        return materiaRepository.findById(id);
    }

    @ResponseBody
    @RequestMapping(value = "materia", method = RequestMethod.GET)
    public List<Materia> listarMaterias() {
        return materiaRepository.read();
    }

    @ResponseBody
    @RequestMapping(value = "materia", method = RequestMethod.POST)
    public Materia criarMateria(@RequestBody Materia materia) {
        materia.setData(new Date());
        materiaRepository.create(materia);

        return materia;
    }

    @ResponseBody
    @RequestMapping(value = "materia/{id}", method = RequestMethod.DELETE)
    public void apagarMateria(@PathVariable Integer id) {
        materiaRepository.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "materia/{id}", method = RequestMethod.PUT)
    public void atualizarMateria(@PathVariable Integer id, @RequestBody Materia materia) {
        materiaRepository.update(id, materia);
    }

}
