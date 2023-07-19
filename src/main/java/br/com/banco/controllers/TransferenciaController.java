package br.com.banco.controllers;

import br.com.banco.dto.TransferenciaResponseDto;
import br.com.banco.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private TransferenciaService transferenciaService;

    @Autowired
    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @GetMapping
    public TransferenciaResponseDto obterTransferencias(
            @RequestParam(value = "dataInicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam(value = "dataFim", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim,
            @RequestParam(value = "nomeOperador", required = false) String nomeOperador) {

        if (dataInicio == null && dataFim == null && nomeOperador == null) {

            return transferenciaService.obterTodasTransferencias();

        } else if (dataInicio != null && dataFim != null && nomeOperador == null) {

            return transferenciaService.obterTransferenciasPorPeriodo(dataInicio, dataFim);

        } else if (dataInicio == null && dataFim == null && nomeOperador != null) {

            return transferenciaService.obterTransferenciasPorNomeOperador(nomeOperador);

        } else if (dataInicio != null && dataFim != null && nomeOperador != null) {

            return transferenciaService.obterTransferenciasPorPeriodoENomeOperador(dataInicio, dataFim, nomeOperador);

        } else {

            throw new IllegalArgumentException("Parâmetros inválido.");
        }
    }
}
