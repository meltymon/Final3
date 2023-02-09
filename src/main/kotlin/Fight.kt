import kotlin.random.Random

// Startet den Kampf zwischen Spieler und Gegner
private var cf = Config()
private var ab = Ability()
private var utl = Utilites()

class Fight {


    private fun fight(players: ArrayList<Player>, enemies: ArrayList<Enemy>) {
        for (player in players) {
            for (enemy in enemies) {
                while (player.leben > 0 && enemy.leben > 0) {


                    if (player.hp <= 0 || enemy.hp <= 0) {
                        continue
                    }
                    println("\nRunde ${1 + cf.anzahlLeben - player.leben}")
                    println("Der Kampf zwischen ${player.name} und ${enemy.name} beginnt!")
                    //Fähigkeiten werden aufgerufen
                    ab.useAbility(player, enemy)

                    while (player.hp > 0 && enemy.hp > 0) {
                        //Überprüft ob der Spieler oder der Gegener gestorben ist
                        if (player.hp <= 0 || enemy.hp <= 0) {
                            break
                        }

                        val damagePlayer = utl.calculateDamage(player.strength, enemy.defense, player, enemy)
                        enemy.hp -= damagePlayer
                        cf.schlaf("Game")
                        println("${player.name} hat ${enemy.name} $damagePlayer Schaden zugefügt!")
                        if (enemy.hp > 0) {
                            val damageEnemy = utl.calculateDamage(enemy.strength, player.defense, enemy, player)
                            player.hp -= damageEnemy
                            cf.schlaf("Game")
                            println("${enemy.name} hat ${player.name} $damageEnemy Schaden zugefügt!")
                        }
                    }
                    //Überprüft, wer im Kampf gewonnen hat
                    if (player.hp > 0) {
                        println("\n${player.name} hat ${enemy.name} besiegt!")
                        enemy.leben--
                        cf.schlaf("Game")
                    } else {
                        println("\n${enemy.name} hat ${player.name} besiegt!")
                        player.leben--
                        if ((player.leben) > 0) {
                            player.hp = (Random.nextInt(100, 500))
                            println("Du hast noch ${player.leben} Leben Übrig,deswegen hast du noch eine Weitere Chance")
                            println("Deine Lebenspunkte haben sich um ${player.hp} Erhöht")
                            cf.schlaf("Continue")
                            //if (enemies.isNotEmpty()) {
                            //fight(players, enemies)
                            //}
                        } else {
                            println("Du hast alle Leben Verloren und das Spiel ist nun Vorbei")
                            cf.schlaf("Game")
                            utl.damageMeters(players, enemies)
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





