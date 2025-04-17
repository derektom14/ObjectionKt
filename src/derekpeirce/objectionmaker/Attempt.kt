package derekpeirce.objectionmaker

fun main() {
    makeTrial {
        val judge = Judge()
        playMusic(Music.TRIAL) {
            judge("How do you want to do this?")
            mutableListOf(5).shuffle()
        }
    }.writeTo("attempt.objection")
}