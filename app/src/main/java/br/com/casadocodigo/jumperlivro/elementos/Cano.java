package br.com.casadocodigo.jumperlivro.elementos;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.casadocodigo.jumperlivro.engine.Cores;
import br.com.casadocodigo.jumperlivro.engine.Tela;

/**
 * Created by Diego on 03/02/2016.
 */
public class Cano {
    private int alturaDoCanoSuperior;
    private static final Paint VERDE = Cores.getCorDoCano();
    private static final int TAMANHO_DO_CANO = 250;
    private static final int LARGURA_DO_CANO = 100;
    int alturaDoCanoInferior ;
    private Tela tela;
    private int posicao;


    public int getPosicao(){
        return this.posicao;

    }
    public boolean saiuDaTela(){
        return this.posicao +LARGURA_DO_CANO < 0 ;
    }

    public void move(){
        this.posicao-=5;

    }
    private int valorAleatorio(){
        return (int)(Math.random()*150);

    }

    public Cano(Tela tela,int posicao){
        this.tela = tela;
        this.posicao = posicao;
        this.alturaDoCanoInferior= tela.getAltura()-TAMANHO_DO_CANO-valorAleatorio();
        this.alturaDoCanoSuperior = 0+TAMANHO_DO_CANO+valorAleatorio();
    }
    public void desenhaNo(Canvas canvas) {
        /// como será o desenho do cano
        desenhaCanoSuperior(canvas);
        desenhaCanoInferiorNo(canvas);

    }
    private void desenhaCanoSuperior(Canvas canvas){
        canvas.drawRect(this.posicao,0,this.posicao+LARGURA_DO_CANO,this.alturaDoCanoSuperior,VERDE);

    }
    private void desenhaCanoInferiorNo(Canvas canvas) {
        canvas.drawRect( this.posicao,this.alturaDoCanoInferior,this.posicao+LARGURA_DO_CANO,this.tela.getAltura(),VERDE);

    }


}