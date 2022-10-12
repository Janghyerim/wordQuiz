package com.java;


import java.util.*;

public class WordQuiz {
	private String name;
	private ArrayList<Word> w;

	public WordQuiz(String name) {
		super();
		this.name = name;
		w = new ArrayList<Word>();  // 생성자를 통해 값을 초기화함

		w.add(new Word("love", "사랑"));
		w.add(new Word("animal", "동물"));
		w.add(new Word("emotion", "감정"));
		w.add(new Word("human", "인간"));
		w.add(new Word("stock", "주식"));
		w.add(new Word("trade", "거래"));
		w.add(new Word("society", "사회"));
		w.add(new Word("baby", "아기"));
		w.add(new Word("honey", "꿀"));
		w.add(new Word("doll", "인형"));
		w.add(new Word("bear", "곰"));
		w.add(new Word("picture", "사진"));
		w.add(new Word("painting", "그림"));
		w.add(new Word("fault", "오류"));
		w.add(new Word("example", "예시"));
		w.add(new Word("eye", "눈"));
		w.add(new Word("statue", "조각상"));
	}
	                              // 보기 //정답
	private int makeExample(int ex[], int answerIndex) { // 보기 구성하기
		int n[] = { -1, -1, -1, -1 }; // 보기를 출력하기 위한 index번호로 활용
		int index;
		for (int i = 0; i < n.length; i++) {
			do {
				index = (int) (Math.random() * w.size()); // 0 ~ 16
			} while (index == answerIndex || exists(n, index)); // 정답과 같은 index번호 이거나 n배열이 이미 들어있는 값이면 사용불가 판정.

			n[i] = index;  // 중복된 값이 들어갈 수 없다.
		}
		for (int i = 0; i < n.length; i++) {
			ex[i] = n[i]; // 배열의 복사
		}
		return (int) (Math.random() * n.length);  // n의 크기가 4니까 n.length 사용 // 0 ~ 3 // ex배열의 정답이 들어갈 위치값
	}

	private boolean exists(int n[], int index) { // 보기 중복 되지 않도록 하기
		for (int i = 0; i < n.length; i++) {
			if (n[i] == index) {
				return true;// 값을 반환하고, 함수를 종료하는 목적을 가진다.
			}
		}
		return false;
	}

	public void run() { // 게임프로그램 실행하기
		System.out.println("[" + name + "]" + " 단어 테스트 게임 시작 | -1을 입력하면 게임 종료.");
		System.out.println("현재 " + w.size() + "개의 단어가 있습니다.");

		Scanner sc = new Scanner(System.in);

		while (true) {
			int answerIndex = (int) (Math.random() * w.size()); // 0 ~ 16
			String eng = w.get(answerIndex).getEnglish();

			int example[] = new int[4];

			int answerLoc = makeExample(example, answerIndex);
			example[answerLoc] = answerIndex;  //answerLoc-> 0 ~ 3 정답이 들어있음.

			System.out.println(eng + "?");

			for (int i = 0; i < example.length; i++) { // 보기 출력
				System.out.print("(" + (i + 1) + ")" + w.get(example[i]).getKorean());
			}

			System.out.print(":>");

			try {
				int in = sc.nextInt();
				if (in == -1) {
					break;
				}
				in--;
				if (in == answerLoc) {
					System.out.println("정답입니다. !!");
				} else {
					System.out.println("분발하세요. !!");
				}
			} catch (InputMismatchException e) {
				sc.next(); // 버퍼를 비워주는 역할
				System.out.println("숫자를 입력하세요!!");
			}
		}

		System.out.println("[" + name + "]" + "를 종료합니다.");

	}
}