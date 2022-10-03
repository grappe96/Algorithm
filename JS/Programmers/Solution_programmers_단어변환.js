function solution(begin, target, words) {
  let queue = [],
    answer = 0,
    result = begin;
  function Process(word, arr, level) {
    this.word = word;
    this.arr = arr;
    this.level = level;
  }

  queue.push(new Process(begin, words.slice(), 0));
  while (queue.length > 0) {
    let now = queue.shift(),
      idx = 0;
    for (let e of now.arr) {
      let check = 0;
      for (let i = 0; i < begin.length; i++)
        if (now.word.charAt(i) != e.charAt(i)) check++;
      if (check == 1) {
        if (e === target) {
          result = e;
          answer = now.level + 1;
          queue = [];
          break;
        }
        queue.push(
          new Process(
            e,
            now.arr.slice(0, idx).concat(now.arr.slice(idx + 1)),
            now.level + 1
          )
        );
      }
      idx++;
    }
  }

  return result !== target ? 0 : answer;
}
