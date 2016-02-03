package br.com.casadocodigo.jumperlivro;


import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

import br.com.casadocodigo.jumperlivro.engine.Game;

public class MainActivity extends Activity {
    private Game game;



    protected void onResume(){
        super.onResume();
        this.game.inicia();
        new Thread(this.game).start();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout container = (FrameLayout) findViewById(R.id.container);
        this.game = new Game(this);
        container.addView(this.game);

    }

    protected void onPause(){
        super.onPause();
        this.game.cancela();

    }
}
