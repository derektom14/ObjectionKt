package derekpeirce.objectionmaker

import kotlin.math.max
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.time.Duration.Companion.milliseconds

typealias Args = ActionArgs

val numToString = listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")

fun main() {

    val mayaRolls = Random(20)

    makeTrial(defaultTextSpeed = 26, tabPauseTime = 100.milliseconds, punctuation = PuncutationMode.AUTO) {
        val phoenix = Phoenix()
        val judge = Judge()
        val maya = Maya()
        val edgeworth = Edgeworth(name = "Miles")

        playMusic(Music.TRIAL) {
            judge("Maya, you're up first in initiative, with Miles on deck.")
            maya("Great, I'll show that bone devil what for! Um, what are a devil's weaknesses?")
            phoenix.stand("Well, they tend to be immune to", Args(interrupted = true))
            edgeworth.deskSlam.objection("Don't metagame! Just because you know about devils out-of-game doesn't mean you get to use that knowledge here!")
            judge.positive("Quite right.")
            phoenix.silly("Oh, sorry.")
        }
        playMusic(Music.OBJECTION) {
            maya("Can I make an Arcana check?")
            judge.positive("That makes sense. Go ahead and roll.")
            maya("That's$dieRoll a ${value(24)}!")
            judge("Then from your studies, you know that most devils don't have particular weaknesses, but they do have Magic Resistance.")
            judge("You also know that they are immune to fire and poison, and resistant to cold and $nonmagical physical attacks that aren't $silvered.")
            maya.thinking("Ah, ok.", Args(mergeNext = true))
        }
        playMusic(Music.CORNERED) {
            maya.angry(" Hey, wait, that covers most of my best spells!")
            edgeworth.armsCrossed("Then maybe you should stick to control and buff spells for now, that's where wizards excel.")
            maya.thinking("No, I've got to have something for this!")
            maya.determined("I got it! I'll use $animateObjects! And I'll animate those five chairs over there!")
            phoenix.thinking.holdIt("Are you sure you want to choose chairs? They have legs, so they won't have a flying speed, which will be important if this devil flies away!")
            edgeworth.read("Plus, if you're going to be animating objects, you should choose Tiny objects, it's the optimal choice. I'll send you the link.")
            judge.surprised("I thought she was animating chairs, not chains?")
            edgeworth.damage(pause)
            maya.angry("Ugh, why does everything have to be optimized with you?")
            edgeworth.deskSlam("Because I'm trying to keep us from getting killed by a devil!")
        }
        maya.dull("Fine, I'll animate the knife set again! At least the devil won't have resistance here!")
        playMusic(Music.SUSPENSE) {
            edgeworth.confidentSmirk.objection("Attacks made by animated objects don't count as $magical!")
            phoenix.point.objection("The attacks are powered by a spell! How could they not be $magical?")
            edgeworth.deskSlam("Because the spell doesn't say that they are!")
            edgeworth.point("We know that beasts from $conjureAnimals don't inherently have $magical attacks, because Shepherd druids grant them that with a subclass ability!")
            phoenix.cornered("${Sound.WHOOPS}That's a good point.")
            maya.angry("Why are you trying to weaken what I'm doing? I should animate your boots and kick you in the head with them!")
            edgeworth.smirk.objection("That's not going to work, the spell clearly states that the target objects must be neither worn nor", Args(interrupted = true))
            maya.angry("Gah!")
        }
        playMusic(Music.ALLEGRO_2001) {
            maya.thinking("Wait, DM, what did you say the devil was resistant to?")
            judge("You would know that it's resistant to cold damage; and bludgeoning, piercing, and slashing damage from $nonmagical attacks that aren't $silvered.")
            maya.determined("${Sound.REALIZATION}That's it! I'll grab ten silver coins from my bag and animate them! They're $silver, so they'll overcome the resistance!")
            phoenix.confident("Well done! Any objections, Miles?")
            edgeworth.confidentShrug("I have nothing against it, at least you're choosing Tiny objects.")
            judge("Then it's finally settled, you cast $animateObjects and now have ten animated silver coins hovering around you. Roll initiative for your coins.")
            maya("That's a $dieRoll${value(13)}!")
        }
        playMusic(Music.CROSS_EXAMINING) {
            judge("Very well. Next is Miles's turn, with Phoenix on deck. What do you do?")
            edgeworth("Well, if we're going to use this plan, we may as well go all-in. I'll move up to the bone devil.")
            phoenix("Time for smiting, then?")
            edgeworth.armsCrossed("Actually, no. I'll cast $fogCloud, then draw my spear!")
            judge.positive("Ah! With your casting, a fog sets in, and nobody can see anything.")
            phoenix("What's your plan here?")
            edgeworth.smirk("By blinding everyone, I've granted $advantage to everyone who has $blindsight. That would be me, and the coins!")
            maya("Wow, thanks!")
            phoenix.point.takeThat("I'll give Maya a $bardicInspiration, then cast $polymorph, turning myself into a giant scorpion!")
            phoenix("Now I also have $blindsight! I move next to the bone devil!")
            judge.positive("Alright, and now it's the coins' turn. Go ahead and roll your attacks, its AC is 19.")
            maya.determined("Ok, ten attacks with $advantage, that's ", Args(interrupted = true))
            var hits = 0
            var crits = 0
            repeat(10) {
                val roll = mayaRolls.rollWithAdvantage()
                if (roll == 20) {
                    crits++
                    hits++
                } else if (roll + 8 >= 19) {
                    hits++
                }
            }
            listOf(maya.determined, phoenix.sipMug, edgeworth.armsCrossed, judge.surprised, maya.determined).forEach { action ->
                action(diceRolls(2) + smallPause + diceRolls(2), Args(animated = false, mergeNext = true, interrupted = true))
            }
            maya.determined("${numToString[hits]} hits, with ${numToString[crits]} ${if (crits > 1) "crits" else "crit"}!", Args(mergeNext = true))
            val damage = 4 * hits + (1..(hits + crits)).sumBy { mayaRolls.nextInt(1..4)}
            maya.determined(" For a total of ${diceRolls(hits + crits)}${value(damage)} damage!")
            judge.surprised("Oh, wow! Now it's the bone devil, who heads straight towards Maya!")
            edgeworth.deskSlam.objection(
                "I take my opportunity attack with $advantage, for ${diceRolls(2)}a ${value(25)} to hit, striking for$dieRoll ${value(
                    10
                )} $magical piercing damage!"
            )
            maya.determined.holdIt("Two of the coins get opportunity attacks! ${diceRolls(2) + smallPause + diceRolls(2)} They both hit, for ${diceRolls(2)} ${value(12)} bludgeoning damage!")
            phoenix.deskSlam.takeThat(
                "I also take my opportunity attack with $advantage, for ${diceRolls(2)}a ${value(20)} to hit, dealing$dieRoll ${value(
                    6
                )} $nonmagical bludgeoning damage and grappling it!"
            )
            judge.surprised("It's now bloodied. Er, ichored. It will attack Miles instead, with${repeatStr(3) { diceRolls(2) }}$bigPause; no, none of those hit.")
            judge.eyesClosed("And this was supposed to be a hard encounter for you three, I didn't expect this level of teamwork.$bigPause")
        }
        playMusic(Music.TRUTH) {
            judge.surprised("Suddenly, a second bone devil who heard the commotion joins the battle!")
            edgeworth.smirk("Really, you're adjusting the encounter after one round?")
            phoenix.confident("You know what? Bring it! With my $bardicInspiration and Miles' $aura, we've got Maya's $concentration protected!")
            maya.determined("Yeah, bring it! Serve up all the devils you want and we'll send them right back to the Nine Hells!")
        }
    }.writeTo("animate_objects.objection")
}

fun Random.rollWithAdvantage() = max(nextInt(20), nextInt(20)) + 1