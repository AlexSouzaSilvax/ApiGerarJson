package Vendas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

public class VendasDAO {

    public List<Vendas> lista(String clausula) {

        try {

            Connection conexao = Conexao.getConexao();
            List<Vendas> listaVendas = new ArrayList<>();
            PreparedStatement ps = conexao.prepareStatement("select * from vendas " + clausula);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Vendas v = new Vendas();

                v.setId(rs.getString("id"));
                v.setIdUsuario(rs.getString("idUsuario"));
                v.setNomeProduto(rs.getString("nomeProduto"));
                v.setQtd(rs.getString("qtd"));
                v.setDtVenda(rs.getDate("dtVenda"));

                listaVendas.add(v);
            }
            ps.execute();
            ps.close();
            Conexao.fecharConexao();

            return listaVendas;
        } catch (SQLException ex) {
            System.out.println("Erro ao listar DAO " + ex.getMessage());
            return null;
        }
    }

    public Vendas inserir(Vendas v) {

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps;

            ps = conexao.prepareStatement("INSERT INTO `vendas` (`idUsuario`,`nomeProduto`,`qtd`,`dtVenda`) VALUES (?,?,?,?)");

            ps.setString(1, v.getIdUsuario());
            ps.setString(2, v.getNomeProduto());
            ps.setString(3, v.getQtd());
            ps.setDate(4, v.getDtVenda());

            ps.execute();
            Conexao.fecharConexao();

            System.out.println("Salvo com sucesso. ID: " + v.getId());
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar DAO " + ex.getMessage());
        }
        return v;
    }
}
