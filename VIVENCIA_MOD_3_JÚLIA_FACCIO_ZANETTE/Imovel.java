public class Imovel{
    private String endereco;
    private double valorDeVenda;
    private double valorDoAluguel;
    private boolean imovelNovo;
    
    public Imovel(String endereco, double valorDeVenda, double valorDoAluguel, boolean imovelNovo){
        this.endereco = endereco;
        this.valorDeVenda = valorDeVenda;
        this.valorDoAluguel = valorDoAluguel;
        this.imovelNovo = imovelNovo;
    }
    
    public String getEndereco(){
        return endereco;
    }
    public double getValorDeVenda(){
        return valorDeVenda;
    }
    public double getValorDoAluguel(){
        return valorDoAluguel;
    }
    public boolean getImovelNovo(){
        return imovelNovo;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public void setValorDeVenda(double valorDeVenda){
        this.valorDeVenda = valorDeVenda;
    }
    public void setValorDoAluguel(double valorDoAluguel){
        this.valorDoAluguel = valorDoAluguel;
    }
    public void setImovelNovo(boolean imovelNovo){
        this.imovelNovo = imovelNovo;
    }
    
    public String toString(){
        String s = "Endereço: " + this.endereco + "\n";
        s += "Valor de venda: R$" + this.valorDeVenda + "\n";
        s += "Valor do aluguel: R$" + this.valorDoAluguel + "\n";
        s += this.imovelNovo ? "É um imóvel novo: SIM" : "É um imóvel novo: NÃO";
        return s;
    }
    
    public double calculaImposto(){
        if(this.imovelNovo)
            return valorDeVenda * 0.15;
        else
            return valorDoAluguel * 0.10;
    }
}