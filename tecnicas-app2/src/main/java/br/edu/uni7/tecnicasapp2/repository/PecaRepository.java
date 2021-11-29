package br.edu.uni7.tecnicasapp2.repository;

import br.edu.uni7.tecnicasapp2.model.Peca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Integer> {

    List<Peca> findAllByFabricante(String fabricante);

}
