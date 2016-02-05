package br.com.casadocodigo.jumperlivro.elementos;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.casadocodigo.jumperlivro.engine.Cores;
import br.com.casadocodigo.jumperlivro.engine.Tela;

/**
 * Created by Diego on 01/02/2016.
 */
public class Passaro {
    private static final Paint VERMELHO= Cores.getCorPassaro();
    private static final int X = 100;
    private static final int RAIO = 50;
    private int altura;
    private Tela tela;


    public void cai(){


        boolean chegouNoChao = this.altura + RAIO > tela.getAltura();

        if(!chegouNoChao){
            this.altura+=5;

        }

    }
    public void pula(){
        if(this.altura> RAIO) {
            this.altura -= 150;
        }
    }



    public Passaro(Tela tela){

        this.tela=tela;
        this.altura=100;
    }
    public void desenhaNo(Canvas canvas){
        canvas.drawCircle(X, this.altura, RAIO,VERMELHO);
    }
}
