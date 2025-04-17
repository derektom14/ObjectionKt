package derekpeirce.objectionmaker

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import derekpeirce.objectionmaker.ObjectionMaker.Builder
import derekpeirce.objectionmaker.ObjectionMaker.Builder.Actor
import java.awt.Color
import java.io.File
import java.util.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

interface PanelCreator {
    fun createPanel(
        id: Int,
        text: String,
        poseId: Int,
        args: ActionArgs,
        username: String
    ): Panel

    object Default : PanelCreator {
        override fun createPanel(
            id: Int,
            text: String,
            poseId: Int,
            args: ActionArgs,
            username: String
        ): Panel {
            return Panel(
                id = id,
                text = text,
                poseId = poseId,
                poseAnimation = args.animated,
                bubbleType = args.bubble,
                goNext = args.interrupted,
                doNotTalk = args.doNotTalk || (args.saidBy != null),
                mergeNext = args.mergeNext,
                username = args.saidBy ?: username,
                blip = args.blip?.ordinal,
            )
        }
    }
}

enum class Blip {
    DEFAULT,
    MALE,
    FEMALE,
    TYPERWRITER,
    ECHOING_BLIP,
    KATONK,
    MUTED,
}

data class ActionArgs(
    val bubble: String = "0",
    val animated: Boolean = true,
    val interrupted: Boolean = false,
    val doNotTalk: Boolean = false,
    val mergeNext: Boolean = false,
    val punctuation: PuncutationMode? = null,
    val saidBy: String? = null,
    val blip: Blip? = null,
) {
    companion object {
        val DEFAULT = ActionArgs()
    }
}

class Action(
    val id: Int,
    private val builder: Builder,
    private val defaultTextSpeed: String? = null,
    private val tabPauseTime: Duration = 150.milliseconds,
    private val name: String? = null
) {
    operator fun invoke(
        text: String,
        args: ActionArgs = ActionArgs.DEFAULT,
        panelCreator: PanelCreator = PanelCreator.Default
    ) = apply {
        val music = when (val state = builder.musicState) {
            MusicState.None, MusicState.Continue -> null
            is MusicState.StartPlaying -> {
                builder.musicState = MusicState.Continue
                state.music.toString()
            }
            MusicState.Stopping -> {
                builder.musicState = MusicState.None
                endBackgroundMusic
            }
        }
        val image = when (val state = builder.imageState) {
            ImageState.None, ImageState.Continue -> null
            is ImageState.StartShowing -> {
                builder.imageState = ImageState.Continue
                val start = "[#evd${state.image}]"
                val prevPanel = builder.panels.lastOrNull()
                if (prevPanel != null) {
                    prevPanel.text += start
                    null
                } else {
                    start
                }
            }
            ImageState.Stopping -> {
                builder.imageState = ImageState.None
                "[#evdh]"
            }
        }
        builder.panels.add(
            panelCreator.createPanel(
                id = builder.panels.size + 1,
                text = music.orEmpty() + image.orEmpty() + defaultTextSpeed.orEmpty() + processText(text, args.punctuation),
                poseId = id,
                args = args,
                username = name.orEmpty()
            )
        )
    }

    private fun processText(text: String, punctuation: PuncutationMode?): String {
        return when (punctuation ?: builder.punctuation) {
            PuncutationMode.MANUAL -> text.replace("\t", pause(tabPauseTime))
            PuncutationMode.AUTO -> text
                .replace(Regex("[.!?]+[\")♪]*")) { it.groupValues[0] + pause(tabPauseTime*2) }
                .replace(Regex("[,]+")) { it.groupValues[0] + pause(tabPauseTime) }
                .replace("\t", pause(tabPauseTime))
        }
    }

    fun objection(text: String, args: ActionArgs = ActionArgs()) = invoke(text, args.copy(bubble = "1"))
    fun holdIt(text: String) = invoke(text, args = ActionArgs("2"))
    fun takeThat(text: String) = invoke(text, args = ActionArgs("3"))

}

enum class PuncutationMode {
    MANUAL,
    AUTO,
}

