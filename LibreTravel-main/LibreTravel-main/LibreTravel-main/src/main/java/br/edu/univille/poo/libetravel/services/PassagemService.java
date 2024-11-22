package br.edu.univille.poo.libetravel.services;

import br.edu.univille.poo.libetravel.entities.Passagem;
import br.edu.univille.poo.libetravel.repositories.PassagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassagemService {

    @Autowired
    private PassagemRepository repository;

    public List<Passagem> listarPassagens() {
        return repository.findAll();
    }

    public Passagem buscarPassagemPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Passagem não encontrada"));
    }

    public Passagem criarPassagem(Passagem passagem) {
        return repository.save(passagem);
    }

    public Passagem atualizarPassagem(Long id, Passagem passagem) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Passagem não encontrada");
        }
        passagem.setId(id);
        return repository.save(passagem);
    }

    public void deletarPassagem(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Passagem não encontrada");
        }
        repository.deleteById(id);
    }
}
