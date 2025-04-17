package derekpeirce.objectionmaker

import kotlin.time.Duration.Companion.milliseconds

fun main() {
    makeTrial(tabPauseTime = 100.milliseconds, punctuation = PuncutationMode.AUTO) {
        val phoenix = Phoenix()
        val edgeworth = Edgeworth(name = "Miles")
        val judge = Judge()
        val maya = Maya()

        playMusic(Music.TRIAL) {
            judge("As you reach the end of the trail, you see before you the Twilight Cave in a cliff face, about 20 feet up.")
            judge("To reach the cave's entrance, you'll have to start climbing.")
            phoenix.thinking("Should we get out the climbing kits? Or does it look like an easy climb?")
            judge("The rocky terrain appears to be climbing-friendly.")
            phoenix("Great, we should all be able to climb up with ease! Miles, you have a spell slot to re-summon Missile at the top, right?")
            edgeworth("What do you mean? I've already summoned Missile.")
            phoenix("Yeah, but he's obviously not going to be able to climb up with us, so you'll need to cast $findSteed again.")
            edgeworth.read("Hm...")
            maya.thinking("If only we had a long-enough ladder.")
            phoenix("For a horse to use it, it would have to be a very long and sturdy step-ladder.")
            maya.stand("So? What's the difference? You need to stop judging things based on narrow-minded", args = ActionArgs(interrupted = true))
        }
        playMusic(Music.SUSPENSE) {
            edgeworth.point.objection("Horses are able to climb up cliffs!")
            judge.surprised("What?!")
            maya.dull("What?!")
            phoenix.deskSlam.objection("Obviously horses can't climb cliffs! That's absurd!")
            edgeworth.smirk("Tell me, Phoenix, what do the rules for climbing say?")
            phoenix("That should be under Special Types of Movement.")
            phoenix.read("\"While climbing or swimming, each foot of movement costs 1 extra foot (2 extra feet in difficult terrain), unless a creature has a climbing or swimming speed.")
            phoenix.read("\"At the DM's option, climbing a slipper vertical surface or one with few handholds requires a successful Strength (Athletics) check.\" So?")
            edgeworth.armsCrossed("And where does it say that a creature needs to have hands to climb?")
            phoenix.damage("Then why do I remember reading about climbing requiring hands?")
            edgeworth.confidentShrug("Perhaps 3.5e,\t which had that requirement.\t\t Your knowledge of climbing rules is outdated.", args = ActionArgs(punctuation = PuncutationMode.MANUAL))
            judge.eyesClosed("The rules seem to check out, though it is strange.")
        }
        playMusic(Music.CORNERED) {
            maya.angry("But that doesn't make any sense! It isn't anatomically possible!")
            edgeworth.confidentShrug("Those are the rules. You should take $phantomSteed next level, then we can both climb cliffs with horses.")
            maya.thinking("Ooh, I like the sound of that.")
            maya("Let's let this one slide, Nick!")
            phoenix.deskSlam("No, it's absurd! Surely the designers just overlooked this case! This isn't Skyrim!")
            judge("Is Skyrim a different setting? I'm hesitant to accept this, but if most of the players are in favor of it...")
        }
        playMusic(Music.OBJECTION) {
            phoenix.deskSlam.holdIt("Let's look at that last sentence again. At the DM's option, a surface with few handholds requries a successful Athletics check.")
            edgeworth("Yes, and? The DM already said that the terrain is climbing-friendly, so handholds should be plentiful.")
            phoenix.confident("Yes, there are enough handholds for a humanoid...")
            phoenix.yell("But how many are there from the point of view of a horse?")
            judge.surprised("Of course! There are none!")
            edgeworth.damage("Urk!")
            phoenix("So, it's entirely within the DM's option to require an Athletics check. DM, what's the DC?")
        }
        playMusic(Music.TRUTH) {
            judge.stand.objection("As horses cannot climb cliffs, I set the DC at 40.")
            edgeworth.cornered("Fine, I'll re-summon Missile at the top.")
            maya.thinking("According to $phantomSteed, I can choose the appearance of the steed. Could I give it hands?")
        }
        judge.surprised("${Sound.DAMAGE2}\t\t\t\t\t")
        edgeworth.damage("\t\t")
        phoenix.damage("I don't even want to imagine such a horror.")
    }.writeTo("climbing.objection")
}