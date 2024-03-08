import sys

V = int(sys.stdin.readline().rstrip())

graph = [[] for _ in range(V + 1)]

for _ in range(V):
    data = list(map(int, sys.stdin.readline().split()))

    first_node = data[0]
    for idx in range(1, len(data)-1, 2):
        second_node, dist = data[idx], data[idx+1]
        graph[first_node].append([dist, second_node])


def DFS(start, distance, graph):
    for next_dist, next_node in graph[start]:
    	# 방문하지 않은 노드 탐색
        if distance[next_node] == -1:
            distance[next_node] = next_dist + distance[start]
            DFS(next_node, distance, graph)

distance = [-1] * (V + 1)
distance[1] = 0
# 임의의 노드 1번에서 가장 먼 노드 찾기
DFS(1, distance, graph)
furthest_node = distance.index(max(distance))

distance = [-1] * (V + 1)
distance[furthest_node] = 0
# 찾은 가장 먼 노드에서 다시 가장 먼 노드 찾기
DFS(furthest_node, distance, graph)
print(max(distance))