package guestbook.bean;

public class GuestbookDTO {
	private String name; // 작성자 이름
	private String email; // 작성자 이메일
	private String homepage; // 작성자의 홈페이지 url
	private String subject; // 방명록의 제목
	private String content; // 방명록의 내용
	
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomepage() {
        return homepage;
    }
    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
	
}
