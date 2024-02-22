abstract class Vehiculo(nombre: String, marca: String, modelo: String, capacidadCombustible: Float, combustibleActual: Float, kmActuales: Float){

    val nombre: String = requerirNombreUnico(nombre)


    val marca = marca
    val capacidadCombustible = capacidadCombustible
    var combustibleActual = combustibleActual
    var kmActuales = kmActuales

    init {

    }
    companion object{
        const val KM_POR_LITRO = 10 // Un vehiculo puede avanzar 10km por cada litro.
        const val AHORRO_ELECTRICO = 15


        var listaNombres = mutableSetOf<String>()

        fun requerirNombreUnico(nombre: String): String{
            require(!listaNombres.contains(nombre)) { "'$nombre' ya existe como competidor." }
            listaNombres.add(nombre)

            return nombre
        }
    }

    fun obtenerInfo(): String{
        val kmRestantes = combustibleActual * KM_POR_LITRO


        return "Quedan $kmRestantes km"
    }


    open fun calcularAutonomia(): Float{ /** Cada litro da para 10km */
        val autonomia = combustibleActual * KM_POR_LITRO

        return autonomia.redondear()
    }


    open fun realizaViaje(distancia: Float): Float{
        val distanciaMax = calcularAutonomia()  // lo asigno así no tiene que recalcular la función calcularAutonomia
        if (distanciaMax > distancia){
            kmActuales += distancia
            combustibleActual -= (distancia / KM_POR_LITRO).redondear()
            return 0f
        }
        else{

            combustibleActual = 0f
            kmActuales += calcularAutonomia()

            return distancia - distanciaMax
        }
    }

    fun repostar(cantidad: Float): Float{
        val combustibleOriginal = combustibleActual
        if (cantidad <= 0f || (cantidad + combustibleActual) > capacidadCombustible){
            combustibleActual = capacidadCombustible
            return capacidadCombustible - combustibleOriginal
        }
        else{
            return capacidadCombustible - combustibleOriginal
        }

    }


    fun Float.redondear(): Float {
        return (this * 100).toInt().toFloat() / 100    //Lo tenía casi en clase
    }
}