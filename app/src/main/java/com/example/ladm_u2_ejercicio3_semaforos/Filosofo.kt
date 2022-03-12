package com.example.ladm_u2_ejercicio3_semaforos

import android.widget.TextView
import java.util.concurrent.ThreadLocalRandom
import kotlin.random.Random

class Filosofo (mensaje: String, act: MainActivity) : Thread() {
        private var pausar =false
        private var ejecutar = true
        var index =0
        var men = mensaje
        var act=act
        var cont=1



        override fun run() {
            super.run()
            var dormirAntes = Random.nextInt(500).toLong()
            sleep(dormirAntes)

            while(ejecutar){
                if(!pausar){
                    //se pone lo que quiero que ejecute
                        while(act.semaforo){
                            println("Estoy Esperando ${men}")
                        }
                        act.semaforo=true //BLOQUEO EL RECURSO
                        act.runOnUiThread {
                            act.binding.mensaje.text= "\n ${cont++}  "+men+ act.binding.mensaje.text.toString()
                        }
                        act.semaforo=false
                }
                //crea un random de entre 1 y 5 segundos
                var dormir= Random.nextInt(1000).toLong()
                sleep(dormir)


            }
        }



        fun terminarHilo(){
            ejecutar=false
        }

        fun pausarHilo(){
            pausar = true
        }

        fun despausarHilo(){
            pausar=false
        }

        fun estaPausado(): Boolean{
            return pausar
        }

    fun Random.nextInt(range: IntRange): Int {
        return range.start + nextInt(range.last - range.start)
    }



    }
