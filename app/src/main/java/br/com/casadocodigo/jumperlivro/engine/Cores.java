package br.com.casadocodigo.jumperlivro.engine;

import android.graphics.Paint;
import android.graphics.Typeface;

import java.lang.reflect.Type;

/**
 * Created by Diego on 01/02/2016.
 */
public class Cores {

    public static Paint getCorDoGameOver(){
        Paint vermelho = new Paint();
        vermelho.setColor(0xFFFF0000);
        vermelho.setTextSize(50);
        vermelho.setTypeface(Typeface.DEFAULT_BOLD);
        vermelho.setShadowLayer(2,3,3,0xFF000000);
        return vermelho;

    }

    public static Paint getCorDaPontuacao(){
        int desloSombraBaixo =5;
        int desloSombraDireita =5;
        int borda =3;
        Paint branco = new Paint();
        branco.setColor(0xFFFFFFFF);
        branco.setTextSize(80);
        branco.setTypeface(Typeface.DEFAULT_BOLD);
        branco.setShadowLayer(borda,desloSombraBaixo,desloSombraDireita,0xFF000000);
        return branco;

    }

    public static Paint getCorPassaro(){
        Paint vermelho = new Paint();
        vermelho.setColor(0xFFFF0000);
        return vermelho;

    }

        public static Paint getCorDoCano(){
            Paint verde = new Paint();
            verde.setColor(0xFF00FF00);
            return verde;

        }

}
