class Menu {

    private var cc =CharacterCreator()
    private var cb= InteractiveMenu()
    private var ca= SaveLoad()
    private var cf= Fight()

    fun run() {
        // Willkommensnachricht anzeigen
        println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *")
        println("*Willkommen beim Character Creator angelehnt an World of Warcraft!*")

        // Interaktives Menü anzeigen
        while (true) {
            showMenu()
            when (cc.readOption()) {
                1 -> cb.createPlayer()
                2 -> cb.createEnemy()
                3 -> cb.showDetails()
                4 -> cf.fight()
                5 -> ca.saveCharacters(cc.players, cc.enemies)
                6 -> ca.loadCharacters()
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
}