package br.mil.eb.basecmp.salc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Requisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_requisite", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataRequisite;

    @Column(nullable = false)
    @NotEmpty(message = "O Documento de de origem da requisição é obrigatório!")
    private String doc;

    @Column(name = "data_doc", nullable = false)
    @NotNull(message = "A Data do documento é Obrigatório")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDoc;

    @Column(nullable = false)
    @NotNull(message = "Selecione a SEÇÃO Solicitante")
    private Integer secao;

    @Column(nullable = false)
    @NotNull(message = "O VALOR não pode está vazio!")
    private Double valor;

    @Column(nullable = false)
    @NotEmpty(message = "O Título da requisição é Obrigatório!")
    private String titulo;

    @Column(nullable = false)
    @NotEmpty(message = "A Descrição da Requisição é Obrigatório!")
    private String descricao;

    @Column(name = "nd")
    private Integer nd;

    public Integer getSecao() {
        return secao;
    }

    @PrePersist
    public void prePercist() {
        setDataRequisite(LocalDate.now());
    }

}


