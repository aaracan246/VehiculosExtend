abstract class Vehiculo(marca: String, capacidadCombustible: Float, combustibleActual: Float, kmActuales: Int){

    val marca = marca
    val capacidadCombustible = capacidadCombustible
    val combustibleActual = combustibleActual
    val kmActuales = kmActuales


    companion object{
        const val KM_POR_LITRO = 10 // Un vehiculo puede avanzar 10km por cada litro.
        const val AHORRO_ELECTRICO = 15

    }
    fun obtenerInfo(): String{
        val kmRestantes = combustibleActual * KM_POR_LITRO


        return "Quedan $kmRestantes km"
    }


    open fun calcularAutonomia(): Float{ /** Cada litro da para 10km */
        val autonomia = combustibleActual * KM_POR_LITRO

        return autonomia
    }


    open fun realizaViaje(distancia: Float): Float{
        val distanciaRecorrible = combustibleActual * KM_POR_LITRO

        val diferenciaDistancia = distancia - distanciaRecorrible
        //Faltan funciones que saquen lo consumido

        return diferenciaDistancia
    }


    fun repostar(cantidad: Float) /**Float*/{ }


    fun Float.redondear(): Float {
        return (this * 100).toInt().toFloat() / 100    //Lo tenía casi en clase
    }
}