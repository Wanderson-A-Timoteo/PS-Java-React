package br.com.banco.repositories;

import br.com.banco.entities.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query("SELECT t FROM Transferencia t")
    List<Transferencia> findAllObterTodasTransferencias();

    List<Transferencia> findByDataTransferenciaBetween(LocalDateTime dataInicio, LocalDateTime dataFim);

    List<Transferencia> findByNomeOperadorTransacao(String nomeOperador);

    List<Transferencia> findByDataTransferenciaBetweenAndNomeOperadorTransacao(
            LocalDateTime dataInicio, LocalDateTime dataFim, String nomeOperador);

}
