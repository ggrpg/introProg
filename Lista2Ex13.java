/*
(Mundo: 4 x 8, Robô: 0 x 0, Aliens: até 3) Faça o robô andar até a última coluna, na linha
em que nasceu, contando os aliens. No final deve falar a quantidade de aliens encontrados.
Atenção: não esqueça do tratamento do singular e plural. Se for mais que 1 alien, ele deve
dizer "aliens".

*/
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;



public class Lista2Ex13 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        int count = 0;
        
        while (!ehFim(DIREITA)){
            andarDireita();
            if(ehObjetoDoMundoTipo("Alien", AQUIMESMO)){
                count++;
            }
                   
        }
        if(count==0)
                diga("não há aliens");
            else
                if(count==1)
                    diga("encontrei um alien");
            else
                    diga("encontrei " + count + " aliens");
        
        }
    
    public static void main(String[] args) {
        MundoVisual.iniciar("Lista2Ex13.xml");
    }
    
}
