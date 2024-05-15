N = int(input())

arr = list(map(int, input().split()))

dp = [[0] + [float('inf') for _ in range(N)] for _ in range(len(arr) + 1)]

for x in range(1, N + 1):
    dp[1][x] = arr[0] * x

for i in range(2, N + 1):
    for j in range(1, len(arr) + 1):
        if j < i: dp[i][j] = dp[i - 1][j]
        else:
            dp[i][j] = min(dp[i - 1][j], dp[i][j - i] + arr[i - 1])

print(dp[N][len(arr)])