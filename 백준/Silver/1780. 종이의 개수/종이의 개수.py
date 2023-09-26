N = int(input())

paper = []

minus = 0
zero = 0
one = 0

for _ in range(N):
    paper.append(list(map(int, input().split())))

def dfs(x, y, n):
    global minus, zero, one

    numCheck = paper[x][y]
    for i in range(x, x + n):
        for j in range(y, y + n):
            if paper[i][j] != numCheck:
                for k in range(3):
                    for l in range(3):
                        dfs(x + k * n  // 3, y + l * n // 3, n // 3)
                return
    
    if numCheck == -1:
        minus += 1
    elif numCheck == 0:
        zero += 1
    else:
        one += 1

dfs(0, 0, N)
print(f'{minus}\n{zero}\n{one}')