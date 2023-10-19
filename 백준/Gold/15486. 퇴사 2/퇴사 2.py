N = int(input())

dp = [0] * (N + 1)

T = [0] * (N)
P = [0] * (N)

for x in range(0, N):
    t, p = map(int, input().split())

    T[x] = t
    P[x] = p

for x in range(N - 1, -1, -1):
    if T[x] + x > N:
        dp[x] = dp[x + 1]
    else:
        dp[x] = max(dp[x + 1], dp[x + T[x]] + P[x])

print(max(dp))