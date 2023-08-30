total = 0
arr = []
for _ in range(9):
    n = int(input())
    arr.append(n)
    total += n

rest = total - 100

arr.sort()

index = []
for x in range(0, len(arr)):
    for y in range(x + 1, len(arr)):
        if arr[x] + arr[y] == rest:
            del arr[x]
            del arr[y - 1]
            break
    if len(arr) == 7:
        break

for x in arr:
    print(x)
