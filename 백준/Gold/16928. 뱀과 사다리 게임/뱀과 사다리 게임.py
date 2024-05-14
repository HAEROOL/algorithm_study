from collections import deque

n, m = map(int, input().split())

visited = [-1 for _ in range(101)]
board = [-1 for _ in range(101)]

for _ in range(n):
    st, end = map(int, input().split())
    board[st] = end
for _ in range(m):
    st, end = map(int, input().split())
    board[st] = end
answer = -1
q = deque([1])
visited[1] = 0
while q:
    n = q.pop()
    if n == 100:
        answer = visited[100]
        break
    for i in range(1, 7):
        node = n + i
        if node <= 100 and visited[node] == -1:
            if board[node] != -1:
                node = board[node]
            if visited[node] == -1:
                visited[node] = visited[n] + 1
                q.appendleft(node)
print(answer)