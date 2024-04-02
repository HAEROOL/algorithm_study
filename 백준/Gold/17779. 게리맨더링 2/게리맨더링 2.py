N = int(input())
board = [[0] * (N + 1)]

for _ in range(N):
    board.append([0] + list(map(int, input().split())))

total = 0
for i in range(1, N + 1):
    total += sum(board[i])

answer = float('inf')

def solve(x, y, d1, d2):
    tmp = [[0] * (N + 1) for _ in range(N + 1)]
    tmp[x][y] = 5
    for i in range(1, d1 + 1):
        tmp[x + i][y - i] = 5
    for i in range(1, d2 + 1):
        tmp[x + i][y + i] = 5
    for i in range(1, d2 + 1):
        tmp[x + d1 + i][y - d1 + i] = 5
    for i in range(1, d1 + 1):
        tmp[x + d2 + i][y + d2 - i] = 5
    people = [0] * 5
    for r in range(1, x + d1):
        for c in range(1, y + 1):
            if tmp[r][c] == 5:
                break
            else:
                people[0] += board[r][c]
    for r in range(1, x + d2 + 1):
        for c in range(N, y, -1):
            if tmp[r][c] == 5:
                break
            else:
                people[1] += board[r][c]
    for r in range(x + d1, N + 1):
        for c in range(1, y - d1 + d2):
            if tmp[r][c] == 5:
                break
            else:
                people[2] += board[r][c]
    for r in range(x + d2 + 1, N + 1):
        for c in range(N, y - d1 + d2 - 1, -1):
            if tmp[r][c] == 5:
                break
            else:
                people[3] += board[r][c]
    people[4] = total - sum(people)
    return max(people) - min(people)


for x in range(1, N + 1):
    for y in range(1, N + 1):
        for d1 in range(1, N + 1):
            for d2 in range(1, N + 1):
                if x + d1 + d2 > N:
                    continue
                if y - d1 < 1:
                    continue
                if y + d2 > N:
                    continue
                answer = min(answer, solve(x, y, d1, d2))
print(answer)