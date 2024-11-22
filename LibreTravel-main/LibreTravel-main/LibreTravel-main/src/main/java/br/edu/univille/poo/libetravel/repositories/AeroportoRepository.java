package br.edu.univille.poo.libetravel.repositories;

import br.edu.univille.poo.libetravel.entities.Aeroporto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {
}
