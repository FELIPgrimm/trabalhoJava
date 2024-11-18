package br.edu.univille.poo.libetravel.controllers;

import br.edu.univille.poo.libetravel.entities.Aeroporto;
import br.edu.univille.poo.libetravel.services.AeroportoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aeroportos")
public class AeroportoController {

    @Autowired
    private AeroportoService service;

    @GetMapping
    public ResponseEntity<List<Aeroporto>> listarAeroportos() {
        List<Aeroporto> aeroportos = service.listarAeroportos();
        return ResponseEntity.ok(aeroportos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aeroporto> buscarAeroportoPorId(@PathVariable Long id) {
        try {
            Aeroporto aeroporto = service.buscarAeroportoPorId(id);
            return ResponseEntity.ok(aeroporto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Aeroporto> criarAeroporto(@RequestBody Aeroporto aeroporto) {
        Aeroporto novoAeroporto = service.criarAeroporto(aeroporto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAeroporto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aeroporto> atualizarAeroporto(@PathVariable Long id, @RequestBody Aeroporto aeroporto) {
        try {
            Aeroporto aeroportoAtualizado = service.atualizarAeroporto(id, aeroporto);
            return ResponseEntity.ok(aeroportoAtualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAeroporto(@PathVariable Long id) {
        try {
            service.deletarAeroporto(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}