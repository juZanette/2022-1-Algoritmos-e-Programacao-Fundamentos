public class Principal{
    public static void main(String[] args){
        int conta = Teclado.leInt("Insira o número da conta: ");
        while(!(conta > 0))
            conta = Teclado.leInt("Insira o número da conta: ");
        
        double saldo = Teclado.leDouble("Insira o saldo da conta: ");
        while(!(saldo > 0))
            saldo = Teclado.leDouble("Insira o saldo da conta: ");
            
        ContaCorrente a = new ContaCorrente(conta, saldo);
        boolean menu = true;
        
        do{
            System.out.println("1)Efetuar saque");                                      
            System.out.println("2)Efetua um depósito");
            System.out.println("3)Imprimir informações da conta");
            System.out.println("4)Sair do menu");
            
            int opcao = Teclado.leInt();
            while(!(opcao > 0 && opcao < 5))                                         
                opcao = Teclado.leInt("Escolha uma opção válida! \n");
            
            if(opcao == 1){                                                            
                double vSaque = Teclado.leDouble("Digite o valor do saque: \n");           
                a.efetuaSaque(vSaque);                                                   
            }
            else if(opcao == 2){
                double vDeposito = Teclado.leDouble("Digite o valor do depósito: \n");      
                a.efetuaDeposito(vDeposito);                                             
            }
            else if(opcao == 3)                                                          
                System.out.println(a);
            else                                                                          
                menu = false;
            System.out.println(); 
            
        } while (menu == true);
        
        for (int i = 0; i < 3; i++){
           String endereco = Teclado.leString("Insira o endereço: "); 
           
           double valorDeVenda = Teclado.leDouble("Insira o valor de venda: "); 
               while(valorDeVenda <= 0.0)
                   valorDeVenda = Teclado.leDouble("ERRO: insira um valor de venda válido!");
           double valorDoAluguel = Teclado.leDouble("Insira o valor do aluguel: ");
               while(valorDoAluguel <= 0.0)
                   valorDoAluguel = Teclado.leDouble("ERRO: insira um valor de aluguel válido!");
           
                   
           boolean imovelNovo;
           char imovelN = Teclado.leChar("O imovel é novo? (S/N)");
               while(!(imovelN == 'S' || imovelN == 'N' || imovelN == 's' || imovelN == 'n'))
                   imovelN = Teclado.leChar("O imovel é novo?(use apenas 'S' ou 'N')");  
           if (imovelN == 'S' || imovelN == 's')
               imovelNovo = true;
           else
               imovelNovo = false;
               
           Imovel im = new Imovel(endereco, valorDeVenda, valorDoAluguel, imovelNovo);
           System.out.println(im);
           double imposto = im.calculaImposto();
           System.out.println("O imposto deste imóvel é: R$" + imposto);
        }

    }
}