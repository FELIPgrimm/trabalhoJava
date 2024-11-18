package br.edu.univille.poo.libetravel.services;

import br.edu.univille.poo.libetravel.entities.DadosPassageiros;
import br.edu.univille.poo.libetravel.repositories.DadosPassageirosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosPassageirosService {

    @Autowired
    private DadosPassageirosRepository repository;

    public List<DadosPassageiros> listarPassageiros() {
        return repository.findAll();
    }

    public DadosPassageiros buscarPassageiroPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Passageiro não encontrado"));
    }

    public DadosPassageiros criarPassageiro(DadosPassageiros passageiro) {
        return repository.save(passageiro);
    }

    public DadosPassageiros atualizarPassageiro(Long id, DadosPassageiros passageiro) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Passageiro não encontrado");
        }
        //passageiro.setId(id);  <-- REMOVA ESTA LINHA
        return repository.save(passageiro);
    }

    public void deletarPassageiro(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Passageiro não encontrado");
        }
        repository.deleteById(id);
    }
}