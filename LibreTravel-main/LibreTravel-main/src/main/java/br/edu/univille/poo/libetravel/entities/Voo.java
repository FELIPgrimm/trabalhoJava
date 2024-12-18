package br.edu.univille.poo.libetravel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "aeronave_id")
    private Aeronave aeronave;

    @ManyToOne
    @JoinColumn(name = "aeroporto_embarque_id")
    private Aeroporto aeroportoEmbarque;

    @ManyToOne
    @JoinColumn(name = "aeroporto_desembarque_id")
    private Aeroporto aeroportoDesembarque;
}