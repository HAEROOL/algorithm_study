def solution(triangle):
    answer = 0
    dp = [[0] * len(triangle) for _ in range(len(triangle))]
    dp[0][0] = triangle[0][0]
    
    for x in range(1, len(triangle)):
        for y in range(x + 1):
            if y == 0:
                dp[x][y] = dp[x - 1][y] + triangle[x][y]
            elif y == x:
                dp[x][y] = dp[x - 1][y - 1] + triangle[x][y]
            else:
                dp[x][y] = max(dp[x - 1][y], dp[x - 1][y - 1]) + triangle[x][y]
    return max(dp[len(triangle) - 1])