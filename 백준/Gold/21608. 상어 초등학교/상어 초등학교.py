n = int(input())
students = []
board = [[0] * n for _ in range(n)]
d = dict()
for _ in range(n ** 2):
    student = list(map(int, input().split()))
    students.append((student[0], student[1:]))
    d[student[0]] = student[1:]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
total = 0
for e in students:
    stu, priorities = e
    pos = (-1, -1, 999, 999)
    for x in range(n):
        for y in range(n):
            if board[x][y] == 0:
                st = 0
                emp = 0
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if 0 <= nx < n and 0 <= ny < n:
                        if board[nx][ny] == 0:
                            emp += 1
                        elif board[nx][ny] in priorities:
                            st += 1
                if st > pos[0]:
                    pos = (st, emp, x, y)
                elif st == pos[0]:
                        if emp > pos[1]:
                            pos = (st, emp, x, y)
                        elif emp == pos[1]:
                            if x < pos[2]:
                                pos = (st, emp, x, y)
                            elif x == pos[2]:
                                if y < pos[3]:
                                    pos = (st, emp, x, y)
    st, emp, x, y = pos
    if pos[0] != -1:
        board[x][y] = stu
for x in range(n):
    for y in range(n):
        cnt = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if board[nx][ny] in d[board[x][y]]:
                    cnt += 1
        if cnt != 0:
            total += 10 ** (cnt - 1)
print(total)