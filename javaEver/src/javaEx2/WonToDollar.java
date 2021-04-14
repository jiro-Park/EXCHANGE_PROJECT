package javaEx2;

import java.io.IOException;
import java.util.Scanner;

public class WonToDollar {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int inputWon =0;
		int inputChangeType =0;
		InputClass inputClass = new InputClass();
		FileWriteClass fwc = new FileWriteClass();
		RunExchangeClass runClass = new RunExchangeClass();
		
		fwc.saveToFileTitle();                                        // 파일에 첫줄(카테고리) 기록
		do {
			inputWon = inputClass.inputFromConsoleWon();     // 사용자가 입력한 값으로 환전할 금액 지정
			inputChangeType = inputClass.inputFromConsoleType();      // 외화 타입도 마찬가지로 지정
			fwc.saveToFileDate();                                         // 파일에 현재 날짜 기록
			fwc.saveToFileTime();                                         // 파일에 현재 시간 기록
			fwc.saveToFileWon(inputWon);                                 // 파일에 환전할 금액 기록
			fwc.saveToFileType(inputChangeType);                      // 파일에 환전할 외화타입 기록
					
			switch (inputChangeType) {                            // 선택한 외화타입에 따라 결과 출력
			case ConstValueClass.CHANGE_TYPE_USD:
				runClass.changeToUSD(inputWon);
				break;
				
			case ConstValueClass.CHANGE_TYPE_EUR:
				runClass.changeToEUR(inputWon);
				break;
				
			case ConstValueClass.CHANGE_TYPE_JPY:
				runClass.changeToJPY(inputWon);
				break;
			case 0 : fwc.saveToFileDefault();	                   // 0 입력시 파일에 환전취소 기록
			}
		} while (inputChangeType != 0);                               // 0 입력되었을 시 반복문 종료
	}
}
