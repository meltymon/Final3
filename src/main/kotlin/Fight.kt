import kotlin.random.Random

class Fight {
    private var cf = Config()
    private var ab = Ability()
    private var utl = Utilites()


    // Startet den Kampf zwischen Spieler und Gegner
    private fun fight(players: ArrayList<Player>, enemies: ArrayList<Enemy>) {
        for (player in players) {
            for (enemy in enemies) {
                println("\nRunde ${4 - player.leben}")
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
                    cf.schlaf("Game")
                } else {
                    println("\n${enemy.name} hat ${player.name} besiegt!")
                    player.leben--
                    if ((player.leben) > 0) {
                        player.hp = (Random.nextInt(100, 500))
                        println("Du hast noch ${player.leben} Leben Übrig,deswegen hast du noch eine Weitere Chance")
                        println("Deine Lebenspunkte haben sich um ${player.hp} Erhöht")
                        cf.schlaf("Continue")
                        fight(players, enemies)
                    } else {
                        println("Du hast alle Leben Verloren und das Spiel ist nun Vorbei")
                        cf.schlaf("Game")
                        utl.checkPlayerDeath(player, enemies)
                        utl.checkAlive(players, enemies)
                        utl.checkWinner(players, enemies)
                        return
                    }
                    cf.schlaf("Game")
                }
            }
        }
    }


    //Aufruf der Funktionen
    fun startFight(players: ArrayList<Player>, enemies: ArrayList<Enemy>) {
        fight(players, enemies)
        utl.checkAlive(players, enemies)
    }


}