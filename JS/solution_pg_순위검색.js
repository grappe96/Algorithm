const map = new Map();
function solution(info, query) {
  for (let i of info) {
    const arr = i.split(' ');
    let type = new Array(4);
    for (let j = 0; j < 4; j++) type[j] = arr[j].charAt(0);
    const score = parseInt(arr[4]);

    combination(0, '', type, score);
  }
  for (let [key, value] of map)
    value.sort(function (a, b) {
      return a - b;
    });

  let answer = [];
  for (let q of query) {
    const arr = q.split(' and ');
    let str = '';
    for (let i = 0; i < 4; i++) str += arr[i].charAt(0);
    const score = parseInt(arr[3].split(' ')[1]);

    if (map.has(str)) answer.push(binarySearch(score, map.get(str)));
    else answer.push(0);
  }
  return answer;
}
function combination(count, str, type, score) {
  if (count === 4) {
    if (map.has(str)) {
      let arr = map.get(str);
      arr.push(score);
      map.set(str, arr);
    } else map.set(str, [score]);
    return;
  }
  combination(count + 1, str + type[count], type, score);
  combination(count + 1, str + '-', type, score);
}
function binarySearch(score, arr) {
  let start = 0,
    len = arr.length,
    end = len;
  while (start < end) {
    const mid = parseInt((start + end) / 2);

    if (arr[mid] >= score) end = mid;
    else start = mid + 1;
  }
  return len - start;
}
