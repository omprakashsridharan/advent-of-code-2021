import java.util.*

fun main(){
    val course = readInput("Day02")
    var x = 0
    var y = 0
    var aim = 0
    for(line in course) {
        val parts = line.split(" ")
        val command = parts[0]
        val value = parts[1].toInt()
        when(command.lowercase(Locale.getDefault())){
            "forward" -> {
                x += value
                y += (aim*value)
            }
            "up" -> {
                aim -= value
            }
            "down" -> {
                aim += value
            }
        }
    }
    println(x*y)
}