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

        if(imc < 17){
            tvMVC.text = imc.format(0)
            setImagem(R.drawable.magreza)
            tvDescricao.setText("Magraza")
        }else if(imc < 18.5){
            tvMVC.text = imc.format(0)
            setImagem(R.drawable.abaixo)
            tvDescricao.setText("Abaixo do peso")
        }else if( imc < 24.9 ){
            tvMVC.text = imc.format(0)
            setImagem(R.drawable.ideal)
            tvDescricao.setText("levemente")
        } else if( imc < 29.9){
            tvMVC.text = imc.format(0)
            setImagem(R.drawable.sobre)
            tvDescricao.setText("Acima do peso")
        } else if ( imc < 34.9){
            tvMVC.text = imc.format(0)
            setImagem(R.drawable.obesidade)
            tvDescricao.setText("Obesidade 1")
        }
        else if ( imc < 39.9){
            tvMVC.text = imc.format(0)
            setImagem(R.drawable.obesidade)
            tvDescricao.setText("Obesidade 2")
        }else{
            tvMVC.text = imc.format(0)
            setImagem(R.drawable.obesidade)
            tvDescricao.setText("Obesidade 3")

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