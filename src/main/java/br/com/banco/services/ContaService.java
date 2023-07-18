package br.com.banco.services;

import br.com.banco.entities.Conta;
import br.com.banco.repositories.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ContaService {

    private ContaRepository contaRepository;

    public List<Conta> obterTodasContas() {
        return contaRepository.findAll();
    }

    public Conta criarConta(Conta conta) {
        return contaRepository.save(conta);
    }
}
