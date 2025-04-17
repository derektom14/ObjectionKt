package derekpeirce.objectionmaker

import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

fun main() {
    makeTrial(defaultTextSpeed = 23, tabPauseTime = 100.milliseconds) {
        val judge = Judge()
        val phoenix = Phoenix()
        val maya = Maya()
        val franziska = FranziskaVonKarma()
        val jake = JakeMarhsall()

        val map = "367150"

        val textSpeedRead = textSpeed(13)

        playMusic(Music.TRIAL) {
            judge("With the sudden strike of your whip,\t the ogre falls,\t defeated.")
            franziska.bow("Of course,\t we can't let any of them escape.\t\t There's just one left now,\t the ogre mage?")
            judge.positive("Yes,\t and it's his turn.\t\t He turns $invisible again,\t and you can barely hear as he flies up to escape.\t\t He'll reach the surface and get away.")
        }
        franziska.whipDesk("Then I'll hit him with an $opportunityAttack!")
        playMusic(Music.CROSS_EXAMINING) {
            phoenix.deskSlam.objection("You're not close enough for that!\t\t Take a look at the map.")
            showImage(map) {
                phoenix("${pause}When you moved to take out the other ogre,\t you stopped 10 feet away from the oni!")
            }
            franziska.confident.objection("Foolish fool who should have joined the college of fools,\t he doesn't need to be next to me.")
            franziska.whipDesk("He just needs to be within $reach of my whip,\t which is 10 feet!")
            maya("Here,\t let's check the Player's Handbook.\t\t$textSpeedRead \"You can make an $opportunityAttack when a hostile creature that you can $see moves out of your $reach.")
            maya("$textSpeedRead\"To make the $opportunityAttack,\t you use your $reaction to make one $meleeAttack against the provoking creature.\t\t The attack occurs right before the creature leaves your $reach.\"")
            maya.dull("Yep,\t she's right.")
            franziska.bow("But of course.\t\t And with $disadvantage, that's ${diceRolls(2)} an ${value(18)} to hit!\t\t And I stop him in his tracks with $sentinel!")
            phoenix.headshake.objection("Did you hear everything Maya read?\t\t \"A hostile creature that you can $see.\"\t\t The oni is $invisible,\t you can't attack him!")
            franziska.damage("How dare you?\t\t What kind of foolish fool turns his own ally into a fool?")
        }
        playMusic(Music.ALLEGRO_2001) {
            judge.surprised("Right,\t the oni does not provoke an $opportunityAttack from Franziska.")
            judge("Safe in his $invisibility,\t he flies up")
            maya.determined.objection("Then it's my turn for an $opportunityAttack!\t\t With my $thirdEye,\t I can $see him,\t and with $warCaster,\t I can cast a spell instead!")
            maya.angry("I'm going to slow him down with ${spell("ray of frost")}!\t\t That's$dieRoll a ${value(23)} to hit!")
        }
        playMusic(Music.SUSPENSE) {
            franziska.whipDesk.objection("You foolish fool with foolish ideas befitting of only a fool!\t\t You have $disadvantage on your attack!")
            maya.thinking("What,\t how?\t\t I can $see him!")
            franziska.point("But you have $disadvantage on ranged attack rolls when a hostile creature is next to you!")
            phoenix.point.objection("The oni is leaving her $reach,\t how can he impose $disadvantage?")
            franziska.armsCrossed.objection("Remember what you just read?\t\t \"The attack occurs right before the creature leaves your $reach.\"")
            franziska.confident("Or do words go into your foolish head and then immediately leave for not being sufficiently foolish?")
            phoenix.damage("")
            maya.thinking("Hold on,\t maybe there's something from Sage Advice.")
            maya("From Jeremy Crawford on Twitter:\t $textSpeedRead\"$warCaster doesn't remove the $disadvantage imposed by making a ranged attack roll within 5 feet of a foe.\"$pause")
            maya.dull("${Sound.WHOOPS}Drat!$pause")
        }
        judge.surprised("Twitter?\t\t\t\t Is that a new source book?")
        phoenix.damage("")
        franziska.damage(pause)
        maya.dull("...$smallPause")
        playMusic(Music.OBJECTION) {
            judge("Anyway,\t it seems Franziska is correct.\t\t Maya,\t roll again for $disadvantage.")
            maya.dull("Fine.\t\t\t That's $dieRoll a ${value(13)} to hit?")
            judge.negative("That's a miss.\t The oni continues to fly upward.$pause")
        }
        playMusic(Music.SUSPENSE) {
            jake.shave("${pause}Now that y'all are done with yer riffraff,\t it's finally my turn for an $opportunityAttack on this hombre!")
            judge("And you are...\t\t")
            jake("I $wildShaped into a giant scorpion,\t pardner.")
            showImage(map) {
                jake("${pause}And I'm right next to him!")
                judge.negative("But he is still $invisible.")
            }
            jake.point.objection("That ain't gonna matter.\t\t As a scorpion,\t I have $blindsight,\t so I'm ${keyword("seein'")} him just fine.")
            jake.point("I'll attack with my claw,\t that's $dieRoll $pause(with some $inspiration)$dieRoll a ${value(19)} to hit.")
            judge("That hits,\t roll damage.")
            jake.serious("$dieRoll That's ${value(5)} bludgeoning damage.")
            judge("You reach out and strike the oni in the leg as he moves away,\t and$dieRoll he maintains his $invisibility.")
            judge("I'm afraid that's not enough to kill him,\t so he still escapes to the surface.")
        }
        playMusic(Music.TRUTH) {
            jake.point.objection("When I hit the oni with my claw attack,\t I also $grapple him.\t He ain't goin' nowhere.")
            franziska.whipDesk.objection("You aren't allowed to $grapple as an $opportunityAttack!\t\t A $grapple has to be part of the $attackAction,\t and you're only allowed a $meleeAttack!")
            jake.serious.objection("Desperados don't follow those rules,\t bambina.")
            jake.point("The $grapple is a side effect of being hit by the claw.\t\t Nothin' in the rules says otherwise.")
            franziska.damage(pause)
            judge.negative("The oni,\t grappled,\t cannot proceed.")
        }
        playMusic(Music.WILD_WEST) {
            judge.eyesClosed("That's the end of his turn,\t and I don't think he'll survive to the next one.")
            maya("Well done!\t\t Did you know that was going to happen,\t or was it just luck?")
            jake.drink("Well,\t as they say,\t pardner,\t luck is when preparation meets opportunity.")
        }
    }.writeTo("opportunity.objection")
}