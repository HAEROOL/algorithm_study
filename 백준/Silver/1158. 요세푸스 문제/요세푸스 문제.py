N, K = map(int, input().split())

arr = [x for x in range(1, N+1)]
answer = []
pointer = K -1
for x in range(0, N):
    answer.append(arr.pop(pointer))
    if len(arr) == 1:
        answer.append(arr.pop())
        break
    pointer += K - 1
    if pointer >= len(arr) and pointer > 0:
        pointer = pointer % len(arr)
print('<', end='')
print(*answer, sep=', ', end='')
print('>')