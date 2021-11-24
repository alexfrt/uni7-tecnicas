package br.edu.uni7.tecnicasapp2.repository;

import br.edu.uni7.tecnicasapp2.model.NotaFiscal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaFiscalRepository extends MongoRepository<NotaFiscal, String> {

    List<NotaFiscal> findAllByCnpjEmitente(String cnpj);

    List<NotaFiscal> findAllByCpfDoCliente(String cpf);

}
