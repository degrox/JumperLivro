package br.com.casadocodigo.jumperlivro.elementos;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.casadocodigo.jumperlivro.engine.Cores;

/**
 * Created by Diego on 11/02/2016.
 */
public class Pontuacao {
    private static final Paint BRANCO = Cores.getCorDaPontuacao();
    private int pontos = 0;

    public void aumenta(){
        this.pontos++;

    }

    public void desenhaNo(Canvas canvas){
        String textoASerEscrito = String.valueOf(this.pontos);
        int CordXObjeto=100;
        int CordYObjeto=100;

        canvas.drawText(textoASerEscrito,CordXObjeto,CordYObjeto,BRANCO);

    }

}
