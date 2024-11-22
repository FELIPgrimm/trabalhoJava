package br.edu.univille.poo.libetravel.repositories;

import br.edu.univille.poo.libetravel.entities.Aeronave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeronaveRepository extends JpaRepository<Aeronave, Long> {
}
