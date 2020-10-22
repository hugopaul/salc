package br.mil.eb.basecmp.salc.domain;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_empenho")
    private Empenho empenho;

    @Column(nullable = false)
    @NotEmpty(message = "O NOME ou Razão Social do Fornecedor é obrigatório!")
    private String razao;

    @Column(name = "data_ctt_fornecedor")
    private LocalDate dataConttFornecedor;

    @Column(nullable = false)
    @NotEmpty(message = "Digite o PRAZO para o fornecedor entregar")
    private Integer prazoEntrega;

    @Column(name = "data_entrega", updatable = false)
    private Date dataEntrega;

    @PrePersist
    public void prePercist() {
        setDataConttFornecedor(LocalDate.now());
    }


}
