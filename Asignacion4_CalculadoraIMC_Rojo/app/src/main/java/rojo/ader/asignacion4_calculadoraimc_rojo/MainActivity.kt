package rojo.ader.asignacion4_calculadoraimc_rojo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    var indice: Float = 0F
    var peso: Int = 0
    var altura: Float = 0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weight: EditText = findViewById(R.id.weight)
        val height: EditText = findViewById(R.id.height)
        val imc: TextView = findViewById(R.id.imc)
        val range: TextView = findViewById(R.id.range)
        val calcular: Button = findViewById(R.id.calcular)

        calcular.setOnClickListener {
            peso = weight.getText().toString().toInt()
            altura = height.getText().toString().toFloat()

            indice = peso/(altura.pow(2))

            if(indice<18.5f){
                imc.setText(indice.toString())
                range.setText("Bajo Peso")
                range.setBackgroundResource(R.color.colorBrown)
            }else if(indice in 18.5f..24.9f){
                imc.setText(indice.toString())
                range.setText("Normal")
                range.setBackgroundResource(R.color.colorGreen)
            }else if(indice in 25f..29.9f){
                imc.setText(indice.toString())
                range.setText("Sobrepeso")
                range.setBackgroundResource(R.color.colorGreenish)
            }else if(indice in 30f..34.9f){
                imc.setText(indice.toString())
                range.setText("Obesidad Grado 1")
                range.setBackgroundResource(R.color.colorYellow)
            }else if(indice in 35f..39.9f){
                imc.setText(indice.toString())
                range.setText("Obesidad Grado 2")
                range.setBackgroundResource(R.color.colorOrange)
            }else if(indice>=40){
                imc.setText(indice.toString())
                range.setText("Obesidad Grado 3")
                range.setBackgroundResource(R.color.colorRed)
            }
        }

    }
}