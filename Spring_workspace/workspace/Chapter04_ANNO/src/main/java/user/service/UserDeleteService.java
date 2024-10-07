package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserDeleteService implements UserService {

	@Autowired 
    private UserDAO userDAO;

    @Override
    public void execute() {
        System.out.println();
        Scanner scan = new Scanner(System.in);
        
        System.out.print("삭제 할 아이디 입력 : ");
        String id = scan.next();

        UserDTO userDTO = userDAO.getExistId(id);
        
        if(userDTO == null) {
            System.out.println("찾고자 하는 아이디가 없습니다.");
            return;
        }
        
        System.out.println();
        userDAO.delete(id);
        System.out.println(id + "님의 데이터를 삭제하였습니다.");
    }
}
