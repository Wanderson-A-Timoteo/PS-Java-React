package br.com.banco.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_conta")
    private Long idConta;

    @Column(name = "nome_responsavel")
    private String nomeResponsavel;

    @OneToMany(mappedBy = "conta")
    private List<Transferencia> transferencias;
}
