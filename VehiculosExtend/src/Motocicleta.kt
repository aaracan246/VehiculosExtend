class Motocicleta(marca: String, capacidadCombustible: Float, combustibleActual: Float, kmActuales: Int, cilindrada: Int): Vehiculo(marca, capacidadCombustible, combustibleActual, kmActuales) {

    companion object{
        const val KM_POR_LITRO = 20

    }

    fun realizaCaballito()/**: Float*/{ }


    override fun calcularAutonomia(): Float {
        return super.calcularAutonomia() * KM_POR_LITRO
    }

    override fun realizaViaje(distancia: Float): Float {
        return super.realizaViaje(distancia)
    }


}