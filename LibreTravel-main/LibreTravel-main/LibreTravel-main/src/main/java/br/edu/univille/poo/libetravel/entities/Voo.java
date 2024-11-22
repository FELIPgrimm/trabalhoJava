package br.edu.univille.poo.libetravel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companhiaAerea;

    private String data;
    private String hora;

    @ManyToOne
    @JoinColumn(name = "aeronave_id")
    private Aeronave aeronave;

    @ManyToOne
    @JoinColumn(name = "aeroporto_embarque_id")
    private Aeroporto aeroportoEmbarque;

    @ManyToOne
    @JoinColumn(name = "aeroporto_desembarque_id")
    private Aeroporto aeroportoDesembarque;

    private Double valor; // Valor base do voo.
}
