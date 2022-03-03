function solution(brown, yellow) {
  let answer = [3, 3];
  for (let length = 1; length <= yellow / 2; length++) {
    if (yellow % length != 0) continue;
    let width = yellow / length;
    if (getBorder(width, length) == brown) {
      answer = [width + 2, length + 2];
      break;
    }
  }
  return answer;
}

function getBorder(width, length) {
  return (width + length) * 2 + 4;
}
