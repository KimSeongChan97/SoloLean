package homework_class;
// 1인분
public class MemberDTO {
	private String name;    // 회원 이름을 저장하는 필드
    private int age;        // 회원 나이를 저장하는 필드
    private String phone;   // 회원 핸드폰 번호를 저장하는 필드
    private String address; // 회원 주소를 저장하는 필드
    // 생성자를 통해 받거나, setter 와 getter 를 통해 보낸다.
    
    
    // 생성자로 추가한다면?
    public MemberDTO () {}
    
    public MemberDTO(String name, int age, String phone, String address) {
    this.name = name;
    this.age = age;
    this.phone = phone;
    this.address = address;
    }
    
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
