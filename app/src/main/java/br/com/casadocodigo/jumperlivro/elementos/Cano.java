package br.com.casadocodigo.jumperlivro.elementos;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.casadocodigo.jumperlivro.engine.Cores;
import br.com.casadocodigo.jumperlivro.engine.Tela;

/**
 * Created by Diego on 03/02/2016.
 */
public class Cano {
    private static final Paint VERDE = Cores.getCorDoCano();
    private static final int TAMANHO_DO_CANO = 250;
    private static final int LARGURA_DO_CANO = 100;
    int alturaDoCanoInferior ;
    private Tela tela;
    private int posicao;

    public void move(){
        this.posicao-=5;

    }

    public Cano(Tela tela,int posicao){
        this.tela = tela;
        this.posicao = posicao;
        this.alturaDoCanoInferior= tela.getAltura()-TAMANHO_DO_CANO;

    }
    public void desenhaNo(Canvas canvas) {
        /// como será o desenho do cano

        desenhaCanoInferiorNo(canvas);

    }

    private void desenhaCanoInferiorNo(Canvas canvas) {
        canvas.drawRect( this.posicao,this.alturaDoCanoInferior,this.posicao+LARGURA_DO_CANO,this.tela.getAltura(),VERDE);

    }


}