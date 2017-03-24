/*
Faça o robô andar ao redor do
mundo e contar os aliens que ele encontrou no caminho. O robô deve voltar à célula de
nascença para então falar a quantidade de aliens encontrados.
*/
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;


public class Lista2Ex14 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        int count = 0;
        int passosE = 0;
        int passosA = 0;
        if(ehObjetoDoMundoTipo("Alien", AQUIMESMO))
            count++;
        
        while(!ehFim(ESQUERDA)){
            andarEsquerda();
            passosE++;
        }
        while(!ehFim(ACIMA)){
            andarAcima();
            passosA++;
        }
        
        while(!ehFim(ABAIXO)){
            while(!ehFim(DIREITA)){
            andarDireita();
            if(ehObjetoDoMundoTipo("Alien", AQUIMESMO))
                count++;
            }
        andarAbaixo();
        if(ehObjetoDoMundoTipo("Alien", AQUIMESMO))
                count++;
        while(!ehFim(ESQUERDA)){
            andarEsquerda();
            if(ehObjetoDoMundoTipo("Alien", AQUIMESMO))
                count++;
            }
        andarAbaixo();
        if(ehObjetoDoMundoTipo("Alien", AQUIMESMO))
            count++;
        }
        if(!ehFim(DIREITA))
            while(!ehFim(DIREITA)){
                andarDireita();
                if(ehObjetoDoMundoTipo("Alien", AQUIMESMO))
                count++;
            }
        else
            while(!ehFim(ESQUERDA)){
                andarEsquerda();
                if(ehObjetoDoMundoTipo("Alien", AQUIMESMO))
                count++;
            }
                
        while(!ehFim(ACIMA))
            andarAcima();
        while(!ehFim(ESQUERDA))
            andarEsquerda();
        
        while(passosA > 0){
            andarAbaixo();
            passosA--;
        }
        while (passosE > 0){
            andarDireita();
            passosE--;
        }
        diga("Encontrei " + count + " Aliens!");
        
        
    }
    public static void main(String[] args) {
        MundoVisual.iniciar("Lista2Ex14.xml");
    }
}
