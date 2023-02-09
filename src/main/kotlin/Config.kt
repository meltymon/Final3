import kotlin.random.Random
//Configurations KLasse ,wo alle Characterwerte und Delay Timers Konfiguriert werden
open class Config {
    var anzahlLeben = 3
    var playerHp = Random.nextInt(500, 750)
    var playerStrength = Random.nextInt(200, 250)
    var playerDefense = Random.nextInt(150, 200)
    var playerTotalDamage: Int = 0

    var enemyHp = Random.nextInt(1000, 1250)
    var enemyStrength = Random.nextInt(200, 250)
    var enemyDefense = Random.nextInt(150, 200)
    var ememyTotalDamage: Int = 0

    //Funktion Schlaf zum Delay Setzen
    fun schlaf(typ: String) {
        when (typ) {
            //Unterschiedliche Verzögerungstimer je nach Anwendungszweck
            "Menu" -> Thread.sleep(1500)
            "Game" -> Thread.sleep(1800)
            "Continue" -> Thread.sleep(2000)
        }
    }

    // Verzögert die Ausführung
    fun sleep(game: String) {
        print("$game wird fortgesetzt...")
        for (i in 0..3) {
            print(".")
            Thread.sleep(1000)
        }
        println("")
    }
}




