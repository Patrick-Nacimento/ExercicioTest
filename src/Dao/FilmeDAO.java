/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PATRICK
 */
public class FilmeDAO {

    public FilmeDAO() {

    }

    public int cadastrar(Filme filme) {
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            String sql = "INSERT INTO filmes"
                    + "\n(filme, nome, diretor, categoria, atorPrincipal, faixaEtaria, idiomaOriginal, duracao, ano, legenda, dublado, orcamento, faturamento)"
                    + "\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, filme.getFilme());
                ps.setString(2, filme.getNome());
                ps.setString(3, filme.getDiretor());
                ps.setString(4, filme.getCategoria());
                ps.setString(5, filme.getAtorPrincipal());
                ps.setString(6, filme.getFaixaEtaria());
                ps.setString(7, filme.getIdiomaOriginal());
                ps.setInt(8, filme.getDuracao());
                ps.setInt(9, filme.getAno());
                ps.setBoolean(10, filme.isLegenda());
                ps.setBoolean(11, filme.isDublado());
                ps.setDouble(12, filme.getOrcamento());
                ps.setDouble(13, filme.getFaturamento());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }
        }

        return -1;
    }

    public Filme obterPeloId(int identificador) {
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            String sql = "SELECT * FROM filmes WHERE id = ?";
            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, identificador);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Filme filme = new Filme();
                    filme.setId(rs.getInt("id"));
                    filme.setFilme(rs.getString("filme"));
                    filme.setNome(rs.getString("nome"));
                    filme.setDiretor(rs.getString("diretor"));
                    filme.setCategoria(rs.getString("categoria"));
                    filme.setAtorPrincipal(rs.getString("atorPrincipal"));
                    filme.setFaixaEtaria(rs.getString("faixaEtaria"));
                    filme.setIdiomaOriginal(rs.getString("idiomaOriginal"));
                    filme.setDuracao(rs.getInt("duracao"));
                    filme.setAno(rs.getInt("ano"));
                    filme.setLegenda(rs.getBoolean("legenda"));
                    filme.setDublado(rs.getBoolean("dublado"));
                    filme.setFaturamento(rs.getDouble("faturamento"));
                    filme.setOrcamento(rs.getDouble("orcamento"));
                    return filme;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }
        }
        return null;
    }

    public boolean alterar(Filme avatar) {
        Connection conexao = Conexao.conectar();
        if(conexao != null) {
            String sql = "UPDATE filmes SET filme = ?, nome = ?, diretor = ?, categoria = ?, atorPrincipal = ?,faixaEtaria = ?, idiomaOriginal = ?, duracao = ?, ano = ?, legenda = ?, dublado = ?, faturamento = ?, orcamento = ? WHERE id = ?";
            try{
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, avatar.getFilme());
                ps.setString(2, avatar.getNome());
                ps.setString(3, avatar.getDiretor());
                ps.setString(4, avatar.getCategoria());
                ps.setString(5, avatar.getAtorPrincipal());
                ps.setString(6, avatar.getFaixaEtaria());
                ps.setString(7, avatar.getIdiomaOriginal());
                ps.setInt(8, avatar.getDuracao());
                ps.setInt(9, avatar.getAno());
                ps.setBoolean(10, avatar.isLegenda());
                ps.setBoolean(11, avatar.isDublado());
                ps.setDouble(12, avatar.getFaturamento());
                ps.setDouble(13, avatar.getOrcamento());
                ps.setInt(14, avatar.getId());
                return ps.executeUpdate() == 1;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }
        }
    return false;
    }

    public boolean apagar(int identificador) {
        Connection conexao = Conexao.conectar();
       if(conexao != null) {  
         String sql = "DELETE FROM filmes WHERE id = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, identificador);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.desconectar();
        }
        
       }
        return false;
    }
}
