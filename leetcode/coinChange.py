

def coinChange(coins, amount):

    num = [float("inf") for am in range(amount+1)]
    num[0] = 0
    for i in coins:
        for j in range(1, amount+1):
            if(j >= i):
                num[j] = min(num[j], 1 + num[j-i])

    return num[amount] if num[amount] != float('inf') else -1


print(coinChange([1, 2, 5], 11))
