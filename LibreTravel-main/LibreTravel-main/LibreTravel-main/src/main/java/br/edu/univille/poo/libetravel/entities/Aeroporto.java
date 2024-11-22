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
public class Aeroporto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cidade;
    private String estado;
    private String pais;

    @ManyToMany
    @JoinTable(
            name = "aeroporto_aeronave",
            joinColumns = @JoinColumn(name = "aeroporto_id"),
            inverseJoinColumns = @JoinColumn(name = "aeronave_id")
    )
    private List<Aeronave> aeronaves;
}
