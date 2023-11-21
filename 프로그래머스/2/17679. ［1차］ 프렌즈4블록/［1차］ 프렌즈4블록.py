def solution(m, n, board):
    answer = 0
    for x in range(m):
        board[x] = list(board[x])
    while True:
        correctSet = set()
        for x in range(m - 1):
            for y in range(n - 1):
                if board[x][y] != -1 and board[x][y] == board[x + 1][y] == board[x][y + 1] == board[x + 1][y + 1]:
                    correctSet.add((x,y))
                    correctSet.add((x+1, y))
                    correctSet.add((x, y + 1))
                    correctSet.add((x + 1, y + 1))
        correctList = list(correctSet)
        
        if len(correctList) == 0 : break
        
        correctList.sort()
        for coord in list(correctList):
            x = coord[0]
            y = coord[1]
            if x == 0:
                board[x][y] = -1
            else:
                for i in range(x, 0, -1):
                    board[i][y] = board[i - 1][y]
                board[0][y] = -1
    for row in board:
        for e in row:
            if e == -1:
                answer += 1
    return answer