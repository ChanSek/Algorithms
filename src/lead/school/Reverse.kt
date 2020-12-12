package lead.school

fun reverse(input: String, high: Int = input.length - 1) {
    if (high < 0) return

    println(input[high])
    reverse(input, high = high - 1)
}

fun main() {
    reverse("hello")
    reverse("")
}
