/*
 * Classe Pessoa, que contém um método que recebe o nome da pessoa, cria um array de TeleSenas que a pessoa tem para concorrer ao prêmio
 * e uma certa quantia de premiação.
 */
public class Pessoa{
    private String nome;
    private int quantTeleSenasCompradas;
    private TeleSena teleSenas[] = new TeleSena[15];
    private boolean premiada;
    private double premio;
    
    public Pessoa(){
        
    }
        
    public Pessoa(String nome){     //Método construtor de Pessoa, que recebe um nome
        this.nome = nome;
    }
    
    public String getNome(){        //Método get, devolve o valor do atributo ao nome
        return this.nome;
    }
    public int getQuantidadeTeleSenasCompradas(){       //Método get, devolve o valor do atributo a quantTeleSenasCompradas
        return this.quantTeleSenasCompradas;
    }
    public boolean getPremiada(){       //Método get, devolve o valor do atributo a Premiada
        return this.premiada;
    }
    public double getPremio(){      //Método get, devolve o valor do atributo ao Premio
        return this.premio;
    }
    public TeleSena[] getTeleSena(){        //Método get, devolve o valor do atributo a TeleSena
        return this.teleSenas;
    }
    
    public void setNome(String nome){       //Método set, usado para mudar o valor do  atributo, pelo informado por parametro
        this.nome = nome;
    }
    public void setQuantidadeTeleSenasCompradas(int quantidade){        //Método set, usado para mudar o valor do  atributo, pelo informado por parametro
        this.quantTeleSenasCompradas = quantidade;
    }
    public void setPremiada(){      //Método set, usado para mudar o valor do  atributo, pelo informado por parametro
        this.premiada = true;
    }
    public void setPremio(double premio){       //Método set, usado para mudar o valor do atributo, pelo informado por parametro
        this.premio = premio;
    }
    

    /*
     * Método para adicionar uma nova TeleSena ou não, dependendo de quantas já foram adicionadas.
     */
    public void addTeleSena(TeleSena teleSena){
        int i=0;
        
        //Adiciona uma nova TeleSena se a contagem não tiver atingido o limite por pessoa.
        while(i<this.teleSenas.length){
            if(this.teleSenas[i] == null){
                this.teleSenas[i] = teleSena;
                break;
            }
            i++;
        }
        
        //Impede que uma nova TeleSena seja adicionada a uma determinada pessoa se o limite dela já foi atingido.
        if(i == this.teleSenas.length){
            System.out.println("Esta pessoa já atingiu o máximo de Tele Senas permitidas!");
        }
    }
}