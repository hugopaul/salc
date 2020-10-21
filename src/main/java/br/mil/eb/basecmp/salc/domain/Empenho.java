package br.mil.eb.basecmp.salc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Empenho{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_empenho", nullable = false)
    @NotEmpty(message = "O número do Empenho é obrigatório!")
    private String numEmpenho;

    @Column(name = "data_empenho")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataEmpenho;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_aprovacao")
    private AprovacaoRequisicao aprovacao;

    @Column(name = "data_registro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataRegEmpenho;


    @PrePersist
    public void prePercist() {
        setDataRegEmpenho(LocalDate.now());
    }

}
