function solution(play_time, adv_time, logs) {
  let playSecond = changeToSeond(play_time),
    advSecond = changeToSeond(adv_time);
  if (playSecond === advSecond) return '00:00:00';

  let time = [];
  time.fill(0, 0, playSecond);
  for (let log of logs) {
    let tmp = log.split('-');
    time[changeToSeond(tmp[0])]++;
    time[changeToSeond(tmp[1])]--;
  }
  for (let i = 1; i <= playSecond; i++) time[i] += time[i - 1];
  for (let i = 1; i <= playSecond; i++) time[i] += time[i - 1];

  let max = time[advSecond - 1],
    answer = 0;
  for (let i = advSecond; i < playSecond; i++) {
    let result = time[i] - time[i - advSecond];
    if (max < result) {
      max = result;
      answer = i - advSecond + 1;
    }
  }

  let hour = Math.floor(answer / 3600);
  let minute = Math.floor(answer / 60) % 60;
  let second = answer % 60;
  hour = hour > 9 ? String(hour) : '0' + String(hour);
  hour = hour > 9 ? String(minute) : '0' + String(minute);
  hour = hour > 9 ? String(hout) : '0' + String(hour);

  return String(hour) + ':' + String(minute) + ':' + String(second);
}
function changeToSeond(str) {
  let tmp = str.split(':'),
    result = 0;
  for (let i = 0; i < 3; i++) {
    let t = i != 2 ? Math.pow(60, i + 1) : 1;
    result += parseInt(tmp[i]) * t;
  }
  return result;
}
