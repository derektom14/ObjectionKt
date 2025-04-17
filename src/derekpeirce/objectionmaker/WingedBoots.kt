package derekpeirce.objectionmaker

import kotlin.time.Duration.Companion.milliseconds

fun main() {
    makeTrial(defaultTextSpeed = 26, tabPauseTime = 100.milliseconds, punctuation = PuncutationMode.AUTO) {
        val phoenix = Phoenix()
        val cody = CodyHackins()
        val judge = Judge()
        val maya = Maya()
        val godot = Godot()

        playMusic(Music.TRIAL) {
            cody.confident("")
        }
    }
}