package br.edu.univille.poo.libetravel.controllers;

import br.edu.univille.poo.libetravel.entities.Voo;
import br.edu.univille.poo.libetravel.services.VooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voos")
public class VooController {

    @Autowired
    private VooService service;

    @GetMapping
    public ResponseEntity<List<Voo>> listarVoos() {
        List<Voo> voos = service.listarVoos();
        return ResponseEntity.ok(voos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voo> buscarVooPorId(@PathVariable Long id) {
        try {
            Voo voo = service.buscarVooPorId(id);
            return ResponseEntity.ok(voo);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Voo> criarVoo(@RequestBody Voo voo) {
        Voo novoVoo = service.criarVoo(voo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVoo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Voo> atualizarVoo(@PathVariable Long id, @RequestBody Voo voo) {
        try {
            Voo vooAtualizado = service.atualizarVoo(id, voo);
            return ResponseEntity.ok(vooAtualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVoo(@PathVariable Long id) {
        try {
            service.deletarVoo(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}