package br.com.casadocodigo.jumperlivro.engine;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Diego on 02/02/2016.
 */
public class Tela {
    private DisplayMetrics metrics;
    public Tela(Context context){
        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        this.metrics = new DisplayMetrics();
        display.getMetrics(this.metrics);

    }
    public int getAltura(){
        return  this.metrics.heightPixels;

    }
}
