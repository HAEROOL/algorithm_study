t = int(input())

dp = [[0, 0]] * 41

dp[0] = [1, 0]
dp[1] = [0, 1]

for x in range(2, 41):
    dp[x] = [dp[x - 1][0] + dp[x - 2][0], dp[x - 1][1] + dp[x - 2][1]]

for x in range(t):
    print(*dp[int(input())])