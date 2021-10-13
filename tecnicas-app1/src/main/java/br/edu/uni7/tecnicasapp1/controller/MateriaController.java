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

    @RequestMapping("materia")
    public ModelAndView listarMaterias() {
        ModelAndView modelAndView = new ModelAndView("materia");
        List<Materia> materias = materiaRepository.read();
        modelAndView.addObject("materias", materias);

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "criarMateria", method = RequestMethod.POST)
    public Materia criarNovaMateria(@RequestBody Materia materia) {
        materia.setData(new Date());
        materiaRepository.create(materia);

        return materia;
    }

}
