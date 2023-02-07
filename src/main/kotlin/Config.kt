import kotlin.random.Random

open class Config {
    var anzahlLeben=7
    var playerHp = Random.nextInt(100, 2000)
    var playerStrength = Random.nextInt(200, 250)
    var playerDefense = Random.nextInt(10, 200)

    var enemyHp = Random.nextInt(100, 2000)
    var enemyStrength = Random.nextInt(500, 1000)
    var enemyDefense = Random.nextInt(150, 200)

    //Funktion Schlaf zum Delay Setzen
    fun schlaf(typ:String){
        when (typ){
            "Menu"-> Thread.sleep(1800)
            "Game" -> Thread.sleep(1000)
            "Continue" -> Thread.sleep(2400)}}
}



