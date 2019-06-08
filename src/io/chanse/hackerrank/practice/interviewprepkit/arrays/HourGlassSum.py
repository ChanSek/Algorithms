import os


# https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
def hourglass_sum(arr):
    result = -63
    for row in range(4):
        for col in range(4):
            temp = sum(arr[row][col:col + 3]) + \
                   arr[row + 1][col + 1] + \
                   sum(arr[row + 2][col:col + 3])
            if temp > result:
                result = temp
    return result


if __name__ == '__main__':
    arr = []
    for _ in range(6):
        arr.append(list(map(int, input().rstrip().split())))

    result = hourglass_sum(arr)
    print(result)
