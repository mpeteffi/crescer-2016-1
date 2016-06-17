package br.com.crescer.controllers;

import br.com.crescer.services.PessoaService;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author murillo.peteffi
 */
@RestController
public class PessoaRest {

    @Autowired
    PessoaService pessoaService;
    
    @RequestMapping(value = "/current_date_time_2")
    public Date date() {
        return new Date();
    }
    
    @RequestMapping("/pessoa")
    public List<Pessoa> list() {
        return pessoaService.list();
    }      
}
