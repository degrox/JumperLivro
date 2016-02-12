package br.com.casadocodigo.jumperlivro.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.view.SoundEffectConstants;

import br.com.casadocodigo.jumperlivro.R;

/**
 * Created by Diego on 12/02/2016.
 */
public class Som {
    public static int COLISAO;
    public static int PONTUACAO;
    private SoundPool soundPool;
    public static int PULO;

    public Som(Context context){
        this.soundPool=new SoundPool(3, AudioManager.STREAM_MUSIC,0);
        PULO=this.soundPool.load(context, R.raw.pulo,1);

        PONTUACAO=this.soundPool.load(context,R.raw.pontos,1);
        COLISAO=this.soundPool.load(context,R.raw.colisao,1);

    }
    public void toca (int som){
        this.soundPool.play(som,1,1,1,0,1);

    }

}
