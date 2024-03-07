N, M = map(int, input().split())

board = []
# Y X
A = [[(0,0),(0,1),(0,2),(0,3)],
     [(0,0),(1,0),(2,0),(3,0)]]

B = [(0,0),(0,1),(1,0),(1,1)]

C = [[(0,0),(-1,0),(-2,0),(0,1)],
     [(0,0),(1,0),(2,0),(0,1)],
     [(0,0),(-1,0),(-2,0),(0,-1)],
     [(0,0),(1,0),(2,0),(0,-1)],
     [(0,0),(0,1),(0,2),(1,2)],
     [(0,0),(0,1),(0,2),(1,0)],
     [(0,0),(0,1),(0,2),(-1,2)],
     [(0,0),(0,1),(0,2),(-1,0)]]

D = [[(0,0),(-1,0),(0,1),(1,1)],
     [(0,0),(1,0),(0,1),(-1,1)],
     [(0,0),(0,1),(1,1),(1,2)],
     [(0,0),(0,1),(-1,1),(-1,2)]]

E = [[(0,0),(0,1),(1,1),(0,2)],
     [(0,0),(0,1),(-1,1),(0,2)],
     [(0,0),(0,1),(1,0),(-1,0)],
     [(0,0),(0,-1),(1,0),(-1,0)]]


for x in range(0, N):
    row = list(map(int, input().split()))
    board.append(row)

answer = 0
for y in range(0, N):
    for x in range(0, M):
        ma = 0
        mb = 0
        mc = 0
        md = 0
        me = 0
        for ac in A:
            a = 0
            for coord in ac:
                dy, dx = coord
                if 0 <= x + dx < M and 0 <= y + dy < N:
                    a += board[y + dy][x + dx]
                else:
                    a = 0
                    break
            ma = max(a, ma)
        for coord in B:
            dy, dx = coord
            if 0 <= x + dx < M and 0 <= y + dy < N:
                mb += board[y + dy][x + dx]
            else:
                mb = 0
                break     
        for cc in C:
            c = 0
            for coord in cc:
                dy, dx = coord
                if 0 <= x + dx < M and 0 <= y + dy < N:
                    c += board[y + dy][x + dx]
                else:
                    c = 0
                    break
            mc = max(c, mc)
        for dc in D:
            d = 0
            for coord in dc:
                dy, dx = coord
                if 0 <= x + dx < M and 0 <= y + dy < N:
                    d += board[y + dy][x + dx]
                else:
                    d = 0
                    break
            md = max(d, md)
        for ec in E:
            e = 0
            for coord in ec:
                dy, dx = coord
                if 0 <= x + dx < M and 0 <= y + dy < N:
                    e += board[y + dy][x + dx]
                else:
                    e = 0
                    break
            me = max(e, me)
        answer = max(ma,mb,mc,md,me,answer)
print(answer)