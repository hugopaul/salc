package br.mil.eb.basecmp.salc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@Entity
public class Requisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty(message="O Documento de de origem da requisição é obrigatório!")
    private String documento;

    @Column(nullable = false)
    @NotEmpty(message="O Título da requisição é Obrigatório!")
    private String titulo;

    @Column(nullable = false)
    @NotEmpty(message="A Descrição da Requisição é Obrigatório!")
    private String descricao;

    @Column(name = "data_requisicao")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataRequisicao;

}
