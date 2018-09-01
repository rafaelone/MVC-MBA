package br.com.heiderlopes.primeiroprojeto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.Toast
import br.com.heiderlopes.primeiroprojeto.extensions.format
import br.com.heiderlopes.primeiroprojeto.utils.ConstantesExtra
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val peso = intent.extras.getString(ConstantesExtra.KEY_PESO)
        val altura = intent.extras.getString(ConstantesExtra.KEY_ALTURA)


        calcularIMC(peso.toDouble(), altura.toDouble())


    }

    private fun calcularIMC(peso: Double, altura: Double) {
        val imc = peso/(altura * altura)
        tvMVC.text = imc.format(0)

        if(imc < 17){
            setImagem(R.drawable.magreza)
            tvDescricao.text = getString(R.string.label_magreza)
        }else if(imc < 18.5){
            setImagem(R.drawable.abaixo)
            tvDescricao.text = getString(R.string.label_abaixo_peso)
        }else if( imc < 24.9 ){
            setImagem(R.drawable.ideal)
            tvDescricao.text = getString(R.string.label_peso_ideal)
        } else if( imc < 29.9){
            setImagem(R.drawable.sobre)
            tvDescricao.text = getString(R.string.label_sobrepeso)
        } else if ( imc < 34.9){
            setImagem(R.drawable.obesidade)
            tvDescricao.text = getString(R.string.label_obesidade1)
        }
        else if ( imc < 39.9){
            setImagem(R.drawable.obesidade)
            tvDescricao.text =getString(R.string.label_obesidade2)
        }else{
            setImagem(R.drawable.obesidade)
            tvDescricao.text = getString(R.string.label_obesidade3)

        }



    }

    private fun setImagem(resourceId: Int){
        ivMC.setImageDrawable(ContextCompat.getDrawable(this, resourceId))
    }
}

/*
*  when (imc){
            in 0..17 ->{}
            in 17.1..18.5 ->{}
            in 18.6..24.9 ->{}
            in 25.0..29.9 ->{}
            in 30.0..34.9 ->{}
            in 35.0..39.9 ->{}
        }
* */

/*
*/