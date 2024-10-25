package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

// 공통관심사항(부가적인 기능)
// 이 클래스는 AOP에서 사용되는 공통 관심 사항(부가적인 기능)을 정의합니다. 주로 로깅과 같은 부가 기능을 처리합니다.
public class LoggingAdvice {
    
    // 메서드가 실행되기 전에 실행되는 부가 기능을 담당하는 메서드
    // AOP에서 'before' advice로 사용되며, 주로 메서드 실행 전 로그를 출력하거나 사전 검증을 할 때 사용
    public void beforeTrace() {
        System.out.println("before trace"); // 메서드 실행 전에 "before trace"라는 메시지를 출력
        // 이 메서드는 AOP의 Before Advice로 설정되어, 타겟 메서드가 실행되기 전에 자동으로 실행됩니다.
    }
    
    // 메서드가 실행된 후에 실행되는 부가 기능을 담당하는 메서드
    // AOP에서 'after' advice로 사용되며, 주로 메서드 실행 후 로그를 출력하거나 후처리를 할 때 사용
    public void afterTrace() {
        System.out.println("after trace"); // 메서드 실행 후에 "after trace"라는 메시지를 출력
        // 이 메서드는 AOP의 After Advice로 설정되어, 타겟 메서드가 실행된 후 자동으로 실행됩니다.
    }
    
    // 'trace' 메서드는 Around Advice를 구현한 메서드입니다.
    // ProceedingJoinPoint는 Around Advice에서 사용되는 매개변수로, 타겟 메서드에 접근할 수 있도록 해줍니다.
    public void trace(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1. 출력
        // 타겟 메서드 실행 전 수행되는 부가적인 작업으로, 여기서는 입실 로그를 출력합니다.
        //System.out.println("입실");
        // 2. 핵심코드(Around)
        // 핵심코드를 수행하는 메서드를 호출하는 부분입니다. 타겟 메서드가 실제로 실행되는 지점입니다.
        // joinPoint.proceed()를 호출하면 타겟 메서드가 실행됩니다.
        //joinPoint.proceed();
        // 3. 출력
        // 타겟 메서드 실행 후 수행되는 부가적인 작업으로, 여기서는 퇴실 로그를 출력합니다.
        //System.out.println("퇴실");
    	
    	// joinPoint로부터 메서드의 시그니처(메서드 이름 및 파라미터)를 가져옵니다.
    	// toShortString() 메서드는 해당 시그니처를 짧은 형태로 반환하며, 메서드 이름과 간단한 정보만을 제공합니다.
    	String methodName = joinPoint.getSignature().toShortString(); 
    	// 해당 메서드 이름을 출력합니다.
    	// 이를 통해 어떤 메서드가 실행되고 있는지 로그로 확인할 수 있습니다.
    	System.out.println("메소드 이름 = " + methodName);
    	// StopWatch 객체를 생성하여 메서드 실행 시간을 측정할 준비를 합니다.
    	// StopWatch는 코드의 실행 시간을 측정할 수 있는 유틸리티 클래스입니다.
    	StopWatch stopWatch = new StopWatch();
    	// 스톱워치를 시작합니다. 이 시점부터 시간 측정이 시작됩니다.
    	stopWatch.start();
    	// 핵심 비즈니스 로직(타겟 메서드)을 실행하는 부분입니다.
    	// joinPoint.proceed()를 호출함으로써 타겟 메서드가 실제로 실행됩니다.
    	// 이 호출은 Around Advice에서 매우 중요한 역할을 하며, 이 지점에서 타겟 메서드의 실행이 이루어집니다.
    	Object ob = joinPoint.proceed();
    	System.out.println("반환값 = " + ob);
    	// 타겟 메서드 실행이 끝난 후, 스톱워치를 멈춥니다.
    	// 이 시점까지의 경과 시간이 StopWatch에 저장됩니다.
    	stopWatch.stop();
    	// 처리 시간을 출력합니다. getTotalTimeMillis() 메서드를 사용하여 경과 시간을 밀리초 단위로 반환받습니다.
    	// 1000으로 나누어 초 단위로 변환한 후, 그 결과를 출력합니다.
    	System.out.println("처리시간 = " + stopWatch.getTotalTimeMillis()/1000 + " 초 경과 ");

    }
    
}
