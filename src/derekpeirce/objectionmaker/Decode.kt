package derekpeirce.objectionmaker

import java.io.File
import java.util.*

fun main() {
    val base64 = File("C:\\Users\\derek\\Downloads\\light_male_blip.objection").readText()
    val json = Base64.getDecoder().decode(base64).decodeToString()
    println(json)
}