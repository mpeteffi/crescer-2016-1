package br.com.crescer.services;

import br.com.crescer.entity.Pessoa;
import br.com.crescer.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author murillo.peteffi
 */
@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;
    
    public Iterable<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa save(Pessoa p) {
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
