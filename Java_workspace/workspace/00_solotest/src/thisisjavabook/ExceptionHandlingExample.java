package thisisjavabook;

public class ExceptionHandlingExample {
    
    public static void main(String[] args) {
        // 문자열 배열을 생성하고 초기화
        String[] array = {"100", "1oo", null, "200"};
        
        // 배열의 길이만큼 반복문 실행
        for(int i=0; i<array.length; i++) {
            try {
                // 배열의 각 요소를 정수로 변환
                int value = Integer.parseInt(array[i]);
            } catch(ArrayIndexOutOfBoundsException e) {
                // 배열 인덱스 초과 예외 처리
                System.out.println("배열 인덱스가 초과됨 : " + e.getMessage());
            } catch(NullPointerException | NumberFormatException e) {
                // NullPointerException 및 NumberFormatException 예외 처리
                // 두 예외를 동시에 처리
                System.out.println("데이터에 문제가 있음 : " + e.getMessage());
            }
        }
    }
}


/*
데이터에 문제가 있음 : For input string: "1oo"
데이터에 문제가 있음 : Cannot parse null string
*/