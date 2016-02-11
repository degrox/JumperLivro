package br.com.casadocodigo.jumperlivro.elementos;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.com.casadocodigo.jumperlivro.engine.Tela;

/**
 * Created by Diego on 03/02/2016.
 */
public class Canos {
    private Tela tela;

    private static final int QUANTIDADE_DE_CANOS = 5;
    private static final int DISTANCIA_ENTRE_CANOS =250;
    private final List<Cano> canos = new ArrayList<Cano>();


    public int maiorPosicao(){
        //
        int maximo = 0;
        for(Cano cano: this.canos) {
            maximo = Math.max(cano.getPosicao(), maximo);
        }
            return maximo;
    }


    public void desenhaNo(Canvas canvas){
        for (Cano cano : this.canos)
            cano.desenhaNo(canvas);

    }


    public Canos (Tela tela){
        this.tela = tela;
        int posicao = 200;

        for (int i=0; i<QUANTIDADE_DE_CANOS; i++){
            posicao+=DISTANCIA_ENTRE_CANOS;
            this.canos.add(new Cano(tela,posicao));

        }

    }

    public void move() {
        ListIterator<Cano> iterator = this.canos.listIterator();
        while(iterator.hasNext()){
            Cano cano =(Cano) iterator.next();
            cano.move();
            if (cano.saiuDaTela()) {

                //
                iterator.remove();
                Cano outroCano = new Cano(this.tela, maiorPosicao()+DISTANCIA_ENTRE_CANOS);
                iterator.add(outroCano);
            }

        }
    }

}
