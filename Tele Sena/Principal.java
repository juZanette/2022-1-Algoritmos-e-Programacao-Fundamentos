/*
 * Classe principal, possui o método main.
 * Além disso, chama os métodos das outras classes e exibe mensagens ao usuário de acordo com o que está acontecendo
 * durante o uso do programa.
 */
public class Principal{
    public static void main(String[] args){
       System.out.println("Bem vindo(a) a Tele Sena!");

       //Cria uma pessoa, sem nome, apenas com um número aleatório de identificação e de de Tele Senas compradas.
       for(int i=0; i<20; i++){
            Pessoa pessoa = new Pessoa();
            pessoa.setNome("Pessoa" + (i+1));
            pessoa.setQuantidadeTeleSenasCompradas((int)(Math.random() * 15 + 1));
            ControleTeleSena.addPessoa(pessoa);
       }
       
       System.out.print("\n----------------------------------------------");
       System.out.print("\nAs Tele Senas estão sendo vendidas!\n");
       pontinhos();
       ControleTeleSena.vendeTeleSenas();
       System.out.print("\nO sorteio está sendo realizado!\n");
       pontinhos();
       ControleTeleSena.realizaSorteio();
       System.out.print("\nRealizando a distribuição da premiação!\n");
       pontinhos();
       ControleTeleSena.realizaDistribuicaoPremiacoes();
        
       System.out.print("\n\nNúmeros sorteados: ");
       ControleTeleSena.imprimeNumerosPremiados();
       System.out.println("\nQuantidade de Tele Senas vendidas: " + ControleTeleSena.getQuantidadeTeleSenasVendidas());
       System.out.println("Número de ganhadores: " + ControleTeleSena.getQuantidadeGanhadores());
       System.out.print("Nome(s) do(s) ganhador(es): ");
       ControleTeleSena.imprimeGanhadores();
       System.out.println("\nPrêmio para cada ganhador: R$ " + String.format("%.2f",ControleTeleSena.getPremioPorGanhador()));
       System.out.println("Valor total das Tele Senas vendidas: R$ " + String.format("%.2f",(double)ControleTeleSena.getQuantidadeTeleSenasVendidas()*10));
       System.out.println("O lucro do senhor Silvio Santos, com a Tele Sena, é de: R$ " + String.format("%.2f",ControleTeleSena.getSilvioSantos()));
    }
    
    private static void pontinhos(){
        delay(0.5);
        for(int i=0; i<3; i++)
        {
            System.out.print(" .");
            delay(0.5);
        }
    }
    
    private static void delay(double s){
        try {
            Thread.sleep((int)(s*1000));
        } catch (Exception e) {}
    }
} 
