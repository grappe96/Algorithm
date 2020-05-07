package Programmers;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
코딩테스트 연습> 해시> 베스트앨범

문제 설명

스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 
노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

제한사항

genres[i]는 고유번호가 i인 노래의 장르입니다.
plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
장르 종류는 100개 미만입니다.
장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
모든 장르는 재생된 횟수가 다릅니다.
*/
public class BestAlbum {
    public static int[] solution(String[] genres, int[] plays) {
        HashMap<Entry<String, Integer>, Integer> songs = new HashMap<>();
        HashMap<String, Integer> genre = new HashMap<>();
        for(int i=0;i<plays.length;i++){
            songs.put(new AbstractMap.SimpleEntry<String, Integer>(genres[i], i), plays[i]);
            if (genre.containsKey(genres[i]))
                genre.put(genres[i], genre.get(genres[i]) + plays[i]);
            else
                genre.put(genres[i], plays[i]);
        }
        List<Entry<Entry<String, Integer>, Integer>> songList = new ArrayList<Entry<Entry<String, Integer>, Integer>>(songs.entrySet());
        Collections.sort(songList, new Comparator<Entry<Entry<String, Integer>, Integer>>() {
            public int compare(Entry<Entry<String, Integer>, Integer> o1, Entry<Entry<String, Integer>, Integer> o2) {
                return o1.getKey().getValue().compareTo(o2.getKey().getValue());
            }
        });
        Collections.sort(songList, new Comparator<Entry<Entry<String, Integer>, Integer>>() {
            public int compare(Entry<Entry<String, Integer>, Integer> o1, Entry<Entry<String, Integer>, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        List<Entry<String, Integer>> genreList = new ArrayList<Entry<String, Integer>>(genre.entrySet());
        Collections.sort(genreList, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        ArrayList<Integer> ans = new ArrayList<>();
        for (Entry<String, Integer> e : genreList) {
            int count = 0;
            for (Entry<Entry<String, Integer>, Integer> ee : songList) {
                if (e.getKey().equals(ee.getKey().getKey())) {
                    ans.add(ee.getKey().getValue());
                    count++;
                    if(count == 2)
                        break;
                }
            }
        }
        int[] answer = new int[ans.size()];
        for (int i=0;i<ans.size();i++)
            answer[i] = ans.get(i);
        return answer;
    }

    public static void main(String args[]) {
        String[] genres = { "classic", "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 800, 600, 150, 800, 2500 };
        int[] ans = solution(genres, plays);
        System.out.println(ans.length);
        for(int i : ans)
            System.out.print(i + " ");
        System.out.println();
    }
}