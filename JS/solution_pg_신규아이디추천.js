function solution(new_id) {
  let answer = new_id.toLowerCase();
  answer = answer.replace(/[^a-z0-9-_.]/g, '');
  answer = answer.replace(/\.{2,}/g, '.');
  answer = answer.replace(/^\./, '');
  answer = answer.replace(/\.$/, '');
  if (answer === '') answer = 'a';
  if (answer.length > 15) answer = answer.substring(0, 15);
  answer = answer.replace(/\.$/, '');
  let a = answer.substring(answer.length - 1);
  while (answer.length < 3) answer += a;
  return answer;
}
