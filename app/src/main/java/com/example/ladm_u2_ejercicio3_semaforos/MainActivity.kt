package com.example.ladm_u2_ejercicio3_semaforos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ladm_u2_ejercicio3_semaforos.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var socrates : Filosofo
    var semaforo=false
    /*semaforo estara en FALSE cuando el recurso compartido este DESOCUPADO, cuando el hilo pida el recurso debe poner
      SEMAFORO en TRUE, para indicar que esta usandolo
     */



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val platon = Filosofo("La vida es bella",this)
        val platon2 = Filosofo("Ella es Callaita",this)
        val platon3 = Filosofo("Ser o no ser",this)
        socrates = Filosofo("nadie sabe lo que tiene",this)

        binding.hilo1.setOnClickListener {
            platon.start()
            platon2.start()
            platon3.start()
            socrates.start()

        }

        binding.hilo2.setOnClickListener {
            if(platon.estaPausado()){

            }
        }

    }



}