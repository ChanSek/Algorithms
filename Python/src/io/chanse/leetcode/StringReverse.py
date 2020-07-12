def reverse_string(s, start, end):
    if start <= end:
        temp = s[start]
        s[start] = s[end]
        s[end] = temp
        reverse_string(s, start + 1, end - 1)
    return s


print(reverse_string(list("hello"), 0, 4))