fun color(text: String, color: Color): String {
    val colorString = when (color) {
        Color.RED -> "r"
        Color.GREEN -> "g"
        Color.BLUE -> "b"
        else -> "c${"%02x".format(color.red)}${"%02x".format(color.green)}${"%02x".format(color.blue)}"
    }
    return "[#/$colorString]$text[/#]"
}
fun textSpeed(speed: Int) = "[#ts$speed]"
fun pause(pause: Duration) = "[#p${pause.inWholeMilliseconds}]"
val flashSmall = "[#fs]"
val flashMedium = "[#fm]"
val flashBig = "[#fl]"
val shakeSmall = "[#ss]"
val shakeMedium = "[#sm]"
val shakeBig = "[#sl]"
val endBackgroundMusic = "[#bgms]"

sealed class MusicState {
    object None : MusicState()
    data class StartPlaying(val music: Music): MusicState()
    object Continue: MusicState()
    object Stopping: MusicState()
}

sealed class ImageState {
    object None : ImageState()
    data class StartShowing(val image: String): ImageState()
    object Continue: ImageState()
    object Stopping: ImageState()
}

class Music(val n: Int) {

    companion object {
        val ALLEGRO_2001 = Music(1)
        val ALLEGRO_2002 = Music(77)
        val ALLEGRO_2004 = Music(7)
        val ALLEGRO_2007 = Music(712)
        val ALLEGRO_2009 = Music(72)
        val ALLEGRO_2011 = Music(71)
        val BLUE_BADGER = Music(695)
        val CIRCUS = Music(470)
        val CONGRATULATIONS = Music(16)
        val CORNERED = Music(4)
        val CROSS_EXAMINING = Music(13)
        val MAYA_FEY = Music(15)
        val MODERATO_2001 = Music(18)
        val OBJECTION = Music(14)
        val SUSPENSE = Music(65)
        val TRIAL = Music(2)
        val TRUTH = Music(17)
        val VON_KARMA = Music(287)
        val WILD_WEST = Music(40)
        val WON_THE_CASE = Music(702)
        val STEEL_SAMURAI = Music(704)
        val STEEL_SAMURAI_RINGTONE = Music(4948)
        val STEEL_SAMURAIS_BALLAD = Music(5345)
        val PLEASE_LISTEN = Music(15570)
        val PSYCHE_LOCK = Music(709)
    }

    override fun toString() = "[#bgm$n]"
}

class Sound(val n: Int) {
    companion object {
        val APPLAUSE = Sound(5)
        val APPLAUSE2 = Sound(18)
        val BADUM = Sound(6)
        val BANG = Sound(24)
        val BREAK = Sound(1631)
        val BREAK2 = Sound(1922)
        val CHICKEN = Sound(929)
        val DAMAGE = Sound(7)
        val DAMAGE2 = Sound(10)
        val DESK_SLAM = Sound(2)
        val DRAMA_POUND = Sound(20)
        val EARTHQUAKE = Sound(126)
        val EVIDENCE = Sound(8)
        val EXPLOSION = Sound(28)
        val FALL = Sound(255)
        val FLIP_BOOK = Sound(1637)
        val GALLERY = Sound(31)
        val GALLERY_CHEER = Sound(29)
        val GALLERY_NOISE = Sound(23)
        val GAVEL_QUICK = Sound(139)
        val GAVEL = Sound(16)
        val GUILTY = Sound(17)
        val GUITAR_ERROR = Sound(928)
        val GUNSHOT = Sound(933)
        val GUNSHOT2 = Sound(931)
        val HEARTBEAT = Sound(11)
        val LIGHT_BULB = Sound(9)
        val MEGAPHONE = Sound(934)
        val PHOTO_SNAP = Sound(30)
        val PING = Sound(25)
        val REALIZATION = Sound(3)
        val ROAR = Sound(136)
        val SALUTE = Sound(925)
        val SHINY = Sound(937)
        val SHOCK = Sound(4)
        val SHOOOP = Sound(14)
        val SKETCH = Sound(1645)
        val SMACK = Sound(15)
        val SNACKOOD = Sound(21)
        val SNAP_FINGER = Sound(1632)
        val SNAP = Sound(1633)
        val THWAP = Sound(27)
        val WHACK = Sound(19)
        val WHIP = Sound(26)
        val WHOOPS = Sound(1)
        val YELL = Sound(12)
        val YELL2 = Sound(13)
        val POKEMON_CATCH = Sound(80152)
    }

