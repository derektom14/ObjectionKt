package derekpeirce.objectionmaker

import java.awt.Color

fun Action.think(text: String) = invoke(color("($text)", Color.BLUE), args = ActionArgs(doNotTalk = true))

fun thinking(text: String) = color(text, Color.BLUE)

fun main() {

    makeTrial {
        val broc = Apollo(name = "Broc Flosham")
        val sevenflower = Maya(name = "Sevenflower")
        val skorpa = Lotta(name = "Skorpa")

        val severa = FranziskaVonKarma(name = "Lady Severa")

        val irsu = MattEngarde(name = "Irsu Severa")

        severa("Here's my proposed contract:")
        severa("That the sword,\t the Blade of Tiamat's Bane, is entrusted to Sevenflower,\t to be used until she dies,\t " +
                "at which point it is returned to Lady Nebet Severa.")
        severa("That Sevenflower must slay three dragons chosen by the sword,\t each within a month of the sword designating" +
                " its chosen dragon,")
        severa("\t or else forfeit her soul upon her death to Bel,\t Lord of Avernus.")
        severa.bow("Everyone should find that agreeable,\t yes?")

        sevenflower.determined("Getting to slay more dragons?\t\t That sounds perfect!")
        broc.thinking("Wait,\t slow down.\t\t Who is this Bel,\t and what's this Avernus?")
        skorpa.angry("${Sound.REALIZATION} I think that's a layer of the Nine Hells!")
        broc.cornered("Wait,\t so we're dealing with devils?")
        sevenflower("I still think we should do it.")
        broc.deskSlam("Wait,\t I'm concerned.\t\t What do you mean by \"use,\"\t exactly?\t\t Does she have to use it continuously?")

        severa.confident("We can add \"as she pleases\" there easily.")
        severa.armsCrossed.think("That's not even the section you should be concerned with.")
        broc.point.holdIt("What if we're attacking and the dragon escapes and flies away?\t As long as we're chasing it,\t we shouldn't be restricted to a month!")
        severa.cornered("!!!")
        severa.confident("That's fine, we can add a clause for that.")
        broc.point("Also, we can't be tasked with every dragon at once! And we need to be allowed a rest period between them.")
        severa("Fine.")
        broc.deskSlam("Oh, and you're not allowed to attack us to prevent us from slaying dragons!")
        severa.armsCrossed("Wouldn't dream of it.")
        broc.point.takeThat("And what if she doesn't get the killing blow?\t\t She should just have to participate in the fight!")
        severa.damage.think("That was one of my best loopholes!")
        broc.thinking("Also,\t what happens if Sevenflower dies while we're fighting the dragon?")
        severa.confident("Then the sword would return to me,\t and you'll have to negotiate again to get it back.")
        broc.deskSlam("We should at least get to keep it to finish the fight!")
        severa.confident("Fine by me!")
        severa.confident.think("As if any of you would be able to attune to it during a fight!")
        sevenflower("And the dragon counts towards my total to not lose my soul,\t right?")
        broc.silly("Right, we need that in the contract,\t too.")
        severa.armsCrossed("We can certainly arrange that.")
        sevenflower.angry.holdIt("What about resurrection magic?\t\t If I die,\t I need to be allowed to be revived to finish my task!")
        severa.damage.think("I thought she hated religion, how did she learn about resurrection?")
        broc.read("We'll also need some language here to ensure that the dragons are of an appropriate strength.\t\t No Bahamut or Tiamat,\t for example.")
        severa.cornered("We can add that as well.")
        sevenflower.thinking("I can sign the contract now,\t right?")
        broc.thinking("${thinking("(I still think there's something off...")}\t\t\t${Sound.REALIZATION}${thinking(" Bahamut or Tiamat, that's it!)")}", args = ActionArgs(doNotTalk = true))
        severa.bow("Yes\t, you did a fine job of getting rid of the loopholes,\t there should be nothing holding you back anymore.")
        broc.point.objection("There are chromatic and metallic dragons,\t and even if Sevenflower doesn't like either of them,\t the rest of us don't want to be fighting metallic dragons!")
        broc.deskSlam("We need to restrict this to chromatic dragons only!")
        severa.damage("What?!\t\t That was my most devillish loophole in there!")
        severa.whipDesk("This is all your fault,\t you were supposed to only invite the dragon-hating bard!")
        irsu.cornered("Eeep!")

    }.writeTo("devil_contract.json")
}