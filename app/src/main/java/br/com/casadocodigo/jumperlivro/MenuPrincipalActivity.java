package br.com.casadocodigo.jumperlivro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Katniss on 12/02/2016.
 */
public class MenuPrincipalActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
       // setContentView();

        TextView jogar = (TextView)findViewById(R.id.menu_principal_jogar);

        jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //// ação do click em Jogar
                Intent proximaActivity = new Intent(MenuPrincipalActivity.this,MainActivity.class);
                startActivity(proximaActivity);

            }
        });




    }
}
