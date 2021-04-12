package com.udea.codelab.eldogo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity(),  DogListFragment.OnDogSelected {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Es null para confirmar que se ha abierto por primera vez la pantalla
        //es decir que la actividad no tenga un estado guardado
        if (savedInstanceState == null) {

            //Como se usa fragmentos de soporte se hace referencia al FragmentManager asi:
            supportFragmentManager
                .beginTransaction()
                    //Se pasa el contenedor de las vistas y se agrean los fragments dinamicamente
                .add(R.id.root_layout, DogListFragment.newInstance(), "dogList")
                    //pide al FragmentManager ejecutar la transacción
                .commit()
        }
    }

    override fun onDogSelected(dogModel: DogModel) {

        val detailsFragment =
            DogDetailsFragment.newInstance(dogModel)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.root_layout, detailsFragment, "dogDetails")
            .addToBackStack(null)
            .commit()

    }

}