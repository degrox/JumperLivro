package br.com.casadocodigo.jumperlivro.elementos;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import br.com.casadocodigo.jumperlivro.engine.Cores;
import br.com.casadocodigo.jumperlivro.engine.Tela;

/**
 * Created by Diego on 12/02/2016.
 */
public class GameOver {
    private final Tela tela;
    private static final Paint VERMELHO= Cores.getCorDoGameOver();


    public GameOver(Tela tela){
        this.tela = tela;

    }

    private int centralizaTexto(String texto){
        Rect limiteDoTexto = new Rect();
        VERMELHO.getTextBounds(texto,0,texto.length(),limiteDoTexto);
        int centroHorizontal = this.tela.getLargura()/2-(limiteDoTexto.right-limiteDoTexto.left)/2;
        return centroHorizontal;
    }

    public void desenhaNo(Canvas canvas){
        String gameOver = "Game Over";
        int centroHorizontal = centralizaTexto(gameOver);
        canvas.drawText(gameOver,centroHorizontal,tela.getAltura()/2,VERMELHO);


    }
}
