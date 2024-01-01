n = int(input())
wines = []

for _ in range(n):
    wines.append(int(input()))

dp = [0] * (n + 1)

dp[1] = wines[0]
if n > 1: 
    dp[2] = wines[1] + dp[1]


for x in range(3, n + 1):
    dp[x] = max(dp[x - 1], dp[x - 2] + wines[x - 1], wines[x - 1] + wines[x - 2] + dp[x - 3])
print(max(dp))