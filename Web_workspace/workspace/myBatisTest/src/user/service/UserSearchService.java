package user.service;

import java.util.Scanner;

import user.dao.UserDAO;

public class UserSearchService implements UserService {

    @Override
    public void execute() {
    	System.out.println();
    	
    	Scanner scan = new Scanner(System.in);
    	
    	//DB
    	UserDAO userDAO = UserDAO.getInstance(); 
    	
    	
    	
        
    }
}
