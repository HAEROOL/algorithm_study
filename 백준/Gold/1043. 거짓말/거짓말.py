import sys
from collections import deque
from itertools import combinations

N, M = map(int,input().split())
ans = 0
truth_flag = False
party_list = []
who_know_truth = [False] * (N + 1)

know = [int(x) for x in sys.stdin.readline().rstrip().split()]
know_member = know[1:]

for k in know_member:
    who_know_truth[k] = True

graph = [[] for _ in range(N + 1)]

for _ in range(M):
    party = [int(x) for x in sys.stdin.readline().rstrip().split()]
    party_member = party[1:]
    party_list.append(party_member)
    for pair in combinations(party_member,2):
        if not pair[1] in graph[pair[0]]:
            graph[pair[0]].append(pair[1])
        if not pair[0] in graph[pair[1]]:
            graph[pair[1]].append(pair[0])

def bfs(n):

    deq = deque()
    deq.append(n)
    visited[n] = True

    while deq:
        x = deq.popleft()

        for i in graph[x]:
            if not visited[i]:
                who_know_truth[i] = True
                visited[i] = True
                deq.append(i)

for i in know_member:
    visited = [False] * (N + 1)
    bfs(i)

ans = M
for party in party_list:
    for p in party:
        if who_know_truth[p] == True:
            ans -= 1
            break
print(ans)