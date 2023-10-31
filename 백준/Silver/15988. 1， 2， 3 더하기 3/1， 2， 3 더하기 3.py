T = int(input())

for x in range(T):
    n = int(input())
    dp = [0] * 1000001
    dp[0] = 0
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for y in range(4, n + 1):
        dp[y] = (dp[y - 3] + dp[y - 2] + dp[y - 1]) % 1000000009
    print(dp[n])