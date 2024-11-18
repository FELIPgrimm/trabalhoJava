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
public class Aeronave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "aeronave", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Assento> assentos;

    @ManyToMany(mappedBy = "aeronaves")
    private List<Aeroporto> aeroportos;

}