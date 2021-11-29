package br.edu.uni7.tecnicasapp2.service;

import br.edu.uni7.tecnicasapp2.exception.EstoqueInsuficienteException;
import br.edu.uni7.tecnicasapp2.model.Peca;
import br.edu.uni7.tecnicasapp2.model.Servico;
import br.edu.uni7.tecnicasapp2.repository.PecaRepository;
import br.edu.uni7.tecnicasapp2.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;
    private final PecaRepository pecaRepository;

    @Autowired
    public ServicoService(ServicoRepository servicoRepository, PecaRepository pecaRepository) {
        this.servicoRepository = servicoRepository;
        this.pecaRepository = pecaRepository;
    }

    public List<Servico> list() {
        return servicoRepository.findAll();
    }

    public Servico findById(Integer id) {
        return servicoRepository.findById(id).get();
    }

    public Servico create(Servico servico) {
        List<Peca> pecas = servico.getPecas();
        if (pecas != null) {
            for (Peca peca : pecas) {
                //verificar se essa peca tem qtd > 1 no estoque
                Peca pecaDoDB = pecaRepository.findById(peca.getId()).get();
                if (pecaDoDB.getQuantidade() == 0) {
                    throw new EstoqueInsuficienteException();
                }
            }
        }

        return servicoRepository.save(servico);
    }

    public Servico update(Servico servico) {
        return servicoRepository.save(servico);
    }

    public void remove(Integer id) {
        servicoRepository.deleteById(id);
    }

}
