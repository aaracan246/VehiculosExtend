import javax.swing.text.Position

class Carrera(nombreCarrera: String,
              distanciaTotal: Float,
              participantes: List<Vehiculo>,
              estadoCarrera: Boolean,
              historialAcciones: MutableMap<String, Int>){


    fun iniciarCarrera(){

        /*TODO(): Inicia la carrera, estableciendo estadoCarrera a true y comenzando el ciclo de iteraciones donde los vehículos avanzan y realizan acciones.*/

    }

    fun avanzarVehiculo(vehiculo: Vehiculo){

        /*TODO():  Identificado el vehículo, le hace avanzar una distancia aleatoria entre 10 y 200 km. Si el vehículo necesita repostar, se llama al método repostarVehiculo() antes de que pueda continuar. Este método llama a realizar filigranas.*/

    }

    fun repostarVehiculo(vehiculo: Vehiculo){

        /*TODO(): Reposta el vehículo seleccionado, incrementando su combustibleActual y registrando la acción en historialAcciones.*/

    }

    fun realizarFiligrana(vehiculo: Vehiculo){

        /*TODO(): Determina aleatoriamente si un vehículo realiza una filigrana (derrape o caballito) y registra la acción.*/


    }

    fun actualizarPosiciones(){

        /*TODO(): Actualiza posiciones con los kilómetros recorridos por cada vehículo después de cada iteración, manteniendo un seguimiento de la competencia.*/

    }

    fun determinarGanador(){

        /*TODO(): Revisa posiciones para identificar al vehículo (o vehículos) que haya alcanzado o superado la distanciaTotal, estableciendo el estado de la carrera a finalizado y determinando el ganador.*/

    }

    fun obtenerResultados(){

        /*TODO(): Devuelve una clasificación final de los vehículos, cada elemento tendrá el nombre del vehiculo, posición ocupada, la distancia total recorrida, el número de paradas para repostar y el historial de acciones. La collección estará ordenada por la posición ocupada.*/


    }

    fun registrarAccion(){

        /*TODO(): Añade una acción al historialAcciones del vehículo especificado.*/

    }

    data class Resultados(val vehiculo: Vehiculo,
                          val posicion: Int,
                          val kilometraje: Float,
                          val paradasRepostaje: Int,
                          val historialAcciones: List<String>){



    }
}