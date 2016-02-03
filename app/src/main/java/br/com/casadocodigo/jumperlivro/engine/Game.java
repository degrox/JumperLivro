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
import br.com.casadocodigo.jumperlivro.elementos.Passaro;

/**
 * Created by Diego on 01/02/2016.
 */
public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private Bitmap background;
    private Tela tela;
    private Passaro passaro;
    private final SurfaceHolder holder = getHolder();
    private boolean estaRodando = true;

    public boolean onTouch(View v, MotionEvent event){
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
        Bitmap back = BitmapFactory.decodeResource(getResources(),R.drawable.background );
        this.background = Bitmap.createScaledBitmap(back, back.getWidth(), tela.getAltura(), false);

        //this.background =BitmapFactory.decodeResource(getResources(), R.drawable.background); desenhava o background no formato original

        //inicialização do passaro.
        this.passaro = new Passaro();
    }
    public void run() {
        while (this.estaRodando) {
            if(!this.holder.getSurface().isValid()) continue;
            Canvas canvas = this.holder.lockCanvas();
            canvas.drawBitmap(this.background,0,0, null);
            //código de desenho do pássaro.
            this.passaro.desenhaNo(canvas);
            this.passaro.cai();
            //Aqui vamos desenhas os elementos do jogo
            this.holder.unlockCanvasAndPost(canvas);
        }
    }


}



