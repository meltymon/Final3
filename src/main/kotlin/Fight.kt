/*import kotlin.random.Random


class Fight {

    private var cf = Config()
    //private var cc=CharacterCreator()

    // Startet den Kampf zwischen Spieler und Gegner
    fun fight(players: ArrayList<Player>, enemys: ArrayList<Enemy>) {
       for(player in players){
           println(player.name)
       }
        val player = players[0]
        val enemy = enemys[0]


        println("\nRunde ${8 - player.leben}")
        println("Der Kampf zwischen ${player.name} und ${enemy.name} beginnt!")

        while (player.hp > 0 && enemy.hp > 0) {
            val damagePlayer = calculateDamage(player.strength, enemy.defense)
            enemy.hp -= damagePlayer
            cf.schlaf("Game")
            println("${player.name} hat ${enemy.name} $damagePlayer Schaden zugefügt!")
            if (enemy.hp > 0) {
                val damageEnemy = calculateDamage(enemy.strength, player.defense)
                player.hp -= damageEnemy
                cf.schlaf("Game")
                println("${enemy.name} hat ${player.name} $damageEnemy Schaden zugefügt!")
            }
        }
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
                fight(players,enemys)

            } else println("Du hast alle Leben Verloren und das Spiel ist nun Vorbei")

            cf.schlaf("Game")
        }

    }
    fun calculateDamage(strength: Int, defense: Int): Int {
        // Generiert zufällig Stärke und Verteidigung
        //generateRandomStrengthAndDefense()
        return strength - defense
    }
}*/


import kotlin.random.Random


class Fight {

    private var cf = Config()
    //private var cc=CharacterCreator()

    // Startet den Kampf zwischen Spieler und Gegner
    fun fight(players: ArrayList<Player>, enemys: ArrayList<Enemy>) {
        for (player in players) {
            for (enemy in enemys) {
                println("\nRunde ${4 - player.leben}")
                println("Der Kampf zwischen ${player.name} und ${enemy.name} beginnt!")

                while (player.hp > 0 && enemy.hp > 0) {
                    val damagePlayer = calculateDamage(player.strength, enemy.defense)
                    enemy.hp -= damagePlayer
                    cf.schlaf("Game")
                    println("${player.name} hat ${enemy.name} $damagePlayer Schaden zugefügt!")
                    if (enemy.hp > 0) {
                        val damageEnemy = calculateDamage(enemy.strength, player.defense)
                        player.hp -= damageEnemy
                        cf.schlaf("Game")
                        println("${enemy.name} hat ${player.name} $damageEnemy Schaden zugefügt!")
                    }
                }
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
                        fight(players, enemys)

                    } else println("Du hast alle Leben Verloren und das Spiel ist nun Vorbei")

                    cf.schlaf("Game")
                }
            }
        }

    }

    fun calculateDamage(strength: Int, defense: Int): Int {
        // Generiert zufällig Stärke und Verteidigung
        //generateRandomStrengthAndDefense()
        return strength - defense
    }
}