    override fun toString() = "[#bgs$n]"
}


class ObjectionMaker(val frames: List<Panel>, val pairs: List<ActorPairData>, val aliases: List<Nothing> = emptyList(), val version: Int = 3) {
    class Builder(defaultTextSpeed: Int?, private val tabPauseTime: Duration, val punctuation: PuncutationMode) {

        private val defaultTextSpeedStr = defaultTextSpeed?.let(::textSpeed)
        private val pairs = mutableListOf<ActorPair<*, *>>()
        private var pairIdCounter = 1

        var musicState: MusicState = MusicState.None
        var imageState: ImageState = ImageState.None

        val panels = mutableListOf<Panel>()

        private fun action(id: Int, name: String? = null) = Action(id,this, defaultTextSpeedStr, tabPauseTime, name)

        fun playMusic(music: Music, withMusic: () -> Unit) {
            musicState = MusicState.StartPlaying(music)
            withMusic()
            musicState = MusicState.Stopping
        }

        fun showImage(image: String, withImage: () -> Unit) {
            imageState = ImageState.StartShowing(image)
            withImage()
            imageState = ImageState.Stopping
        }

        inner open class Actor(val characterId: Int?, standId: Int, val name: String? = null) {
            val stand = a(standId)

            internal fun a(id: Int) = action(id, name)

            operator fun invoke(text: String) = stand(text)
        }

        inner class Polly : Actor(38, 302)

        inner class Judge : Actor(0, 30) {
            val negative = a(31)
            val surprised = a(32)
            val positive = a(44)
            val eyesClosed = a(186)
        }

        inner class Phoenix : Actor(1, 1) {
            val deskSlam = a(2)
            val point = a(3)
            val confident = a(4)
            val thinking = a(33)
            val cornered = a(34)
            val silly = a(35)
            val read = a(59)
            val sipMug = a(76)
            val nod = a(100)
            val headshake = a(101)
            val damage = a(129)
            val breakdown = a(140)
            val coffeeStained = a(188)
            val yell = a(271)
        }

        inner class Edgeworth(name: String? = null) : Actor(94, 5, name = name) {
            val deskSlam = a(6)
            val point = a(7)
            val armsCrossed = a(8)
            val confidentShrug = a(9)
            val cornered = a(36)
            val confidentSmirk = a(47)
            val read = a(89)
            val damage = a(90)
            val smirk = a(185)
            val bow = a(189)
            val yell = a(272)
        }

        inner class VonKarma : Actor(0, 27) {
            val confident = a(28)
            val armsCrossed = a(29)
            val cornered = a(42)
            val snapFinger = a(43)
            val damage = a(191)
            val breakdown1 = a(309)
            val breakdown2 = a(310)
        }

        inner class Maya(name: String? = null) : Actor(0, 102, name = name) {
            val angry = a(103)
            val dull = a(104)
            val thinking = a(105)
            val determined = a(106)
        }

        inner class Apollo(name: String? = null) : Actor(0, 60, name = name) {
            val confident = a(55)
            val silly = a(56)
            val deskSlam = a(57)
            val read = a(58)
            val point = a(61)
            val cornered = a(62)
            val thinking = a(63)
        }

        inner class FranziskaVonKarma(name: String? = null) : Actor(0, 21, name = name) {
            val confident = a(22)
            val deskSlam = a(23)
            val armsCrossed = a(24)
            val point = a(25)
            val whipDesk = a(26)
            val cornered = a(41)
            val damage = a(192)
            val bow = a(193)
            val yell = a(274)
        }

        inner class Lotta(name: String? = null) : Actor(0, 113, name = name) {
            val stand2 = a(114)
            val silly = a(115)
            val relieved = a(116)
            val smile = a(117)
            val angry = a(118)
            val stare = a(119)
            val uncertain = a(120)
        }

