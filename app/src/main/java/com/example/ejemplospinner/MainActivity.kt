package com.example.ejemplospinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //atributos
    private lateinit var spDias: Spinner
    private lateinit var tvDia: TextView
    private lateinit var spMarcasCelulares: Spinner
    private lateinit var tvMarcaCelular: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inicializar atributos
        spDias = findViewById(R.id.spDias)
        tvDia = findViewById(R.id.tvMensaje1)
        spMarcasCelulares = findViewById(R.id.spMarcasCelulares)
        tvMarcaCelular = findViewById(R.id.tvMensaje2)

        // declaramos el arreglo con los dias de la semana
        val dias = arrayOf("Seleciona un dia 🙏 ","Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
        //declaramos el adaptador
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, dias)

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spDias.adapter = adaptador

        //logica de el spinner
        spDias.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long){
                if (position == 0){
                    tvDia.text = ""
            }else{
                    val diaSeleccionado = parent.getItemAtPosition(position).toString()
                    tvDia.text = "El dia seleccionado es: $diaSeleccionado"
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                tvDia.text = "No seleccionaste nada 🥺"
            }
        }

        // declaramos el arreglo con las marcas de celulares desde el xml con los valores
        val marcasCelularesAdap = ArrayAdapter.createFromResource(this, R.array.marcasCelulares, android.R.layout.simple_spinner_item)

        //declaramos el adaptador
        marcasCelularesAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spMarcasCelulares.adapter = marcasCelularesAdap

        //logica de el spinner de marcas de celulares del xml
        spMarcasCelulares.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long){
                if (position == 0){
                    tvMarcaCelular.text = ""
                }else{
                    val marcaCelularSeleccionada = parent.getItemAtPosition(position).toString()
                    tvMarcaCelular.text = "La marca de celular seleccionada es: $marcaCelularSeleccionada"
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                tvMarcaCelular.text = "No seleccionaste nada :("
            }
        }


    }
}