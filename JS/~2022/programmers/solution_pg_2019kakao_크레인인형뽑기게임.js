function solution(board, moves) {
  const N = board.length;
  let basket = [],
    answer = 0,
    topIdx = [],
    lastIdx = -1;

  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (board[j][i] > 0) {
        topIdx.push(j);
        break;
      }
    }
  }

  function fillBasket(dollNumber) {
    if (lastIdx === -1 || basket[lastIdx] !== dollNumber) {
      basket.push(dollNumber);
      lastIdx++;
    } else {
      basket.pop();
      lastIdx--;
      answer += 2;
    }
  }

  for (let move of moves) {
    if (topIdx[move - 1] === N) continue;
    fillBasket(board[topIdx[move - 1]][move - 1]);
    board[topIdx[move - 1]++][move - 1] = 0;
  }

  return answer;
}
