package br.edu.univille.poo.libetravel.entities;

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
    private Double valorTotal;

    @ManyToMany
    @JoinTable(
            name = "passagem_voo",
            joinColumns = @JoinColumn(name = "passagem_id"),
            inverseJoinColumns = @JoinColumn(name = "voo_id")
    )
    private List<Voo> voos;

    @ElementCollection
    @CollectionTable(name = "dados_passageiros", joinColumns = @JoinColumn(name = "passagem_id"))
    private List<DadosPassageiros> dadosPassageiros;
}