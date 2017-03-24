
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

public class Lista2Ex15 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        int soma = 0;
        
        while(!ehFim(DIREITA)){
            
            if(ehObjetoDoMundoTipo("Numero", DIREITA)){
                Numero num = getObjeto(DIREITA);
                soma = soma + num.getValor(); /* esse getValor é um metodo da 
                                                Classe Numero que converte o 
                                                numero no mundo visual em inteiro?*/
                
            }
            andarDireita();
        }
        diga("Soma da linha " + getY() + " = " + soma);
        
        while(!ehFim(ABAIXO)){
            andarAbaixo();
        }
         soma = 0;
         if(ehObjetoDoMundoTipo("Numero", AQUIMESMO)){
                Numero num = getObjeto(AQUIMESMO);
                soma = soma + num.getValor();
         }
        while(!ehFim(ESQUERDA)){
            if(ehObjetoDoMundoTipo("Numero", ESQUERDA)){
                Numero num = getObjeto(ESQUERDA);
                soma = soma + num.getValor();
            }
            andarEsquerda();
            
        }
        diga("Soma da linha " + getY() + " = " + soma);
        
    }
    
    public static void main(String[] args) {
        MundoVisual.iniciar("Lista2Ex15.xml");
    }
    
}
