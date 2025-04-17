package derekpeirce.objectionmaker

import kotlin.time.Duration.Companion.milliseconds

fun main() {
    makeTrial(defaultTextSpeed = 26, tabPauseTime = 100.milliseconds, punctuation = PuncutationMode.AUTO) {
        val phoenix = Phoenix()
        val judge = Judge()
        val maya = Maya()
        val edgeworth = Edgeworth("Miles")

        
    }.writeTo("dispel_magic.objection")
}