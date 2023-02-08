//SaveLoad.kt
//enthält Funktionen für das Speichern und Laden von Dateien

@file:Suppress("DuplicatedCode", "DuplicatedCode")

import java.io.File


class SaveLoad {
    private var config=Config()

    // Speichert die Details der Spieler und Gegner
    fun saveCharacters(players: ArrayList<Player>, enemies: ArrayList<Enemy>) {
        // Ausgabe der Speichermeldung
        println("Speichern der Spieler und Gegner in Spielstände.txt")
        config.schlaf("Game")

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


    }

    // Lädt die Details der Spieler und Gegner
    fun loadCharacters():CharacterCreator {
        val cc=CharacterCreator()
        // Ausgabe der Lade Meldung
        println("Laden der Spieler und Gegner aus Spielstände.txt")
        config.schlaf("Game")

        // Öffnen einer Datei zum Lesen
        val file = File("Spielstände.txt")
        val lines = file.readLines()

        // Spieler details Laden
        var i = 1
        while (lines[i+1] != "Gegner:") {
            val player = Player()
            player.name = lines[i].removePrefix("Name: ")
            player.hp = lines[i + 1].removePrefix("Lebensanzeige: ").toInt()
            player.strength = lines[i + 2].removePrefix("Stärke: ").toInt()
            player.defense = lines[i + 3].removePrefix("Verteidigung: ").toInt()
            player.leben = lines[i + 4].removePrefix("Anzahl Leben: ").toInt()
            cc.players.add(player)
            i += 5
        }

        // Gegner details Laden
        i+=2
        while (i < lines.size) {
            val enemy = Enemy()
            enemy.name = lines[i].removePrefix("Name: ")
            enemy.hp = lines[i + 1].removePrefix("Lebensanzeige: ").toInt()
            enemy.strength = lines[i + 2].removePrefix("Stärke: ").toInt()
            enemy.defense = lines[i + 3].removePrefix("Verteidigung: ").toInt()
            cc.enemies.add(enemy)
            i += 4
        }
return cc

    }

}