n = int(input())

arr = [0 for _ in range(1001)]

arr[0] = 1
arr[1] = 3

for x in range(2, 1001):
    arr[x] = 2 * arr[x - 2] + arr[x-1]

print(arr[n-1]%10007)