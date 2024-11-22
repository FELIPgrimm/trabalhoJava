package br.edu.univille.poo.libetravel.repositories;

import br.edu.univille.poo.libetravel.entities.Passagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Long> {
}
