import kotlin.random.Random

// Startet den Kampf zwischen Spieler und Gegner
private var config = Config()
private var ability = Ability()
private var utl = Utilites()

class Fight {


    private fun fight(players: ArrayList<Player>, enemies: ArrayList<Enemy>) {
        // Diese Beiden For Schleifen sind dafür da, das das Programm alle Spieler und Gegner der Listen nutzt
        for (player in players) {
            for (enemy in enemies) {
                while (player.leben > 0 && enemy.hp > 0) { //While Schleifen mit Überprüfung ob Spieler oder Gegner noch Lebt


                    println("\nRunde ${1 + config.anzahlLeben - player.leben}") //Ausgabe der Runden anhand vom Spieler Leben
                    println("Der Kampf zwischen ${player.name} und ${enemy.name} beginnt!") //Ausgabe das der Kampf beginnt

                    //Fähigkeiten werden aufgerufen
                    ability.useAbility(player, enemy)

                    while (player.hp > 0 && enemy.hp > 0) {
                        //Überprüft ob der Spieler oder der Gegener gestorben ist
                        if (player.hp <= 0 || enemy.hp <= 0) {
                            break
                        }

                        val damagePlayer =
                            utl.calculateDamage(player.strength, enemy.defense, player, enemy) //Schadensberechnung
                        enemy.hp -= damagePlayer
                        config.schlaf("Game")
                        println("${player.name} hat ${enemy.name} $damagePlayer Schaden zugefügt!") //Schadensanzeige in der Konsole
                        if (enemy.hp > 0) {
                            val damageEnemy = utl.calculateDamage(enemy.strength, player.defense, enemy, player)
                            player.hp -= damageEnemy
                            config.schlaf("Game")
                            println("${enemy.name} hat ${player.name} $damageEnemy Schaden zugefügt!")
                        }
                    }
                    //Überprüft, wer im Kampf gewonnen hat
                    if (player.hp > 0) {
                        println("\n${player.name} hat ${enemy.name} besiegt!")
                        enemy.leben--
                        config.schlaf("Game")
                    } else {
                        println("\n${enemy.name} hat ${player.name} besiegt!")
                        player.leben--
                        if ((player.leben) > 0) { //Wenn ein Spieler stirbt werden ihm 1 Leben abgezogen und er Bekommt zufällig Neue Gesundheit gutgeschrieben
                            player.hp = (Random.nextInt(100, 500))
                            println("Du hast noch ${player.leben} Leben Übrig,deswegen hast du noch eine Weitere Chance")
                            println("Deine Lebenspunkte haben sich um ${player.hp} Erhöht")
                            config.schlaf("Continue")
                        }
                        //Ende Kampf
                        if (player.leben >= 0) {
                        } else {
                            println("Du hast alle Leben Verloren und das Spiel ist nun Vorbei")
                            config.schlaf("Game")
                            utl.damageMeters(players, enemies) //Ausgabe des Schadensmeters Total
                            return
                        }
                    }
                }

            }

        }
        //Ausgabe der Schadensstatistik
        utl.damageMeters(players, enemies)


    }

    //Aufruf der Funktionen
    fun startFight(players: ArrayList<Player>, enemies: ArrayList<Enemy>) {
        fight(players, enemies)

    }

}





