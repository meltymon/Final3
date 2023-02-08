// CharacterCreator.kt
// Hauptdatei des Character Creators
// enthält das Programm und die Hauptfunktionalität

class CharacterCreator {
    private var config = Config()
    val players = ArrayList<Player>()
    val enemies = ArrayList<Enemy>()

    // Liest die Option des Benutzers ein
    fun readOption(): Int {
        print("Ihre Option:")
        val input = readln()
        //Abfangen von Exceptions
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            println("Du hast eine Falsche eingabe gemacht,Versuche es Erneut")
            config.schlaf("Game")
            readOption()
        }

    }
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
    // Liest den Namen des Spielers ein
    fun readName(): String {
        print("Bitte geben Sie den Namen des Characters ein: ")
        return readlnOrNull() ?: ""
    }

    // Generiert den Namen des Gegners
    fun generateName(): String {
        val adjectives = listOf("Böser ", "Mutiger ", "Starker ", "Furchtloser ", "Hinterhältiger ")
        val nouns = listOf("Ork", "Elf", "Zwerg", "Mensch", "Untoter")
        val adjective = adjectives.random()
        val noun = nouns.random()
        println("Der Gegner Heißt '${adjective}${noun}'")
        config.schlaf("Game")
        return "$adjective$noun"
    }

    /*fun calculateDamage(strength: Int, defense: Int): Int {
        // Generiert zufällig Stärke und Verteidigung
        //generateRandomStrengthAndDefense()
        return strength - defense
    }*/
}

