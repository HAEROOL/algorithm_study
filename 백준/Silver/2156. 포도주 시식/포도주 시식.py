n = int(input())
arr = [0]
dp = [0]
for _ in range(n):
    arr.append(int(input()))

for x in range(1, 3):
    dp.append(dp[x-1] + arr[x])
    if n == 1 : break

for x in range(3, n + 1):
    a = dp[x-2] + arr[x]
    b = dp[x-1]
    c = arr[x] + arr[x-1] + dp[x-3]
    dp.append(max(a,b,c))
print(max(dp))