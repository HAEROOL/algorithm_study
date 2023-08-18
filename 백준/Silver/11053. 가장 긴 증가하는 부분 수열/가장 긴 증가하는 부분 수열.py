n = int(input())

arr = list(map(int, input().split()))

dp = [1] * n

for x in range(1, n):
    for y in range(x):
        if arr[x] > arr[y]:
            dp[x] = max(dp[x], dp[y] + 1)

print(max(dp))