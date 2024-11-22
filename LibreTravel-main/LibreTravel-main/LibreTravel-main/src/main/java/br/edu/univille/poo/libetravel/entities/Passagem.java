package br.edu.univille.poo.libetravel.entities;

// (valor do voo + valor do assento = valor total da passagem)

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidadePessoas;

    private Double valorTotal; // Valor do voo + valor dos assentos.

    @OneToOne
    @JoinTable(
            name = "passagem_voo",
            joinColumns = @JoinColumn(name = "passagem_id"),
            inverseJoinColumns = @JoinColumn(name = "voo_id")
    )
    private List<Voo> voos;

    @OneToOne
    private DadosPassageiros dadosPassageiros; // Dados de cada ocupante.
}
