open class Utilites {
private var cf=Config()

    //Überprüft, ob ein Spieler oder Gegner tot ist
    open fun checkAlive(players: ArrayList<Player>, enemies: ArrayList<Enemy>) {
        val playersToRemove = ArrayList<Player>()
        val enemiesToRemove = ArrayList<Enemy>()

        for (player in players) {
            if (player.hp <= 0) {
                playersToRemove.add(player)
            }
        }
        for (enemy in enemies) {
            if (enemy.hp <= 0) {
                enemiesToRemove.add(enemy)
            }
        }
        players.removeAll(playersToRemove.toSet())
        enemies.removeAll(enemiesToRemove.toSet())
    }

    //Überprüfen, wer gewonnen hat
    open fun checkWinner(players: ArrayList<Player>, enemies: ArrayList<Enemy>) {
        if (players.isEmpty()) {
            println("Der Kampf ist vorbei, Gegner hat gewonnen!")
            cf.schlaf("Game")
        } else if (enemies.isEmpty()) {
            println("Der Kampf ist vorbei, Spieler hat gewonnen!")
            cf.schlaf("Game")
        }

        //Ausgabe der Schadensstatistik
        println("\nSchadensstatistik:")
        for (player in players) {
            println("${player.name} hat insgesamt ${player.totalDamage} Schaden verursacht!")
        }
        for (enemy in enemies) {
            println("${enemy.name} hat insgesamt ${enemy.totalDamage} Schaden verursacht!")
        }
    }
    fun calculateDamage(attackerStrength: Int, defenderDefense: Int, attacker: Player, defender: Player): Int {
        val damage = (attackerStrength * 2) - defenderDefense

        //Aktualisieren Sie hier totalDamage
        attacker.totalDamage += damage
        defender.totalDamage += damage

        return damage
    }

    //Überprüft ob der Spieler gestorben ist und gibt eine Meldung aus
    open fun checkPlayerDeath(player: Player, enemies: ArrayList<Enemy>) {
        if (player.hp <= 0) {
            println("\nSpieler gestorben!")
            cf.schlaf("Game")
        }
        // Berechnet den Schaden, der angegriffen wird

    }




}

