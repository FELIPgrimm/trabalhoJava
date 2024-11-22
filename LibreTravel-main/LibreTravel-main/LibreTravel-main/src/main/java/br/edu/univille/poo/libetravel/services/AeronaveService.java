package br.edu.univille.poo.libetravel.services;

import br.edu.univille.poo.libetravel.entities.Aeronave;
import br.edu.univille.poo.libetravel.entities.Assento;
import br.edu.univille.poo.libetravel.repositories.AeronaveRepository;
import br.edu.univille.poo.libetravel.repositories.AssentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AeronaveService {

    @Autowired
    private AeronaveRepository repository;

    @Autowired
    private AssentoRepository assentoRepository;

    public List<Aeronave> listarAeronaves() {
        return repository.findAll();
    }

    public Aeronave buscarAeronavePorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Aeronave não encontrada"));
    }

    public Aeronave criarAeronave(Aeronave aeronave) {
        Aeronave novaAeronave = repository.save(aeronave);

        double precoJanela = 300.00;
        double precoMeio = 150.00;
        double precoCorredor = 200.00;

        List<Assento> assentos = gerarAssentos(novaAeronave, precoJanela, precoMeio, precoCorredor);

        assentoRepository.saveAll(assentos);

        return novaAeronave;
    }

    public Aeronave atualizarAeronave(Long id, Aeronave aeronave) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Aeronave não encontrada");
        }
        aeronave.setId(id);
        return repository.save(aeronave);
    }

    public void deletarAeronave(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Aeronave não encontrada");
        }
        repository.deleteById(id);
    }

    private List<Assento> gerarAssentos(Aeronave aeronave, double precoJanela, double precoMeio, double precoCorredor) {
        List<Assento> assentos = new ArrayList<>();
        String[] letrasEsquerda = {"A", "B", "C"};
        String[] letrasDireita = {"E", "F", "G"};

        for (int i = 1; i <= 10; i++) {
            String numero = String.format("%02d", i);

            for (String letra : letrasEsquerda) {
                double preco = getPreco(letra, precoJanela, precoMeio, precoCorredor);
                assentos.add(new Assento(null, letra + numero, preco, aeronave));
            }

            for (String letra : letrasDireita) {
                double preco = getPreco(letra, precoJanela, precoMeio, precoCorredor);
                assentos.add(new Assento(null, letra + numero, preco, aeronave));
            }
        }
        return assentos;
    }

    private double getPreco(String letra, double precoJanela, double precoMeio, double precoCorredor) {
        if ("A".equals(letra) || "G".equals(letra)) {
            return precoJanela;
        } else if ("B".equals(letra) || "F".equals(letra)) {
            return precoMeio;
        } else {
            return precoCorredor;
        }
    }
}
