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
                v.setDtVenda(rs.getString("dtVenda"));

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

}
