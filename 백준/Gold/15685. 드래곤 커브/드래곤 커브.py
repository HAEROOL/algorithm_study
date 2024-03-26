N = int(input())

coords = []
dy = [0, -1, 0, 1]
dx = [1, 0, -1, 0]
for _ in range(N):
    x,y,d,g = map(int, input().split())
    dirarr = [d]
    pos = [(x, y)]
    for _ in range(0, g):
        tmp = []
        for i in range(len(dirarr)):
            tmp.append((dirarr[- i -1] + 1) % 4)
        dirarr.extend(tmp)
    for dir in dirarr:
        a, b = pos[-1]
        nx = a + dx[dir]
        ny = b + dy[dir]
        pos.append((nx, ny))
    coords.extend(pos)

answer = 0
for y in range(100):
    for x in range(100):
        if (x, y) in coords and (x+1, y) in coords and (x, y + 1) in coords and (x + 1, y + 1)in coords:
            answer += 1

print(answer)