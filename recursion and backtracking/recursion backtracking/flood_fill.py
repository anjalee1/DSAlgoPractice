
def floodfill(maze, row, col, psf, visited):
    if row < 0 or col < 0 or row == len(maze) or col == len(maze[0]) or maze[row][col] == 1 or visited[row][col] == True:
        return
    if row == len(maze) - 1 and col == len(maze[0]) - 1:
        print(psf)
        return
    visited[row][col] = True
    floodfill(maze, row - 1, col, psf + "t", visited)
    floodfill(maze, row, col - 1, psf + "l", visited)
    floodfill(maze, row + 1, col, psf + "d", visited)
    floodfill(maze, row, col + 1, psf + "r", visited)
    visited[row][col] = False


def main():
  n, m = input().split()
  n = int(n)
  m = int(m)
  arr = []
  for i in range(n) :
    row = list(map(int, input().split()))
    arr.append(row)
    
    
  visited = []
  for i in range(n):
    b = []
    for  j in range(m):
        b.append(0)
    visited.append(b)
    
  floodfill(arr, 0, 0,"",visited);
main()
