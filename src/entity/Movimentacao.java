package entity;

public class Movimentacao<Produto> {
    public enum Tipo {
        ADICAO,
        REMOCAO
    }

    private Tipo tipo;
    private Produto produto;
    private Cliente cliente;

    public Movimentacao(Tipo tipo, Produto produto, Cliente cliente) {
        this.tipo = tipo;
        this.produto = produto;
        this.cliente = cliente;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
