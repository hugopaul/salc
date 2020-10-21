package br.mil.eb.basecmp.salc.domain;

import br.mil.eb.basecmp.salc.domain.enums.EstadoAprovacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class AprovacaoRequisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "estado_requisicao")
    private Integer estate;

    @Column(name = "data_aprovacao")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEstadoAprovacao;

    @ManyToOne
    @JoinColumn(name = "id_requisicao")
    private Requisicao requisicao;

    public EstadoAprovacao getEstate() {
        return EstadoAprovacao.toEnum(estate);
    }

    public void setEstate(EstadoAprovacao estate) {
        this.estate = estate.getCod();
    }
    @PrePersist
    public void prePercist() {
        setDataEstadoAprovacao(LocalDate.now());
        setEstate(EstadoAprovacao.PENDENTE);
    }

    //FAZER TESTE DESTE PREPERCIST AO DEFINIR ESTADO DA REQUISIÇÃO
}
