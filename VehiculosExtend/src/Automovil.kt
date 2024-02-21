class Automovil(marca: String, capacidadCombustible: Float, combustibleActual: Float, kmActuales: Int): Vehiculo(marca, capacidadCombustible, combustibleActual, kmActuales){

    fun esElectrico(): Boolean{ return true }


    fun condicionBritania(): Boolean{ return true }


    fun cambiarCondicionBritania(nuevaCondicion: Boolean){}


    fun realizarDerrape()/**: Float*/ { }

    override fun calcularAutonomia(): Float {
        return super.calcularAutonomia()
    }
}