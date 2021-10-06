package br.edu.uni7.tecnicasapp1.controller;

import br.edu.uni7.tecnicasapp1.model.Materia;
import br.edu.uni7.tecnicasapp1.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "criarMateria", method = RequestMethod.POST)
    public ModelAndView criarNovaMateria(@RequestParam String titulo, @RequestParam String autor, @RequestParam String conteudo) {
        Materia materia = new Materia(titulo, autor, conteudo, new Date());
        materiaRepository.create(materia);

        ModelAndView modelAndView = new ModelAndView("materia");
        modelAndView.addObject("materias", materiaRepository.read());

        return modelAndView;
    }

}
