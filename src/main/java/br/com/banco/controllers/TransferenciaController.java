package br.com.banco.controllers;

import br.com.banco.entities.Transferencia;
import br.com.banco.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    @Autowired
    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @GetMapping
    public List<Transferencia> obterTodasTransferencias() {
        return transferenciaService.obterTodasTransferencias();
    }

    @PostMapping
    public Transferencia criarTransferencia(@RequestBody Transferencia transferencia) {
        return transferenciaService.criarTransferencia(transferencia);
    }
}
