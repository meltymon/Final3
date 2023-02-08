import kotlin.random.Random

open class Config {
    var anzahlLeben = 3
    var playerHp = Random.nextInt(100, 2000)
    var playerStrength = Random.nextInt(200, 250)
    var playerDefense = Random.nextInt(10, 200)
    var playerTotalDamage: Int = 0

    var enemyHp = Random.nextInt(100, 2000)
    var enemyStrength = Random.nextInt(500, 1000)
    var enemyDefense = Random.nextInt(150, 200)
    var ememyTotalDamage: Int = 0

    //Funktion Schlaf zum Delay Setzen
    fun schlaf(typ: String) {
        when (typ) {
            "Menu" -> Thread.sleep(1800)
            "Game" -> Thread.sleep(2500)
            "Continue" -> Thread.sleep(3000)
        }
    }

    // Verzögert die Ausführung
    fun sleep(game: String) {
        print("$game wird fortgesetzt...")
        println()
        for (i in 0..3) {
            print(".")
            Thread.sleep(1000)
        }
        println("")
    }
}




