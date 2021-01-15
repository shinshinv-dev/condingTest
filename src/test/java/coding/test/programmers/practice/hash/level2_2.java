package coding.test.programmers.practice.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class level2_2 {
    /* 위장 */
	/*
	스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.

	예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면
	다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.

	종류	이름
	얼굴	동그란 안경, 검정 선글라스
	상의	파란색 티셔츠
	하의	청바지
	겉옷	긴 코트

	스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때
	서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
	*/

	/* 추가 정보
	경우의 수를 구하는 공식은 4종류의 옷과 그 옷이 {n, m, o, p}의 개수로 있을 때 아래와 같다.
	(n + 1) * (m + 1) * (o + 1) * (p + 1) - 1
	 */

	@Test
	public void test() throws Exception {
		String c[][] = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(c));
		System.out.println(solution2(c));
		System.out.println(solution3(c));

	}

	public int solution(String[][] clothes) {
		int answer = 1; //곱셈을 위해 1로 선언
		HashMap<String, Integer> clothesMap = new HashMap<String, Integer>();
		//map 구하기
		for(int i =0; i<clothes.length; i++){
			//의상종류, 갯수
			clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0)+1);
		}
		Set<String> keySet = clothesMap.keySet(); //의상종류.
		for(String key : keySet) {
			answer *= clothesMap.get(key)+1;
		}
		return answer-1; //아무것도 안입는 경우의 수 제거
	}
	public int solution2(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<clothes.length; i++){
			String key = clothes[i][1];
			if(!map.containsKey(key)) {
				map.put(key, 1);
			} else {
				map.put(key, map.get(key) + 1);
			}
		}
		Iterator<Integer> it = map.values().iterator();
		while(it.hasNext()) {
			answer *= it.next().intValue()+1;
		}
		return answer-1;
	}

	public int solution3(String[][] clothes) {
		HashMap<String, Integer> hm = new HashMap();
		int answer = 1;

		for (int i = 0; i < clothes.length; i++) { // 아무것도 안입은 상태도 개수로 친다.
			hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 1) + 1);
		}

		for (int i : hm.values()) {
			answer *= i;
		}
		//옷을 하나도 입지 않은 상태를 빼준다.
		return answer-1;
	}

}
