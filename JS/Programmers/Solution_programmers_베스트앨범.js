function solution(genres, plays) {
  let totalMap = new Map(),
    genreListMap = new Map(),
    answer = [],
    totalArray = [];
  for (let idx in genres) {
    totalMap.has(genres[idx])
      ? totalMap.set(
          genres[idx],
          totalMap.get(genres[idx]) + Number(plays[idx])
        )
      : totalMap.set(genres[idx], Number(plays[idx]));
    genreListMap.has(genres[idx])
      ? genreListMap.get(genres[idx]).push([Number(idx), Number(plays[idx])])
      : genreListMap.set(genres[idx], [[Number(idx), Number(plays[idx])]]);
  }

  totalArray = [...totalMap];
  totalArray.sort((a, b) => {
    return b[1] - a[1];
  });

  for (let [genre, total] of totalArray) {
    genreListMap.get(genre).sort((a, b) => {
      if (a[1] == b[1]) return a[0] - b[0];
      return b[1] - a[1];
    });

    answer.push(genreListMap.get(genre)[0][0]);
    if (genreListMap.get(genre).length > 1)
      answer.push(genreListMap.get(genre)[1][0]);
  }
  return answer;
}
