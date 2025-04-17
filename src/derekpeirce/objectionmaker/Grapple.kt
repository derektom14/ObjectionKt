package derekpeirce.objectionmaker

import derekpeirce.objectionmaker.ObjectionMaker.Builder.JakeMarhsall
import kotlin.time.Duration.Companion.milliseconds

fun main() {

    makeTrial(defaultTextSpeed = 26, tabPauseTime = 100.milliseconds, punctuation = PuncutationMode.AUTO) {
        val phoenix = Phoenix()
        val judge = Judge()
        val maya = Maya()
        val franziska = FranziskaVonKarma()
        val (larry, jake) = ActorPair<ObjectionMaker.Builder.Larry, JakeMarhsall>(Larry(name = "Larry"), JakeMarhsall())
        val gallery = Gallery()

        playMusic(Music.SUSPENSE) {
            judge("At the top of initiative, we have Gregor the Mighty, with Maya on deck. He enters a rage, and moves 20 feet towards Jake.")
            judge("He attempts to grapple you. You can contest it with either Athletics or Acrobatics.")
            jake("I'll go with Acrobatics. ${dieRoll}That's a 16.")
            judge("${dieRoll}He gets a 29. You are grappled! He then moves 20 feet towards Maya.")
        }
        playMusic(Music.OBJECTION) {
            phoenix.point.objection("While he's moving and dragging Jake, his speed is halved!")
            phoenix.deskSlam("He already moved 20 feet, so he would need a total speed of 60 to move that far now!")
            franziska.confident.objection("Foolish fool who foolishly assumes nothing beyond his own foolish knowledge!")
            franziska.whipDesk("As of Tasha's, when a barbarian rages, they can immediately move half their speed!")
            phoenix.damage("Oh, right!")
            judge.positive("He then attempts to grapple Maya!")
            maya.determined("I'll also use Acrobatics!")
            maya.dull("${dieRoll}That's an 11. I don't think that can succeed.")
            judge.eyesClosed("${dieRoll}24, you are also grappled.")
        }
        playMusic(Music.TRIAL) {
            judge("Maya, it is now your turn.")
            maya.thinking("Alright, what are the ways I can break out of this grapple?")
            maya.thinking("I can use an action to repeat the check to escape, but that doesn't look like I'll succeed.")
            phoenix.read("It also ends if the grappler is incapacitated, so if you can paralyze him, that'll free you and Jake!")
            jake(JakeMarhsall::shave, "You could also escape by teleporting, don't you worry about me, bambina.")
            maya.determined("Alright, then I'll cast $mistyStep, and teleport to be next to Franziska.")
            maya.determined("And then I'll cast $mindSliver as my action! Gregor makes an Int save!")
            judge("That's ${dieRoll}a 6.")
            maya.determined("That fails, so he takes ${diceRolls(3)}${value(12)} psychic damage, and gets a 1d4 penalty on his next save!")
        }
        playMusic(Music.SUSPENSE) {
            judge("It's now a hidden NPC's turn. You hear the sound of a spell being cast in the center of the room, but you see nobody there.")
            phoenix.thinking("And we can't see the caster? Perhaps they're trying to avoid $counterspell?")
            judge.surprised("Perhaps. Suddenly, the noise of the struggle between Gregor and Jake is gone, and Jake, you can no longer hear anything.")
            jake(JakeMarhsall::cornered, "Of course, a grapple/silence combo. Makes sense, since we've got four caster in our gang right now.")
            judge("As she has finished casting, the caster is now visible in the center of the room: Gregor's ally, ")
        }
        playMusic(Music.ALLEGRO_2001) {
            judge("Jake, it's now your turn. You're aware that you cannot cast any spells that require a verbal component.")
            jake(JakeMarhsall::drink, "That's fine, my escape plan didn't require any of that speaking anyhow.")
            jake(JakeMarhsall::serious, "I'll wildshape into a fire elemental!")
            maya("Of course, fire elementals are immune to the grappled condition!")
            jake("I'll move into the hombre's space and set him on fire for ${dieRoll} ${value(3)} fire damage, then use two touch attacks!")
            jake("${diceRolls(2)}That's a 14 and an 18!")
            judge.eyesClosed("Both miss.")
        }
        gallery("One round of combat later...")
        playMusic(Music.CROSS_EXAMINING) {
            judge("We're back to Gregor's turn. He takes ${dieRoll} fire damage from being on fire ")
        }

    }
}