/*
 * Código criado por Júlia Faccio Zanette
 *
 * A classe chamada "Principal" é pública, e contém o método que dá início ao programa desenvolvido (Tamagotchi)
 */
public class Principal{
    public static void main (String[] args){    //Método main, chama as informações necessárias para o programa começar
        
        Tamagotchi atual = new Tamagotchi("Bob", 0, 1); 
        /*Usando o método construtor, cria uma referência e envia essas informações (parâmetros) para o método*/
        
        boolean vivo = true;    //A variável "vivo", do tipo booleana, indica que o Tamagotchi deve começar como vivo
        
        /*
         * Enquanto o Tamagotchi estiver vivo, o "while(vivo)" chama os métodos "acaoTamagotchi" 
         * e "estadoTamagotchi"para sortear a ação do Tamagotchi e informar se ele está vivo ou não 
         * depois da última ação
         */
        while (vivo){   
            System.out.println("≧◠‿◠≦");
            /*Imprime uma mensagem de boas-vindas ao usuário*/
            
            atual.acaoTamagotchi();                      
            /*Chama o método "acaoTamagotchi" para sortear a próxima ação do Tamagotchi*/
            
            vivo = atual.estadoTamagotchi();
            /*Chama o método "estadotamagotchi" para comunicar se o valor da variável vivo continua
             * sendo true ou mudou para false*/
        }
    }
}
