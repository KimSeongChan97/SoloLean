package member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "membertbl")
public class MemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;

	@Column(name="id", nullable = false, unique = true, length = 30)
	private String id;

	@Column(name = "pwd", nullable = false, length = 300)
	private String pwd;

	@Column(name = "name", nullable = false, length = 30)
	private String name;


}
