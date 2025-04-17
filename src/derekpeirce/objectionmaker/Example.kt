package derekpeirce.objectionmaker

import java.awt.Color
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds


fun main() {

    makeTrial(defaultTextSpeed = null) {
        
        val judge = Judge()
        val phoenix = Phoenix()
        val vonKarma = VonKarma()
        val maya = Maya()
        val polly = Polly()
        
        playMusic(Music.TRIAL) {
            judge("Now that you've defeated the archmage and his cohorts,\t what would you like to do?")
            phoenix("I'm going to search the archmage's body for any hints to who his allies are.")
            vonKarma("I'll follow and keep an eye out for any remaining threats.\t$dieRoll That's a ${value(16)} on my $perception check.")
            phoenix.silly.think("(Isn't he supposed to wait for the DM to ask for the roll?)")
            maya("I'll stay back and start casting $leomundsTinyHut for our $shortRest,\t but you can take Polly with you!\t\t Polly,\t $help!")
            polly("I'm helping!\t I'm helping!")
            judge.positive("Very well.\t\t Phoenix, you may make an $investigation check,\t with $advantage from the familiar's $help.")
            judge("Von Karma,\t with your $perception check,\t you don't notice any further threats about you.")
            phoenix.stand("Great!$dieRoll I rolled a ${value(13)},\t which comes out to a ${value(25)} with modifiers,\t but my passive", args = ActionArgs(interrupted = true))
        }
        playMusic(Music.SUSPENSE) {
            vonKarma.snapFinger.holdIt("While Phoenix is busy investigating,\t\t\t I'll take out my $daggerOfVenom and stab him in the back!")
            phoenix.damage("Wait,\t what?\t\t Why would you attack me?\t\t And why now?")
            vonKarma.confident(
                "Simple.\t\t You and Maya took significant damage in the last fight,\t" +
                        " and this is my perfect chance to finally get rid of both of you and claim the glory for myself.",
                args = ActionArgs(animated = false)
            )
            maya.angry("No way!\t That's not fair!\t DM,\t you can't let him do this!")
            vonKarma.armsCrossed.objection("No,\t this isn't for him to decide.\t\t This is what my character would do.\t\t DM, allow this fight!")
            judge.surprised("Well,\t he has a point.\t\t This fight will proceed.\t\t Von Karma,\t you have a $surpriseRound.")
        }
        playMusic(Music.CROSS_EXAMINING) {
            phoenix.deskSlam.holdIt("Just because I'm investigating doesn't mean I've dropped my guard!\t\t I shouldn't be $surprised!")
            judge.eyesClosed("Ah,\t hmmm.\t\t How to resolve this...")
            vonKarma.armsCrossed("Simple.\t My $sleightOfHand check needs to beat his $passivePerception score.\t\t If it does, he's $surprised.")
                .invoke("And,\t as he's busy investigating and his back is turned,\t he has $disadvantage on his score for a ${value(-5)} penalty.")
            judge.positive("Very well.\t\t Make your $sleightOfHand check.")
            vonKarma.snapFinger(dieRoll)
            phoenix.confident("Ha!\t\t Only a roll of ${value(3)}!\t\t There's no way you'll beat my $passivePerception of ${value(21)}!")
            vonKarma.confident.objection("You forgot about my $reliableTalent feature!\t\t I treat this roll as a ${value(10)},\t and my total comes out to $shakeMedium ${value(25)}!")
            phoenix.damage(flashMedium)
            judge.surprised("A minimum roll of ${value(25)}?\t\t Why did I even ask?\t\t\t\t Very well,\t you may take your $surpriseRound.")
            vonKarma.snapFinger("Perfect!\t\t With my $assassinate feature,\t I get $advantage,\t so that's ${diceRolls(2)} $pause a $shakeBig ${value(24)} to hit!\t\t And because you're $surprised,\t it's an automatic $criticalHit!")
            phoenix.breakdown("Gah!\t\t I don't have enough $hitPoints to survive this!\t\t I'm toast!")
            maya.determined("No,\t Phoenix,\t don't give up!\t\t There's no way he can defeat you in a single $surpriseRound!")
        }
        phoenix.thinking("(Wait,\t\t $surpriseRound...$bigPause${Sound.REALIZATION} Of course!)")
        vonKarma.confident("Let's see,\t that's ${value(5)} plus the weapon bonus of ${value(1)},\t plus the weapon die of ${keyword("2d4")}, and the $sneakAttack damage of ${keyword("16d")}, ", ActionArgs(interrupted = true, animated = false))
        playMusic(Music.OBJECTION) {
            phoenix.deskSlam.objection("There's no such thing as a $surpriseRound!")
            judge.surprised("What?\t\t Of course there's a $surpriseRound,\t you were $surprised!")
            phoenix.read("No,\t not if we check the $combatStepByStep section on the first page of $chapterNineCombat!\t\t ")
                .invoke("Step 1 is to determine $surprise,\t which we have already done,\t and Step 2 is to establish our positions.")
            phoenix.deskSlam("Before we reach Step 4 of taking the first turn,\t Step 3,\t\t we all$shakeBig roll $initiative!" +
                    "\t\t\t And if my roll is higher,\t I'm no longer $surprised during the attack!")
            vonKarma.damage(flashMedium)
            vonKarma.armsCrossed("Fine,\t but you're wasting our time if you think you can beat my $initiative roll!")
            judge.surprised("Oh,\t of course!\t\t Everyone,\t roll $initiative!")
        }
        playMusic(Music.SUSPENSE) {
            vonKarma.snapFinger("$dieRoll${value(8)},\t plus my $dexterity and $alert bonus,\t so ${value(18)}!")
            maya.determined(dieRoll)
            maya.dull("Oh, no,\t I got a ${value(3)}!")
            phoenix("Don't forget,\t you roll a separate $initiative for Polly!")
            maya.determined("Right!\t\t Polly, roll $initiative!")
            polly("Let's goooooo!$dieRoll")
            maya.determined("That's a ${value(21)}!")
            phoenix("${dieRoll}I got a roll of ${value(10)}.")
            vonKarma.snapFinger("Ha,\t that's only a ${value(13)} for you!")
            phoenix.confident.objection("You forget,\t I benefit from $jackOfAllTrades,\t which adds half of my $proficiencyBonus to any $abilityCheck that doesn't already include it!\t\t And $initiative rolls are $abilityChecks!")
            vonKarma.armsCrossed("Fine,\t but that's still only a ${value(15)}.")
            phoenix.headshake("That,\t and my $peerlessSkill that lets me use a $bardicInspiration to add a $d12!$dieRoll")
            phoenix.confident("And that's an additional $shakeMedium ${value(5)},\t for a total of$shakeMedium ${value(20)}!\t\t\t I beat your $initiative,\t and I'm no longer $surprised!")
            vonKarma.damage(flashMedium)
            vonKarma.cornered("Fine,\t so I lose the $criticalHit,\t but I can still use $cunningActionAim!")
            vonKarma.armsCrossed("As long as I don't move,\t I get $advantage on one $attackRoll,\t which ensures my $sneakAttack damage! That should still be enough.")
        }
        playMusic(Music.OBJECTION) {
            phoenix.point.holdIt(
                "Now that I'm not $surprised,\t I can use $cuttingWords as my $reaction,\t subtracting a $d12 roll from your $attackRoll! $shakeMedium ${pause(
                    500.milliseconds
                )}"
            )
            vonKarma.confident.objection("The Player's Handbook is clear on this,\t you can't use $cuttingWords after knowing that an $attackRoll hits!")
            phoenix.read.objection("It says that I can't use it after the DM determines whether the $attackRoll succeeds or fails,\t and he hasn't ruled on it yet!")
            judge.positive("That is correct,\t the attack may still be modified.")
            vonKarma.damage(flashSmall)
            phoenix.point.objection("$dieRoll$bigPause")
        }
        judge.surprised("Wait,\t\t why are you objecting?")
        phoenix.silly("Oh,\t\t sorry,\t\t that's my $cuttingWord. \"Objection.\"")
        playMusic(Music.OBJECTION) {
            phoenix.yell.objection("That's a $shakeBig ${value(9)}!\t\t\t Your $attackRoll is now ${value(15)},\t which is less than my $armorClass!")
            vonKarma.breakdown1("Fine,\t but you're still low on $spells and $hitPoints!\t\t You won't win this!")
        }
        playMusic(Music.SUSPENSE) {
            vonKarma.confident("You just used your two remaining $bardicInspirations,\t you no longer have a chance! $pause You're just delaying the inevitable!", ActionArgs(animated = false))
            judge("Von Karma stabs with his dagger,\t but Phoenix avoids it with a distracting objection.\t\t Maya is also $surprised,\t so after her we go to Phoenix at the top of the round!")
            maya.stand.holdIt("Wait,\t don't forget Polly!\t\t She got a ${value(21)}!")
            vonKarma("And what is a parrot supposed to do in this fight?")
            maya.determined("She can use $help, which will grant Phoenix $advantage on his next $attackRoll!\t\t Polly, $help!")
            polly("I'm helping!\t I'm helping!")
            vonKarma("Fine,\t as if that'll accomplish anything.\t\t I don't think I've seen him make an $attackRoll this entire campaign.\t\t You've wasted enough time as it is.")
            phoenix.confident("Thanks, Maya.\t\t On my turn,\t I cast $planeShift!")
            vonKarma.confident("Ha!\t\t\t You're fleeing!\t\t Fine by me,\t I can eliminate Maya in peace,\t and then I'll come after you!")
        }
        playMusic(Music.OBJECTION) {
            phoenix.point.takeThat("I never said I was casting it on myself.")
            phoenix.yell("I'm using it to target$shakeBig von Karma!")
            vonKarma.damage("What?")
            vonKarma.snapFinger("To do that,\t you'll need to hit me with an $attackRoll!")
            phoenix.nod("Yes,\t with $advantage thanks to Polly! ${diceRolls(2)} And that's a $shakeMedium ${value(27)} to hit!")
            vonKarma.damage("Urgh!\t\t But I still get to make a $charisma $savingThrow!")
            vonKarma.confident("And I have $advantage thanks to my $mageSlayer feat because you're next to", ActionArgs(animated = false, interrupted = true))
            maya.determined.objection("You rolled an ${value(11)}.")
            vonKarma.cornered("Wh-what?\t\t I haven't rolled my $d20 yet!")
            maya.determined("Right,\t but I still had one more $portent left,\t and I can see you!\t\t I foresaw your die roll as an ${value(11)}.")
            vonKarma.cornered("That's... $pause only a ${value(15)} total!")
            phoenix.point("And the $dc is $shakeBig${value(18)}! $pause")
        }
        vonKarma.damage("$flashBig ${pause(1.seconds)}")
        playMusic(Music.TRUTH) {
            vonKarma.breakdown1("Argh!\t\t Fine,\t I'll disappear for now,\t but I'll be back!")
            judge.positive("You connect with your attack,\t and von Karma vanishes in an instant. $pause Phoenix,\t which tuning fork did you use for this $planeShift?")
            phoenix("The Elemental Plane of Fire.")
            vonKarma.armsCrossed("I can work with that.\t\t DM,\t I shall appear in the City of Brass!\t\t I'll use my efreeti contact there to", ActionArgs(interrupted = true))
            phoenix.read.objection("According to the Player's Handbook,\t the location in the new plane is determined randomly.")
            judge.surprised("I see.\t\t I'll take a map of the Plane of Fire and roll a $d100...${diceRolls(2)}")
            judge.negative("That's a ${value(17)}. $bigPause You appear in ${shakeBig}the Sea of Fire!${diceRolls(10)} You take ${value(42)} fire damage from the lava,\t and will continue to take $tenD10 fire damage per round.")
            vonKarma.damage(flashBig)
            vonKarma.breakdown2("Gah!\t\t\t That's it,\t you're clearly all ganging up on me!\t\t I'm leaving,\t and not coming back!")
            judge.negative("And good riddance!")
        }
        judge.surprised("Um,$pause do either of you know anyone else who can join?")
    }.run {
        print()
        writeTo("example.objection")
    }
}
