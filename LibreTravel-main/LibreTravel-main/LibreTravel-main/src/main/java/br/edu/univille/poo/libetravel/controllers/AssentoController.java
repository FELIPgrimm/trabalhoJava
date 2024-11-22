package br.edu.univille.poo.libetravel.controllers;

import br.edu.univille.poo.libetravel.entities.Assento;
import br.edu.univille.poo.libetravel.services.AssentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assentos")
public class AssentoController {

    @Autowired
    private AssentoService service;

    @GetMapping
    public ResponseEntity<List<Assento>> listarAssentos() {
        List<Assento> assentos = service.listarAssentos();
        return ResponseEntity.ok(assentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assento> buscarAssentoPorId(@PathVariable Long id) {
        try {
            Assento assento = service.buscarAssentoPorId(id);
            return ResponseEntity.ok(assento);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Assento> criarAssento(@RequestBody Assento assento) {
        Assento novoAssento = service.criarAssento(assento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAssento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assento> atualizarAssento(@PathVariable Long id, @RequestBody Assento assento) {
        try {
            Assento assentoAtualizado = service.atualizarAssento(id, assento);
            return ResponseEntity.ok(assentoAtualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAssento(@PathVariable Long id) {
        try {
            service.deletarAssento(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}