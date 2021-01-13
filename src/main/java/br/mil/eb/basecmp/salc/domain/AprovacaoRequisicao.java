package br.mil.eb.basecmp.salc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id", "id_requisicao"}))
public class AprovacaoRequisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_registro", updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataRegistro;


    @PrePersist
    public void prePercist() {
        setDataRegistro(LocalDate.now());
    }


    @Column(name = "estado_requisicao")
    @NotNull(message = "O Estado da Requisição deve ser escolhido")
    private Integer estate;

    @Column(name = "data_aprovacao", updatable = false)
    @NotNull(message = "A data em que o OD aprovou a Requisição é Obrigatório")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataEstadoAprovacao;

    @NaturalId
    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_requisicao")
    @NotNull(message = "Escolha a Requisição para avaliar")
    @JsonFormat
    private Requisicao requisicao;




}
