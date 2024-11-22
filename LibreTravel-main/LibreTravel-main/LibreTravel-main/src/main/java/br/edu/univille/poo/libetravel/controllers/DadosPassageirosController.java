package br.edu.univille.poo.libetravel.controllers;

import br.edu.univille.poo.libetravel.entities.DadosPassageiros;
import br.edu.univille.poo.libetravel.services.DadosPassageirosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passageiros")
public class DadosPassageirosController {

    @Autowired
    private DadosPassageirosService service;

    @GetMapping
    public ResponseEntity<List<DadosPassageiros>> listarPassageiros() {
        List<DadosPassageiros> passageiros = service.listarPassageiros();
        return ResponseEntity.ok(passageiros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosPassageiros> buscarPassageiroPorId(@PathVariable Long id) {
        try {
            DadosPassageiros passageiro = service.buscarPassageiroPorId(id);
            return ResponseEntity.ok(passageiro);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<DadosPassageiros> criarPassageiro(@RequestBody DadosPassageiros passageiro) {
        DadosPassageiros novoPassageiro = service.criarPassageiro(passageiro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPassageiro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosPassageiros> atualizarPassageiro(@PathVariable Long id, @RequestBody DadosPassageiros passageiro) {
        try {
            DadosPassageiros passageiroAtualizado = service.atualizarPassageiro(id, passageiro);
            return ResponseEntity.ok(passageiroAtualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPassageiro(@PathVariable Long id) {
        try {
            service.deletarPassageiro(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
