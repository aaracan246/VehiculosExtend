/**
 * Clase que representa una motocicleta en una carrera, que hereda de la clase Vehiculo.
 * @param nombre Nombre único de la motocicleta.
 * @param marca Marca de la motocicleta.
 * @param modelo Modelo de la motocicleta.
 * @param capacidadCombustible Capacidad total del depósito de combustible en litros.
 * @param combustibleActual Cantidad actual de combustible en el depósito en litros.
 * @param kmActuales Kilómetros recorridos por la motocicleta desde el inicio de la carrera.
 * @param cilindrada Cilindrada de la motocicleta en centímetros cúbicos (cc).
 */
class Motocicleta(
    nombre: String,
    marca: String,
    modelo: String,
    capacidadCombustible: Float,
    combustibleActual: Float,
    kmActuales: Float,
    val cilindrada: Int
) : Vehiculo(nombre, marca, modelo, capacidadCombustible, combustibleActual, kmActuales) {

    init {
        require(cilindrada in 125..999) { "La cilindrada debe estar entre 125 y 1000 cc." }
    }

    companion object {
        // Kilómetros recorridos por litro de combustible para una motocicleta.
        const val KM_POR_LITRO = 20f

        // Consumo de combustible al realizar un caballito con la motocicleta.
        const val GASTO_CABALLITO = 6.5f
    }

    /**
     * Realiza un caballito con la motocicleta, lo que consume combustible.
     * @return La cantidad actual de combustible después de realizar el caballito.
     */
    fun realizaCaballito(): Float {
        // Verificamos si hay suficiente combustible antes de restar
        if (combustibleActual >= GASTO_CABALLITO) {
            val combustibleTrasCaballito = combustibleActual - GASTO_CABALLITO
            println("¡¡¡${this.nombre} ha hecho un caballito!!!")
            return combustibleTrasCaballito
        } else {
            println("${this.nombre} ha intentado hacer un caballito ¡¡¡No hay suficiente combustible para hacer el caballito!!! Toca repostar.")
            return combustibleActual
        }
    }

    /**
     * Realiza la conversión de la cilindrada de la motocicleta a la cantidad de combustible
     * consumido por kilómetro.
     * @return La cantidad de combustible consumido por kilómetro en función de la cilindrada.
     */
    fun conversionCC(): Float {
        return KM_POR_LITRO - ((1000 - cilindrada) / 1000f)
    }

    /**
     * Calcula la autonomía de la motocicleta.
     * @return La autonomía de la motocicleta en kilómetros.
     */
    override fun calcularAutonomia(): Float {
        return combustibleActual * KM_POR_LITRO
    }

    /**
     * Simula el viaje de la motocicleta una distancia determinada, actualizando los kilómetros recorridos
     * y el combustible consumido.
     * @param distancia La distancia a recorrer en kilómetros.
     * @return La distancia restante que no se pudo recorrer debido a la falta de combustible.
     */
    override fun realizaViaje(distancia: Float): Float {
        val distanciaMax = calcularAutonomia()
        return if (distanciaMax > distancia) {
            kmActuales += distancia
            combustibleActual -= (distancia / conversionCC()).redondear()
            1f
        } else {
            combustibleActual = 0f
            kmActuales += distanciaMax
            distancia - distanciaMax
        }
    }
}