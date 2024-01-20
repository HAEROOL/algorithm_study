n = int(input())


dp = [0] * (abs(n) + 1)

if(n == 0):
    print(0)
    print(0)
else:
    dp[1] = 1

    for x in range(2, abs(n) + 1):
        dp[x] = (dp[x - 1] + dp[x - 2]) % 1000000000
    if(n > 0):
        print(1)
        print(dp[n])
    else:
        if(n == -1):
            print(1)
        elif(abs(n) % 2 == 1):
            print(1)
        else: print(-1)
        print(dp[abs(n)])

