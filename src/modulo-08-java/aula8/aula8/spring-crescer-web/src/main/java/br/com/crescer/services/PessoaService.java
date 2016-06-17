package br.com.crescer.services;

import br.com.crescer.controllers.Pessoa;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

/**
 * @author murillo.peteffi
 */
@Service
public class PessoaService {

    public List<Pessoa> list() {
        Pessoa p = new Pessoa();
        p.setNome("Murillo Peteffi");
        p.setNascimento(new Date());
        return Stream.of(p).collect(Collectors.toList());
    }
}
