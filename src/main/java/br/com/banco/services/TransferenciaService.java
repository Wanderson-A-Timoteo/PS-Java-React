package br.com.banco.services;

import br.com.banco.dto.TransferenciaResponseDto;
import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.ContaRepository;
import br.com.banco.repositories.TransferenciaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class TransferenciaService {

    private TransferenciaRepository transferenciaRepository;
    private ContaRepository contaRepository;

    public TransferenciaResponseDto obterTodasTransferencias() {
        List<Transferencia> transferencias = transferenciaRepository.findAllObterTodasTransferencias();
        BigDecimal saldoTotalNoPeriodo = BigDecimal.ZERO;
        BigDecimal gastos = BigDecimal.ZERO;

        for (Transferencia transferencia : transferencias) {
            BigDecimal valor = transferencia.getValor();
            String tipo = StringUtils.stripAccents(transferencia.getTipo());

            if (isTransferenciaEntrada(tipo) || isDeposito(tipo)) {
                saldoTotalNoPeriodo = saldoTotalNoPeriodo.add(valor);
            } else if (isTransferenciaSaida(tipo) || isSaque(tipo)) {
                gastos = gastos.add(valor);
            }
        }

        BigDecimal saldoTotal = saldoTotalNoPeriodo.subtract(gastos).setScale(2, RoundingMode.HALF_UP);

        return new TransferenciaResponseDto(transferencias, saldoTotal, saldoTotalNoPeriodo);
    }

    public Transferencia criarTransferencia(Transferencia transferencia) {
        return transferenciaRepository.save(transferencia);
    }

    public TransferenciaResponseDto obterTransferenciasPorPeriodo(LocalDateTime dataInicio, LocalDateTime dataFim) {
        List<Transferencia> transferencias = transferenciaRepository.findByDataTransferenciaBetween(dataInicio, dataFim);
        BigDecimal saldoTotalNoPeriodo = BigDecimal.ZERO;
        BigDecimal gastos = BigDecimal.ZERO;

        for (Transferencia transferencia : transferencias) {
            BigDecimal valor = transferencia.getValor();
            String tipo = StringUtils.stripAccents(transferencia.getTipo());

            if (isTransferenciaEntrada(tipo) || isDeposito(tipo)) {
                saldoTotalNoPeriodo = saldoTotalNoPeriodo.add(valor);
            } else if (isTransferenciaSaida(tipo) || isSaque(tipo)) {
                gastos = gastos.add(valor);
            }
        }

        BigDecimal saldoTotal = saldoTotalNoPeriodo.subtract(gastos).setScale(2, RoundingMode.HALF_UP);

        return new TransferenciaResponseDto(transferencias, saldoTotal, saldoTotalNoPeriodo);
    }

    public TransferenciaResponseDto obterTransferenciasPorNomeOperador(String nomeOperador) {
        List<Transferencia> transferencias = transferenciaRepository.findByNomeOperadorTransacao(nomeOperador);
        BigDecimal saldoTotalNoPeriodo = BigDecimal.ZERO;
        BigDecimal gastos = BigDecimal.ZERO;

        for (Transferencia transferencia : transferencias) {
            BigDecimal valor = transferencia.getValor();
            String tipo = StringUtils.stripAccents(transferencia.getTipo());

            if (isTransferenciaEntrada(tipo) || isDeposito(tipo)) {
                saldoTotalNoPeriodo = saldoTotalNoPeriodo.add(valor);
            } else if (isTransferenciaSaida(tipo) || isSaque(tipo)) {
                gastos = gastos.add(valor);
            }
        }

        BigDecimal saldoTotal = saldoTotalNoPeriodo.subtract(gastos).setScale(2, RoundingMode.HALF_UP);

        return new TransferenciaResponseDto(transferencias, saldoTotal, saldoTotalNoPeriodo);
    }

    public TransferenciaResponseDto obterTransferenciasPorPeriodoENomeOperador(
            LocalDateTime dataInicio, LocalDateTime dataFim, String nomeOperador) {
        List<Transferencia> transferencias = transferenciaRepository
                .findByDataTransferenciaBetweenAndNomeOperadorTransacao(dataInicio, dataFim, nomeOperador);
        BigDecimal saldoTotalNoPeriodo = BigDecimal.ZERO;
        BigDecimal gastos = BigDecimal.ZERO;

        for (Transferencia transferencia : transferencias) {
            BigDecimal valor = transferencia.getValor();
            String tipo = StringUtils.stripAccents(transferencia.getTipo());

            if (isTransferenciaEntrada(tipo) || isDeposito(tipo)) {
                saldoTotalNoPeriodo = saldoTotalNoPeriodo.add(valor);
            } else if (isTransferenciaSaida(tipo) || isSaque(tipo)) {
                gastos = gastos.add(valor);
            }
        }

        BigDecimal saldoTotal = saldoTotalNoPeriodo.subtract(gastos).setScale(2, RoundingMode.HALF_UP);

        return new TransferenciaResponseDto(transferencias, saldoTotal, saldoTotalNoPeriodo);
    }

    private boolean isTransferenciaEntrada(String tipo) {
        return tipo != null && (tipo.equalsIgnoreCase("transferencia entrada"));
    }

    private boolean isTransferenciaSaida(String tipo) {
        return tipo != null && (tipo.equalsIgnoreCase("transferencia saida"));
    }

    private boolean isDeposito(String tipo) {
        return tipo != null && (tipo.equalsIgnoreCase("deposito"));
    }

    private boolean isSaque(String tipo) {
        return tipo != null && (tipo.equalsIgnoreCase("saque"));
    }
}