package derekpeirce.objectionmaker

import kotlin.time.Duration.Companion.milliseconds

fun main() {
    makeTrial(defaultTextSpeed = 26, tabPauseTime = 100.milliseconds, punctuation = PuncutationMode.AUTO) {
        val phoenix = Phoenix()
        val judge = Judge()
        val maya = Maya()
        val mayaFey = Maya(name = "Maya Fey")
        val miles = Edgeworth(name = "Miles")
        val cody = CodyHackins("Cody")

        val saidByPhoenix = ActionArgs(saidBy = "Phoenix", blip = Blip.MALE)

        playMusic(Music.STEEL_SAMURAI) {
            cody.happy("All right! It's my turn! I charge at the troll!")
            miles.point("There's no need to charge, we can still get a few rounds of kiting it!")
            cody.angry("Too late, old man, the Steel Samurai never retreats!")
            judge.positive("With your movement, you can reach it easily.")
            cody.confident("I swing my shortsword! $dieRoll${value(25)}! Wham! For ${diceRolls(2)}${damage(8)} damage!")
            cody.confident("Then I swing again for $dieRoll${value(13)}!")
            judge.negative("That misses, only a glancing blow.")
            phoenix.point.holdIt("Remember, your first attack applied Vex, so your next attack is with advantage!")
            cody.angry(
                "Hey, I knew that, pops! That's$dieRoll a nat ${value(20)}! Whizzam! For ${diceRolls(2)}${damage(7)} damage! Hey, why did my crit do less damage?"
            )
            miles.armsCrossed("That's just the way the dice work sometimes.")
            cody.confident("Whatever! Next I switch to my scimitar for another attack! Samurai Slash!")
        }
        playMusic(Music.SUSPENSE) {
            phoenix.point.objection("Aren't you holding a shield? If you want an additional attack with a Light weapon, you need a weapon in each hand.")
            miles.confidentSmirk.objection("Phoenix, it seems that your understanding of the Light weapon rules is outdated.")
            phoenix.damage("Not again!")
            miles.read("The new rule states: \"When you take the Attack action on your turn and attack with a Light weapon,")
            miles.read("\"you can make one extra attack as a Bonus Action later on in the same turn.")
            miles.read("\"That extra attack must be made with a different Light weapon.\"")
            miles.deskSlam("Where does it say that each weapon must be held in a different hand?")
            phoenix.cornered("Wow, that's quite the oversight.")
        }
        playMusic(Music.ALLEGRO_2001) {
            phoenix.thinking("But how is he able to swap out both weapons at once?")
            phoenix.thinking("He can stow the shortsword as part of the attack, but this attack is a Bonus Action, so he can't draw a weapon as part of it.")
            miles.armsCrossed("Then you've forgotten about Nick.")
            phoenix("I forgot about myself?")
            miles("No, not you, the Mastery property of the scimitar, Nick. He can make the additional attack as part of the Attack action, so he can draw the weapon first.")
            phoenix.silly("Oh, right.")
            maya("First an elemental, now a Mastery, everything is getting named after you, Nick!")
        }
        playMusic(Music.OBJECTION) {
            phoenix.point.objection("This still doesn't make any sense, though!", ActionArgs(punctuation = PuncutationMode.MANUAL))
            phoenix.point("If you can make three attacks with a shortsword and scimitar instead of two attacks with a rapier and still hold a shield, why would you ever choose the rapier?")
            judge("Hmm, that does seem strange.")
            miles.confidentShrug("What does it matter? Why would anyone use a blowgun?")
            phoenix.deskSlam("And why would it matter that it's a different weapon?")
            phoenix.yell("You can attack twice with a scimitar, but if you swap it out for a different scimitar in the same turn, you get another attack!? Explain that!")
            miles.damage("Urk!")
            judge.surprised("Now that part defies all possible logic!")
        }
        judge("How about we go back to the old rules where you had to use a weapon in each hand? I rather liked those rules.")
        miles.armsCrossed("Fine.")
        playMusic(Music.STEEL_SAMURAI) {
        maya("Does that sound good to you, Cody?")
            cody.annoyed("I don't need a shield anyway! I'm not afraid of any monsters!")
            miles.smirk("Tsk. I was just trying to keep you alive.")
            judge("Then we'll retcon that you were never holding a shield, but instead your shortsword and scimitar at the same time.")
            cody.angry("I attack with my scimitar with advantage! ${diceRolls(2)}That's an ${value(18)} to hit!")
            judge.positive("That hits.")
            cody.confident("That's ${damage(6)} more damage! Alright, I think I'm done!")
        }
        playMusic(Music.OBJECTION) {
            miles.point.objection("You've forgotten about your Dual Wielder attack!")
            maya.thinking("I thought he already made a Nick attack.")
            maya.thinking("Huh, I didn't do anything this", saidByPhoenix)
            maya.thinking("${Sound.WHOOPS}Not again.", saidByPhoenix)
            maya("Tee-hee!")
            miles.confidentSmirk("Your Dual Wielder feat says that you can make a bonus action after attacking with a Light weapon,")
            miles.confidentSmirk("but it doesn't actually modify the attack granted by the Light weapon property.")
            phoenix.read("\"When you take the Attack action on your turn and attack with a weapon that has the Light property,")
            phoenix.read("\"you can make one extra attack as a Bonus Action later on the same turn with a different weapon,\"")
            phoenix.read("and it can be any one-handed weapon and still doesn't add the attack modifier unless negative.")
            phoenix("Yep, he's right.")
            cody.angry("Alright, Samurai Stab!$dieRoll A ${value(17)} to hit!")
            judge.positive("Also a hit.")
            cody.confident("That's...$pause")
            cody.annoyed("Wait, do I add my Dex to this or not?", ActionArgs(interrupted = true))
            miles.read("Well, your Two-Weapon Fighting says, \"When you make an extra attack as a result of using a weapon that has the Light property,")
            miles.read("\"you can add your ability modifier to the damage if you aren't already adding it to the damage.\"")
            miles.point("I think we can all agree that describes both the attack from the Light property and the attack from Dual Wielder.")
            phoenix.nod("No objections here.")
            cody.confident("Alright, then that's ${damage(8)} more damage!")
            cody.happy("Now I'm done!")
        }
        playMusic(Music.PSYCHE_LOCK) {
            judge("The troll is wounded, but not done yet. Phoenix, it's your turn.")
            phoenix("Then for my action, I'll use $summonFey.")
            mayaFey.thinking("What do you mean? I'm right here.")
            mayaFey.angry("${Sound.REALIZATION}Hey!")
            mayaFey.angry("Tee-hee!", saidByPhoenix)
        }
    }.writeTo("light_weapons.objection")
}