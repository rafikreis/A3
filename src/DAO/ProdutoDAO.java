package DAO;

import conexao.Conexao;
import entity.Produtos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {

    public void cadastrarProduto(Produtos produtos) {
        // SQL buscar seleciona todos os dados da tb_produto onde o nome for o mesmo que o informado
        String sqlBuscar = "SELECT * FROM tb_produtos WHERE nomeProd=?";

         // SQL update selecionaa tb_produto e pega q quntidade e soma mais a quantidade informada onde o nome for o mesmo que o informado
        String sqlSomar = "UPDATE tb_produtos SET qntdProd=qntdProd+? WHERE nomeProd=?";

         // SQL inserir insire na tb_produto o nome e quantidade informadas
        String sqlInserir = "INSERT INTO tb_produtos (nomeProd, qntdProd) VALUES (?, ?)";

        PreparedStatement psBuscar = null;
        PreparedStatement psAtualizar = null;
        PreparedStatement psInserir = null;

        try {
            // Verificar se o produto já existe na tabela
            psBuscar = Conexao.pegarConexao().prepareStatement(sqlBuscar);
            psBuscar.setString(1, produtos.getNomeProd());
            ResultSet rs = psBuscar.executeQuery();

            if (rs.next()) {
                // Se o produto existe, atualiza a quantidade
                psAtualizar = Conexao.pegarConexao().prepareStatement(sqlSomar);
                psAtualizar.setInt(1, produtos.getQntdProd());
                psAtualizar.setString(2, produtos.getNomeProd());
                psAtualizar.executeUpdate();
                System.out.println("Quantidade do produto atualizada.");
            } else {
                // Se o produto não existe, insere um novo registro
                psInserir = Conexao.pegarConexao().prepareStatement(sqlInserir);
                psInserir.setString(1, produtos.getNomeProd());
                psInserir.setInt(2, produtos.getQntdProd());
                psInserir.executeUpdate();
                System.out.println("Produto inserido com sucesso.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar o produto: " + e.getMessage());
        } finally {
            // Fecha os statements após o uso
            try {
                if (psBuscar != null) psBuscar.close();
                if (psAtualizar != null) psAtualizar.close();
                if (psInserir != null) psInserir.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Produtos buscarProduto(String nomeProd) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            
            // SQL para buscar um produto pelo nome
            String sql = "SELECT * FROM tb_produtos WHERE nomeProd=?";
            ps = Conexao.pegarConexao().prepareStatement(sql);
            ps.setString(1, nomeProd);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Se encontrou o produto, cria um objeto Produtos com os dados no banco
                Produtos prod = new Produtos();
                prod.setIdProd(rs.getInt("idProd"));
                prod.setNomeProd(rs.getString("nomeProd"));
                prod.setQntdProd(rs.getInt("qntdProd"));
                return prod;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Produto: " + e.getMessage());
        } finally {
            // Fecha o ResultSet e o PreparedStatement após o uso
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // Retorna null se o produto não for encontrado
        return null; 
    }

    public void removerProduto(String nomeProd, int quantidade) {
        PreparedStatement ps = null;
        try {
            // SQL para atualizar a quantidade do produto removendo a quantidade especificada
            String sql = "UPDATE tb_produtos SET qntdProd=qntdProd-? WHERE nomeProd=?";
            ps = Conexao.pegarConexao().prepareStatement(sql);
            ps.setInt(1, quantidade);
            ps.setString(2, nomeProd);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Quantidade do produto reduzida com sucesso.");
            } else {
                System.out.println("Produto não encontrado ou quantidade insuficiente para redução.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao remover quantidade do produto: " + e.getMessage());
        } finally {
            // Fecha o PreparedStatement após o uso
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
