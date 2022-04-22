function solution(n, arr1, arr2) {
  let answer = [];
  for (let i = 0; i < n; i++) {
    let s1 = arr1[i].toString(2);
    let s2 = arr2[i].toString(2);
    const len1 = n - s1.length,
      len2 = n - s2.length;
    for (let j = 0; j < len1; j++) s1 = '0' + s1;
    for (let j = 0; j < len2; j++) s2 = '0' + s2;

    let tmp = '';
    for (let j = 0; j < n; j++)
      s1.charAt(j) === '1' || s2.charAt(j) === '1'
        ? (tmp += '#')
        : (tmp += ' ');
    answer.push(tmp);
  }
  return answer;
}
