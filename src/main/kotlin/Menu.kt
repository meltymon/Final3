class Menu {

    private var cc = CharacterCreator()
    private var saveload = SaveLoad()
    private var fight = Fight()
    private var config = Config()

    fun run() {
        // Willkommensnachricht anzeigen
        println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *")
        println("*Willkommen beim Character Creator angelehnt an World of Warcraft!*")

        // Interaktives Menü anzeigen
        while (true) {
            showMenu()
            when (cc.readOption()) {
                1 -> cc.createPlayer()
                2 -> cc.createEnemy()
                3 -> showDetails()
                4 -> fight.startFight(cc.players, cc.enemies)
                5 -> saveload.saveCharacters(cc.players, cc.enemies)
                6 -> cc = saveload.loadCharacters()
                7 -> break
            }
        }
    }

    // Zeigt das interaktive Menü an
    private fun showMenu() {
        println("\n* * * * * * Bitte wählen Sie eine Option aus: * * * * * * * * * * * ")
        println("* 1 = Erstellen eines Characters                                  *")
        println("* 2 = Erstellen eines Gegners                                     *")
        println("* 3 = Zeige Details des Spielers und Gegners                      *")
        println("* 4 = Starte Kampf                                                *")
        println("* 5 = Speichern der Spieler und Gegner                            *")
        println("* 6 = Laden der Spieler und Gegner                                *")
        println("* 7 = Programm Beenden                                            *")
        println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *")
    }

    // Zeigt die Details der Spieler und Gegner an
    private fun showDetails() {
        println("* * * * * * * * * * * * * * * * * *")
        println("*** Players ***")
        config.schlaf("Menu")
        println("\nDetails der Spieler:")
        for (player in cc.players) {
            println("Name: ${player.name}")
            println("Lebensanzeige: ${player.hp}")
            println("Stärke: ${player.strength}")
            println("Verteidigung: ${player.defense}")
            println("Anzahl Leben: ${player.leben}")
            println()

        }
        config.sleep("Menu")
        println("*** Enemies ***")
        config.schlaf("Menu")
        println("\nDetails der Gegner:")
        for (enemy in cc.enemies) {
            println("Name: ${enemy.name}")
            println("Lebensanzeige: ${enemy.hp}")
            println("Stärke: ${enemy.strength}")
            println("Verteidigung: ${enemy.defense}")
            println()

        }


    }

}