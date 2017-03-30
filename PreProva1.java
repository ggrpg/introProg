
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

/**
 *
 * @author Murillo Bonson
 */
public class PreProva1 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        int trilha = 0; //variavel auxiliar para definir se está no começo da trilha
        int dirX = 0;
        int dirY = 0;
        int fimA = 0;
        int fimN = 0;
        int countA = 0;
        int countN = 0;
        float soma = 0;
        float med;
                
                
        //deslocar para ponto de partida
        while(!ehFim(ESQUERDA)) 
            andarEsquerda();
        while(!ehFim(ACIMA))
            andarAcima();
        //fim do deslocamento inicial
        
        
        //percorrer todo o mapa
        while(!ehFim(ABAIXO) && trilha!=1){ 
            if(ehObjetoDoMundoTipo("Alien", AQUIMESMO)){ //testa se encontrou a trilha
                int pathFinder = 0;
                
                if(ehVazio(ESQUERDA))
                    pathFinder++;
                if(ehVazio(ACIMA))
                    pathFinder++;
                if(ehVazio(DIREITA))
                    pathFinder++;
                if(ehVazio(ABAIXO))
                    pathFinder++;
                if(pathFinder==3){
                trilha=1;
                diga("encontrei começo da trilha");
                countA++;
                }// fim do teste da trilha
            }
            while(!ehFim(DIREITA) && trilha !=1){
                andarDireita();
            
                if(ehObjetoDoMundoTipo("Alien", AQUIMESMO)){//teste da trilha
                int pathFinder = 0;
                
                if(ehVazio(ESQUERDA))
                    pathFinder++;
                if(ehVazio(ACIMA))
                    pathFinder++;
                if(ehVazio(DIREITA))
                    pathFinder++;
                if(ehVazio(ABAIXO))
                    pathFinder++;
                if(pathFinder==3){
                trilha=1;
                diga("encontrei começo da trilha");
                countA++;
                }
                }// fim do teste da trilha
            }
                
            if(trilha !=1 && !ehFim(ABAIXO)){
                andarAbaixo();
                if(ehObjetoDoMundoTipo("Alien", AQUIMESMO)){//teste da trilha
                    int pathFinder = 0;
                    
                    if(ehVazio(ESQUERDA))
                        pathFinder++;
                    if(ehVazio(ACIMA))
                        pathFinder++;
                    if(ehVazio(DIREITA))
                        pathFinder++;
                    if(ehVazio(ABAIXO))
                        pathFinder++;
                    if(pathFinder==3){
                        trilha=1;
                        diga("encontrei começo da trilha");
                        countA++;
                    }
                }// fim do teste da trilha
            } 
            
                
            while(!ehFim(ESQUERDA) && trilha !=1){
                andarEsquerda();
                if(ehObjetoDoMundoTipo("Alien", AQUIMESMO)){//teste da trilha
                int pathFinder = 0;
                
                if(ehVazio(ESQUERDA))
                    pathFinder++;
                if(ehVazio(ACIMA))
                    pathFinder++;
                if(ehVazio(DIREITA))
                    pathFinder++;
                if(ehVazio(ABAIXO))
                    pathFinder++;
                if(pathFinder==3){
                trilha=1;
                diga("encontrei começo da trilha");
                countA++;
                }
            } // fim do teste da trilha
            }
            if(trilha !=1 && !ehFim(ABAIXO)){
                andarAbaixo();
                if(ehObjetoDoMundoTipo("Alien", AQUIMESMO)){ //teste da trilha
                    int pathFinder = 0;
                    
                    if(ehVazio(ESQUERDA))
                        pathFinder++;
                    if(ehVazio(ACIMA))
                        pathFinder++;
                    if(ehVazio(DIREITA))
                        pathFinder++;
                    if(ehVazio(ABAIXO))
                        pathFinder++;
                    if(pathFinder==3){
                        trilha=1;
                        diga("encontrei começo da trilha");
                        countA++;
                    }
                } //// fim do teste da trilha
            } 
        } //fim de percorrer todo mapa
            
       
        //caminhar pela trilha 1
        while(!ehVazio(AQUIMESMO) && fimA!=1){
            dirX = 0; //debug de direção
            dirY = 0; //debug de direção
            
            //bloco trilha dos aliens
            while(ehObjetoDoMundoTipo("Alien",DIREITA) && dirX !=2){
                andarDireita();
                dirX = 1;
                if(ehObjetoDoMundoTipo("Alien", AQUIMESMO))
                    countA++;
            }
            
            while(ehObjetoDoMundoTipo("Alien",ESQUERDA) && dirX !=1){
                andarEsquerda();
                dirX = 2;
                if(ehObjetoDoMundoTipo("Alien", AQUIMESMO))
                    countA++;
            }
            
            while(ehObjetoDoMundoTipo("Alien",ACIMA) && dirY !=2){
                andarAcima();
                dirY = 1;
                if(ehObjetoDoMundoTipo("Alien", AQUIMESMO))
                    countA++;
            }
            while(ehObjetoDoMundoTipo("Alien",ABAIXO) && dirY !=1){
                andarAbaixo();
                dirY = 2;
                if(ehObjetoDoMundoTipo("Alien", AQUIMESMO))
                    countA++;                
            } //fim dos aliens
            if(ehObjetoDoMundoTipo("Numero", ABAIXO))
                fimA=1;
            if(ehObjetoDoMundoTipo("Numero", ACIMA))
                fimA=1;
            if(ehObjetoDoMundoTipo("Numero", DIREITA))
                fimA=1;
            if(ehObjetoDoMundoTipo("Numero", ESQUERDA))
                fimA=1;
        } //fim caminhar pela trilha 
            
        //caminhar pela trilha 2
        while(!ehVazio(AQUIMESMO) && fimN!=1){
            dirX = 0; //debug de direção
            dirY = 0; //debug de direção
                
            //bloco trilha dos numeros
             while(ehObjetoDoMundoTipo("Numero",DIREITA) && dirX !=2){
                andarDireita();
                dirX = 1;
                if(ehObjetoDoMundoTipo("Numero", AQUIMESMO)){ //pegar valores
                    Numero num = getObjeto(AQUIMESMO);
                    soma = soma + num.getValor();
                    countN++;
                }
                if(ehObjetoDoMundoTipo("Numero", AQUIMESMO)){ //teste da trilha
                    int pathFinder = 0;
                    
                    if(ehVazio(ESQUERDA))
                        pathFinder++;
                    if(ehVazio(ACIMA))
                        pathFinder++;
                    if(ehVazio(DIREITA))
                        pathFinder++;
                    if(ehVazio(ABAIXO))
                        pathFinder++;
                    if(pathFinder==3){
                        fimN=1;
                        diga("encontrei o final da trilha");
                        
                    }
                }// fim do teste da trilha
                   
            }
            
            while(ehObjetoDoMundoTipo("Numero",ESQUERDA) && dirX !=1){
                andarEsquerda();
                dirX = 2;
                if(ehObjetoDoMundoTipo("Numero", AQUIMESMO)){ //pegar valores
                    Numero num = getObjeto(AQUIMESMO);
                    soma = soma + num.getValor();
                    countN++;
                }
                if(ehObjetoDoMundoTipo("Numero", AQUIMESMO)){ //teste da trilha
                    int pathFinder = 0;
                    
                    if(ehVazio(ESQUERDA))
                        pathFinder++;
                    if(ehVazio(ACIMA))
                        pathFinder++;
                    if(ehVazio(DIREITA))
                        pathFinder++;
                    if(ehVazio(ABAIXO))
                        pathFinder++;
                    if(pathFinder==3){
                        fimN=1;
                        diga("encontrei o final da trilha");
                    }
                }// fim do teste da trilha
            }
            
            while(ehObjetoDoMundoTipo("Numero",ABAIXO) && dirY !=1){
                andarAbaixo();
                dirY = 2;
                if(ehObjetoDoMundoTipo("Numero", AQUIMESMO)){
                    Numero num = getObjeto(AQUIMESMO);
                    soma = soma + num.getValor();
                    countN++;
                }
                if(ehObjetoDoMundoTipo("Numero", AQUIMESMO)){ //teste da trilha
                    int pathFinder = 0;
                    
                    if(ehVazio(ESQUERDA))
                        pathFinder++;
                    if(ehVazio(ACIMA))
                        pathFinder++;
                    if(ehVazio(DIREITA))
                        pathFinder++;
                    if(ehVazio(ABAIXO))
                        pathFinder++;
                    if(pathFinder==3){
                        fimN=1;
                        diga("encontrei o final da trilha");
                    }
                }// fim do teste da trilha
            }
            
            while(ehObjetoDoMundoTipo("Numero",ACIMA) && dirY !=2){
                andarAcima();
                dirY = 1;
                if(ehObjetoDoMundoTipo("Numero", AQUIMESMO)){ //pegar valores
                    Numero num = getObjeto(AQUIMESMO);
                    soma = soma + num.getValor();
                    countN++;
                }
                if(ehObjetoDoMundoTipo("Numero", AQUIMESMO)){ //teste da trilha
                    int pathFinder = 0;
                    
                    if(ehVazio(ESQUERDA))
                        pathFinder++;
                    if(ehVazio(ACIMA))
                        pathFinder++;
                    if(ehVazio(DIREITA))
                        pathFinder++;
                    if(ehVazio(ABAIXO))
                        pathFinder++;
                    if(pathFinder==3){
                        fimN=1;
                        diga("encontrei o final da trilha");
                    }
                }// fim do teste da trilha
            }
            
            
        }
        //fim de caminhar pela trilha
        
        //informações finais
        med = soma/countN;
        diga("Encontrei " + countA + " Aliens e a média de números é: " + med);
        
        
        
        
        
    }//fim da inteligencia
    
    public static void main(String[] args) {
        MundoVisual.iniciar("PreProva1.xml");
    }
}
