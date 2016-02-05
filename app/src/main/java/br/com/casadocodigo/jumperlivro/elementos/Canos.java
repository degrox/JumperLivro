package br.com.casadocodigo.jumperlivro.elementos;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

import br.com.casadocodigo.jumperlivro.engine.Tela;

/**
 * Created by Diego on 03/02/2016.
 */
public class Canos {
    private static final int QUANTIDADE_DE_CANOS = 5;
    private static final int DISTANCIA_ENTRE_CANOS =250;
    private final List<Cano> canos = new ArrayList<Cano>();

    public void desenhaNo(Canvas canvas){
        for (Cano cano : this.canos)
            cano.desenhaNo(canvas);

    }

    public void move(){
        for (Cano cano : this.canos)
            cano.move();

    }

    public Canos (Tela tela){
        int posicao = 200;

        for (int i=0; i<QUANTIDADE_DE_CANOS; i++){
            posicao+=DISTANCIA_ENTRE_CANOS;
            this.canos.add(new Cano(tela,posicao));

        }

    }

}
