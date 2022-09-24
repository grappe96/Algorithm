function solution(grid) {
  let R = grid.length,
    C = grid[0].length,
    map = new Array(R),
    result = [],
    dr = [-1, 0, 1, 0],
    dc = [0, 1, 0, -1],
    cycleLen = 0,
    checkRangeR = (idx) => {
      if (idx < 0) return R - 1;
      if (idx >= R) return 0;
      return idx;
    },
    checkRangeC = (idx) => {
      if (idx < 0) return C - 1;
      if (idx >= C) return 0;
      return idx;
    },
    findNextDirection = (ch, d) => {
      if (ch == 'L') return d - 1 < 0 ? 3 : d - 1;
      if (ch == 'R') return d + 1 >= 4 ? 0 : d + 1;
      return d;
    };

  for (let i = 0; i < R; i++) {
    map[i] = new Array(C);
    for (let j = 0; j < C; j++) map[i][j] = [false, false, false, false];
  }

  for (let i = 0; i < R; i++) {
    for (let j = 0; j < C; j++) {
      for (let d = 0; d < 4; d++) {
        if (!map[i][j][d]) {
          let x = i,
            y = j,
            dir = d;
          map[x][y][dir] = true;
          cycleLen = 1;
          while (true) {
            let nx = checkRangeR(x + dr[dir]);
            let ny = checkRangeC(y + dc[dir]);
            let nd = findNextDirection(grid[nx].charAt(ny), dir);

            if (map[nx][ny][nd]) {
              result.push(cycleLen);
              break;
            }

            map[nx][ny][nd] = true;
            cycleLen++;
            dir = nd;
            x = nx;
            y = ny;
          }
        }
      }
    }
  }

  return result.sort((a, b) => {
    return a - b;
  });
}
