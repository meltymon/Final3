import kotlin.random.Random


class Fight{

    private var cc=Config()
    private var cf=CharacterCreator()

    // Startet den Kampf zwischen Spieler und Gegner
fun fight() {
        val player=Player()
        val enemy=Enemy()

        println("\nRunde ${8-player.leben}")
    println("Der Kampf zwischen ${player.name} und ${enemy.name} beginnt!")

    while (player.hp > 0 && enemy.hp > 0) {
        val damagePlayer = cf.calculateDamage(player.strength, enemy.defense)
        enemy.hp -= damagePlayer
        cc.schlaf("Game")
        println("${player.name} hat ${enemy.name} $damagePlayer Schaden zugefügt!")
        if (enemy.hp > 0) {
            val damageEnemy = cf.calculateDamage(enemy.strength, player.defense)
            player.hp -= damageEnemy
            cc.schlaf("Game")
            println("${enemy.name} hat ${player.name} $damageEnemy Schaden zugefügt!")
        }
    }
    if (player.hp > 0) {
        println("\n${player.name} hat ${enemy.name} besiegt!")
        cc.schlaf("Game")
    } else {
        println("\n${enemy.name} hat ${player.name} besiegt!")
        player.leben --
        if ((player.leben) >0){
            player.hp=(Random.nextInt(100,500))
            println("Du hast noch ${player.leben} Leben Übrig,deswegen hast du noch eine Weitere Chance")
            println("Deine Lebenspunkte haben sich um ${player.hp} Erhöht")
            cc.schlaf("Continue")
            fight()

        }
        else println("Du hast alle Leben Verloren und das Spiel ist nun Vorbei")

        cc.schlaf("Game")
    }
}}