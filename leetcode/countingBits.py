"""
338. Counting Bits
Easy

7500

350

Add to List

Share
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
"""

"""
used dynamic programming bottom up
"""


def countBits(n):

    if(n == 0):
        return [0]
    ans = []
    ans.append(0)
    ans.append(1)
    for i in range(2, n+1):
        ans.append(i % 2 + ans[i//2])

    return ans


print(countBits(0))
