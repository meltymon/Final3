import kotlin.random.Random

private var cf = Config()

open class Ability {


    open fun useAbility(player: Player, enemy: Enemy) {
        when (Random.nextInt(1, 3)) {
            1 -> {
                player.hp += 50
                println("${player.name} benutzt eine Heilfähigkeit und bekommt 50 Lebenspunkte!")
                cf.schlaf("Game")
            }

            2 -> {
                enemy.hp -= 200
                println("${player.name} benutzt eine starke Angriffsfähigkeit und verursacht 200 Schaden bei ${enemy.name}!")
                cf.schlaf("Game")
            }

            3 -> {
                println("${player.name} benutzt eine Verteidigungsfähigkeit und erhält einen Bonus an Verteidigung!")
                player.defense += 50
                cf.schlaf("Game")
            }
        }
    }
}
