import kotlin.math.pow

fun getOxygenRating(numbers: List<Int>, length: Int): Int{
    var nums = numbers.toMutableList()
    for (power in length - 1 downTo 0 ) {
        val twoPower = 2.0.pow(power.toDouble()).toInt()
        var ones = 0
        var zeros = 0
        val numOnes = mutableListOf<Int>()
        val numZeroes = mutableListOf<Int>()
        if(nums.size == 1){
            break
        }
        for (num in nums) {
            val res = num and twoPower
            val bit = res/twoPower
            if(bit == 0){
                zeros++
                numZeroes.add(num)
            }else{
                ones++
                numOnes.add(num)
            }
        }
        if(ones >= zeros){
            nums = numOnes
        }else{
            nums = numZeroes
        }
    }
    return nums[0]
}

fun getCo2Rating(numbers: List<Int>, length: Int): Int{
    var nums = numbers.toMutableList()
    for (power in length - 1 downTo 0 ) {
        val twoPower = 2.0.pow(power.toDouble()).toInt()
        var ones = 0
        var zeros = 0
        val numOnes = mutableListOf<Int>()
        val numZeroes = mutableListOf<Int>()
        if(nums.size == 1){
            break
        }
        for (num in nums) {
            val res = num and twoPower
            val bit = res/twoPower
            if(bit == 0){
                zeros++
                numZeroes.add(num)
            }else{
                ones++
                numOnes.add(num)
            }
        }
        if(ones >= zeros){
            nums = numZeroes
        }else{
            nums = numOnes
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
        l = if(l < line.length) line.length else l
        numbers.add(num)
    }
    var result = ""
    for (power in 0 until l) {
        val twoPower = 2.0.pow(power.toDouble()).toInt()
        var ones = 0
        var zeros = 0
        for (num in numbers) {
            val res = num and twoPower
            val bit = res/twoPower
            if(bit == 0){
                zeros++
            }else{
                ones++
            }
        }
        result = (if(ones >= zeros) "1" else "0") + result
    }
    val gamma = result.toInt(2)
    val powerConsumption = gamma * ((2.0.pow(l) - 1) - gamma)
    println(powerConsumption)
    val oxygen = getOxygenRating(numbers,l)
    val co2 = getCo2Rating(numbers,l)
    println(oxygen*co2)
}