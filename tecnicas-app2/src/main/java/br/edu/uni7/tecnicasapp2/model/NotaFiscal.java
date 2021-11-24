package br.edu.uni7.tecnicasapp2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class NotaFiscal {

    @Id
    private String id;
    private Double valorTotal;
    private String cnpjEmitente;
    private String cpfDoCliente;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCnpjEmitente() {
        return cnpjEmitente;
    }

    public void setCnpjEmitente(String cnpjEmitente) {
        this.cnpjEmitente = cnpjEmitente;
    }

    public String getCpfDoCliente() {
        return cpfDoCliente;
    }

    public void setCpfDoCliente(String cpfDoCliente) {
        this.cpfDoCliente = cpfDoCliente;
    }
}
