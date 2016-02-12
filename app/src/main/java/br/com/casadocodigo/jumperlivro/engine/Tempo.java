package br.com.casadocodigo.jumperlivro.engine;

/**
 * Created by Diego on 12/02/2016.
 */
public class Tempo {
    private double atual;

    public void reinicia(){
        atual=0;
    }
    public void passa(){
        atual+=0.1;

    }
    public double atual(){
        return atual;

    }
}
