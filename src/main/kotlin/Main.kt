fun main(args: Array<String>) {
    var magnum = Pistola("Magnum", 8, 1, "normal", 3, "a")
    var escopeta = Rifle("Escopeta", 2, 2, "normal", 6, "b")
    var M9A1 = Bazoka("M9A1", 4, 1, "proyectil", 14, "c")
    var contador = 1
    var listaDeArmas = mutableListOf<ArmaDeFuego>(magnum, escopeta, M9A1)
    var mapaDeArmas = mapOf(
        1 to listaDeArmas.get((0..2).random()),
        2 to listaDeArmas.get((0..2).random()),
        3 to listaDeArmas.get((0..2).random()),
        4 to listaDeArmas.get((0..2).random()),
        5 to listaDeArmas.get((0..2).random()),
        6 to listaDeArmas.get((0..2).random())
    )
    var valor = mapaDeArmas.get(contador)

    while (contador <= 6) {
        mapaDeArmas.get(contador)?.dispara()
        println(mapaDeArmas.get(contador))
        contador += 1
    }
}

open class ArmaDeFuego(
    var nombre: String,
    var municion: Int,
    var municionARestar: Int,
    var tipoDeMunicion: String,
    var danio: Int,
    var radio: String
) {
    open fun dispara() = municion - municionARestar

    fun recarga(balas: Int) = municion + balas


}

class Pistola(nombre: String, municion: Int, municionARestar: Int, tipoDeMunicion: String, danio: Int, radio: String) :
    ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio, radio) {

    override fun dispara(): Int {

        if (municion > 0) municion -= (municionARestar * 1)

        return municion
    }

    override fun toString(): String {
        if (municion < municionARestar) {
            return "La pistola $nombre no tiene municion "
        } else {
            return "La pistola ha disparado"
        }

    }
}

class Rifle(nombre: String, municion: Int, municionARestar: Int, tipoDeMunicion: String, danio: Int, radio: String) :
    ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio, radio) {

    override fun dispara(): Int {

        if (municion > 0) municion -= (municionARestar * 2)

        return municion
    }

    override fun toString(): String {
        if (municion < municionARestar) {
            return " El rifle $nombre no tiene municion suficiente "
        } else {
            return "El rifle ha disparado"
        }

    }
}

class Bazoka(nombre: String, municion: Int, municionARestar: Int, tipoDeMunicion: String, danio: Int, radio: String) :
    ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio, radio) {

    override fun dispara(): Int {

        if (municion > 0) municion -= (municionARestar * 3)

        return municion
    }

    override fun toString(): String {
        if (municion < municionARestar) {
            return " El bazoka $nombre no tiene municion suficiente "
        } else {
            return "El bazoka ha disparado"
        }

    }

}