package br.com.banco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_conta")
    private Long idConta;

    @Column(name = "nome_responsavel")
    private String nomeResponsavel;

    @JsonIgnore
    @OneToMany(mappedBy = "conta")
    private List<Transferencia> transferencias;
}
