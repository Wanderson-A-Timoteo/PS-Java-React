package br.com.banco.dto;

import br.com.banco.entities.Transferencia;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class TransferenciaResponseDto {
    private List<Transferencia> transferencias;
    private BigDecimal saldoTotal;
    private BigDecimal saldoTotalNoPeriodo;

    public TransferenciaResponseDto(List<Transferencia> transferencias, BigDecimal saldoTotal, BigDecimal saldoTotalNoPeriodo) {
        this.transferencias = transferencias;
        this.saldoTotal = saldoTotal;
        this.saldoTotalNoPeriodo = saldoTotalNoPeriodo;
    }

    public TransferenciaResponseDto() {

    }
}
