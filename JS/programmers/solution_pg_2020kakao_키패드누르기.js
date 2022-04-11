function solution(numbers, hand) {
  let map = new Map();
  for (let i = 0; i < 3; i++) {
    let num = i * 3;
    for (let j = 1; j <= 3; j++) map.set(num + j, [i, j - 1]);
  }
  map.set(0, [3, 1]);

  const isLeft = hand === 'left' ? true : false;
  let lr = 3,
    lc = 0,
    rr = 3,
    rc = 2,
    answer = '';
  for (let number of numbers) {
    const position = map.get(number);
    if (position[1] === 0) {
      answer += 'L';
      lr = position[0];
      lc = position[1];
    } else if (position[1] === 2) {
      answer += 'R';
      rr = position[0];
      rc = position[1];
    } else {
      const lDistance = Math.abs(lr - position[0]) + Math.abs(lc - position[1]);
      const rDistance = Math.abs(rr - position[0]) + Math.abs(rc - position[1]);
      if (lDistance < rDistance || (lDistance === rDistance && isLeft)) {
        answer += 'L';
        lr = position[0];
        lc = position[1];
      } else {
        answer += 'R';
        rr = position[0];
        rc = position[1];
      }
    }
  }

  return answer;
}

console.log(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], 'right'));
