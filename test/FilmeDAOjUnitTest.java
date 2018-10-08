/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Bean.Filme;
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
    
    @Test
    public void testarCadastro() {
        Filme titanic = new Filme();
        titanic.setFilme("Titanic");
        titanic.setNome("Titanic");
        titanic.setOrcamento(200000000);
        titanic.setLegenda(true);
        titanic.setIdiomaOriginal("inglês");
        titanic.setFaturamento(218677230);
        titanic.setFaixaEtaria("livre");
       // titanic.setDuracao(194);
        
        
    }
    
}
