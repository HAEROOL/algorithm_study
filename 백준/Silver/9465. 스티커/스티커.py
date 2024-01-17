import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T) :
    n = int(input())
    dp = [list(map(int,input().split())) for _ in range(2)]

    for y in range(1, n):
        dp[0][y] = max(dp[1][y - 1] + dp[0][y], dp[0][y - 1])
        dp[1][y] = max(dp[0][y - 1] + dp[1][y], dp[1][y - 1])
    print(max(dp[0][n - 1], dp[1][n - 1]))

    