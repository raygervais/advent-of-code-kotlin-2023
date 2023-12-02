fun main() {
    fun part1(input: List<String>): Int {
        return input
            .map { s -> "${s.first { c -> c.isDigit() }}${s.last { c -> c.isDigit() }}" }
            .sumOf { s -> s.toInt() }
    }


    fun part2(input: List<String>): Int {
        val conversion = mapOf(
            "one" to "1",
            "two" to "2",
            "three" to "3",
            "four" to "4",
            "five" to "5",
            "six" to "6",
            "seven" to "7",
            "eight" to "8",
            "nine" to "9",
        )

        val cleanup = fun(s: String): String {
            var holder: String = ""
            for (c in s) {
                holder += c.toString()
                for ((k, v) in conversion) {
                    holder = holder.replace(k, v, true)
                }
            }
            return holder
        }

        return input
            .map { s -> cleanup(s) }
            .map { s -> "${s.first { c -> c.isDigit() }}${s.last { c -> c.isDigit() }}" }
            .sumOf { s -> s.toInt() }
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_Test")
    check(part1(testInput) == 142)

    val testInput2 = readInput("Day01_Test_2")
    check(part2(testInput2) == 281)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
