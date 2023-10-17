T = int(input())

dp = [() for _ in range(0, 41)]
dp[0] = [1, 0]
dp[1] = [0, 1]
for _ in range(T):
    n = int(input())
    for x in range(2, n+1):
        dp[x] = (dp[x - 1][0] + dp[x-2][0], dp[x - 1][1] + dp[x-2][1])
    print(*dp[n])
