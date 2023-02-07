//InteractiveMenu.kt
//enthalten Funktionen für die Interaktion mit dem Benutzer

class InteractiveMenu {
private val cc=CharacterCreator()
    // Erstellt den Spieler
    fun createPlayer() {
        //Eingabe des Spieler namen
        val player = Player()
        player.name = cc.readName()
        cc.players.add(player)
    }

    // Erstellt den Gegner
    fun createEnemy() {
        //Generierter Gegner name
        val enemy = Enemy()
        enemy.name = cc.generateName()
        cc.enemies.add(enemy)

    }

    // Zeigt die Details der Spieler und Gegner an
    fun showDetails() {
        println("* * * * * * * * * * * * * * * * * *")
        println("\nDetails der Spieler:")
        for (player in cc.players) {
            println("Name: ${player.name}")
            println("Lebensanzeige: ${player.hp}")
            println("Stärke: ${player.strength}")
            println("Verteidigung: ${player.defense}")
            println("Anzahl Leben: ${player.leben}")
            println()

        }
        sleep("Game")
        println("\nDetails der Gegner:")
        for (enemy in cc.enemies) {
            println("Name: ${enemy.name}")
            println("Lebensanzeige: ${enemy.hp}")
            println("Stärke: ${enemy.strength}")
            println("Verteidigung: ${enemy.defense}")
            println()
        }

    }

      // Verzögert die Ausführung
    private fun sleep(game: String) {
        print("$game wird fortgesetzt...")
        println()
        for (i in 0..3) {
            print(".")
            Thread.sleep(1000)
        }
        println("")
    }
}