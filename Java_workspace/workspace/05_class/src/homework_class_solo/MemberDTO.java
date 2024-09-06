package homework_class_solo;

public class MemberDTO {
    private String name;    // 회원 이름을 저장하는 필드
    private int age;        // 회원 나이를 저장하는 필드
    private String phone;   // 회원 핸드폰 번호를 저장하는 필드
    private String address; // 회원 주소를 저장하는 필드
    
    // 각 필드의 getter와 setter 메서드
    
    // 이름(name) 필드의 setter 메서드
    public void setName(String name) {
        this.name = name;
    }
    
    // 나이(age) 필드의 setter 메서드
    public void setAge(int age) {
        this.age = age;
    }
    
    // 핸드폰 번호(phone) 필드의 setter 메서드
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    // 주소(address) 필드의 setter 메서드
    public void setAddress(String address) {
        this.address = address;
    }
    
    // 이름(name) 필드의 getter 메서드
    public String getName() {
        return name;
    }
    
    // 나이(age) 필드의 getter 메서드
    public int getAge() {
        return age;
    }
    
    // 핸드폰 번호(phone) 필드의 getter 메서드
    public String getPhone() {
        return phone;
    }
    
    // 주소(address) 필드의 getter 메서드
    public String getAddress() {
        return address;
    }
}
