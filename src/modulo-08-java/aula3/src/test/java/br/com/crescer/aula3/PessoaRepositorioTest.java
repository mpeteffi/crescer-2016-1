package br.com.crescer.aula3;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author murillo.peteffi
 */
public class PessoaRepositorioTest {
    
    public PessoaRepositorioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInsert() {
        Pessoa pessoa = new Pessoa("JORGE", 0);
        PessoaRepositorio instance = new PessoaRepositorio();
        int totalAnterior = instance.listAll().size();
        instance.insert(pessoa);
        int totalPosterior = instance.listAll().size();
        assertEquals(totalAnterior + 1, totalPosterior);
    }

    @Test
    public void testUpdate() {
        Pessoa pessoa = new Pessoa("JOSÉ", 3);
        PessoaRepositorio instance = new PessoaRepositorio();
        instance.update(pessoa);
        assertTrue(instance.findNome("JOSÉ").get(0).getIdPessoa() == 3);
    }

    @Test
    public void testDelete() {
        PessoaRepositorio instance = new PessoaRepositorio();
        int maiorId = instance.listAll().get(instance.listAll().size() - 1).getIdPessoa();
        Pessoa pessoa = new Pessoa("MARIA", maiorId + 1);
        instance.insert(pessoa);
        int totalAnterior = instance.findNome("MARIA").size();
        instance.delete(pessoa);
        int totalPosterior = instance.findNome("MARIA").size();
        assertEquals(totalAnterior - 1, totalPosterior);
    }

    @Test
    public void testListAll() {
        PessoaRepositorio instance = new PessoaRepositorio();
        List<Pessoa> expResult = new ArrayList<>();
        expResult.add(new Pessoa("MURILLO", 1));
        expResult.add(new Pessoa("PEDRO", 2));
        List<Pessoa> result = instance.listAll();
        assertEquals(expResult.get(0).getNome(), result.get(0).getNome());
        assertEquals(expResult.get(0).getIdPessoa(), result.get(0).getIdPessoa());
        assertEquals(expResult.get(1).getNome(), result.get(1).getNome());
        assertEquals(expResult.get(1).getIdPessoa(), result.get(1).getIdPessoa());
    }

    @Test
    public void testFindNome() {
        String nome = "MURILLO";
        PessoaRepositorio instance = new PessoaRepositorio();
        List<Pessoa> expResult = new ArrayList<>();
        expResult.add(new Pessoa("MURILLO", 1));
        List<Pessoa> result = instance.findNome(nome);
        assertEquals(expResult.get(0).getNome(), result.get(0).getNome());
        assertEquals(expResult.get(0).getIdPessoa(), result.get(0).getIdPessoa());
    }
}