        inner class MattEngarde(name: String? = null) : Actor(0, 253, name = name) {
            val uncertain = a(254)
            val call = a(255)
            val onCall = a(256)
            val evil = a(257)
            val laugh = a(258)
            val cornered = a(259)
            val breakdown = a(260)
        }

        inner class Gumshoe(name: String? = null) : Actor(0, 130, name = name) {
            val sad = a(134)
            val headscratch = a(137)
            val stare = a(135)
        }

        inner class JakeMarhsall(name: String? = null) : Actor(0, 152, name = name) {
            val cornered = a(161)
            val damage = a(160)
            val drink = a(155)
            val drinkNewBottle = a(154)
            val hatOff = a(156)
            val nervous = a(157)
            val point = a(153)
            val serious = a(159)
            val shave = a(162)
        }

        inner class Pearl(name: String? = null): Actor(62,469, name = name) {
            val angry = a(472)
            val cry = a(477)
            val dream = a(475)
            val happy = a(473)
            val neutral = a(470)
            val sad = a(476)
            val surprised = a(474)
            val worried = a(471)
        }

        inner class Larry(name: String? = null): Actor(27, 206, name = name) {
            val cornered = a(211)
            val cry = a(211)
            val happy = a(207)
            val nervous = a(212)
            val surprised = a(214)
            val think = a(208)
            val thinkScratchHead = a(209)
            val thumbsUp = a(213)
        }

        inner class Godot(name: String? = null): Actor(25, 175, name = name) {
            val confident = a(180)
            val confidentWithMug = a(181)
            val cornered = a(179)
            val damage = a(218)
            val damageCustom = a(413)
            val deskSlam = a(174)
            val deskSlanWithMug = a(173)
            val maskExplosion = a(520)
            val mugSip = a(184)
            val newMugSip = a(176)
            val point = a(178)
            val pointWihtMug = a(177)
            val think = a(182)
            val throwMug = a(219)
            val yell = a(275)
        }

        inner class RonDeLite(name: String? = null): Actor(43, 331, name = name) {
            val cornered = a(334)
            val sad = a(333)
            val serious = a(335)
            val shout = a(336)
            val shout2 = a(337)
            val think = a(332)
        }

        inner class WinstonPayne(name: String? = null): Actor(6, 19, name = name) {
            val confident = a(20)
            val cornered = a(40)
            val damage = a(190)
            val damage2 = a(410)
        }

        inner class CodyHackins(name: String? = null): Actor(34, 276, name = name) {
            val angry = a(283)
            val confident = a(282)
            val annoyed = a(277)
            val cry = a(280)
            val crying = a(281)
            val happy = a(284)
            val sad = a(279)
            val surprised = a(278)
        }

        inner class Gallery(name: String? = null): Actor(null, 540, name = name) {

        }

