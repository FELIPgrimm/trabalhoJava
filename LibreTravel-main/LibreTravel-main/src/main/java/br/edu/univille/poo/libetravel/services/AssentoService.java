package br.edu.univille.poo.libetravel.services;

import br.edu.univille.poo.libetravel.entities.Assento;
import br.edu.univille.poo.libetravel.repositories.AssentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssentoService {

    @Autowired
    private AssentoRepository repository;

    public List<Assento> listarAssentos() {
        return repository.findAll();
    }

    public Assento buscarAssentoPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Assento não encontrado"));
    }

    public Assento criarAssento(Assento assento) {
        return repository.save(assento);
    }

    public Assento atualizarAssento(Long id, Assento assento) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Assento não encontrado");
        }
        assento.setId(id);
        return repository.save(assento);
    }

    public void deletarAssento(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Assento não encontrado");
        }
        repository.deleteById(id);
    }
}