#!/bin/python3

import math
import os
import random
import re
import sys


# Complete the repeatedString function below.
def repeated_string(s, n):
    input_len = len(s)
    count = s.count('a')
    times = int(n / input_len)
    remainder = int(n % input_len)
    count *= times
    count += s.count('a', 0, remainder)
    return count


if __name__ == '__main__':
    # fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()
    n = int(input())

    result = repeated_string(s, n)
    # fptr.write(str(result) + '\n')
    # fptr.close()
    print(result)
