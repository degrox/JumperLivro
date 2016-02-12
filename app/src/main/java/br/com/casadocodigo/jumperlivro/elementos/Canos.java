package br.com.casadocodigo.jumperlivro.elementos;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.com.casadocodigo.jumperlivro.engine.Tela;

/**
 * Created by Diego on 03/02/2016.
 */
public class Canos {
    private Context context;
    private final Pontuacao pontuacao;
    private Tela tela;

    private static final int QUANTIDADE_DE_CANOS = 5;
    private static final int DISTANCIA_ENTRE_CANOS =250;
    private final List<Cano> canos = new ArrayList<Cano>();


    public boolean temColisaoCom(Passaro passao){
        for(Cano cano: this.canos){
            ///verificar se tem colisão
            if(cano.cruzouHorizontalmenteComPassaro()&&cano.cruzouVerticalmenteCom(passao)){
                return true;

            }
        }
        return false;

    }
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


    public Canos (Context context,Tela tela, Pontuacao pontuacao){
        this.context=context;
        this.tela = tela;
        this.pontuacao=  pontuacao;
        int posicao = 200;

        for (int i=0; i<QUANTIDADE_DE_CANOS; i++){
            posicao+=DISTANCIA_ENTRE_CANOS;
            this.canos.add(new Cano(context,tela,posicao));

        }

    }

    public void move() {
        ListIterator<Cano> iterator = this.canos.listIterator();
        while(iterator.hasNext()){
            Cano cano =(Cano) iterator.next();
            cano.move();
            if (cano.saiuDaTela()) {

                //criação do método
                this.pontuacao.aumenta();
                //
                iterator.remove();
                Cano outroCano = new Cano(this.context,this.tela, maiorPosicao()+DISTANCIA_ENTRE_CANOS);
                iterator.add(outroCano);
            }

        }
    }

}
