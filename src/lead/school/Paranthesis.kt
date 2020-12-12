package lead.school

import java.util.*

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * In
 * Input: "()[]{}"
 * Output: true
 *
 * Input: "([])"
 * Output: true
 *
 * (   [   {
 *
 * )   ]   }
 *
 */
fun isValid(s: String): Boolean {
    if (s.isEmpty()) return true

    val stack = Stack<Char>()
    for (ch in s) {
        if (ch == '(' || ch == '[' || ch == '{') {
            stack.push(ch)
        } else {
            if (isMapped(stack.pop(), ch)) continue
            else return false
        }
    }
    return stack.empty()
}

private fun isMapped(open: Char, close: Char) = when {
    open == '(' && close == ')' -> true
    open == '[' && close == ']' -> true
    open == '{' && close == '}' -> true
    else -> false
}

fun main() {
    println(isValid(""))
    println(isValid("()"))
    println(isValid("()[]{}"))
    println(isValid("([])"))
    println(isValid("([]){"))
}
