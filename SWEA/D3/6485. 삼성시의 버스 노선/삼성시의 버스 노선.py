T = int(input())
for tc in range(T):
    n = int(input())
    arr = []
    for _ in range(n):
        arr.append(list(map(int, input().split())))
    p = int(input())
    stops = []
    answers = [0] * p
    for _ in range(p):
        stops.append(int(input()))
    for ai, bi in arr:
        total = 0
        for i in range(p):
            if ai <= stops[i] <= bi:
                answers[i] += 1
    print(f'#{tc + 1} ', end='')
    print(*answers)