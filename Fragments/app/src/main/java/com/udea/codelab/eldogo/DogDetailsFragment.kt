package com.udea.codelab.eldogo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.udea.codelab.eldogo.databinding.FragmentDogDetailsBinding

//Declaracion de DogDetailsFragment como subclase de Fragment
class DogDetailsFragment :  Fragment() {


    companion object {
        private const val DOGMODEL = "model"

        fun newInstance(dogModel: DogModel): DogDetailsFragment {
            val args = Bundle()
            args.putSerializable(DOGMODEL, dogModel)
            val fragment = DogDetailsFragment()
            fragment.arguments = args
            return fragment
        }

    }

    //Creacion de la vista para el Fragment
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflamos la vista
        val fragmentDogDetailsBinding =
            FragmentDogDetailsBinding.inflate(inflater, container, false)

        //Obtenemos el DogModel de los argumentos
        val model = arguments!!.getSerializable(DOGMODEL) as DogModel

        //Vinculacion
        fragmentDogDetailsBinding.dogModel = model
        model.text = String.format(getString(R.string.description_format),
            model.description, model.url)
        return fragmentDogDetailsBinding.root

    }

}
