package br.edu.univille.poo.libetravel.services;

import br.edu.univille.poo.libetravel.entities.Aeroporto;
import br.edu.univille.poo.libetravel.repositories.AeroportoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeroportoService {

    @Autowired
    private AeroportoRepository repository;

    public List<Aeroporto> listarAeroportos() {
        return repository.findAll();
    }

    public Aeroporto buscarAeroportoPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Aeroporto não encontrado"));
    }

    public Aeroporto criarAeroporto(Aeroporto aeroporto) {
        return repository.save(aeroporto);
    }

    public Aeroporto atualizarAeroporto(Long id, Aeroporto aeroporto) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Aeroporto não encontrado");
        }
        aeroporto.setId(id);
        return repository.save(aeroporto);
    }

    public void deletarAeroporto(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Aeroporto não encontrado");
        }
        repository.deleteById(id);
    }
}