package br.edu.univille.poo.libetravel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificador;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "aeronave_id")
    private Aeronave aeronave;

    public static List<Assento> gerarAssentos(Aeronave aeronave, double precoJanela, double precoMeio, double precoCorredor) {
        List<Assento> assentos = new ArrayList<>();
        String[] fileiras = {"A", "B", "C", "E", "F", "G"};

        for (String fileira : fileiras) {
            for (int i = 1; i <= 10; i++) {
                String identificador = fileira + String.format("%02d", i); // Esperado: A01, B10
                double preco;

                if (fileira.equals("A") || fileira.equals("G")) {
                    preco = precoJanela;
                } else if (fileira.equals("B") || fileira.equals("F")) {
                    preco = precoMeio;
                } else {
                    preco = precoCorredor;
                }

                Assento assento = new Assento();
                assento.setIdentificador(identificador);
                assento.setPreco(preco);
                assento.setAeronave(aeronave);

                assentos.add(assento);
            }
        }

        return assentos;
    }
}
