abstract class Vehiculo(marca: String, capacidadCombustible: Float, combustibleActual: Float, kmActuales: Int){

    val marca = marca
    val capacidadCombustible = capacidadCombustible
    val combustibleActual = combustibleActual
    val kmActuales = kmActuales


    companion object{
        const val KM_POR_LITRO = 10 // Un vehiculo puede avanzar 10km por cada litro.

    }
    fun obtenerInfo(): String{
        val kmRestantes = combustibleActual * KM_POR_LITRO


        return "Quedan $kmRestantes km"
    }


    open fun calcularAutonomia(): Int{ /** Cada litro da para 10km */
        val autonomia = combustibleActual * KM_POR_LITRO

        return autonomia.toInt()
    }


    open fun realizaViaje(distancia: Int): Int{
        val distanciaRecorrible = combustibleActual * KM_POR_LITRO

        val diferenciaDistancia = distancia - distanciaRecorrible


        return diferenciaDistancia.toInt()
    }


    fun repostar(cantidad: Float) /**Float*/{ }


//    fun redondear(valor: Double): Float{
//
//    }
}