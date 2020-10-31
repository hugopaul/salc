package br.mil.eb.basecmp.salc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_registro", updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd" )
    private LocalDate dataRegistro;

    @PrePersist
    public void prePercist() {
        setDataRegistro(LocalDate.now());
    }

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_empenho")
    @NotNull(message = "SELECIONE O EMPENHO para cadastrar o contato com o Fornecedor")
    private Empenho empenho;

    @Column(nullable = false)
    @NotEmpty(message = "O NOME ou RAZÃO SOCIAL do Fornecedor é obrigatório!")
    private String razao;

    @Column(name = "data_ctt_fornecedor")
    @NotNull(message = "Coloque a DATA E HORA em que o fornecedor foi contatado!")
    private LocalDateTime dataConttFornecedor;

    @Column(nullable = false)
    @NotNull(message = "Digite o PRAZO para o fornecedor entregar")
    private Integer prazoEntrega;

    @Column(name = "data_entrega", updatable = false)
    private LocalDateTime dataEntrega;

}
