import javax.swing.text.Position

class Carrera(nombreCarrera: String,
              distanciaTotal: Float,
              participantes: List<Vehiculo>,
              estadoCarrera: Boolean,
              historialAcciones: MutableMap<String, Int>){


    fun iniciarCarrera(){}

    fun avanzarVehiculo(vehiculo: Vehiculo){}

    fun repostarVehiculo(vehiculo: Vehiculo){}

    fun realizarFiligrana(vehiculo: Vehiculo){}

    fun actualizarPosiciones(){}

    fun determinarGanador(){}

    fun obtenerResultados(){}

    fun registrarAccion(){}

    data class Resultados(val vehiculo: Vehiculo,
                          val posicion: Int,
                          val kilometraje: Float,
                          val paradasRepostaje: Int,
                          val historialAcciones: List<String>){



    }
}