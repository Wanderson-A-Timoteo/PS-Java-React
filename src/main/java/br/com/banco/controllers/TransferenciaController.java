package br.com.banco.controllers;

import br.com.banco.dto.TransferenciaResponseDto;
import br.com.banco.entities.Transferencia;
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
    public TransferenciaResponseDto obterTodasTransferencias() {
        return transferenciaService.obterTodasTransferencias();
    }

    @PostMapping
    public Transferencia criarTransferencia(@RequestBody Transferencia transferencia) {
        return transferenciaService.criarTransferencia(transferencia);
    }

    @GetMapping(params = {"dataInicio", "dataFim"})
    public TransferenciaResponseDto obterTransferenciasPorPeriodo(
            @RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim) {
        return transferenciaService.obterTransferenciasPorPeriodo(dataInicio, dataFim);
    }

    @GetMapping(params = "nomeOperador")
    public TransferenciaResponseDto obterTransferenciasPorNomeOperador(@RequestParam("nomeOperador") String nomeOperador) {
        return transferenciaService.obterTransferenciasPorNomeOperador(nomeOperador);
    }

    @GetMapping(params = {"dataInicio", "dataFim", "nomeOperador"})
    public TransferenciaResponseDto obterTransferenciasPorPeriodoENomeOperador(
            @RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim,
            @RequestParam("nomeOperador") String nomeOperador) {
        return transferenciaService.obterTransferenciasPorPeriodoENomeOperador(dataInicio, dataFim, nomeOperador);
    }

}