        inner class ActorPair<A1: Actor, A2: Actor>(
            private val actor1: A1,
            private val actor2: A2,
            name: String? = null,
            private val offsetX: Int = -20,
            private val offsetY: Int = 0,
            private val offsetX2: Int = 20,
            private val offsetY2: Int = 0,
            private val front: Boolean = true
        ) {
            private val pairId = pairIdCounter++
            private val name = name ?: "Pair $pairId"

            init {
                pairs += this
            }

            operator fun component1() = Delegate1()
            operator fun component2() = Delegate2()

            inner class Delegate1 {
                operator fun invoke(text: String, args: ActionArgs = ActionArgs.DEFAULT, otherPose: A2.() -> Action = Actor::stand) {
                    return invoke(Actor::stand, text, args, otherPose)
                }


                operator fun invoke(action: A1.() -> Action, text: String, args: ActionArgs = ActionArgs.DEFAULT, otherPose: A2.() -> Action = Actor::stand) {
                    val action1 = actor1.action()
                    val action2 = actor2.otherPose()
                    action1.invoke(
                        text = text,
                        args = args,
                        panelCreator = object : PanelCreator {
                            override fun createPanel(
                                id: Int,
                                text: String,
                                poseId: Int,
                                args: ActionArgs,
                                username: String
                            ): Panel {
                                return Panel(
                                    id = id,
                                    text = text,
                                    poseId = poseId,
                                    pairPoseId = action2.id,
                                    bubbleType = args.bubble,
                                    username = args.saidBy ?: username,
                                    doNotTalk = args.doNotTalk || (args.saidBy != null),
                                    goNext = args.interrupted,
                                    poseAnimation = true,
                                    mergeNext = args.mergeNext,
                                    flipped = false,
                                    pairId = pairId,
                                    blip = args.blip?.ordinal,
                                )
                            }

                        }
                    )
                }
            }

            inner class Delegate2 {
                operator fun invoke(text: String, args: ActionArgs = ActionArgs.DEFAULT, otherPose: A1.() -> Action = Actor::stand) {
                    return invoke(Actor::stand, text, args, otherPose)
                }


                operator fun invoke(action: A2.() -> Action, text: String, args: ActionArgs = ActionArgs.DEFAULT, otherPose: A1.() -> Action = Actor::stand) {
                    val action2 = actor2.action()
                    val action1 = actor1.otherPose()
                    action2.invoke(
                        text = text,
                        args = args,
                        panelCreator = object : PanelCreator {
                            override fun createPanel(
                                id: Int,
                                text: String,
                                poseId: Int,
                                args: ActionArgs,
                                username: String
                            ): Panel {
                                return Panel(
                                    id = id,
                                    text = text,
                                    poseId = poseId,
                                    pairPoseId = action1.id,
                                    bubbleType = args.bubble,
                                    username = args.saidBy ?: username,
                                    doNotTalk = args.doNotTalk || (args.saidBy != null),
                                    goNext = args.interrupted,
                                    poseAnimation = true,
                                    flipped = false,
                                    pairId = pairId,
                                    blip = args.blip?.ordinal,
                                )
                            }

                        }
                    )
                }
            }

            fun toData() = ActorPairData(
                id = 0,
                pairId = pairId,
                name = name,
                characterId = actor1.characterId,
                characterId2 = actor2.characterId,
                offsetX = offsetX,
                offsetY = offsetY,
                offsetX2 = offsetX2,
                offsetY2 = offsetY2,
                front = front
            )
        }

        fun build(): ObjectionMaker = ObjectionMaker(panels.toList(), pairs.map { it.toData() })
    }

    fun writeTo(filename: String) {
        val json = Gson().toJson(this)
        println(json)
        val base64 = Base64.getEncoder().encodeToString(json.toByteArray())
        File(filename).writeText(base64)
    }

    fun print() {
        println(GsonBuilder().setPrettyPrinting().create().toJson(this))
    }
}

fun makeTrial(defaultTextSpeed: Int? = null, tabPauseTime: Duration = 150.milliseconds, punctuation: PuncutationMode = PuncutationMode.MANUAL, builder: Builder.() -> Unit): ObjectionMaker {
    return Builder(defaultTextSpeed = defaultTextSpeed, tabPauseTime = tabPauseTime, punctuation = punctuation).apply(builder).build()
}

data class Panel(
    val id: Int,
    var text: String,
    val poseId: Int = 1,
    val pairPoseId: Int? = null,
    val poseAnimation: Boolean = true,
    val flipped: Boolean = false,
    val bubbleType: String = "0",
    val goNext: Boolean = false,
    val mergeNext: Boolean = false,
    val doNotTalk: Boolean = false,
    val username: String = "",
    val pairId: Int? = null,
    val blip: Int? = null,
)

data class ActorPairData(
    val id: Int = 0,
    val pairId: Int,
    val name: String,
    val characterId: Int?,
    val characterId2: Int?,
    val offsetX: Int = -20,
    val offsetY: Int = 0,
    val offsetX2: Int = 20,
    val offsetY2: Int = 0,
    val front: Boolean = true
)

fun repeatStr(numTimes: Int, separator: String = "", factory: () -> String) = (1..numTimes).map { factory() }.joinToString(separator = separator)