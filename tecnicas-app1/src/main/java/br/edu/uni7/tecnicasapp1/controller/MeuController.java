package br.edu.uni7.tecnicasapp1.controller;

import br.edu.uni7.tecnicasapp1.model.Materia;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MeuController {

    @RequestMapping("/materia")
    public String materia(Model model) {
        List<Materia> materias = new ArrayList<>();
        materias.add(new Materia("Titulo 1", "o rato roeu 1"));
        materias.add(new Materia("Titulo 2", "o rato roeu 2"));
        materias.add(new Materia("Titulo 3", "o rato roeu 3"));
        materias.add(new Materia("Titulo 4", "o rato roeu 4"));

        model.addAttribute("materias", materias);
        return "materia";
    }

}
