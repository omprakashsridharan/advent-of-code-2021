import kotlin.math.pow

fun getRating(numbers: List<Int>, length: Int, reverse: Boolean = false): Int {
    var nums = numbers.toMutableList()
    for (power in length - 1 downTo 0) {
        val twoPower = 2.0.pow(power.toDouble()).toInt()
        var ones = 0
        var zeros = 0
        val numOnes = mutableListOf<Int>()
        val numZeroes = mutableListOf<Int>()
        if (nums.size == 1) {
            break
        }
        for (num in nums) {
            val res = num and twoPower
            val bit = res / twoPower
            if (bit == 0) {
                zeros++
                numZeroes.add(num)
            } else {
                ones++
                numOnes.add(num)
            }
        }
        nums = if (reverse) {
            //CO2
            if (ones >= zeros) {
                numZeroes
            } else {
                numOnes
            }
        } else {
            if (ones >= zeros) {
                numOnes
            } else {
                numZeroes
            }
        }

    }
    return nums[0]
}

fun main() {
    val report = readInput("Day03")
    val numbers = mutableListOf<Int>()
    var l = 0
    for (line in report) {
        val num = line.toInt(2)
        l = if (l < line.length) line.length else l
        numbers.add(num)
    }
    var result = ""
    for (power in 0 until l) {
        val twoPower = 2.0.pow(power.toDouble()).toInt()
        var ones = 0
        var zeros = 0
        for (num in numbers) {
            val res = num and twoPower
            val bit = res / twoPower
            if (bit == 0) {
                zeros++
            } else {
                ones++
            }
        }
        result = (if (ones >= zeros) "1" else "0") + result
    }
    val gamma = result.toInt(2)
    val powerConsumption = gamma * ((2.0.pow(l) - 1) - gamma)
    println(powerConsumption)
    val oxygen = getRating(numbers, l)
    val co2 = getRating(numbers, l, true)
    println(oxygen * co2)
}