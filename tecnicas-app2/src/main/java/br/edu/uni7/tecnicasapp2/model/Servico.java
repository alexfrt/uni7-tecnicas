package br.edu.uni7.tecnicasapp2.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double custoMaoDeObra;

    @OneToMany
    private List<Peca> pecas;
    private Double precoTotal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCustoMaoDeObra() {
        return custoMaoDeObra;
    }

    public void setCustoMaoDeObra(Double custoMaoDeObra) {
        this.custoMaoDeObra = custoMaoDeObra;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
