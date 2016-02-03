package br.com.casadocodigo.jumperlivro.engine;

import android.graphics.Paint;

/**
 * Created by Diego on 01/02/2016.
 */
public class Cores {

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
