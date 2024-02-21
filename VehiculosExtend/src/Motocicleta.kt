class Motocicleta(nombre: String, marca: String, capacidadCombustible: Float, combustibleActual: Float, kmActuales: Float, cilindrada: Int): Vehiculo(nombre,marca, capacidadCombustible, combustibleActual, kmActuales) {

    val cilindrada = cilindrada

    companion object{
        const val KM_POR_LITRO = 20f
        const val GASTO_CABALLITO = 6.5f
    }

    fun realizaCaballito(): Float{

            val combustibleTrasCaballito = combustibleActual - GASTO_CABALLITO

            return combustibleTrasCaballito

    }

    fun conversionCC(): Float{
        return KM_POR_LITRO - ((1000 - cilindrada)/ 1000)

    }

    override fun calcularAutonomia(): Float {
        val autonomia = combustibleActual * KM_POR_LITRO

        return autonomia.redondear()
    }

    override fun realizaViaje(distancia: Float): Float {
        return super.realizaViaje(distancia)
    }


}