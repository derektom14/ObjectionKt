package derekpeirce.objectionmaker

import java.awt.Color

fun red(text: String) = color(text, Color.RED)

fun main() {
    makeTrial {
        val gumshoe = Gumshoe()
        val phoenix = Phoenix()
        val judge = Judge()

        playMusic(Music.TRIAL) {
            gumshoe.stare("Well, I have some bad news.")
            gumshoe.headscratch("It turns out that shipping something from California to California still takes over a week.")
            gumshoe.sad("So I'm afraid the gift won't arrive in time.")
        }
        phoenix.deskSlam.holdIt("That's why there's a backup plan!")
        playMusic(Music.ALLEGRO_2001) {
            phoenix.read("A Nintendo eShop gift card for ${red("$15")}.")
            judge.surprised("${red("$15")}? That's just enough for...")
            phoenix.point("The ${red("Phoenix Wright: Ace Attorney Trilogy")}! Check your e-mail")
        }
    }.writeTo("christmas.objection")
}