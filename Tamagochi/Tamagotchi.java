/*
 *  Código criado por Júlia Faccio Zanette
 *
 * 
 * Classe que contém os métodos responsáveis por simular as ações do Tamagotchi, bem como as respostas dele às escolhas
 * feitas pelo usuário, além do estado dele durante o funcionamento do programa.
 */
public class Tamagotchi{
    private String nome;                    //Atributo do tipo String.
    private int idade;                      //Atributo do tipo inteiro.
    private int peso;                       //Atributo do tipo inteiro.
    public int ficarAcordado;               //Atributo do tipo inteiro.
    
    /*
     * Método construtor que solicita três parâmetros da classe Principal: nome(String), idade(int) e peso(int).
     */
    public Tamagotchi (String nome, int idade, int peso){
        this.nome = nome;                   //Muda o valor do atributo "nome" pelo parâmetro "nome".
        this.idade = idade;                 //Muda o valor do atributo "idade" pelo parâmetro "idade".
        this.peso = peso;                   //Muda o valor do atributo "peso" pelo parâmetro "peso".
    }
    
    public String getNome(){                //Método get que pode ser usado para acessar o valor do atributo nome.
        return nome;                        //Retorna o valor da variável "nome".
    }
    public int getIdade(){                  //Método get que pode ser usado para acessar o valor do atributo idade.
        return idade;                       //Retorna o valor da variável "idade".
    }
    public int getPeso(){                   //Método get que pode ser usado para acessar o valor do atributo peso.
        return peso;                        //Retorna o valor da variável "peso".
    }
    
    public void setNome(String nome){       //Metódo set, muda o valor do atributo "nome".
        this.nome = nome;                   //substitui o que está no atributo (valor) de "nome" pelo parâmetro "nome".
    }
    public void setIdade(int idade){        //Metódo set, muda o valor do atributo "idade".
        this.idade = idade;                 //substitui o que está no atributo (valor) de "idade" pelo parâmetro "idade".
    }
    public void setPeso(int peso ){         //Metódo set, muda o valor do atributo "peso".
        this.peso = peso;                   //substitui o que está no atributo (valor) de "peso" pelo parâmetro "peso".
    }
    
    /*
     * Método que tem como função informar o estado do Tamagotchi ao usuário.
     * Se ele estiver vivo, é impressa na tela uma mensagem com o peso e a idade dele.
     * Se ele morrer, é impressa na tela uma mensagem informando a causa da morte dele.
     */
    public boolean estadoTamagotchi(){
        if (peso < 1){
            /*Se o peso do Tamagotchi for menor que 1, imprime na tela uma mensagem informando que ele morreu de fome
             * e retorna o valor booleano false para quem chamou o método.
             */
            System.out.println(nome + " morreu de fome! (×_×)");
            return false;
        }
        
        else if (peso > 20){
            /*Se o peso do Tamagotchi for maior do que 20, imprime na tela uma mensagem informando que ele 
             * morreu de tanto comer e retorna o valor booleano false para quem chamou o método.
             */
            System.out.println(nome + " explodiu de tanto comer! (×_×)");
            return false;
        }
        
        else if (idade > 15){
            /*Se a idade do Tamagotchi for maior que 15, imprime na tela uma mensagem informando que ele 
             * morreu de velhisse e retorna o valor booleano false para quem chamou o método.
             */
            System.out.println(nome + " morreu de velhice! (×_×)");
            return false;
        }
        
        else{
            /*Se o Tamagotchi estiver com o peso e a idade com valores dentro dos extremos (>15 dias e 0<peso>20kg),
             * é mostrado na tela o estado dele e retorna o valor booleano true para o método que chamou essa informação.
             */
            System.out.println("Idade: " + idade + " dias!");
            if(peso > 1){
                System.out.println("Peso: " + peso + "kg");
                System.out.println("(^o^)/\n");
            }
            return true;
        }
    }
    
    /*
     * Método que tem como função escolher aleatoriamente as ações do Tamagotchi enquanto ele estiver vivo.
     */
    public void acaoTamagotchi(){
        int acao = (int)(Math.random()*3);      //É sorteado um número entre 0 e 2, e guarda essa informação na variável "acaoTamagotchi"
        
        if (acao == 0){                         //Se o valor sorteado for 0, chama o método "sentirFome"
            sentirFome();
        }
        else if (acao == 1){                    //Se o valor sorteado for 1, chama o método "sentirSono"
            sentirSono();
        }
        else{                                   //Se o valor sorteado for 2, chama o método "ficarEntediado"
            ficarEntediado();
        }
    }
    
