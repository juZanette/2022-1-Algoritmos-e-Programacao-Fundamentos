/*
 * Código criado por Júlia Faccio Zanette
/*
 * Classe ControleTeleSena, responsável pelos métodos de gerenciamento das Telesenas vendidas, prêmio, 
 * sorteio dos números, e um array de Pessoa, que possui 20 posições.
 */
public class ControleTeleSena{
    private static Pessoa pessoas[] = new Pessoa[20];
    private static int numerosPremiados[] = new int[60];
    private static int quantidadeTeleSenasVendidas;
    private static int quantidadeGanhadores;
    private static double premioPorGanhador;
    public static double silvioSantos;
    
    public static Pessoa[] getPessoa(){             //Cria o método Pessoa
        return pessoas;
    }
    
    public static void addPessoa(Pessoa pessoa){            // Esse método adiciona uma pessoa ao próximo espaço vaio disponível em memória
        int i=0;
        while(i<pessoas.length){
            if(pessoas[i] == null){
                pessoas[i] = pessoa;
                break;
            }
            i++;
        }
        
        /*
         * Essa parte do código é responsável por impedir que um novo usuário seja adicionado se o limite já estiver cheio.
         */
        if(i == pessoas.length){
            System.out.println("O número máximo de pessoas permitidas já foi atingido!");
        }
    }
    
    /*
     * Os quatro Métodos Get a seguir substituem o valor do atributo nome
     */
    public static int[] getNumerosPremiados(){
        return numerosPremiados;
    }  
    public static int getQuantidadeTeleSenasVendidas(){
        return quantidadeTeleSenasVendidas;
    }
    public static int getQuantidadeGanhadores(){
        return quantidadeGanhadores;
    }
    public static double getPremioPorGanhador(){
        return premioPorGanhador;
    }
    public static double getSilvioSantos(){
        return silvioSantos;
    }
        
    //Método que exibe quais foram os números sorteados da vez
    public static void imprimeNumerosPremiados(){
        for(int i=0; i<numerosPremiados.length; i++){
            if(numerosPremiados[i]!=0){
                System.out.print(String.format("%2d ",i+1));
            }
        }
    }
    
    //Método que busca o nome fictício do usuário e exibe ele(s)
    public static void imprimeGanhadores(){
        for(int i=0; i<pessoas.length; i++){
            if(pessoas[i].getPremiada()){
                System.out.print(ControleTeleSena.getPessoa()[i].getNome() + " ");
            }
        }
    }

    /*
     * Nesse método, a Tele Sena vai sendo vendida, até que seja atngido o limite do cliente.
     */
    public static void vendeTeleSenas(){
        for(int i=0; i<pessoas.length; i++){
            for(int j=0; j<pessoas[i].getQuantidadeTeleSenasCompradas(); j++){
                TeleSena teleSena = new TeleSena(sorteiaConjuntoDeNumeros(),sorteiaConjuntoDeNumeros());
                pessoas[i].addTeleSena(teleSena);
                quantidadeTeleSenasVendidas++;
            }
        }
    }
    
    //Método para sortear aleatóriamente todos os números necessários
    private static int[] sorteiaConjuntoDeNumeros(){
        int conjunto[] = new int[60], numero, i=0;
        
        while(i<25){
            numero = (int)(Math.random() * 60 + 1);
            if(conjunto[numero-1] == 0){
                conjunto[numero-1] = 1;
                i++;
            }
        }
        return conjunto;
    }
   
    public static void realizaSorteio(){
        //Sorteia os números premiados
        numerosPremiados = sorteiaConjuntoDeNumeros();
        
        boolean houveUmGanhador = false, numeroNaoSorteado = false;
        int numero;
        
        while(!houveUmGanhador){
            //Percorre o array dos número sorteados, sendo i um número sorteado
            for(int i=0; i<numerosPremiados.length; i++){
                //Realiza a verificação para os números que foram sorteados, sendo i um número sorteado
                if(numerosPremiados[i]==1){
                    //Percorre as pessoas
                    for(int j=0; j<pessoas.length; j++){
                        //Percorre as Tele Senas compradas por cada pessoa
                        for(int k=0; k<pessoas[j].getQuantidadeTeleSenasCompradas(); k++){
                            //Se o número sorteado i está no conjunto 1, aumenta o contador de números sorteados
                            if(pessoas[j].getTeleSena()[k].getNumeroConjunto1()[i] == 1){
                                pessoas[j].getTeleSena()[k].incrementaNumSorteados1();
                            }
                            //Se o número sorteado i está no conjunto 2, aumenta o contador de números sorteados
                            if(pessoas[j].getTeleSena()[k].getNumeroConjunto2()[i] == 1){
                                pessoas[j].getTeleSena()[k].incrementaNumSorteados2();
                            }
                            //Verifica alguém ganhou
                            if(pessoas[j].getTeleSena()[k].getNumSorteados1()==25 || pessoas[j].getTeleSena()[k].getNumSorteados2()==25){
                                houveUmGanhador = true;
                                pessoas[j].setPremiada();
                            }
                        }
                    }
                }
            }
            
            //Se ainda não houve um ganhador, mais números devem ser sorteados
            if(!houveUmGanhador){
                numeroNaoSorteado = false;
                while(!numeroNaoSorteado){
                    numero = (int)(Math.random() * 60 + 1);
                    if(numerosPremiados[numero-1] == 0){
                        numerosPremiados[numero-1] = 1;
                        numeroNaoSorteado = true;
                    }
                }
                
                //Zera os contadores de números sorteados de todas as Tele Senas, pois será conferido tudo novamente
                for(int j=0; j<pessoas.length; j++){
                    //Percorre as Tele Senas compradas por cada pessoa
                    for(int k=0; k<pessoas[j].getQuantidadeTeleSenasCompradas(); k++){
                        pessoas[j].getTeleSena()[k].zeraNumerosSorteados();
                    }
                }
            }
        }
    }
    
    public static void realizaDistribuicaoPremiacoes(){
        //Conta quantos ganhadores tiveram
        for(int i=0; i<pessoas.length; i++){
            if(pessoas[i].getPremiada()){
                quantidadeGanhadores++;
            }
        }
        //Divide o prêmio igualmente entre os ganhadores
        premioPorGanhador = quantidadeTeleSenasVendidas * 8 / quantidadeGanhadores;
        for(int i=0; i<pessoas.length; i++){
            if(pessoas[i].getPremiada()){
                pessoas[i].setPremio(premioPorGanhador);
            }
        }
        silvioSantos = quantidadeTeleSenasVendidas * 2;
    }
}