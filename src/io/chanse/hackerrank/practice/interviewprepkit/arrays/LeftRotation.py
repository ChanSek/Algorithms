

# https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=arrays
def rot_left(a, d):
    arr_size = len(a)
    diff = arr_size - d
    output = [0] * arr_size

    for index, value in enumerate(a):
        output[(index + diff) % arr_size] = value
    return output


if __name__ == '__main__':
    # fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nd = input().split()
    n = int(nd[0])
    d = int(nd[1])

    a = list(map(int, input().rstrip().split()))

    result = rot_left(a, d)
    print(result)

    # fptr.write(' '.join(map(str, result)))
    # fptr.write('\n')
    # fptr.close()
