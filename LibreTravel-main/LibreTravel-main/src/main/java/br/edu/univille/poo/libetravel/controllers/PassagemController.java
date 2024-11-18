package br.edu.univille.poo.libetravel.controllers;

import br.edu.univille.poo.libetravel.entities.Passagem;
import br.edu.univille.poo.libetravel.services.PassagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passagens")
public class PassagemController {

    @Autowired
    private PassagemService service;

    @GetMapping
    public ResponseEntity<List<Passagem>> listarPassagens() {
        List<Passagem> passagens = service.listarPassagens();
        return ResponseEntity.ok(passagens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passagem> buscarPassagemPorId(@PathVariable Long id) {
        try {
            Passagem passagem = service.buscarPassagemPorId(id);
            return ResponseEntity.ok(passagem);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Passagem> criarPassagem(@RequestBody Passagem passagem) {
        Passagem novaPassagem = service.criarPassagem(passagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPassagem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passagem> atualizarPassagem(@PathVariable Long id, @RequestBody Passagem passagem) {
        try {
            Passagem passagemAtualizada = service.atualizarPassagem(id, passagem);
            return ResponseEntity.ok(passagemAtualizada);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPassagem(@PathVariable Long id) {
        try {
            service.deletarPassagem(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}