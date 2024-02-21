class Automovil(nombre: String, marca: String, capacidadCombustible: Float, combustibleActual: Float, kmActuales: Float, esHibrido: Boolean): Vehiculo(nombre, marca, capacidadCombustible, combustibleActual, kmActuales){

    val esHibrido = esHibrido


    companion object{
        const val CONSUMO_DERRAPE = 7.5f
        const val CONSUMO_DERRAPE_HIBRIDO = 6.75f



        var condicionBritanica = false
            private set // <- lo convierte en solo lectura

        fun cambiarCondicionBritanica(nuevaCondicion: Boolean){

            condicionBritanica = nuevaCondicion

        }
        fun cambiarCondicionBritanica(){

            condicionBritanica = !condicionBritanica

        }
    }

    fun realizarDerrape(): Float {

        println("¡¡¡this.nombre(NOT YET IMPLEMENTED) ha derrapado!!!")
        combustibleActual -= if (esHibrido){   // <-- lo había hecho con if y me lo ha puesto así que está xulo
            CONSUMO_DERRAPE_HIBRIDO
        } else{
            CONSUMO_DERRAPE


        }
        return combustibleActual
    }

    override fun calcularAutonomia(): Float {
        if (!esHibrido){
            return super.calcularAutonomia()
        }
        else{
            var autonomiaElectrico = combustibleActual * AHORRO_ELECTRICO

            return autonomiaElectrico.redondear()
        }
    }
}