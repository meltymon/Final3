// CharacterCreator.kt
// Hauptdatei des Character Creators
// enthält das Programm und die Hauptfunktionalität
/*
import kotlin.random.Random
import java.io.File


class CharacterCreator {
    private val players = ArrayList<Player>()
    private val enemies = ArrayList<Enemy>()

    fun run() {
        // Willkommensnachricht anzeigen
        println("Willkommen beim Character Creator angelehnt an World of Warcraft!")

        // Interaktives Menü anzeigen
        while (true) {
            showMenu()
            when (readOption()) {
                1 -> createPlayer()
                2 -> createEnemy()
                3 -> showDetails()
                4 -> fight()
                5 -> saveCharacters(players, enemies)
                6 -> loadCharacters()
                7 -> break
            }
        }
    }

    // Zeigt das interaktive Menü an
    private fun showMenu() {
        println("\nBitte wählen Sie eine Option aus:")
        println("1 = Erstellen eines Characters")
        println("2 = Erstellen eines Gegners")
        println("3 = Zeige Details der Spieler und Gegner")
        println("4 = Starte Kampf")
        println("5 = Speichern der Spieler und Gegner")
        println("6 = Laden der Spieler und Gegner")
        println("7 = Beenden")
    }

    // Liest die Option des Benutzers ein
    fun readOption(): Int {
        print("Ihre Option:")
        return when (readlnOrNull()) {
            "1" -> 1
            "2" -> 2
            "3" -> 3
            "4" -> 4
            "5" -> 5
            "6" -> 6
            "7" -> 7
            else -> 0
        }
    }

    // Erstellt den Spieler
    fun createPlayer() {
        //Eingabe des Spieler namen
        val player = Player()
        player.name = readName()
        players.add(player)
    }

    // Erstellt den Gegner
    fun createEnemy() {
        //Generierter Gegner name
        val enemy = Enemy()
        enemy.name = generateName()
        enemies.add(enemy)

    }

    // Zeigt die Details der Spieler und Gegner an
    fun showDetails() {
        println("* * * * * * * * * * * * * * * * * *")
        println("\nDetails der Spieler:")
        for (player in players) {
            println("Name: ${player.name}")
            println("Lebensanzeige: ${player.hp}")
            println("Stärke: ${player.strength}")
            println("Verteidigung: ${player.defense}")
            println("Anzahl Leben: ${player.leben}")
            println()

        }
        sleep("Game")
        println("\nDetails der Gegner:")
        for (enemy in enemies) {
            println("Name: ${enemy.name}")
            println("Lebensanzeige: ${enemy.hp}")
            println("Stärke: ${enemy.strength}")
            println("Verteidigung: ${enemy.defense}")
            println()
        }

    }

    // Startet den Kampf
    fun fight() {
        for (player in players) {
            for (enemy in enemies) {
                while (player.hp > 0 && enemy.hp > 0) {
                    // Spieler schlägt zuerst
                    enemy.hp -= player.strength
                    if (enemy.hp > 0) {
                        // Gegner schlägt zurück
                        player.hp -= enemy.strength
                    }
                }
                if (player.hp > 0) {
                    // Spieler gewinnt Kampf
                    println("Glückwunsch ${player.name}, du hast den Kampf gewonnen")
                    player.leben++
                } else {
                    // Gegner gewinnt Kampf
                    println("Leider hat dich ${enemy.name} besiegt")
                    player.leben--
                }
            }
        }
    }

    // Speichert die Details der Spieler und Gegner
    private fun saveCharacters(players: ArrayList<Player>, enemies: ArrayList<Enemy>) {
        // Ausgabe der Speichermeldung
        println("Speichern der Spieler und Gegner in Spielstände.txt")
        sleep("Game")

        // Öffnen einer Datei zum Schreiben
        val file = File("Spielstände.txt")
        file.writeText("")

        // Spieler details speichern
        file.appendText("Spieler:\n")
        for (player in players) {
            file.appendText("Name: ${player.name}\n")
            file.appendText("Lebensanzeige: ${player.hp}\n")
            file.appendText("Stärke: ${player.strength}\n")
            file.appendText("Verteidigung: ${player.defense}\n")
            file.appendText("Anzahl Leben: ${player.leben}\n")
        }

        // Gegner details speichern
        file.appendText("\nGegner:\n")
        for (enemy in enemies) {
            file.appendText("Name: ${enemy.name}\n")
            file.appendText("Lebensanzeige: ${enemy.hp}\n")
            file.appendText("Stärke: ${enemy.strength}\n")
            file.appendText("Verteidigung: ${enemy.defense}\n")
        }

        // Schließen der Datei
        //file.close()
    }

    // Lädt die Details der Spieler und Gegner
    private fun loadCharacters() {
        // Ausgabe der Lade Meldung
        println("Laden der Spieler und Gegner aus Spielstände.txt")
        sleep("Game")

        // Öffnen einer Datei zum Lesen
        val file = File("Spielstände.txt")
        val lines = file.readLines()

        // Spieler details Laden
        var i = 1
        while (lines[i] != "\nGegner:") {
            val player = Player()
            player.name = lines[i].removePrefix("Name: ")
            player.hp = lines[i + 1].removePrefix("Lebensanzeige: ").toInt()
            player.strength = lines[i + 2].removePrefix("Stärke: ").toInt()
            player.defense = lines[i + 3].removePrefix("Verteidigung: ").toInt()
            player.leben = lines[i + 4].removePrefix("Anzahl Leben: ").toInt()
            players.add(player)
            i += 5
        }

        // Gegner details Laden
        i++
        while (i < lines.size) {
            val enemy = Enemy()
            enemy.name = lines[i].removePrefix("Name: ")
            enemy.hp = lines[i + 1].removePrefix("Lebensanzeige: ").toInt()
            enemy.strength = lines[i + 2].removePrefix("Stärke: ").toInt()
            enemy.defense = lines[i + 3].removePrefix("Verteidigung: ").toInt()
            enemies.add(enemy)
            i += 4
        }

        // Schließen der Datei
        //file.close()
    }

    // Liest den Namen des Spielers ein
    private fun readName(): String {
        print("Bitte geben Sie den Namen des Spielers ein:")
        return readlnOrNull().toString()
    }

    // Generiert einen Namen für den Gegner
    private fun generateName(): String {
        return "Gegner" + Random.nextInt(1, 1000)
    }

    // Schließt das Programm ab
    private fun exitGame() {
        println("Vielen Dank, dass Sie den Character Creator benutzt haben")
        println("Programm wird beendet")
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

// Klasse des Spielers
class Player {
    var name = ""
    var hp = 100
    var strength = 5
    var defense = 5
    var leben = 3
}

// Klasse des Gegners
class Enemy {
    var name = ""
    var hp = 100
    var strength = 5
    var defense = 5
}

fun main() {
    CharacterCreator().run()
}*/