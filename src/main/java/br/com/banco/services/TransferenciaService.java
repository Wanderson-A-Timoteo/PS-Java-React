package br.com.banco.services;

import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.ContaRepository;
import br.com.banco.repositories.TransferenciaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class TransferenciaService {

    private TransferenciaRepository transferenciaRepository;
    private ContaRepository contaRepository;

    public List<Transferencia> obterTodasTransferencias() {
        return transferenciaRepository.findAll();
    }

    public Transferencia criarTransferencia(Transferencia transferencia) {
        return transferenciaRepository.save(transferencia);
    }

    public List<Transferencia> obterTransferenciasPorPeriodo(LocalDateTime dataInicio, LocalDateTime dataFim) {
        return transferenciaRepository.findByDataTransferenciaBetween(dataInicio, dataFim);
    }

}
