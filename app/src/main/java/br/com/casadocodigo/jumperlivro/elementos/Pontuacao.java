package br.com.casadocodigo.jumperlivro.elementos;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.casadocodigo.jumperlivro.engine.Cores;
import br.com.casadocodigo.jumperlivro.engine.Som;

/**
 * Created by Diego on 11/02/2016.
 */
public class Pontuacao {
    private Som som;
    private static final Paint BRANCO = Cores.getCorDaPontuacao();
    private int pontos = 0;

    public Pontuacao(Som som){
        this.som = som;

    }
    public void aumenta(){
        this.som.toca(Som.PONTUACAO);
        this.pontos++;

    }

    public void desenhaNo(Canvas canvas){
        String textoASerEscrito = String.valueOf(this.pontos);
        int CordXObjeto=100;
        int CordYObjeto=100;

        canvas.drawText(textoASerEscrito,CordXObjeto,CordYObjeto,BRANCO);

    }

}
