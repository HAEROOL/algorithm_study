from collections import deque
def solution(arr):
    answer = []
    d = deque(arr)
    answer.append(d.popleft())
    while len(d) != 0:
        e = d.popleft()
        if answer[-1] != e:
            answer.append(e)
    return answer