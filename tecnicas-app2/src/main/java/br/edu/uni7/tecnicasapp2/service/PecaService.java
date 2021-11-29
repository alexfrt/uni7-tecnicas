package br.edu.uni7.tecnicasapp2.service;

import br.edu.uni7.tecnicasapp2.model.NotaFiscal;
import br.edu.uni7.tecnicasapp2.model.Peca;
import br.edu.uni7.tecnicasapp2.repository.NotaFiscalRepository;
import br.edu.uni7.tecnicasapp2.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PecaService {

    private final PecaRepository pecaRepository;
    private final NotaFiscalRepository notaFiscalRepository;

    @Autowired
    public PecaService(PecaRepository pecaRepository, NotaFiscalRepository notaFiscalRepository) {
        this.pecaRepository = pecaRepository;
        this.notaFiscalRepository = notaFiscalRepository;
    }

    public List<Peca> list() {
        return pecaRepository.findAll();
    }

    public Peca findById(Integer id) {
        return pecaRepository.findById(id).get();
    }

    public Peca create(Peca peca) {
        pecaRepository.save(peca);

        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setCnpjEmitente("cnpj 918273921/00");
        notaFiscal.setCpfDoCliente("2938.321.312-12");
        notaFiscalRepository.save(notaFiscal);

        return peca;
    }

    public Peca update(Peca peca) {
        pecaRepository.save(peca);
        return peca;
    }

    public void remove(Integer id) {
        pecaRepository.deleteById(id);
    }

    public List<Peca> findByFabricante(String fabricante) {
        return pecaRepository.findAllByFabricante(fabricante);
    }
}
