def climbing_stairs(n):
    memo = []
    memo.append(1)
    memo.append(2)

    for i in range(2, n):
        memo.append(memo[i-1] + memo[i-2])

    return memo[n-1]


print(climbing_stairs(5))
