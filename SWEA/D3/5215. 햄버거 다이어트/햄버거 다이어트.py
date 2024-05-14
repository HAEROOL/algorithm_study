T = int(input())

for tc in range(T):
    n, k = map(int, input().split())
    ins = [[0, 0]]
    for x in range(n):
        score, cal = map(int, input().split())
        ins.append((cal, score))
    dp = [[0] * (k + 1) for _ in range(n + 1)]
    for x in range(1, n + 1):
        cal, score = ins[x]
        for y in range(1, k + 1):
            if y < cal: dp[x][y] = dp[x - 1][y]
            else:
                dp[x][y] = max(dp[x - 1][y], dp[x - 1][y - cal] + score)
    print(f'#{tc + 1} {dp[n][k]}')