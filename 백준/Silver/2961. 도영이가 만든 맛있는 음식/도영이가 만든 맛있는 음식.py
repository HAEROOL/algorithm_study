def dfs(depth, cnt, lemon, bad):
    global result

    # 가지 치기
    if cnt != 0:
        if abs(lemon - bad) < result:
            result = abs(lemon - bad)

    # 기저
    if depth == N:
        return

    # 재귀
    dfs(depth + 1, cnt + 1, lemon * cuisine[depth][0], bad + cuisine[depth][1])  # 깊이와 개수 모두 증가시켜준다.
    dfs(depth + 1, cnt, lemon, bad)  # 깊이만 증가시키고 개수는 증가시키지 않는다.


N = int(input())
cuisine = [list(map(int, input().split())) for i in range(N)]
arr = []
result = 1 << 100  # 결과값을 처음에 아주 큰 값으로 초기화

dfs(0, 0, 1, 0)

print(result)