package br.com.casadocodigo.jumperlivro.engine;

import br.com.casadocodigo.jumperlivro.elementos.Canos;
import br.com.casadocodigo.jumperlivro.elementos.Passaro;

/**
 * Created by Diego on 12/02/2016.
 */
public class VerificadorDeColisao {
    private final Passaro passaro;
    private final Canos canos;

    public boolean temColisao(){
        return canos.temColisaoCom(passaro);
    }
    public VerificadorDeColisao(Passaro passaro, Canos canos){
        this.passaro = passaro;
        this.canos = canos;


    }

}
