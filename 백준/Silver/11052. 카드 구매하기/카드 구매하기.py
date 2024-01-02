n = int(input())

arr = list(map(int, input().split()))


dp = [0] * (n + 1)

dp[1] = arr[0]

for x in range(1, n + 1):
    for y in range(1, x + 1):
        dp[x] = max(dp[x], dp[x - y] + arr[y - 1])
print(dp[n])