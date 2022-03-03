function solution(record) {
  let map = new Map();
  for (let rc of record) {
    let arr = rc.split(' ');
    if (arr[0] == 'Leave') continue;
    map.set(arr[1], arr[2]);
  }

  let answer = [];
  for (let rc of record) {
    let arr = rc.split(' ');
    if (arr[0] == 'Enter') answer.push(map.get(arr[1]) + '님이 들어왔습니다.');
    else if (arr[0] == 'Leave')
      answer.push(map.get(arr[1]) + '님이 나갔습니다.');
  }
  return answer;
}
