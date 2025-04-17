package derekpeirce.objectionmaker

import java.awt.Color
import kotlin.math.max
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.time.Duration.Companion.milliseconds

fun gray(s: String) = color(s, Color.LIGHT_GRAY)

fun main() {
    makeTrial(defaultTextSpeed = 26, tabPauseTime = 100.milliseconds, punctuation = PuncutationMode.AUTO) {
        val phoenix = Phoenix()
        val judge = Judge()
        val maya = Maya()
        val ron = RonDeLite()
        val winston = WinstonPayne(name = "Winston")
        val gallery = Gallery()

        playMusic(Music.TRIAL) {
            judge("You've now successfully opened a window on the roof of the manor. You've confirmed that up ahead, there will be guards.")
            phoenix("Well, we only need to send one person to retrieve the blackmail evidence we need.")
            winston("And clearly, that job falls to Ron.")
            maya.determined("Then I'll help you with some $invisibilitySpell! Now go get it!")
            maya("Just try to avoid attacking anything while you're down there.")
            ron.serious("Right! I'll slip down into the corridor!")
            judge.positive("Advancing through, you come across a guard patrolling the hallway. Make a $stealth check to avoid being heard.")
            ron.think("I'm pretty good at this, and I have $advantage from")
        }
        playMusic(Music.CORNERED) {
            winston.stand.objection("Being $invisible doesn't grant you advantage on your $stealth rolls!")
            ron.sad("${Sound.REALIZATION}But that's not", Args(interrupted = true))
            phoenix.point.objection("Why not? Clearly being $invisible makes it easier to move undetected!")
            ron.sad("${Sound.REALIZATION}The reason for", Args(interrupted = true))
            winston.confident.objection("Ah, but the $invisibility is already helping him, for if he wasn't $invisible, he would be spotted instantly!")
            winston.confident("It's what enables the ability to hide in the first place, it shouldn't grant advantage on top of that!")
        }
        ron.serious.objection("${Sound.SMACK}You're wrong!", Args(mergeNext = true))
        ron.sad(" Err, umm, I mean...")
        ron.think("Not exactly wrong so much, but actually not right is what I was re${gray("ally trying to say")}.")
        ron.sad("But the reason that I have $advantage", Args(mergeNext = true))
        playMusic(Music.PLEASE_LISTEN) {
            ron.serious(" is because I'm a $thief!")
            ron.serious("And I have $supremeSneak, which grants me $advantage on any $stealth check I make as long as I move no more than half my speed!")
            winston.damage(pause)
            phoenix.damage(pause)
            judge.surprised("Quite right! Go ahead and roll your $stealth check with $advantage!")
            ron("That's ${diceRolls(2)} a ${value(26)}.")
            judge.positive("Then you slink past the guard making nary a sound.")
            ron.stand("We were told the evidence would be in the study, so I'll make my way there.", Args(interrupted = true))
            maya("${textSpeed(18)}♪ Making my way ♪")
            gallery("3 minutes of rogue sneaking later...")
            judge.surprised("You pick the lock with ease, and quietly open the door.")
        }
        playMusic(Music.SUSPENSE) {
            judge("You see two figures behind a desk. One, you've seen before: the blackmailer, Lord Harrington.")
            judge.negative("The other is a purple aberration that you recognize to be a Nothic. You can tell that it can see you, roll for initiative!")
            ron.think("Ok, that's $dieRoll", Args(mergeNext = true, interrupted = true))
            ron.shout("an ${value(8)}!")
            judge("${diceRolls(2)}Then Lord Harrington is up first. He casts a spell, make a $wisdom $savingThrow.")
            ron.serious("That's$dieRoll only an ${value(11)}!")
            judge.negative("That fails. He utters a command, \"Approach!\" You must follow this on your turn.")
            ron.shout2("I'm going to dieeeeeee!")
        }
        playMusic(Music.OBJECTION) {
            phoenix.confident.objection("Lord Harrington can't cast $command on Ron! That spell requires sight, and Ron is $invisible!")
            judge.surprised("Oh, you're right! And it seems that many of his spells do require sight.")
            judge("We will retcon that, he instead approaches you and draws his blade, swinging twice with $disadvantage. That's${diceRolls(2)} a ${value(15)} to hit...")
            ron("That misses!")
            judge("...and${diceRolls(2)} a ${value(9)} to hit.")
        }
        judge.stand(
            "It's now the Nothic's turn. He strides over to you and will attack you with his claws. As he can see you, he does not have $disadvantage. That's",
            Args(interrupted = true)
        )
        playMusic(Music.CORNERED) {
            winston.confident.objection("The attacks still have $disadvantage!")
            judge.surprised("What!?")
            phoenix.deskSlam("Why not? Ron isn't benefiting from being unseen.")
            winston("That may be so, but that's irrelevant! Part of the $invisible condition is, \"Attack rolls against the creature have disadvantage and the creature's attack rolls have advantage.\"")
            winston("Being \"impossible to see\" is a completely separate aspect!")
            phoenix.read("That can't be right.")
            phoenix.damage("Wait, no, that's exactly what it says.")
            ron("Does this mean I'm saved?")
            judge.surprised("Apparently so!")
        }
        playMusic(Music.ALLEGRO_2001) {
            maya.angry.holdIt("Phoenix, you can't let that ruling stand!")
            phoenix("Why not? It's helping Ron in a tight spot!")
            maya.angry("But it also makes my $thirdEye and $seeInvisibility spell weaker! And it doesn't make any sense!")
            phoenix.thinking("Good point, I'll press harder on this.")
            phoenix.point("You say that $invisibility still works even when a creature can see you.")
            phoenix.silly("Um, how?")
            winston("Jeremy Crawford explained it himself! \"If you're wondering how to rationalize that narratively, imagine an invisible person, under the effects of the $invisibilitySpell spell.")
            winston.confident("\"Even if by some means you can discern them, imagine that there is still some strange magical shimmer over them that is affecting your ability to target them effectively.\"")
        }
        playMusic(Music.OBJECTION) {
            phoenix.point.objection("That contradicts the text of $seeInvisibility!")
            phoenix.read("\"For the duration, you can see $invisible creatures and objects as if they were visible.\"")
            phoenix.yell("Seeing a magical shimmer contradicts that description!")
            winston.cornered("I... er... I don't know, but if Crawford said it it must be accurate, right?")
            phoenix.confident("There's also the matter of other senses like blindsight and tremorsense!")
            phoenix.point("Why would a creature relying on blindsight to attack someone be impaired at all by what they do or don't look like?")
            winston.damage("Oof! *wince*")
        }
        judge.surprised.objection("In light of this new evidence, I'm going to rule that the $invisible condition is relative, and you do not benefit from it against a creature that can see you anyway.")
        playMusic(Music.SUSPENSE) {
            ron.cornered("The $invisibility bonus was my only chance!")
            judge("That's a$dieRoll ${value(20)} to hit for $dieRoll${damage(7)} damage.")
            ron.cornered("I'll halve that one with $uncannyDodge.")
            judge("And then$dieRoll an ${value(18)} to hit for $dieRoll${damage(8)} damage. It is now your turn.")
            ron.shout("If I attack, Lord Harrington can hit me with his spells, ", Args(interrupted = true, mergeNext = true))
            ron.shout2("and if I don't, the Nothic will still kill me before I can retrieve the blackmail evidence!")
        }
        playMusic(Music.TRUTH) {
            maya.determined.takeThat("I don't think you need to retrieve it at all!")
            phoenix("Why not? The entire point of this mission was to make sure he can't blackmail Winston anymore with his evidence.")
            maya.thinking("But I don't think the evidence ${Sound.REALIZATION}actually exists!")
            maya.determined("We've only been told that he has the evidence, but I think it's a bluff! With a Nothic on his side, he can learn information without having the evidence to back it up!")
            judge.surprised("...")
            judge.eyesClosed("You may relay that message to him via your $telepathicBond.")
            ron("Oh, in that case, I'll disengage, and grab whatever the most valuable thing is in this study.")
            ron("Then I'll use my $capeMountebank to cast $dimensionDoor, returning to the roof with the rest of the party!")
            judge.positive("You grab a gem-encrusted bowl from the desk, then disappear in a flash of smoke, and reappear next to your companions, now visible.")
            winston("Well, that was a lot of work for just a bowl.")
        }
        playMusic(Music.PLEASE_LISTEN) {
            ron.think("No, I also pinched three candlesticks, a fancy vase, a jade ring, and a sapphire necklace!")
            winston.damage("What? Why were you stealing so much instead of focusing on the mission?")
            phoenix("...")
            maya.dull("...")
            judge.surprised("...")
            ron.serious("Because I'm a thief!")
        }

    }.writeTo("stealth.objection")
}