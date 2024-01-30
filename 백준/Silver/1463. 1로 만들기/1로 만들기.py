N = int(input())
INF = float('inf')

dp = [INF] * (10**6 + 1)

dp[1] = 0
dp[2] = 1
dp[3] = 1

for x in range(4, N + 1):
    if x % 3 == 0:
        dp[x] = dp[x // 3] + 1
    if x % 2 == 0:
        dp[x] = min(dp[x], dp[x // 2] + 1)
    dp[x] = min(dp[x], dp[x - 1] + 1)

print(dp[N])