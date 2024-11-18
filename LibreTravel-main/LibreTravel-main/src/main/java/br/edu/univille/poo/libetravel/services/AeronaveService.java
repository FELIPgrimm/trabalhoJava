package br.edu.univille.poo.libetravel.services;

import br.edu.univille.poo.libetravel.entities.Aeronave;
import br.edu.univille.poo.libetravel.repositories.AeronaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeronaveService {

    @Autowired
    private AeronaveRepository repository;

    public List<Aeronave> listarAeronaves() {
        return repository.findAll();
    }

    public Aeronave buscarAeronavePorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Aeronave não encontrada"));
    }

    public Aeronave criarAeronave(Aeronave aeronave) {
        return repository.save(aeronave);
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
}