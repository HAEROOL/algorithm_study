N = int(input())

dp = [[1] for _ in range(0, N + 1)]

dp[1] = [1]

for x in range(2, N + 1):
    dp[x] = [x] + dp[x - 1]
    if x % 3 == 0:
        if len(dp[x]) > len([x] + dp[x // 3]):
            dp[x] = [x] + dp[x // 3]
    if x % 2 == 0:
        if len(dp[x]) > len([x] + dp[x // 2]):
            dp[x] = [x] + dp[x // 2]
        
print(len(dp[N]) - 1)
print(*dp[N])