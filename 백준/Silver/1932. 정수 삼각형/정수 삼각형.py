n=int(input())
d=[]
for i in range(n):
  d.append(list(map(int, input().split())))

for x in range(1, n):
  for y in range(0, len(d[x])):
    if y == 0:
      d[x][y] = d[x][y] + d[x - 1][y]
    elif y == len(d[x]) - 1:
      d[x][y] = d[x][y] + d[x - 1][y - 1]
    else:
      d[x][y] = max(d[x - 1][y], d[x - 1][y - 1]) + d[x][y]
print(max(d[n-1]))