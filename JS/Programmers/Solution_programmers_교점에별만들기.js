function solution(line) {
  let points = [],
    minX = Number.POSITIVE_INFINITY,
    minY = Number.POSITIVE_INFINITY,
    maxX = Number.NEGATIVE_INFINITY,
    maxY = Number.NEGATIVE_INFINITY,
    answer = [],
    len = line.length,
    str = '';

  for (let i = 0; i < len - 1; i++) {
    for (let j = i + 1; j < len; j++) {
      let denominator = line[i][0] * line[j][1] - line[i][1] * line[j][0];
      if (denominator == 0) continue;

      let numeratorX = line[i][1] * line[j][2] - line[j][1] * line[i][2],
        numeratorY = line[i][2] * line[j][0] - line[j][2] * line[i][0];

      if (numeratorX % denominator != 0 || numeratorY % denominator != 0)
        continue;

      points.push([numeratorX / denominator, numeratorY / denominator]);
      minX = Math.min(numeratorX / denominator, minX);
      minY = Math.min(numeratorY / denominator, minY);
      maxX = Math.max(numeratorX / denominator, maxX);
      maxY = Math.max(numeratorY / denominator, maxY);
    }
  }

  for (let i = minX; i <= maxX; i++) str += '.';
  for (let i = minY; i <= maxY; i++) answer.push(str);

  for (let point of points) {
    let x = point[0] - minX,
      y = maxY - point[1];
    answer[y] = answer[y].slice(0, x) + '*' + answer[y].slice(x + 1);
  }

  return answer;
}
