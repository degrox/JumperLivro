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
import br.com.casadocodigo.jumperlivro.elementos.GameOver;
import br.com.casadocodigo.jumperlivro.elementos.Passaro;
import br.com.casadocodigo.jumperlivro.elementos.Pontuacao;

/**
 * Created by Diego on 01/02/2016.
 */
public class Game extends SurfaceView implements Runnable, View.OnTouchListener {
    private Tempo tempo;
    private Som som;
    private VerificadorDeColisao verificadorDeColisao;
    private Pontuacao pontuacao;

    //outros atributos
    private Canos canos;
    private Bitmap background;
    private Tela tela;
    private Passaro passaro;
    private Cano cano;
    private final SurfaceHolder holder = getHolder();
    private boolean estaRodando = true;
    private Context context;

    public Game(Context context) {

        super(context);
        this.context = context;
        setOnTouchListener(this);
        this.tela = new Tela(context);
        this.som = new Som(context);
        inicializaElementos();

    }

    private void inicializaElementos(){
        this.tempo = new Tempo();
        Bitmap back = BitmapFactory.decodeResource(getResources(),R.drawable.background );
        this.background = Bitmap.createScaledBitmap(back, back.getWidth(), tela.getAltura(), false);
        //inicialização do passaro.
        this.passaro=new Passaro(this.context,this.tela,this.som,this.tempo);
        this.pontuacao= new Pontuacao(this.som);
        this.canos = new Canos(this.context,this.tela, this.pontuacao);
        this.verificadorDeColisao = new VerificadorDeColisao(passaro,canos);

    }

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



    public void run() {
        while (this.estaRodando) {
            if(!this.holder.getSurface().isValid()) continue;
            Canvas canvas = this.holder.lockCanvas();
            this.tempo.passa();
            canvas.drawBitmap(this.background, 0, 0, null);
            //código de desenho do pássaro.
            this.passaro.desenhaNo(canvas);
            this.passaro.voa();

            //Aqui vamos desenhas os elementos do jogo
            //this.cano.desenhaNo(canvas);
            this.canos.desenhaNo(canvas);
            //this.cano.move();
            this.canos.move();
            this.pontuacao.desenhaNo(canvas);
            if(this.verificadorDeColisao.temColisao()){
                this.som.toca(Som.COLISAO);
                new GameOver(this.tela).desenhaNo(canvas);
                cancela();
            }

            this.holder.unlockCanvasAndPost(canvas);

        }
    }


}



