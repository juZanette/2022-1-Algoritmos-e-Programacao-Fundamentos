/*
 * Classe Tele Sena.
 * Nela, há o método de valor com o valor de venda de cada Tele Sena,e dois arrays, cada um com uma quantidade limite 
 * de números que cada Tele Sena tem.
 */
public class TeleSena{
    private static double preco;
    private int conjuntoNum1[] = new int[60];
    private int numSorteados1;
    private int conjuntoNum2[] = new int [60];
    private int numSorteados2;
    
    public TeleSena(int[] conjuntoNum1, int[] conjuntoNum2){            //Método construtor
        this.conjuntoNum1 = conjuntoNum1;
        this.conjuntoNum2 = conjuntoNum2;
        this.numSorteados1 = 0;
        this.numSorteados2 = 0;
        preco = 10;
    }
    
    public int getNumSorteados1(){                  //Método, devolve o valor do atributo nome
        return this.numSorteados1;
    }   
    public int getNumSorteados2(){                  //Método, devolve o valor do atributo nome
        return this.numSorteados2;
    }
    public int[] getNumeroConjunto1(){              //Método, devolve o valor do atributo nome
        return this.conjuntoNum1;
    }
    public int[] getNumeroConjunto2(){              //Método, devolve o valor do atributo nome
        return this.conjuntoNum2;
    }
    
    public void incrementaNumSorteados1(){          //Método que aumenta a contagem de números sorteados do conjunto 1 em +1
        this.numSorteados1++;
    }
    public void incrementaNumSorteados2(){          //Método que aumenta a contagem de números sorteados do conjunto 2 em +1
        this.numSorteados2++;
    }
    public void zeraNumerosSorteados(){             //Método que zera a contegem de números sorteados
        this.numSorteados1 = 0;
        this.numSorteados2 = 0;
    }
    
    public void imprimeTeleSena(){                  //Imprime na tela que o conjunto 1 foi sorteado, e quais foram os números
        System.out.print("Conjunto 1: ");
        for(int i=0; i<this.conjuntoNum1.length; i++){
            if(this.conjuntoNum1[i]!=0){
                System.out.print(String.format("%2d ",i+1));
            }
        }
        System.out.print("Conjunto 2: ");
        for(int i=0; i<this.conjuntoNum2.length; i++){
            if(this.conjuntoNum2[i]!=0){
                System.out.print(String.format("%2d ",i+1));
            }
        }
    }
}