
class Game {
    fun getRandom(mode: String): Pair<Pair<String, String>, List<String>> {
        var first = 0
        var second = 0
        when (mode) {
            "*" -> {
                first = (1..100).random()
                second = (1..100).random()
            }

            "/" -> {
                first = (1..100).random()
                second = (1..100).random()
            }

            "+" -> {
                first = (1..100).random()
                second = (1..100).random()
            }
            "-" -> {
                first = (1..100).random()
                second = (1..100).random()
            }
        }
        if (mode == "/") {
            while (first % second != 0) {
                first = (1..100).random()
                second = (1..100).random()
            }
        }
        var one = (1..100).random().toString()
        var two = (1..100).random().toString()
        var three = (1..100).random().toString()
        val ans = solve(first, second, mode)
        while (one == ans) one = (1..100).random().toString()
        while (two == ans) two = (1..100).random().toString()
        while (three == ans) three = (1..100).random().toString()
        val list = listOf(one, two, three, ans)
        list.shuffled()
        return Pair(Pair("$first $mode $second = ?", solve(first, second, mode)), list)
    }

    private fun solve(first: Int, second: Int, operator: String): String {
        return when (operator) {
            "*" -> "${first * second}"
            "/" -> "${first / second}"
            "+" -> "${first + second}"
            "-" -> "${first - second}"
            else -> {
                "Error"
            }
        }
    }
}