import java.util.Collections.max
import kotlin.math.max

open class Utilites {
    private var config = Config()

    //Ausgabe der Schadensstatistik
    open fun damageMeters(players: ArrayList<Player>, enemies: ArrayList<Enemy>) {
        println("\nSchadensstatistik:")
        config.schlaf("Menu")
        for (i in 0 until max(players.size, enemies.size)) {
            if (i < players.size) {
                println("${players[i].name} hat insgesamt ${players[i].totalDamage} Schaden verursacht!")
                println()
                config.schlaf("Menu")
            }
            if (i < enemies.size) {
                println("${enemies[i].name} hat insgesamt ${enemies[i].totalDamage} Schaden verursacht!")
                println()
                config.schlaf("Menu")
            }
        }


    }


    fun calculateDamage(attackerStrength: Int, defenderDefense: Int, attacker: Player, defender: Player): Int {
        val damage = (attackerStrength * 2) - defenderDefense

        //Aktualisieren Sie hier totalDamage
        attacker.totalDamage += damage
        defender.totalDamage += damage

        return damage
    }
}









