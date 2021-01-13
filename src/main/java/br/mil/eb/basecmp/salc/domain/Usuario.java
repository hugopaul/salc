package br.mil.eb.basecmp.salc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "login")
    @NotEmpty(message = "O campo Login é obrigatório")
    private String username;

    @Column(name = "senha")
    @NotEmpty(message = "O campo Senha é obrigatório")
    private String password;
}
