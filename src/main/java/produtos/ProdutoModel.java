package produtos;

public class ProdutoModel {

    private int codigo;
    private String descricao;

    private double valor_unitario;

    public ProdutoModel(int codigo, String descricao, double valor_unitario) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor_unitario = valor_unitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }
}
