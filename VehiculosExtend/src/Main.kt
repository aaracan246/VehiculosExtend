

// Si ves código raro en lo que rodea a las dos filigranas es porque lo he tenido que buscar. Me he tirado toda la tarde buscando el motivo del bucle infinito y no he podido avanzar mucho por ello.

fun main() {

    val pierreNodoyuna = Automovil("Pierre Nodoyuna", "Seat", "Patán", 60f, 50f * 0.1f, 50f , true)
    val penelopeGlamour = Automovil("Penélope Glamour", "Volkswagen", "Passat 5", 70f * 0.1f, 45f, 50f * 0.1f, false)
    val peterPerfect = Automovil("Peter Perfect", "Citroen", "C7", 33f, 20f * 0.1f, 35f, false)
    val ghostRider = Motocicleta("Ghost Rider", "Yamaha", "Yakisoba", 44f, 13f * 0.1f, 35f, 225)
    val elNano = Automovil("Fernando Alonso, el Nano. Primero de su nombre. Arquitecto de la 33", "Aston Martin", "nanosexo", 33f, 33f  * 0.1f, 33f, true)


    val participantes = listOf(pierreNodoyuna, penelopeGlamour, peterPerfect, ghostRider, elNano)

    val carrera = Carrera("Copa Pistón", 1000f, participantes, estadoCarrera = false)

    carrera.iniciarCarrera()

    carrera.obtenerResultados()
}

