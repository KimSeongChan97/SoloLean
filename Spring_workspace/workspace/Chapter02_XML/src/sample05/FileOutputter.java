package sample05;

import java.io.FileWriter;
import java.io.IOException;

// 결과를 파일로 출력하는 클래스
// 이 클래스는 Outputter 인터페이스를 구현하여, 메시지를 파일로 출력하는 역할을 합니다.
public class FileOutputter implements Outputter {

    // 파일 경로와 파일 이름을 저장할 변수들입니다.
    private String filePath; // 파일이 저장될 경로를 저장하는 변수입니다. 예를 들어 "C:/output/" 같은 경로를 설정할 수 있습니다.
    private String fileName; // 저장할 파일의 이름을 저장하는 변수입니다. 예를 들어 "output.txt" 같은 파일명을 설정할 수 있습니다.

    // setFilePath 메서드는 파일이 저장될 경로를 외부에서 설정할 수 있도록 해줍니다.
    public void setFilePath(String filePath) {
        this.filePath = filePath; // 입력받은 파일 경로를 filePath 필드에 저장합니다.
        System.out.println("setFilePath(String filePath)"); // 파일 경로가 설정되었음을 알리는 출력문입니다.
    }

    // setFileName 메서드는 파일의 이름을 외부에서 설정할 수 있도록 해줍니다.
    public void setFileName(String fileName) {
        this.fileName = fileName; // 입력받은 파일 이름을 fileName 필드에 저장합니다.
        System.out.println("setFileName(String fileName)"); // 파일 이름이 설정되었음을 알리는 출력문입니다.
    }

    // Outputter 인터페이스의 output 메서드를 구현한 메서드로, 전달받은 메시지를 파일에 출력합니다.
    @Override
    public void output(String message) {
        System.out.println("output(String Message)"); // 메서드 호출을 확인하기 위한 출력문입니다.

        try {
            // FileWriter 객체를 생성하여 파일을 엽니다. filePath와 fileName을 합쳐서 파일 경로와 파일 이름을 지정합니다.
            // 이때, 파일 경로와 파일 이름을 결합하여 출력 파일을 생성합니다.
            FileWriter fileWriter = new FileWriter(filePath + fileName); // 파일 객체 생성
            // FileWriter는 지정된 파일에 문자열을 작성할 수 있는 객체입니다.
            // filePath + fileName으로 지정된 경로에 파일이 생성되며, 해당 파일에 내용을 쓸 수 있게 됩니다.

            // 전달받은 message 내용을 파일에 작성합니다.
            fileWriter.write(message); // message 내용(메서드로 전달된 문자열)을 파일에 씁니다.
            // 이 메서드는 파일에 실제로 내용을 기록하는 작업을 수행합니다. 예를 들어, "나의 이름은 홍길동이고, 전화번호는 123-456-7890이다."라는 메시지가 파일에 기록됩니다.

            // 파일 작업이 완료되면 파일을 닫습니다.
            fileWriter.close(); // 파일 쓰기가 완료되면 반드시 파일을 닫아야 합니다.
            // 파일을 닫지 않으면 데이터가 완전히 쓰이지 않거나, 다른 프로그램에서 파일에 접근할 수 없는 문제가 발생할 수 있습니다.

        } catch (IOException e) {
            // 파일 쓰기 작업 중 예외가 발생하면 예외 메시지를 출력합니다.
            e.printStackTrace(); // IOException 발생 시, 에러 메시지와 함께 오류의 원인을 출력합니다.
            // 파일 경로가 잘못되었거나, 파일에 쓰는 중에 문제가 발생하면 이 부분에서 예외 처리를 통해 문제를 확인할 수 있습니다.
        }
    }
}
