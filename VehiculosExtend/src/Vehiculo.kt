/**
 * Clase abstracta que representa un vehículo en una carrera.
 * @param nombre Nombre único del vehículo.
 * @param marca Marca del vehículo.
 * @param modelo Modelo del vehículo.
 * @param capacidadCombustible Capacidad total del depósito de combustible en litros.
 * @param combustibleActual Cantidad actual de combustible en el depósito en litros.
 * @param kmActuales Kilómetros recorridos por el vehículo desde el inicio de la carrera.
 */
abstract class Vehiculo(
    nombre: String,
    marca: String,
    modelo: String,
    capacidadCombustible: Float,
    combustibleActual: Float,
    kmActuales: Float
) {
    // Nombre único del vehículo.
    val nombre: String = requerirNombreUnico(nombre)

    // Marca del vehículo.
    val marca = marca

    // Capacidad total del depósito de combustible en litros.
    val capacidadCombustible = capacidadCombustible

    // Cantidad actual de combustible en el depósito en litros.
    var combustibleActual = combustibleActual

    // Kilómetros recorridos por el vehículo desde el inicio de la carrera.
    var kmActuales = kmActuales

    companion object {
        // Kilómetros que puede recorrer el vehículo con un litro de combustible.
        const val KM_POR_LITRO = 10 // Un vehículo puede avanzar 10km por cada litro.

        // Valor de ahorro eléctrico para vehículos híbridos.
        const val AHORRO_ELECTRICO = 15

        // Conjunto mutable que almacena los nombres de los vehículos para garantizar la unicidad.
        var listaNombres = mutableSetOf<String>()

        /**
         * Verifica que el nombre del vehículo sea único.
         * @param nombre Nombre del vehículo a verificar.
         * @return Nombre del vehículo si es único, de lo contrario lanza una excepción.
         */
        fun requerirNombreUnico(nombre: String): String {
            require(!listaNombres.contains(nombre)) { "'$nombre' ya existe como competidor." }
            listaNombres.add(nombre)
            return nombre
        }
    }

    /**
     * Obtiene información sobre la cantidad de kilómetros restantes que el vehículo puede recorrer con el combustible actual.
     * @return Cadena que indica los kilómetros restantes que el vehículo puede recorrer.
     */
    fun obtenerInfo(): String {
        val kmRestantes = combustibleActual * KM_POR_LITRO
        return "Quedan $kmRestantes km"
    }

    /**
     * Calcula la autonomía del vehículo en función de la cantidad actual de combustible.
     * @return La autonomía del vehículo en kilómetros.
     */
    open fun calcularAutonomia(): Float {
        val autonomia = combustibleActual * KM_POR_LITRO
        return autonomia.redondear()
    }

    /**
     * Realiza un viaje con el vehículo, avanzando una cierta distancia y consumiendo combustible en función de esta distancia.
     * @param distancia Distancia a recorrer en kilómetros.
     * @return La distancia restante que el vehículo no pudo recorrer debido a la falta de combustible.
     */
    open fun realizaViaje(distancia: Float): Float {
        val distanciaMax = calcularAutonomia()
        return if (distanciaMax > distancia) {
            kmActuales += distancia
            combustibleActual -= (distancia / KM_POR_LITRO).redondear()
            1f
        } else {
            combustibleActual = 0f
            kmActuales += calcularAutonomia()
            distancia - distanciaMax
        }
    }

    /**
     * Realiza un repostaje de combustible para el vehículo.
     * @param cantidad Cantidad de combustible a repostar en litros.
     * @return La cantidad de combustible que se ha repostado.
     */
    fun repostar(cantidad: Float): Float {
        val combustibleOriginal = combustibleActual
        return if (cantidad <= 0f || (cantidad + combustibleActual) > capacidadCombustible) {
            combustibleActual = capacidadCombustible
            capacidadCombustible - combustibleOriginal
        } else {
            capacidadCombustible - combustibleOriginal
        }
    }

    /**
     * Redondea un número decimal a dos decimales.
     * @return El número redondeado.
     */
    fun Float.redondear(): Float {
        return (this * 100).toInt().toFloat() / 100
    }
}