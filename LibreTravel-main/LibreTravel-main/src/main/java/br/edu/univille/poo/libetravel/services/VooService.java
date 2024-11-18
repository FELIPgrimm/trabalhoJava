package br.edu.univille.poo.libetravel.services;

import br.edu.univille.poo.libetravel.entities.Voo;
import br.edu.univille.poo.libetravel.repositories.VooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VooService {

    @Autowired
    private VooRepository repository;

    public List<Voo> listarVoos() {
        return repository.findAll();
    }

    public Voo buscarVooPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Voo não encontrado"));
    }

    public Voo criarVoo(Voo voo) {
        return repository.save(voo);
    }

    public Voo atualizarVoo(Long id, Voo voo) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Voo não encontrado");
        }
        voo.setId(id);
        return repository.save(voo);
    }

    public void deletarVoo(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Voo não encontrado");
        }
        repository.deleteById(id);
    }
}