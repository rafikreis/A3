package entity;
// Classe que representa um produto
public class Produtos {

    // Atributos do produto
    private int idProd;         // ID do produto
    private String nomeProd;    // Nome do produto
    private String localProd;   // Local onde o produto é armazenado
    private int qntdProd;       // Quantidade do produto
    private Fornecedor fornecedor; // Fornecedor do produto

    // Acessar e modificar o ID do produto
    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    // Acessar e modificar o nome do produto
    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    // Acessar e modificar o local do produto
    public String getLocalProd() {
        return localProd;
    }

    public void setLocalProd(String localProd) {
        this.localProd = localProd;
    }

    // Acessar e modificar a quantidade do produto
    public int getQntdProd() {
        return qntdProd;
    }

    public void setQntdProd(int qntdProd) {
        this.qntdProd = qntdProd;
    }

    // Acessar e modificar o fornecedor do produto
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getQuantidade() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQuantidade'");
    }

}