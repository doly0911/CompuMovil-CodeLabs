package com.udea.codelab.eldogo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

//Declaracion de DogDetailsFragment como subclase de Fragment
class DogDetailsFragment :  Fragment() {

    //Metodo para crear instancias de este Fragment (Factory Method)
    companion object {

        fun newInstance(): DogDetailsFragment {
            return DogDetailsFragment()
        }
    }

    //Creacion de la vista para el Fragment
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dog_details, container, false)
    }

}
