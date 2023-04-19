c = int(input())
answers = []
coverType = [[(0,0), (0,1), (-1,1)],
             [(0,0), (1,0), (1,1)],
             [(0,0), (1,0), (0,1)],
             [(0,0), (0,1), (1,1)]]

def boardCover():
    x, y = -1, -1
    for i in range(H):
        for j in range(W):
            if(board[i][j] == '.'):
                x = j
                y = i
                break
        if(y != -1):
            break
    
    if x == -1 and y == -1: return 1

    count = 0

    for cover in coverType:
        flag = True
        for dx, dy in cover:
            nx, ny = x + dx, y + dy
            if(nx < 0 or nx >= W or ny < 0 or ny >= H):
                flag = False
                break
            elif board[ny][nx] == '#':
                flag = False
                break
        if flag:
            for dx, dy in cover:
                nx, ny = x + dx, y + dy
                board[ny][nx] = '#'
            
            count += boardCover()
            
            for dx, dy in cover:
                nx, ny = x + dx, y + dy
                board[ny][nx] = '.'
    return count


for _ in range(c):
    H, W = map(int, input().split())
    board = [list(input()) for _ in range(H)]
    print(boardCover())