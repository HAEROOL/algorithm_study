# 문제
![](./image.png)
H*W 크기의 게임판이 있습니다. 게임판은 검은 칸과 흰 칸으로 구성된 격자 모양을 하고 있는데 이 중 모든 흰 칸을 3칸짜리 L자 모양의 블록으로 덮고 싶습니다. 이 때 블록들은 자유롭게 회전해서 놓을 수 있지만, 서로 겹치거나, 검은 칸을 덮거나, 게임판 밖으로 나가서는 안 됩니다. 위 그림은 한 게임판과 이를 덮는 방법을 보여줍니다.

게임판이 주어질 때 이를 덮는 방법의 수를 계산하는 프로그램을 작성하세요.


## 입력
입력의 첫 줄에는 테스트 케이스의 수 C (C <= 30) 가 주어집니다. 각 테스트 케이스의 첫 줄에는 2개의 정수 H, W (1 <= H,W <= 20) 가 주어집니다. 다음 H 줄에 각 W 글자로 게임판의 모양이 주어집니다. # 은 검은 칸, . 는 흰 칸을 나타냅니다. 입력에 주어지는 게임판에 있는 흰 칸의 수는 50 을 넘지 않습니다.

## 출력
한 줄에 하나씩 흰 칸을 모두 덮는 방법의 수를 출력합니다..

## 예제 입력
```
3 
3 7 
#.....# 
#.....# 
##...## 
3 7 
#.....# 
#.....# 
##..### 
8 10 
########## 
#........# 
#........# 
#........# 
#........# 
#........# 
#........# 
########## 
```
## 예제 출력
```
0
2
1514
```


# 풀이
## 코드
```python
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
```

[문제링크](https://www.algospot.com/judge/problem/read/BOARDCOVER)
