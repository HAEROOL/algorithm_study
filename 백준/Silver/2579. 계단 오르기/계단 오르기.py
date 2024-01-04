n = int(input())

stairs = [0]
for _ in range(n):
    stairs.append(int(input()))



dp = [0] * (n + 1)

if n <= 2:
    print(sum(stairs))
else:
    dp[1] = stairs[1]
    dp[2] = stairs[1] + stairs[2]
    for x in range(3, n + 1):
        dp[x] = max(dp[x - 2] + stairs[x], dp[x - 3] + stairs[x] + stairs[x - 1])
    print(dp[n])