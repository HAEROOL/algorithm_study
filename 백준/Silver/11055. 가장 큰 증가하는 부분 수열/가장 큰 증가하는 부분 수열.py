N = int(input())

A = [0] + list(map(int, input().split()))

dp = A[:]

for x in range(1, N + 1):
    for y in range(1, x):
        if A[x] > A[y]:
            dp[x] = max(dp[x], A[x] + dp[y])

print(max(dp))