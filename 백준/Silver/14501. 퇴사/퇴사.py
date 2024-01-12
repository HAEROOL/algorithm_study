N = int(input())

dp = [0] * (N + 1)

T = []
P = []

for _ in range(N):
    t, p = map(int, input().split())
    T.append(t)
    P.append(p)

for x in range(N - 1, -1, -1):
    dp[x] = dp[x + 1]
    if T[x] + x <= N:
        dp[x] = max(P[x] + dp[x + T[x]], dp[x])
print(max(dp))