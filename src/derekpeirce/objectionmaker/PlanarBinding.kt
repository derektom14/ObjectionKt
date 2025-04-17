package derekpeirce.objectionmaker

import kotlin.time.Duration.Companion.milliseconds

val manes = true
fun main() {
    makeTrial(defaultTextSpeed = 26, tabPauseTime = 100.milliseconds, punctuation = PuncutationMode.AUTO) {
        val phoenix = Phoenix()
        val judge = Judge()
        val maya = Maya()
        val miles = Edgeworth(name = "Miles")
        val gallery = Gallery()

        playMusic(Music.TRIAL) {
            maya.angry("Ugh, we've been wandering around this maze forever! We need another plan!")
            miles("Agreed, I don't know how many more of these demons we can take on before we're toast.")
            phoenix.thinking("Maybe we could just... ask the demons for directions?")
            miles.deskSlam("They are our sworn enemies, we are not going to parlay with them!")
            phoenix.silly("Oh, no, I meant using magic to ask them. Though, I don't have any spells left that could do that, $dominatePerson isn't going to work here.")
            miles.read("Best I have is $command, and I don't think I could fit everything we'd be asking in a single word.")
            maya.thinking("Maybe something in German...")
            phoenix("Maya, you're the wizard, do you have any spells for this occasion?")
            maya.determined("Let's see... ooh, how about $planarBinding?")
        }
        playMusic(Music.ALLEGRO_2001) {
            maya("\"${textSpeed(18)}With this spell, you attempt to bind a celestial, an elemental, a fey, or a fiend to your service.")
            maya("\"${textSpeed(18)}The creature must be within range for the entire casting of the spell.")
            maya("\"${textSpeed(18)}(Typically, the creature is first summoned into the center of an inverted magic circle in order to keep it trapped while this spell is cast.)")
            maya("\"${textSpeed(18)}At the completion of the casting, the target must make a Charisma saving throw. On a failed save, it is bound to serve you for the duration.\"")
            phoenix.confident("Now we're getting somewhere, that would let us bind one of those demons to our will!")
            miles("If they fail their saving throw, at least.")
            maya("I doubt they'd be able to pass with a ${value(7)}, my remaining Portent!")
            maya.dull("Unfortunately, it takes a full hour to cast, that's not going to help us in combat.")
        }
        playMusic(Music.SUSPENSE) {
            miles.deskSlam.holdIt("There's a workaround for that! We can use $glyphOfWarding!")
            maya.thinking("Ah, so I cast the spell ahead of time and store it in a 5th-level glyph, and then the next demon that walks by gets hit with the spell?")
            miles.smirk("Precisely!")
            phoenix.point.objection("You missed an important part of $planarBinding!")
            phoenix.read("\"The creature must be within range for the entire casting of the spell.\"")
            phoenix.deskSlam("As the target demon is not in range when the spell is cast as part of $glyphOfWarding, the spell would fail.")
            miles.deskSlam.objection("And you missed an important part of $glyphOfWarding!")
            miles.read("\"${textSpeed(18)}You can store a prepared spell of 3rd level or lower in the glyph by casting it as part of creating the glyph.")
            miles.read("\"${textSpeed(18)}The spell must target a single creature or an area. The spell being stored has no immediate effect when cast in this way.")
            miles.read("\"${textSpeed(18)}When the glyph is triggered, the stored spell is cast.\"")
            miles.armsCrossed("The spell is cast two different times, once as part of creating the glyph with no immediate effect, and again on the trigger.")
            miles.confidentSmirk("Only the second casting, which is instantaneous, should matter here.")
            phoenix.headshake.objection("Even if the spell has disjoint casting times, the initial casting time is part of the same spell that is re-cast on the trigger.")
            phoenix.point("This is the only spell I know of that has this kind of restriction, it must be an important balance consideration that shouldn't be negated by $glyphOfWarding.")
            miles.armsCrossed.objection("By the most literal reading of the spells, only the second casting has an effect and should matter.")
        }
        playMusic(Music.TRUTH) {
            judge.stand.objection("We don't have all day to argue this point, even if it may seem like your characters do.")
            judge.eyesClosed("You both make solid points, this is an edge case among edge cases and the rules are ambiguous here.")
            judge.stand("Therefore, I will err on the side of balance. A $planarBinding stored in a $glyphOfWarding would be far more powerful than is intended for the spell.")
            judge.negative("I rule that you may not store a $planarBinding in a $glyphOfWarding unless the intended target is also in range for the initial casting.")
        }
        maya("The spell suggests trapping the target in a magic circle first, what if I stored $magicCircle in the glyph instead?")
        miles.damage("")
        phoenix.damage("Oh, duh.")
        playMusic(Music.ALLEGRO_2001) {
            gallery("One hour and one minute of spellcasting later...")
            maya("The trap is set!")
            miles("Excellent, then it's just a matter of waiting for a demon to approach.")
            if (manes) {
                judge("Time to get out an encounter table!$dieRoll Twenty minutes later, it will be$dieRoll, hm, yes, and it will appear$dieRoll, oh dear...")
            } else {
                judge("Time to get out an encounter table!${diceRolls(3)} Twenty minutes later, you see a Glabrezu approaching!")
                maya.stand("Perfect! Let's just lure it into the-", ActionArgs(interrupted = true))
            }
        }
        playMusic(Music.CROSS_EXAMINING) {
            if (manes) {
                judge.surprised("Suddenly materializing next to you is a manes, freshly formed from an evil soul reaching the Abyss.")
                miles.damage("But that's the weakest possible demon!")
                phoenix.damage("And it knows absolutely nothing!")
                judge("As soon as it appears, your glyph glows bright as a magic circle surrounds and traps it.")
            } else {
                miles.damage("We've fought them before, they can cast $dispelMagic! It'll destroy the circle as soon as it's created!")
                phoenix.damage("Not again! We'll just have to kill it like the last one!")
            }
        }
        if (manes) {
            maya("${textSpeed(80)}${Sound.POKEMON_CATCH}All right! MANES was caught!")
        }
    }.writeTo("planar_binding.objection")
}