package br.com.casadocodigo.jumperlivro.elementos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.casadocodigo.jumperlivro.R;
import br.com.casadocodigo.jumperlivro.engine.Cores;
import br.com.casadocodigo.jumperlivro.engine.Som;
import br.com.casadocodigo.jumperlivro.engine.Tela;
import br.com.casadocodigo.jumperlivro.engine.Tempo;

/**
 * Created by Diego on 01/02/2016.
 */
public class Passaro {
    public static final int DESLOCAMENTO_DO_PULO=20;
    private Tempo tempo;
    private Som som;
    private final Bitmap passaro;
    private static final Paint VERMELHO= Cores.getCorPassaro();
    public static final int X = 100;
    public static final int RAIO = 50;
    private int altura;
    private Tela tela;


    public Passaro(Context context, Tela tela,Som som,Tempo tempo){
            this.som=som;
            this.tela=tela;
            this.altura=tela.getAltura()/2;
            this.tempo=tempo;
        //atribuições
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        this.passaro=Bitmap.createScaledBitmap(bp, RAIO * 2, RAIO * 2, false);
    }

    public int getAltura(){
        return this.altura;
    }
    public void voa(){
        double tempo = this.tempo.atual();
        double novaAltura = -DESLOCAMENTO_DO_PULO+ ((10*(tempo*tempo))/2.0);

        boolean chegouNoChao = this.altura + RAIO > tela.getAltura();

        if(!chegouNoChao){
            this.altura+=novaAltura;
        }
    }
    public void pula(){
        if(this.altura> RAIO) {
            this.som.toca(Som.PULO);
            this.tempo.reinicia();
            //this.altura -= 150;
        }
    }




    public void desenhaNo(Canvas canvas){
        canvas.drawBitmap(this.passaro, X - RAIO, this.altura - RAIO, null);
        //canvas.drawCircle(X, this.altura, RAIO,VERMELHO);
    }
}
