package derekpeirce.objectionmaker

import derekpeirce.objectionmaker.ObjectionMaker.Builder.Pearl
import kotlin.time.Duration.Companion.milliseconds

fun main() {
    makeTrial(defaultTextSpeed = 26, tabPauseTime = 100.milliseconds) {
        val phoenix = Phoenix()
        val edgeworth = Edgeworth(name = "Miles")
        val judge = Judge()
        val maya = Maya()
        val (pearl, polly) = ActorPair(Pearl(), Polly())

        val textSpeedRead = textSpeed(16)

        playMusic(Music.TRIAL) {
            judge("And with that,\t Pearl,\t it's now your turn,\t with Polly on deck.")

            pearl(Pearl::worried, "Let's see,\t there are just two zombies left...")

            pearl(Pearl::happy, "They're close together,\t I can hit them both with a $fireball!")

            phoenix.headshake.holdIt("Hold on,\t Pearls,\t there's not enough room for that!")
            phoenix.silly("If you use that,\t you'll have to also hit some of us!")

            pearl(Pearl::surprised, "Oh!\t\t I'm sorry,\t Mr. Nick,\t I won't do that!")

            pearl(Pearl::dream, "Can I use $scorchingRay?")

            maya.determined("Yes,\t great choice,\t Pearly!")

            pearl(Pearl::happy, "I'll fire three rays at the first zombie,\t and then three more rays at the second zombie with $twinnedSpell!")
        }
        playMusic(Music.OBJECTION) {
            edgeworth.stand.objection("$twinnedSpell is only allowed on spells that $target only a single creature.\t\t ${scorchingRay.capitalize()}, able to hit multiple creatures,\t is ineligible.")

            phoenix.point.objection("But she's only $targeting one creature initially with all three rays,\t and then just one more creature with the extra rays!\t\t That should allow the spell to be $twinned!")

            judge("He has a point.\t\t The spell was cast with only a single $target.")

            edgeworth.armsCrossed.objection("Phoenix.\t\t\t I beg your pardon,\t but when did you obtain your copy of the Player's Handbook?")

            phoenix("Wh-when...!?\t\t\t It was late 2014...")

            edgeworth.confidentSmirk("Your PHB is outdated,\t Phoenix.")
            phoenix("Wh-what!?")
            edgeworth.read("A new paragraph was added about $twinnedSpell via ${Sound.REALIZATION}errata:")
            edgeworth.read(
                "$textSpeedRead\"To be eligible,\t a spell must be incapable of targeting more than one creature at the spell’s current level.\t\t" +
                        " For example,\t magic missile and scorching ray aren’t eligible,\t but ray of frost and chromatic orb are.\""
            )

            edgeworth.yell("${scorchingRay.capitalize()} is explicitly forbidden from this $metamagic!")

            phoenix.damage("")
        }

        playMusic(Music.MODERATO_2001) {

            judge.eyesClosed("Very well,\t then you may select a different spell,\t Pearl.")

            pearl("Aw,\t fine...")

            edgeworth("The right answer here is to use $burningHands to weaken them,\t so that I can finish them off.")

            pearl("But Polly is going next...")
            pearl(Pearl::dream, "I'll cast $twinned $dragonsBreath on me and Polly!\t\t Then we can both burn the monsters!")
        }
        playMusic(Music.CORNERED) {
            edgeworth.point.objection("${dragonsBreath.capitalize()} is also ineligible for being $twinned, as it has multiple $targets!")

            phoenix.point.objection("${dragonsBreath.capitalize()} has a range of touch, and has only one $target, the creature imbued with a breath weapon!")
            phoenix.read("It's a $transmutation spell that transforms the creature and gives it its own ability\t, anything beyond that is incidental.")

//        pearl.happy("Then I'll cast a Twinned firebolt instead!")
//
//        edgeworth.stand.objection("Firebolt is also invalid! As it can target objects as well as creatures!")
//
//        phoenix.point.objection("Why would that matter? The rule only requires it to be unable to target more than one creature!")

            edgeworth.confidentSmirk("They also released a Sage Advice Compendium with more clarifications on $twinnedSpell.")
            edgeworth.read("One of the disqualifiers is,\t $textSpeedRead\"The spell can force more than one creature to make a $savingThrow before the spell's duration expires.\"")

            pearl(Pearl::sad, "But I just wanted to give us both the power to breathe fire.")

            maya.determined.holdIt("That Sage Advice isn't actually a ruling!\t\t It's just \"design intent\"!\t\t It says the DM has final say!\t\t You're just trying to make sure you get the final kill!")

            judge.surprised("Oh,\t dear!\t\t I haven't made my mind up on this one yet!")

            edgeworth.deskSlam("Surely,\t their intent should carry weight!\t\t Pearl would not be the only $target of the spell,\t it also counts everyone hit by its breath weapons!")

            phoenix.thinking.holdIt("Would you consider $haste to be eligible for $twinnedSpell?")

            edgeworth.confidentShrug("Of course,\t it only $targets a single creature.")

            phoenix.confident.takeThat("But $haste lets that creature do extra attacks!\t\t And with smites or battle maneuvers,\t those can force $savingThrows!\t\t Is every creature you hit a $target of $haste?")
            phoenix.confident("They could also throw caltrops with their extra action, \tand those can force $saves from many creatures!")

            edgeworth.damage("But,\t that's different,\t the $saves come from other factors outside of the spell!")

            phoenix("And why should that matter?\t\t And what of $polymorph?")

            edgeworth.cornered("Obviously,\t $polymorph should work for the same reason.")

            phoenix("But the stat blocks of various beasts include $savingThrows against poison damage or being knocked prone!")
            phoenix("With $dominatePerson, you could $target two dragonborns and command them to use their breath weapons,\t too!")

            phoenix.yell("And how about $truePolymorph?\t\t You could turn two creatures into dragons,\t and then they can use breath weapons all day!")

            judge.negative("Well,\t Miles?\t\t Your distinction sounds rather arbitrary.\t\t Are you going to argue against $twinned $haste and $polymorph as well?")

            edgeworth.damage("No,\t I suppose not.")
        }
        playMusic(Music.SUSPENSE) {
            edgeworth.confidentSmirk("But clearly,\t the design intent wasn't just for consistency.\t\t It was for balance.")
            edgeworth.smirk("After they released dragon's breath,\t they realized that $twinning it would be too powerful,\t and adjusted accordingly.")

            judge.surprised("You're saying that allowing this will break the game's balance?")

            pearl(Pearl::sad, "Oh no,\t I didn't mean to break anything...")
            maya.angry("No,\t Pearly,\t you didn't break anything!\t\t Miles is just being a jerk!")

            edgeworth.armsCrossed("There's nothing wrong with being a jerk as long as I'm right.")

            phoenix.deskSlam.objection("Compared to other spells,\t $twinned $dragonsBreath is not overpowered!")
            phoenix.point("Sure,\t it's powerful,\t but not any more than $haste or $polymorph relative to their levels!")
            phoenix.point("I mean,\t $twinned $polymorph lets you transform yourself and an ally into giant apes,\t with full hit points!")

            judge.negative("Miles,\t is there anything that makes $dragonsBreath particularly more powerful when $twinned?")

            edgeworth.confidentSmirk("Simple. Both $haste and $polymorph add more power to an already-powerful creature.")
            edgeworth.confidentSmirk("${dragonsBreath.capitalize()} lets you power up a creature that is otherwise ineffective in combat,\t like a familiar.")
            edgeworth.confidentShrug("${keyword("Twinning")} $dragonsBreath onto two familiars would be far too powerful.")
            phoenix.deskSlam.objection("Creatures that have low attack power also tend to have low defense as well!\t\t The familiars can be destroyed in one attack each!")
        }

        playMusic(Music.TRUTH) {
            // gavel
            judge.stand.objection("We don't have all day for this.\t I've heard enough,\t and as DM,\t I must take into account these arguments and make a ruling.")
            judge("I rule that you may $twin $dragonsBreath,\t considering the creature receiving the breath weapon as the sole $target.")
            judge("You reach out to Polly,\t wand in hand,\t and imbue her and yourself with fire breath.")

            pearl(Pearl::happy, "Yay! ", args = ActionArgs(mergeNext = true))
            pearl(Pearl::dream, "And for my action,\t I breathe fire on the zombies!\t\t That's ${diceRolls(3)}${value(10)} fire damage!")
            judge("${diceRolls(2)}And they both fail their $saves.\t\t Up next is Polly.")
            maya.determined("Polly will use her dragon's breath on the zombies!")
            pearl(Pearl::happy, "Here,\t Polly,\t roll these dice!")
            polly("Let's gooooooo!${diceRolls(3)}")
            pearl(Pearl::surprised, "That's,\t um,\t ${value(13)} fire damage!")

            judge("Very well,\t and ${diceRolls(2)}that's two more failures... ${diceRolls(2)}")
        }
        judge.surprised("Um,\t how does Polly want to do this?")
        polly("${textSpeed(200)}I am fire.\t\t I am death.")



//        edgeworth.read("One of the disqualifiers is, \"The spell can target an object.\"")
//        edgeworth.point("And firebolt is one such spell!")
    }.writeTo("twinned.objection")
}