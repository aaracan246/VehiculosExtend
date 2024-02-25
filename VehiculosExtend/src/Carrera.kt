import javax.swing.text.Position


class Carrera(nombreCarrera: String,
              distanciaTotal: Float,
              participantes: List<Vehiculo>,
              var estadoCarrera: Boolean){

    var historial: MutableMap<String, MutableList<String>> = mutableMapOf()
    val distanciaTotal = distanciaTotal
    val participantes = participantes

    companion object{

        const val TRAMO = 20f
    }

    init {

        for (i in participantes){
            historial.put(i.nombre, mutableListOf())

        }

    }




    fun iniciarCarrera(){
        estadoCarrera = true

        println("¡¡¡Está a punto de comenzar la carrera!!!")
        println("3...")
        println("2...")
        println("1...")

        println("¡YA!")

        do {
            for (i in participantes){
                avanzarVehiculo(i)

                determinarGanador()
            }

        }   while (estadoCarrera)



        /*TODO(): Inicia la carrera, estableciendo estadoCarrera a true y comenzando el ciclo de iteraciones donde los vehículos avanzan y realizan acciones.*/

    }

    fun avanzarVehiculo(vehiculo: Vehiculo){

        val avance = (10..200).random().toFloat()
        val tramosIguales = distanciaTotal / 20
        /*val ultimoTramo = distanciaTotal - tramosIguales*/

        if (vehiculo.kmActuales + avance < distanciaTotal && vehiculo.kmActuales + avance <= vehiculo.calcularAutonomia()){
            vehiculo.kmActuales += avance


        }
        else{
            repostarVehiculo(vehiculo, (15..25).random().toFloat())

        }

        repeat(tramosIguales.toInt()){
            realizarFiligrana(vehiculo)
        }

    }


        /*TODO():  Identificado el vehículo, le hace avanzar una distancia aleatoria entre 10 y 200 km. Si el vehículo necesita repostar, se llama al método repostarVehiculo() antes de que pueda continuar. Este método llama a realizar filigranas.*/



    fun repostarVehiculo(vehiculo: Vehiculo, cantidad: Float){


        vehiculo.repostar(vehiculo.capacidadCombustible)

    }

    fun realizarFiligrana(vehiculo: Vehiculo){

        if ((1..10).random() > 7){
            if (vehiculo is Automovil){
                vehiculo.realizarDerrape()

                registrarAccion(vehiculo.nombre, "¡¡¡${vehiculo.nombre} ha derrapado!!!")

            }
            else if (vehiculo is Motocicleta){
                vehiculo.realizaCaballito()

                registrarAccion(vehiculo.nombre, "¡¡¡${vehiculo.nombre} ha hecho un caballito!!!")

            }
        }
        else{
            registrarAccion(vehiculo.nombre, "${vehiculo.nombre} no hace nada especial.")
        }

        /*TODO(): registra la acción.*/


    }


    fun determinarGanador(){


        participantes.sortedBy { it.kmActuales }

        for (i in participantes){
            if (i.kmActuales >= distanciaTotal){

                println("¡¡${i.nombre} HA GANADO LA CARRERA!!")
                estadoCarrera = false

            }
        }


        /*TODO(): Revisa posiciones para identificar al vehículo (o vehículos) que haya alcanzado o superado la distanciaTotal, estableciendo el estado de la carrera a finalizado y determinando el ganador.*/

    }

    fun obtenerResultados(){

        participantes.sortedBy { it.kmActuales }

        println("Clasificación: ")
        println("______________")
        println("1 -> ${participantes[0].nombre}")
        println("2 -> ${participantes[1].nombre}")
        println("3 -> ${participantes[2].nombre}")
        println("4 -> ${participantes[3].nombre}")
        println("5 -> ${participantes[4].nombre}")


        /*TODO(): Devuelve una clasificación final de los vehículos, cada elemento tendrá el nombre del vehiculo, posición ocupada, la distancia total recorrida, el número de paradas para repostar y el historial de acciones. La collección estará ordenada por la posición ocupada.*/


    }

    private fun registrarAccion(vehiculo: String, accion: String){

        val accionesPorVehiculo = historial.get(vehiculo)
        accionesPorVehiculo?.add(accion)




        /*TODO(): Añade una acción al historialAcciones del vehículo especificado.*/

    }

    data class Resultados(val vehiculo: Vehiculo,
                          val kilometraje: Float,
                          val paradasRepostaje: Int,
                          val historialAcciones: List<String>){
    }
}
