def solution(money):
    dp1 = [0] * (len(money))
    dp1[0] = money[0]
    dp1[1] = max(dp1[0], money[1])
    for x in range(2, len(dp1) - 1):
        dp1[x] = max(money[x] + dp1[x - 2], dp1[x - 1])
    dp2 = [0] * (len(money))
    dp2[0] = 0
    dp2[1] = money[1]
    for x in range(2, len(dp2)):
        dp2[x] = max(money[x] + dp2[x - 2], dp2[x - 1])
    # print(dp1, dp2)
    return max(max(dp1), max(dp2))

# print(solution([1,1,1]))