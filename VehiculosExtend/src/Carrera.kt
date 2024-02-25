import kotlin.random.Random

/**
 * Representa una carrera entre varios participantes.
 * @param nombreCarrera Nombre de la carrera.
 * @param distanciaTotal Distancia total de la carrera en kilómetros.
 * @param participantes Lista de vehículos participantes en la carrera.
 * @param estadoCarrera Estado actual de la carrera (en curso o finalizada).
 */
class Carrera(
    nombreCarrera: String,
    distanciaTotal: Float,
    participantes: List<Vehiculo>,
    var estadoCarrera: Boolean
) {
    // Mapa que registra el historial de acciones realizadas por cada vehículo.
    var historial: MutableMap<String, MutableList<String>> = mutableMapOf()

    // Distancia total de la carrera en kilómetros.
    val distanciaTotal = distanciaTotal

    // Lista de vehículos participantes en la carrera.
    val participantes = participantes

    companion object {
        // Longitud de cada tramo en kilómetros.
        const val TRAMO = 20f
    }

    init {
        // Inicializa el historial de acciones para cada participante.
        for (i in participantes) {
            historial.put(i.nombre, mutableListOf())
        }
    }

    /**
     * Inicia la carrera, estableciendo el estado de la carrera a "en curso".
     * Comienza el ciclo de iteraciones donde los vehículos avanzan y realizan acciones.
     */
    fun iniciarCarrera() {
        estadoCarrera = true
        val participantesRandom = participantes.shuffled().take(Random.nextInt(1, participantes.size + 1)) // Esto soluciona el que no fuera random.


        println("¡¡¡Está a punto de comenzar la carrera!!!")
        println("3...")
        println("2...")
        println("1...")
        println("¡YA!")

        do {
            for (vehiculo in participantesRandom) {
                avanzarVehiculo(vehiculo)
                determinarGanador()
            }
        } while (estadoCarrera)
    }

    /**
     * Hace que un vehículo avance durante un tramo de la carrera.
     * @param vehiculo Vehículo que avanza en la carrera.
     */
    fun avanzarVehiculo(vehiculo: Vehiculo) {
        val avance = (10..200).random().toFloat()

        // Realiza una filigrana antes de avanzar.
        realizarFiligrana(vehiculo)

        // Verifica si el vehículo tiene suficiente combustible para avanzar.
        val distanciaAvanzable = minOf(avance, vehiculo.calcularAutonomia())
        if (vehiculo.combustibleActual >= distanciaAvanzable / Vehiculo.KM_POR_LITRO){
            vehiculo.kmActuales += distanciaAvanzable

            vehiculo.combustibleActual -= distanciaAvanzable / Vehiculo.KM_POR_LITRO

        }
        else{
            // El vehículo no tiene suficiente combustible, así que lo repostamos.
            val distanciaRestante = distanciaTotal - vehiculo.kmActuales
            repostarVehiculo(vehiculo, distanciaRestante)
        }
    }

    /**
     * Realiza el repostaje de combustible para un vehículo.
     * @param vehiculo Vehículo que realiza el repostaje.
     * @param cantidad Cantidad de combustible a repostar.
     */
    fun repostarVehiculo(vehiculo: Vehiculo, cantidad: Float) {
        vehiculo.repostar(cantidad)
    }

    /**
     * Realiza una acción especial (filigrana) para un vehículo.
     * @param vehiculo Vehículo que realiza la acción.
     */
    fun realizarFiligrana(vehiculo: Vehiculo) {
        if ((1..10).random() > 7) {
            if (vehiculo is Automovil) {
                vehiculo.realizarDerrape()
                registrarAccion(vehiculo.nombre, "¡¡¡${vehiculo.nombre} ha derrapado!!!")
            } else if (vehiculo is Motocicleta) {
                vehiculo.realizaCaballito()
                registrarAccion(vehiculo.nombre, "¡¡¡${vehiculo.nombre} ha hecho un caballito!!!")
            }
        } else {
            registrarAccion(vehiculo.nombre, "${vehiculo.nombre} no hace nada especial.")
        }
    }

    /**
     * Determina si algún vehículo ha ganado la carrera.
     */
    fun determinarGanador() {
        // Ordena los participantes por la cantidad de kilómetros recorridos.
        val participantesOrdenados = participantes.sortedBy { it.kmActuales }

        // Verifica si algún vehículo ha superado la distancia total y declara un ganador.
        for (i in participantesOrdenados) {
            if (i.kmActuales >= distanciaTotal) {
                estadoCarrera = false
                println("¡¡${i.nombre} HA GANADO LA CARRERA!!")
            }
        }
        return
    }

    /**
     * Obtiene los resultados finales de la carrera.
     */
    fun obtenerResultados() {
        val participantesOrdenados = participantes.sortedBy { it.kmActuales }

        println("Clasificación: ")
        println("______________")
        println("1 -> ${participantesOrdenados[0].nombre}")
        println("2 -> ${participantesOrdenados[1].nombre}")
        println("3 -> ${participantesOrdenados[2].nombre}")
        println("4 -> ${participantesOrdenados[3].nombre}")
        println("5 -> ${participantesOrdenados[4].nombre}")
    }

    /**
     * Registra una acción realizada por un vehículo en su historial.
     * @param vehiculo Nombre del vehículo.
     * @param accion Acción realizada por el vehículo.
     */
    private fun registrarAccion(vehiculo: String, accion: String) {
        val accionesPorVehiculo = historial.get(vehiculo)
        accionesPorVehiculo?.add(accion)
    }
}
