public class ContaCorrente{
    private int numeroDaConta;
    private double saldo;
    
    public ContaCorrente(int numeroDaConta, double saldo){
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo;
    }
    
    public int getNumeroDaConta(){
        return numeroDaConta;
    }
    public double getSaldo(){
        return saldo;
    }
    
    public void setNumeroDaConta(int numeroDaConta){
        this.numeroDaConta = numeroDaConta;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
    public String toString(){
        String s = "Conta: " + this.numeroDaConta + "\n";
        s += "Saldo: R$" + this.saldo + "\n";
        return s;
    }
    
    public void efetuaDeposito(double deposito){
        if(deposito <= 0.0)
            System.out.println("ERRO: não foi possível depositar esse valor!");
        else
            this.saldo += deposito;
    }
    
    public void efetuaSaque(double saque){
        if (saque <= 0.0)
            System.out.println("ERRO: não foi possível sacar esse valor!");
        else if(this.saldo - saque < 0.0)
            System.out.println("ERRO: saldo insuficiente!");
        else
            this.saldo -= saque;
    }
}