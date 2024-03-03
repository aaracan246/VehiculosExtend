/**
 * Clase que representa un automóvil en una carrera, que hereda de la clase Vehiculo.
 * @param nombre Nombre único del automóvil.
 * @param marca Marca del automóvil.
 * @param modelo Modelo del automóvil.
 * @param capacidadCombustible Capacidad total del depósito de combustible en litros.
 * @param combustibleActual Cantidad actual de combustible en el depósito en litros.
 * @param kmActuales Kilómetros recorridos por el automóvil desde el inicio de la carrera.
 * @param esHibrido Indica si el automóvil es híbrido o no.
 */
open class Automovil(
    nombre: String,
    marca: String,
    modelo: String,
    capacidadCombustible: Float,
    combustibleActual: Float,
    kmActuales: Float,
    val esHibrido: Boolean
) : Vehiculo(nombre, marca, modelo, capacidadCombustible, combustibleActual, kmActuales) {

    companion object {
        // Consumo de combustible al realizar un derrape.
        const val CONSUMO_DERRAPE = 7.5f

        // Consumo de combustible al realizar un derrape en un automóvil híbrido.
        const val CONSUMO_DERRAPE_HIBRIDO = 6.75f

        // Indicador de la condición británica para los automóviles.
        var condicionBritanica = false
            private set

        /**
         * Cambia el estado de la condición británica para los automóviles.
         * @param nuevaCondicion El nuevo estado de la condición británica.
         */
        fun cambiarCondicionBritanica(nuevaCondicion: Boolean) {
            condicionBritanica = nuevaCondicion
        }

        /**
         * Alterna el estado de la condición británica para los automóviles.
         */
        fun cambiarCondicionBritanica() {
            condicionBritanica = !condicionBritanica
        }
    }

    /**
     * Realiza un derrape con el automóvil, lo que consume combustible.
     * @return La cantidad actual de combustible después de realizar el derrape.
     */
    fun realizarDerrape(): Float {
        println("¡¡¡$nombre ha derrapado!!!")

        val consumoDerrape = if (esHibrido) CONSUMO_DERRAPE_HIBRIDO else CONSUMO_DERRAPE

        if (combustibleActual >= consumoDerrape) {
            combustibleActual -= consumoDerrape
        } else {
            println("${this.nombre} ha intentado derrapar. ¡No hay suficiente combustible para realizar el derrape!")
        }

        return combustibleActual
    }

    /**
     * Calcula la autonomía del automóvil, teniendo en cuenta si es híbrido o no.
     * @return La autonomía del automóvil en kilómetros.
     */
    override fun calcularAutonomia(): Float {
        return if (!esHibrido) {
            super.calcularAutonomia()
        } else {
            val autonomiaElectrico = combustibleActual * AHORRO_ELECTRICO
            autonomiaElectrico.redondear(2)
        }
    }
}