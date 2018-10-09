/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Bean.Filme;
import Dao.FilmeDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alunos
 */
public class FilmeDAOjUnitTest {

    FilmeDAO filmeDAO = new FilmeDAO();

    @Test
    public void testarCadastro() {
        Filme titanic = new Filme();
        titanic.setFilme("Titanic");
        titanic.setNome("Titanic");
        titanic.setOrcamento(20000000);
        titanic.setLegenda(true);
        titanic.setIdiomaOriginal("inglês");
        titanic.setFaturamento(218677230);
        titanic.setFaixaEtaria("livre");
        titanic.setDuracao(194);
        titanic.setDublado(true);
        titanic.setDiretor("James Cameron");
        titanic.setCategoria("romance drama");
        titanic.setAtorPrincipal("Leo DiCaprio");
        titanic.setAno(1997);

        int identificador = filmeDAO.cadastrar(titanic);

        assertNotSame(identificador, -1);

        Filme filmeBuscado = filmeDAO.obterPeloId(identificador);

        assertEquals(titanic.getFilme(), filmeBuscado.getFilme());
        assertEquals(titanic.getNome(), filmeBuscado.getNome());
        assertEquals(titanic.getOrcamento(), filmeBuscado.getOrcamento(), 0);
        assertEquals(titanic.isLegenda(), filmeBuscado.isLegenda());
        assertEquals(titanic.getIdiomaOriginal(), filmeBuscado.getIdiomaOriginal());
        assertEquals(titanic.getFaturamento(), filmeBuscado.getFaturamento(), 0);
        assertEquals(titanic.getFaixaEtaria(), filmeBuscado.getFaixaEtaria());
        assertEquals(titanic.getDuracao(), filmeBuscado.getDuracao(), 0);
        assertEquals(titanic.isDublado(), filmeBuscado.isDublado());
        assertEquals(titanic.getDiretor(), filmeBuscado.getDiretor());
        assertEquals(titanic.getCategoria(), filmeBuscado.getCategoria());
        assertEquals(titanic.getAtorPrincipal(), filmeBuscado.getAtorPrincipal());
        assertEquals(titanic.getAno(), filmeBuscado.getAno(), 0);
    }

    @Test
    public void testarEdicao() {
        Filme avatar = new Filme();
        avatar.setFilme("Avatar");
        avatar.setNome("Avatar");
        avatar.setOrcamento(237000000);
        avatar.setLegenda(true);
        avatar.setIdiomaOriginal("inglês");
        avatar.setFaturamento(278796508);
        avatar.setFaixaEtaria("maiores 10 anos");
        avatar.setDuracao(164);
        avatar.setDublado(true);
        avatar.setDiretor("James Cameron");
        avatar.setCategoria("ação aventura");
        avatar.setAtorPrincipal("Sam Worthington");
        avatar.setAno(2009);

        int identificador = filmeDAO.cadastrar(avatar);
        avatar.setId(identificador);

        avatar.setFilme("Avatar");
        avatar.setNome("Avatar 2");
        avatar.setOrcamento(137000000);
        avatar.setLegenda(false);
        avatar.setIdiomaOriginal("inglês");
        avatar.setFaturamento(278796508);
        avatar.setFaixaEtaria("maiores 10 anos");
        avatar.setDuracao(164);
        avatar.setDublado(true);
        avatar.setDiretor("James Cameron");
        avatar.setCategoria("ação aventura");
        avatar.setAtorPrincipal("Sam Worthington");
        avatar.setAno(2019);
        boolean alterado = new FilmeDAO().alterar(avatar);
        assertTrue(alterado);


        assertNotSame(identificador, -1);

        Filme filmeBuscado = filmeDAO.obterPeloId(identificador);
        assertNotNull(filmeBuscado);
        assertEquals(avatar.getFilme(), filmeBuscado.getFilme());
        assertEquals(avatar.getNome(), filmeBuscado.getNome());
        assertEquals(avatar.getOrcamento(), filmeBuscado.getOrcamento(), 0);
        assertEquals(avatar.isLegenda(), filmeBuscado.isLegenda());
        assertEquals(avatar.getIdiomaOriginal(), filmeBuscado.getIdiomaOriginal());
        assertEquals(avatar.getFaturamento(), filmeBuscado.getFaturamento(), 0);
        assertEquals(avatar.getFaixaEtaria(), filmeBuscado.getFaixaEtaria());
        assertEquals(avatar.getDuracao(), filmeBuscado.getDuracao(), 0);
        assertEquals(avatar.isDublado(), filmeBuscado.isDublado());
        assertEquals(avatar.getDiretor(), filmeBuscado.getDiretor());
        assertEquals(avatar.getCategoria(), filmeBuscado.getCategoria());
        assertEquals(avatar.getAtorPrincipal(), filmeBuscado.getAtorPrincipal());
        assertEquals(avatar.getAno(), filmeBuscado.getAno(), 0);

    }

    @Test
    public void testarApagar() {
        Filme avatar = new Filme();
        avatar.setFilme("Avatar");
        avatar.setNome("Avatar");
        avatar.setOrcamento(237000000);
        avatar.setLegenda(true);
        avatar.setIdiomaOriginal("inglês");
        avatar.setFaturamento(278796508);
        avatar.setFaixaEtaria("maiores 10 anos");
        avatar.setDuracao(164);
        avatar.setDublado(true);
        avatar.setDiretor("James Cameron");
        avatar.setCategoria("ação aventura");
        avatar.setAtorPrincipal("Sam Worthington");
        avatar.setAno(2009);

        int identificador = filmeDAO.cadastrar(avatar);
        boolean excluido = filmeDAO.apagar(identificador);
        assertTrue(excluido);
       
        Filme filmeBuscado = filmeDAO.obterPeloId(identificador);
        assertNull(filmeBuscado);
    }

}
