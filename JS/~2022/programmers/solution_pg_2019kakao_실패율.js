function solution(N, stages) {
  let stageInfo = [];
  for (let i = 0; i < N; i++)
    stageInfo.push({ stage: i + 1, clear: 0, notYet: 0 });

  for (let stage of stages) {
    if (stage > 1) stageInfo[0].clear++;
    for (let i = 1; i < stage - 1; i++) stageInfo[i].clear++;
    if (stage <= N) stageInfo[stage - 1].notYet++;
  }

  for (let i = 0; i < N; i++) {
    if (stageInfo[i].clear > 0 || stageInfo[i].notYet > 0)
      stageInfo[i].failure = stageInfo[i].notYet / stageInfo[i].clear;
    else stageInfo[i].failure = 0;
  }

  stageInfo.sort((a, b) => {
    if (b.failure === a.failure) return a.stage - b.stage;
    else return b.failure - a.failure;
  });
  let answer = [];
  for (let i = 0; i < N; i++) answer.push(stageInfo[i].stage);

  return answer;
}
