// Player.kt
// Klasse für den Spieler
//PlayerClass
open class Player {
    private var config = Config()
    var name = ""
    open var hp = config.playerHp
    open var strength = config.playerStrength
    open var defense = config.playerDefense
    open var totalDamage = config.playerTotalDamage
    var leben = config.anzahlLeben

//var abilitty:List<Ability> =listOf()
}
