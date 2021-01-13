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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id", "id_aprovacao_requisicao", "numero_empenho"}))
public class Empenho{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_registro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy" )
    private LocalDate dataRegEmpenho;

    @PrePersist
    public void prePercist() {
        setDataRegEmpenho(LocalDate.now());
    }

    @Column(name = "numero_empenho", nullable = false)
    @NotEmpty(message = "O NÚMERO do Empenho é obrigatório!")
    private String numEmpenho;

    @Column(name = "data_empenho")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "A DATA em que o Empenho foi cadastrado é Obrigatório")
    private LocalDate dataEmpenho;

    @Column(name="valor_empenho")
    @NotNull(message = "O VALOR do Empenho é obrigatório")
    private Double valorEmp;

    @Column(name = "nd")
    private Integer nd;

    @NaturalId
    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_aprovacao_requisicao")
    @NotNull(message = "SELECIONE a Requisição Aprovada para cadastrar o Empenho!")
    @JsonFormat
    private AprovacaoRequisicao aprovacao;


}
