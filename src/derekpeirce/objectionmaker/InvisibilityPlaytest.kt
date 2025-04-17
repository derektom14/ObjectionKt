package derekpeirce.objectionmaker

import java.awt.Color
import kotlin.math.max
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

fun main() {
    makeTrial(defaultTextSpeed = 26, tabPauseTime = 100.milliseconds, punctuation = PuncutationMode.AUTO) {
        val phoenix = Phoenix()
        val judge = Judge()
        val maya = Maya()
        val larry = Larry(name = "Larry")
        val franziskaVonKarma = FranziskaVonKarma(name = "Franziska")
        val gallery = Gallery()

        playMusic(Music.TRIAL) {
            franziskaVonKarma.whipDesk("And that's a total of ${diceRolls(9)}${damage(38)} damage!")
            judge.positive("The enemy cultist collapses before you, foiled in his attempt to escape your wrath.")
            franziskaVonKarma.bow("That's two down, only four cultists remaining!")
            larry.thinkScratchHead("Wow, two in one round, you're really cleaning up! Who knew $greaterInvisibility on a rogue was so effective?")
            phoenix.sipMug("Everyone, Larry. ${bigPause}Everyone.")
        }
        playMusic(Music.SUSPENSE) {
            judge.negative("At initiative ${value(7)}, reinforcements arrive. Turning the corner, you see one of the cult's higher-ups, Delmirev Torinn the Enforcer.")
            judge.negative("He carries a greatsword and wears full plate armor, but over that he wears a robe decorated with a pattern of eyes.", ActionArgs(animated = false))
            judge("He says, \"I suspected you lot would interfere. Now perish!\" He lets loose a series of swings against Franziska.")
            maya("With disadvantage, right? From the invisibility?")
            judge(pause(1.seconds))
            maya.dull("With disadvantage, right?")
            judge.negative("No, with his Robe of Eyes, the Enforcer can see invisible creatures!")
            larry.nervous.objection("Wait, isn't there a rule that invisibility still imposes disadvantage even if the enemy can see you?")
            phoenix.point.objection("Yes, but we tossed out that rule long ago.")
            phoenix.read("Besides, we're using the new Playtest rules, which now clarify:")
            phoenix.read(
                "\"If a creature can somehow see you, " +
                        "as with magic or Blindsight, you don’t gain this " +
                        "benefit against that creature.\""
            )
            judge.positive("Exactly. He can even see in all directions.")
            larry.surprised("Woah! He can see everything!")
        }
        maya.thinking("But can he see why kids love Cinnamon Toast Crunch?")
        playMusic(Music.CROSS_EXAMINING) {
            franziskaVonKarma.damage("$dieRoll${value(22)} to hit for ${diceRolls(2)}${damage(18+5)} damage, $dieRoll${value(25)} to hit for${diceRolls(2)}$dieRoll ${damage(13)} damage, and a$dieRoll ${value(13)}, Heroic Inspiration,$dieRoll ${value(19)} for${diceRolls(2)}$dieRoll ${damage(13)} damage!", ActionArgs(saidBy = "Judge"))
            franziskaVonKarma.cornered("Well, that hurt a fair bit, but I'm not out yet!")
            judge.negative.objection("Action Surge!")
            franziskaVonKarma.damage("Critical hit for ${diceRolls(4)}${diceRolls(2)}${damage(20)} damage, $dieRoll${value(25)} to hit for${diceRolls(2)}$dieRoll ${damage(10)} damage, and $dieRoll${value(23)} to hit for${diceRolls(2)} ${damage(14)} damage! Oh, and Great Weapon Master $dieRoll${value(22)} to hit for ${diceRolls(2)}${damage(17)} damage!", ActionArgs(saidBy = "Judge"))
            franziskaVonKarma.cornered("${Sound.GUILTY}I'm down! And I was at full health!")


//            franziskaVonKarma.damage("$dieRoll${diceRolls(2)}${dieRoll}${damage(5+5+3+6+1)}, $dieRoll${damage(5)}, and ${diceRolls(2)}${diceRolls(2)}$dieRoll${damage(5+5+4+1)} damage!", ActionArgs(saidBy = "Judge"))
//            franziskaVonKarma.cornered("Well, that hurt a fair bit, but I'm not out yet!")
//            judge.negative("Action Surge!")
//            franziskaVonKarma.damage("$dieRoll${diceRolls(2)}${dieRoll}${damage(5+4+4+1)}, $dieRoll${damage(5)}, and ${diceRolls(2)}${diceRolls(2)}$dieRoll${damage(5+5+6+1)} damage!", ActionArgs(saidBy = "Judge"))
//            franziskaVonKarma.cornered("${Sound.GUILTY}I'm down!")
        }
        playMusic(Music.CORNERED) {
            phoenix.deskSlam("I'm up, I'll use $healingWord!")
            franziskaVonKarma.deskSlam.objection("Foolish fool blinded by his own foolishness! I'm still invisible, and $healingWord requires sight!")
            maya.thinking("I could drop $greaterInvisibility so that you could heal!")
            phoenix.headshake("Franziska still needs that invisibility for the other cultists, two move before she does.")
            phoenix("We can count on Larry to heal you with Healing Light, he can see you thanks to Witch Sight!")// In the meantime, I'll use ${spell("irresistible dance")} on the Enforcer!")
            franziskaVonKarma.armsCrossed("Healing Light? I thought your patron was a water nymph!")
            larry.thinkScratchHead("Well, it was, until the portal from the elemental planes was closed. Freak accident, I think it was.")
            larry.happy("But then the last time I died I briefly met Aurelia, and everything's been good!")
            phoenix.point("I'll cast $command, upcast to get both the Enforcer and one of the cultists next to Franziska! \"Grovel!\"")
            judge("The Enforcer$dieRoll fails with a ${value(13)}, but with Indomitable$dieRoll gets a ${value(33)}! The cultist gets$dieRoll a ${value(4)}, and fails!")
            phoenix.silly("Whoops, I forgot Indomitable is actually good now.")
            //judge("The Enforcer suddenly starts to dance uncontrollably, ")
        }
        playMusic(Music.MODERATO_2001) {
            larry.nervous("Alright, my turn! I use Healing Light on Franziska!")
            maya(
                "Say, looking at the new rules for Invisibility, it says: \"Concealed. You aren’t affected by any effect that \n" +
                        "requires its target to be seen.\""
            )
            maya.thinking("But this clause doesn't have an exception like the Attacks Affected clause does.")
        }
        phoenix.damage(pause(300.milliseconds))
        larry.cornered("${Sound.DAMAGE}${pause(800.milliseconds)}")
        franziskaVonKarma.damage(pause(800.milliseconds))
        playMusic(Music.BLUE_BADGER) {
            judge.surprised("...This is the part where someone insists that we use that rule and then someone objects, right?")
            franziskaVonKarma.whipDesk.objection("Only the most foolish of fools would defend a foolish rule written so foolishly!")
            larry.thumbsUp("Ok, I use Healing Light! You regain ${diceRolls(5)} ${value(11)} hit points!${Sound.SHINY}")
            franziskaVonKarma.cornered("That's really not as many as I was hoping for!")
            judge("The cultist is up next, but falls to his knees and grovels before you.")
        }
        playMusic(Music.SUSPENSE) {
            judge("The one that was not commanded makes two scimitar attacks against you,$dieRoll hitting with a ${value(25)} for $dieRoll${damage(9)} slashing damage, and then$dieRoll a ${value(18)} for")
            phoenix.point.objection("I use Cutting Words, reducing that attack roll by $dieRoll", ActionArgs(mergeNext = true, interrupted = true))
            phoenix.breakdown("${Sound.WHOOPS}${value(1)}!")
            judge.surprised("That's just enough to cause it to miss! The cultist then runs towards Larry.")
        }
        playMusic(Music.TRUTH) {
            franziskaVonKarma.whipDesk("I get up, and attack the remaining cultist, still with advantage.")
            franziskaVonKarma.point("${diceRolls(2)} That's a ${value(24)} to hit!")
            judge.positive("That hits.")
            franziskaVonKarma.point("${diceRolls(8)}For ${damage(27)} damage.")
            judge.positive("The cultist falls, dying. The Enforcer then", ActionArgs(interrupted = true))
            franziskaVonKarma.confident("And I use Cunning Strike: Withdraw,${Sound.SHOOOP} moving 15 feet away without provoking opportunity attacks.")
            judge.surprised("Oh, sorry, you avoided his Sentinel attack, then.")
            franziskaVonKarma.bow("I then move away another 30 feet, taking cover behind that bookcase, hiding with ${dieRoll}a ${value(26)}.")
            larry.think("That means that the enemies can't hear you now, right?")
            phoenix("It used to, but I think there are some new rules for hiding.")
            phoenix.read("Let's see, DC 15 now, \"On a successful check, you have the Invisible condition.\"")
            phoenix.cornered("${Sound.WHOOPS}Which you already have.")
        }
    }.writeTo("playtest_invisibility.objection")
}