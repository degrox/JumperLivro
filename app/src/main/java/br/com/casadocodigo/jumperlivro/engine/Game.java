package br.com.casadocodigo.jumperlivro.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import br.com.casadocodigo.jumperlivro.R;
import br.com.casadocodigo.jumperlivro.elementos.Cano;
import br.com.casadocodigo.jumperlivro.elementos.Canos;
import br.com.casadocodigo.jumperlivro.elementos.Passaro;
import br.com.casadocodigo.jumperlivro.elementos.Pontuacao;

/**
 * Created by Diego on 01/02/2016.
 */
public class Game extends SurfaceView implements Runnable, View.OnTouchListener {
    private Pontuacao pontuacao;

    //outros atributos
    private Canos canos;
    private Bitmap background;
    private Tela tela;
    private Passaro passaro;
    private Cano cano;
    private final SurfaceHolder holder = getHolder();
    private boolean estaRodando = true;

    public boolean onTouch(View v, MotionEvent event){
        this.passaro.pula();
        return false;

    }
    public void inicia(){
        this.estaRodando = true;

    }
    public void cancela(){
        this.estaRodando = false;
    }

    public Game(Context context) {

        super(context);
        setOnTouchListener(this);
        this.tela = new Tela(context);
        inicializaElementos();
    }
    private void inicializaElementos(){
        this.pontuacao = new Pontuacao();


        Bitmap back = BitmapFactory.decodeResource(getResources(),R.drawable.background );
        this.background = Bitmap.createScaledBitmap(back, back.getWidth(), tela.getAltura(), false);


        //inicialização do passaro.
        this.passaro = new Passaro(this.tela);

        this.pontuacao= new Pontuacao();
        this.canos = new Canos(tela, pontuacao);
    }
    public void run() {
        while (this.estaRodando) {
            if(!this.holder.getSurface().isValid()) continue;
            Canvas canvas = this.holder.lockCanvas();
            canvas.drawBitmap(this.background, 0, 0, null);
            //código de desenho do pássaro.
            this.passaro.desenhaNo(canvas);
            this.passaro.cai();
            this.pontuacao.desenhaNo(canvas);
            //Aqui vamos desenhas os elementos do jogo
            //this.cano.desenhaNo(canvas);
            this.canos.desenhaNo(canvas);
            //this.cano.move();
            this.canos.move();
            this.holder.unlockCanvasAndPost(canvas);
        }
    }


}



