n = int(input())

dp = [[0]] * (n + 2)

dp[1] = [1]
dp[2] = [2, 1]
if n < 3:
    print(len(dp[n]) - 1)
    print(*dp[n])
else:
    dp[3] = [3, 1]

    for x in range(4, n + 2):
        dp[x] = [x] + dp[x - 1]
        if x % 3 == 0 and len(dp[x]) > len([x] + dp[x // 3]):
            dp[x] = [x] + dp[x // 3]
        if x % 2 == 0 and len(dp[x]) > len([x] + dp[x // 2]):
            dp[x] = [x] + dp[x // 2]


    print(len(dp[n]) - 1)
    print(*dp[n])