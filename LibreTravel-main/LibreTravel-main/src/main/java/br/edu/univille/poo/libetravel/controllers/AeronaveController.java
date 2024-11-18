package br.edu.univille.poo.libetravel.controllers;

import br.edu.univille.poo.libetravel.entities.Aeronave;
import br.edu.univille.poo.libetravel.services.AeronaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aeronaves")
public class AeronaveController {

    @Autowired
    private AeronaveService service;

    @GetMapping
    public ResponseEntity<List<Aeronave>> listarAeronaves() {
        List<Aeronave> aeronaves = service.listarAeronaves();
        return ResponseEntity.ok(aeronaves);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aeronave> buscarAeronavePorId(@PathVariable Long id) {
        try {
            Aeronave aeronave = service.buscarAeronavePorId(id);
            return ResponseEntity.ok(aeronave);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Aeronave> criarAeronave(@RequestBody Aeronave aeronave) {
        Aeronave novaAeronave = service.criarAeronave(aeronave);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAeronave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aeronave> atualizarAeronave(@PathVariable Long id, @RequestBody Aeronave aeronave) {
        try {
            Aeronave aeronaveAtualizada = service.atualizarAeronave(id, aeronave);
            return ResponseEntity.ok(aeronaveAtualizada);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAeronave(@PathVariable Long id) {
        try {
            service.deletarAeronave(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}