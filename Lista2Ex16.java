
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

/**
 (Mundo 8 x 8, Robô: 0 x 0, Números: aleatórios) O robô passeia pelo modo tradicional.
Em cada linha ele soma os valores dos números, sempre iniciando em 0. Sempre que ele
chegar ao final da linha deve informar o valor total. No final ele precisa falar qual foi a linha
que teve a maior soma.
 * @author murillo
 */
public class Lista2Ex16 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
     int soma = 0;
       
     while(!ehFim(ABAIXO)){
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
        
        
            andarAbaixo();
        
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
         andarAbaixo();
     }
                while(!ehFim(ESQUERDA)){
                andarEsquerda();
                if(ehObjetoDoMundoTipo("Alien", AQUIMESMO))
                soma++;
            }
        diga("Soma da linha " + getY() + " = " + soma);
        
    }
    public static void main(String[] args) {
        MundoVisual.iniciar("Lista2Ex16.xml");
    }
}
