package derekpeirce.objectionmaker

import kotlin.time.Duration.Companion.milliseconds

fun main() {
    makeTrial(defaultTextSpeed = 26, tabPauseTime = 100.milliseconds, punctuation = PuncutationMode.AUTO) {
        val phoenix = Phoenix()
        val larry = Larry(name = "Larry")
        val judge = Judge()
        val maya = Maya()
        val godot = Godot()

        playMusic(Music.TRIAL) {
            judge("Maya, it's your turn. I believe you're still $paralyzed from $holdPerson?")
            maya.determined("Yep, I'll reroll my $savingThrow for", ActionArgs(mergeNext = true))
            maya.dull("$dieRoll a ${value(17)}?")
            judge.negative("That still fails.")
        }
        playMusic(Music.SUSPENSE) {
            judge("It is now Archmage Visoren's turn, with Phoenix on deck. He casts $disintegrate on Maya.")
            maya.determined("I'm $paralyzed, so that's an automatic hit! It'll use up my $deathWard.")
            godot.confidentWithMug.objection("Your $deathWard was removed by $dispelMagic a few rounds ago!")
            maya.dull("Right.")
            maya.angry("Nick, I'm about to turn to dust, do something!")
            phoenix.point.holdIt("I cast $counterspell!")
            judge.eyesClosed("Very well, mark down which spell slot you're using. In response, Visoren also casts $counterspell.")
        }
        playMusic(Music.CROSS_EXAMINING) {
            larry.stand.objection("He's already casting a high-level spell this turn! He can't also cast $counterspell!")
            phoenix.read.objection("You're thinking of the rule for bonus actions, Larry. If he casts a spell as a bonus action, he can't cast another spell on his turn except for a cantrip.")
            larry.cornered("What? You mean I've been covering for your spells this entire time when I could have let you handle them?")
            phoenix.silly("Sorry, I thought you were just trying to use up your spell slots before the next short rest.")
            larry.thumbsUp("Well, I still have your back! I'll cast $counterspell against his $counterspell!")
            godot.deskSlanWithMug.objection("You're still a T-rex from Phoenix's $polymorph!")
            larry.surprised("Oh, you're right! I can't do anything!")
        }
        playMusic(Music.OBJECTION) {
            phoenix.confident.holdIt("I can drop the concentration on $polymorph, no action required!")
            godot.pointWihtMug("Even though that'll leave Larry with hardly any hit points again? Gutsy move.")
            phoenix.headshake("I know it's not ideal, but if I don't do this, Maya will die! I drop concentration on $polymorph!")
            judge.positive("Very well. Larry, you revert to your prior warlock form.")
            larry.thumbsUp("Great! Then by the power vested in me by Titania, the Summer Queen, I also cast $counterspell!")
        }
        playMusic(Music.SUSPENSE) {
            judge.negative("In response, General Anya invokes a magical tattoo on her arm, which fades as she channels that magic into her own $counterspell against Larry!")
            godot.damage("What is this, the fourth $counterspell?")
            judge("Larry, which spell level did you choose for $counterspell?")
            larry.thinkScratchHead("Er, I've only got 5th-level spell slots.")
            judge("Ah, right, then she'll make a spellcasting $abilityCheck, so")
            maya.determined.takeThat("I may be paralyzed, but I can still use my last $portent! She rolls a ${value(6)}!")
            judge.surprised("Ah, that's a total of ${value(10)}, and her $counterspell fails. Larry, your $counterspell succeeds, and is strong enough to neutralize Visoren's own $counterspell.")
            larry.happy("Wohoo! Alright, Phoenix, it's all up to you!")
        }
        playMusic(Music.CORNERED) {
            judge("Phoenix, your $counterspell is cast, what level did you use?")
            phoenix("Third level.")
            maya.angry("What!? That's all you have to stop me from dying?")
            godot.throwMug("How were you not able to spare a sixth-level spell slot?")
            phoenix.coffeeStained("Well, I had to use my 7th-level for $planeShift to get us here and my 8th-level for $glibness to talk our way here, and I already used my 6th-level to make the general dance for a while.")
            judge.negative("Well, $disintegrate is certainly not a 3rd-level spell, so you must now make a spellcasting $abilityCheck.")
            phoenix.confident("Alright, that's$dieRoll", ActionArgs(mergeNext = true))
            phoenix.breakdown("${Sound.WHOOPS} a ${value(4)}. For a total of ${value(11)}, with $jackOfAllTrades.")
            judge.negative("That's not enough, the $disintegrate goes through. Maya automatically fails her save, and")
        }
        playMusic(Music.OBJECTION) {
            phoenix.deskSlam.holdIt("How long has it been since I cast $glibness?")
            judge("Er, that was back at the gate, so I suppose about 20 minutes ago.")
            phoenix.confident("${Sound.REALIZATION} Then I'm still under the effect of $glibness! And it makes my minimum roll on $charisma checks a ${value(15)}!")
            judge.eyesClosed("Right, you used it for a $deception check.")
            phoenix.point("But as a Bard, my spellcasting ability is $charisma, so $counterspell is also a $charisma check!")
            phoenix.confident("My minimum roll for $counterspell is a ${value(15)}, for a total of ${value(22)}!")
            judge.positive("Very well, then your $counterspell successfully diffuses the $disintegrate entirely!")
            maya("Whew, I get to survive for a while longer!")
        }
        playMusic(Music.TRUTH) {
            judge("Phoenix, it's now your turn.")
            phoenix.stand.takeThat("Well, if it worked for $counterspell, it should also work for this!")
            phoenix.yell("I cast $dispelMagic on Visoren, with a minimum roll of ${value(22)}!")
            judge.surprised("Well, that certainly works!")
            judge.eyesClosed("That eliminates his $mageArmor, $disguiseSelf, $contingency, $deathWard...")
            judge.surprised("Wait a second.$pause How do you want to do this?")
            phoenix("Wh-what!? I didn't cast a damaging spell. I guess I just render every spell on him inert by$pause my sheer presence?")
            judge.positive("And with that, the archmage dissolves into snow and melts away, and you realize that this was a simulacrum.")
            godot.cornered("Are you saying the real Visoren is still out there? We were just dealing with a copy?")
        }
        larry.thinkScratchHead("That's neat and all, but can we take a short rest now?")
        judge.negative("We are still in combat!")
    }.writeTo("counterspell.objection")
}