import sys

n,m,h = map(int,sys.stdin.readline().split())

# 2차원 배열로 사다리 만들기
ladder = [[0] * n for _ in range(h)]

for _ in range(m):
  a,b = map(int,sys.stdin.readline().split())
  ladder[a-1][b-1] = 1

# i번 세로선의 결과가 i번이 나오는지 확인하는 check 함수
def check():
  for i in range(n):
    tmp = i
    for j in range(h):
      if ladder[j][tmp] == 1:
        tmp += 1
      elif tmp > 0 and ladder[j][tmp-1] == 1:
        tmp -= 1
    if tmp != i:
      return False
  return True

# 사다리 만드는 DFS 함수
def dfs(cnt, x, y):
    global ans
    if ans <= cnt:
        return
    if check():
        ans = min(ans, cnt)
        return
    if cnt == 3:
        return
    for i in range(x, h):
        if i == x:
          tmp = y 
        else:
          tmp = 0
        for j in range(tmp, n - 1):
            if ladder[i][j]:
                j += 1
            else:
                ladder[i][j] = 1
                dfs(cnt + 1, i, j + 2)
                ladder[i][j] = 0

ans = 4
dfs(0, 0, 0)
print(ans if ans < 4 else -1)