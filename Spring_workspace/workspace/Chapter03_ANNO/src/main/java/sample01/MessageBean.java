package sample01;

// MessageBean 인터페이스는 메서드들이 포함된 인터페이스로, 각 메서드는 다양한 시점(before/after)에 실행되는 것을 나타냅니다.
public interface MessageBean {
    
    // showPrintBefore 메서드는 메서드 실행 전(before) 시점에서 공통 관심 사항을 처리할 때 호출됩니다.
    // AOP의 before advice와 연동되어, 메서드 실행 전에 특정 작업(예: 로그 출력)을 할 수 있습니다.
    public void showPrintBefore();
    
    // viewPrintBefore 메서드는 showPrintBefore와 비슷하게 실행 전(before) 시점에서 호출되는 메서드입니다.
    // AOP의 before advice와 연동되어 메서드 실행 전 특정 작업을 할 수 있습니다.
    public void viewPrintBefore();
    
    // showPrintAfter 메서드는 메서드 실행 후(after) 시점에서 공통 관심 사항을 처리할 때 호출됩니다.
    // AOP의 after advice와 연동되어, 메서드 실행 후 특정 작업(예: 후처리나 로그 출력)을 할 수 있습니다.
    public void showPrintAfter();
    
    // viewPrintAfter 메서드는 showPrintAfter와 비슷하게 실행 후(after) 시점에서 호출되는 메서드입니다.
    // AOP의 after advice와 연동되어, 메서드 실행 후 특정 작업을 할 수 있습니다.
    public void viewPrintAfter();
    
    public String showPrint();
    public void viewPrint();
    
    // display 메서드는 before/after와 관계없이 일반적인 실행 흐름에서 호출되는 메서드입니다.
    // 이 메서드에서는 특정 AOP advice와 연동되지 않으며, 단순히 비즈니스 로직을 수행합니다.
    public void display();
}
