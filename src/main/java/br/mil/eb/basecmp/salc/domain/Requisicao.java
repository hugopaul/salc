package br.mil.eb.basecmp.salc.domain;

import br.mil.eb.basecmp.salc.domain.enums.EstadoAprovacao;
import br.mil.eb.basecmp.salc.domain.enums.SecaoSolicitante;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Requisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "O Documento de de origem da requisição é obrigatório!")
    @NotEmpty(message = "O Documento de de origem da requisição é obrigatório!")
    private String doc;

    @Column(name = "data_doc")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDoc;

    @Column(nullable = false)
    @NotEmpty(message = "O valor não pode está vazio")
    private Double valor;

    @Column(nullable = false)
    @NotEmpty(message = "O Título da requisição é Obrigatório!")
    private String titulo;

    @Column(nullable = false)
    @NotEmpty(message = "A Descrição da Requisição é Obrigatório!")
    private String descricao;

    @Column(nullable = false)
    @NotEmpty(message = "Selecione a SEÇÃO Solicitante")
    private Integer secao;

    @Column(name = "data_requisite", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataRequisite;

    public SecaoSolicitante getSecao() {
        return SecaoSolicitante.toEnum(secao);
    }
    public void setSecao(SecaoSolicitante estate) {
        this.secao = estate.getCod();
    }


    @PrePersist
    public void prePercist() {
        setDataRequisite(LocalDate.now());
    }

}


