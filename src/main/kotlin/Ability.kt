import kotlin.random.Random

private var config = Config()

open class Ability {

    //Definition von Fähigkeiten die Zufällig gewählt Werden
    open fun useAbility(player: Player, enemy: Enemy) {
        when (Random.nextInt(1, 3)) {
            1 -> {
                player.hp += 300
                println("${player.name} benutzt eine Heilfähigkeit und bekommt 300 Lebenspunkte!")
                config.sleep("Game")
            }

            2 -> {
                enemy.hp -= 200
                println("${player.name} benutzt eine starke Angriffsfähigkeit und verursacht 200 Schaden bei ${enemy.name}!")
                config.sleep("Game")
            }

            3 -> {
                println("${player.name} benutzt eine Verteidigungsfähigkeit und erhält einen 100 Bonus an Verteidigung!")
                player.defense += 100
                config.sleep("Game")
            }
        }
    }
}