     /*
     * Método que simula o estado de sono do Tamagotchi e as suas reações às escolhas feitas pelo usuário
     * (fazer com que o Tamagotchi durma ou fique acordado).
     */
    public void sentirSono(){
        System.out.println(nome + " está sonolento! (>_<)");    //Imprime a mensagem de que o Tamagotchi está com sono
        
        if (ficarAcordado < 5){
            /*
             * Caso a contagem de vezes que o Tamagothci ficou acordado for menor que 5, dá ao usuário as opções de
             * deixar ele dormir ou permanecer acordado.
             */
            System.out.println("1 - Dormir");
            System.out.println("2 - Permanecer acordado");
            
            int opcao = Teclado.leInt();                           
            /*Cria a variável "opcao", chama a classe Teclado e o método leInt para receber o valor digitado pelo usuário.*/
            
            if (opcao == 1){
                /*
                 * Se a opção escolhida for 1, imprime a mensagem de que o Tamagotchi dormiu, aumenta a idade dele
                 * em 1 dia e anula a contagem de sono.
                 */
                System.out.println(nome + " dormiu! (-_-) zZzZz");
                idade = idade + 1;
                ficarAcordado = 0;
            }
            else if (opcao == 2){
                /*
                 * Se a opção escolhida for 2, imprime a mensagem de que o Tamagotchi permanecerá acordado
                 * e acrescenta 1 à contagem de dias em que ele está acordado.
                 */
                System.out.println(nome + " ficou acordado (>_<)");
                ficarAcordado = ficarAcordado + 1;
            }
        }
        
        else{
            /*
             * Se a contagem de dias em que o Tamagotchi está acordado for maior ou igual a 5,
             * ele automaticamente dorme, anula a contagem de dias acordado e tem a sua idade
             * aumentada em 1.
             */
            System.out.println(nome + " desmaiou de sono! (-_-) zZzZz");
            idade = idade + 1;
            ficarAcordado = 0;
        }
    }
    
    /*
     * Método que simula o estado de fome do Tamagotchi e as suas reações às escolhas feitas pelo usuário
     * (alimentar muito o tamagotchi, alimentar pouco ou não alimentar ele).
     */
    public void sentirFome(){
        /*
         * Imprime a mensagem de que o Tamagotchi está com fome e dá três opções de ação ao usuário.
         */
        System.out.println(nome + " está faminto! (>_<)");
        System.out.println("1 - Comer muito");
        System.out.println("2 - Comer pouco");
        System.out.println("3 - Não comer");
        
        int opcao = Teclado.leInt();
        /*Cria a variável "opcao", chama a classe Teclado e o método leInt para receber o valor digitado pelo usuário.*/
        
        if (opcao == 1){
            /*
             * Se a opção escolhida for 1, imprime a mensagem de que o Tamagotchi comeu muito e engordou 5kg.
             * Além disso, aumenta a contagem de dias acordado em 5, chamando o método sentirSono
             * e fazendo com que ele durma logo em seguida.
             */
            System.out.println(nome + " comeu demais e engordou 5kg!");
            peso = peso + 5;
            ficarAcordado = 5;
            sentirSono();
        }
        else if (opcao == 2){
            /*
             * Se a opção escolhida for 2, imprime a mensagem de que o tamagotchi comeu pouco e engordou apenas 1kg.
             */
            System.out.println(nome + " comeu só um pouquinho e engordou 1kg!");
            peso = peso + 1;
        }
        else{
            /*
             * Se a opção escolhida for 3, o Tamagotchi não é alimentado e emagrece 2kg.
             */
            System.out.println(nome + " não se alimentou e emagreceu 2kg!");
            peso = peso - 2;
        }
    }
    
    /*
     * Método que simula o estado de tédio do Tamagotchi e as suas reações às escolhas feitas pelo usuário
     * (fazer com que o tamagotchi corra por 10 minutos ou que ele caminhe por 10 minutos).
     */
    public void ficarEntediado(){
        System.out.println(nome +" está entediado! (>_<)");
        System.out.println("1 - Correr 10 minutos");
        System.out.println("2 - Caminhar 10 minutos");
        
        int opcao = Teclado.leInt();
        /*Cria a variável "opcao", chama a classe Teclado e o método leInt para receber o valor digitado pelo usuário.*/
        
        if (opcao == 1){
            /*
             * Se a opção escolhida for 1, informa o usuário de que o Tamagotchi correu, perdeu 4kg
             * e se ele morreu (peso<0) ou permaneceu vivo (peso = peso + 5)
             */
            System.out.println(nome + " correu durante 10min,");
            System.out.println("perdeu 4kg...");
            peso = peso - 4;
            if (peso < 1){
                /*
                 * Se o peso do Tamagotchi for menor do que 1 após ele correr, o método estadoTamagotchi é chamado para informar
                 * que ele morreu de fome.
                 */
                estadoTamagotchi();
            }
            else{
                /*
                 * Se o peso do Tamagotchi for maior ou igual a 1, é impressa na tela a mensagem de que ele comeu muito,
                 * aumentou seu peso em 5, aumenta a contagem do método ficarAcordado em 5 e chama o método sentirSono
                 * logo em seguida.
                 */
                System.out.println("e comeu muito! (^o^)/");
                peso = peso + 5;
                estadoTamagotchi();
                ficarAcordado = ficarAcordado + 5;
                sentirSono();
            }
        }
        
        else{
            /*
             * Se a escolha do usuário for 2, imprime a mensagem de que o Tamagotchi caminhou e chama o método sentirFome.
             */
            System.out.println(nome +" caminhou por 10min e ficou com fome! (>_<)");
            sentirFome();
        }
    }
}