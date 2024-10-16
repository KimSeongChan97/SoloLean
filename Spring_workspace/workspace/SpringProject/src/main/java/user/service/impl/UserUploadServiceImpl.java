package user.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import user.bean.UserUploadDTO;
import user.dao.UserUploadDAO;
import user.service.ObjectStorageService;
import user.service.UserUploadService;

@Service
public class UserUploadServiceImpl implements UserUploadService {
    
    @Autowired
    private UserUploadDAO userUploadDAO; 
    // `userUploadDAO`는 데이터베이스와 상호작용하는 객체입니다.
    // `DAO`는 Data Access Object의 약자로, 데이터베이스 작업을 처리하는 계층을 의미합니다.
    // 데이터베이스에 대한 CRUD(Create, Read, Update, Delete) 작업을 처리하는 역할입니다.
    
    @Autowired
    private HttpSession session; 
    // `HttpSession`은 현재 사용자의 세션에 대한 정보를 저장하고 관리하는 객체입니다.
    // 여기서는 업로드 파일의 경로를 설정할 때 사용됩니다.
    // 세션은 서버와 클라이언트 간에 상태를 유지하기 위해 사용됩니다. 사용자별로 고유한 세션이 있으며, 로그인 상태 정보나 특정 요청과 관련된 정보를 세션에 저장할 수 있습니다.
    
    @Autowired
    private ObjectStorageService objectStorageService; 
    // `ObjectStorageService`는 클라우드 상의 객체 스토리지(NCP)를 다루는 서비스입니다.
    // 파일을 S3에 업로드하거나 삭제하는 작업을 담당합니다.
    // 객체 스토리지는 대규모 데이터를 저장하고 관리하는 데 사용되며, 주로 이미지, 동영상, 문서 같은 비정형 데이터를 저장하는 데 적합합니다.
    
    private String bucketName = "bitcamp-9th-bucket-65"; 
    // NCP에서 사용하는 S3 버킷 이름을 지정합니다. 
    // 버킷은 파일을 저장하는 공간이며, 여기서는 "bitcamp-9th-bucket-65"라는 이름의 버킷을 사용합니다.
    // 버킷은 일종의 디렉토리 개념으로, 클라우드 스토리지에서 데이터를 관리할 때 사용하는 논리적 단위입니다.

    @Override
    public void upload(List<UserUploadDTO> imageUploadList) {
        // `upload` 메서드는 데이터베이스에 파일 업로드 정보를 저장합니다.
        userUploadDAO.upload(imageUploadList); 
        // DAO를 통해 업로드된 파일 리스트를 저장합니다.
        // `imageUploadList`는 업로드된 파일에 대한 정보를 담고 있는 리스트입니다. 
        // 데이터베이스에 이 리스트를 저장하는 이유는, 나중에 사용자가 업로드한 파일을 조회하거나 관리할 수 있도록 하기 위함입니다.
    }
    
    @Override
    public List<UserUploadDTO> uploadList() {
        // `uploadList` 메서드는 업로드된 파일 목록을 조회하는 메서드입니다.
        // 데이터베이스에서 모든 업로드된 파일의 목록을 가져옵니다.
        return userUploadDAO.uploadList();
        // 이 메서드는 사용자가 업로드한 파일의 목록을 데이터베이스에서 조회하여 반환합니다.
        // 반환되는 데이터는 List 형태로, 여러 개의 업로드 정보를 담을 수 있습니다.
    }
    
    @Override
    public UserUploadDTO getuploadDTO(String seq) {
        // `getuploadDTO`는 특정 파일(이미지)의 정보를 가져오는 메서드입니다.
        // `seq`는 파일의 고유 식별자(시퀀스)이며, 이를 기반으로 데이터베이스에서 파일 정보를 조회합니다.
        return userUploadDAO.getuploadDTO(seq);
        // 데이터베이스에서 특정 시퀀스(`seq`)에 해당하는 파일 정보를 가져옵니다.
        // 이 정보는 `UserUploadDTO` 객체에 담겨 반환됩니다.
        // DTO는 Data Transfer Object의 약자로, 데이터를 전달하는 데 사용되는 객체입니다.
    }
    
    @Override
    public void uploadUpdate(UserUploadDTO userUploadDTO, MultipartFile img) {
        
        // 실제 폴더
        // 서버의 실제 파일 저장 경로를 구합니다. 이 경로는 WAR 파일 내부의 `WEB-INF/storage` 디렉토리를 의미합니다.
        String filePath = session.getServletContext().getRealPath("WEB-INF/storage");  
        System.out.println("실제 폴더 = " + filePath); 
        // `session.getServletContext().getRealPath`는 서버 상의 실제 물리적 경로를 가져오는 메서드입니다.
        // 이 메서드를 사용하면 웹 애플리케이션 내부에서 파일을 저장하거나 읽을 때 사용할 수 있는 경로를 얻을 수 있습니다.
        
        System.out.println("img = " + img);
        
        UserUploadDTO dto = userUploadDAO.getuploadDTO(userUploadDTO.getSeq()+"");
        // DB 에 있는 것을 다 가져오라는 의미
        // `userUploadDTO.getSeq()`는 현재 수정하려는 이미지의 고유한 시퀀스 번호를 가져옵니다.
        // 이를 통해 기존에 데이터베이스에 저장된 이미지 정보를 가져오고, 이후 비교하거나 수정할 때 사용합니다.
        
        String imageFileName;
        
        	if(img.getSize() != 0) {
        // Object Storage (NCP) 는 이미지를 덮어쓰지 않는다.
        // NCP의 Object Storage는 파일을 덮어쓰는 방식이 아닌, 고유한 파일 이름을 생성하여 처리합니다.
        // 기존 이미지를 삭제하고 나서 새로운 이미지를 넣어야 한다.
        // 먼저 기존 이미지를 삭제한 후, 새로운 이미지를 업로드하는 절차를 따릅니다.
        // 이 방식은 클라우드 스토리지에서 데이터 일관성을 유지하는 데 도움을 줍니다.
        		
        // DB 에서 seq 에 해당하는 imageFileName 을 꺼내와서 현재 DB에 저장된 파일 이름을 조회합니다.
        // Object Storage (NCP)의 이미지를 삭제하고, Object Storage 상에서 이 파일을 삭제한 후,
        // 새로운 이미지를 업로드 한다.
        		
        imageFileName = dto.getImageFileName();
        // 기존 DB에 보관된 1개의 정보 값을 가져옴
        // 기존에 데이터베이스에 저장된 이미지 파일 이름을 가져옵니다.
        // 나중에 이 파일을 삭제할 때 사용됩니다.
        
        // seq 가져오기
        // `userUploadDTO.getSeq()`를 사용하여 해당 이미지의 시퀀스를 가져옵니다.
        // String imageFileName = userUploadDAO.getImageFileName(userUploadDTO.getSeq());
        // 데이터베이스에서 해당 시퀀스(seq)에 대한 `imageFileName`을 가져옵니다.
        // 이미지 파일은 고유한 이름으로 저장되며, 이를 통해 관리할 수 있습니다.
        
        
        System.out.println("imageFileName = " + imageFileName); 

        // 1. 이미지 삭제
        // 기존의 이미지를 Object Storage에서 삭제합니다.
        objectStorageService.deleteFile(bucketName, "storage/", imageFileName);
        // `deleteFile` 메서드는 Object Storage에 저장된 특정 파일을 삭제하는 작업을 수행합니다.
        // `bucketName`, `storage/` 경로와 이미지 파일 이름을 인자로 받아 해당 파일을 삭제합니다.
        // 삭제하는 이유는 클라우드 스토리지가 같은 파일 이름으로 덮어쓰기를 지원하지 않기 때문에,
        // 기존 파일을 삭제한 후 새로운 파일을 업로드하는 방식으로 처리합니다.

        // 2. 새로운 객체 이미지 삽입
        // 새로운 이미지를 Object Storage에 업로드하고, 업로드된 파일 이름을 반환받습니다.
        imageFileName = objectStorageService.uploadFile(bucketName, "storage/", img);
        // `uploadFile` 메서드는 새로운 파일을 Object Storage에 업로드하고, 업로드된 파일의 고유 이름을 반환합니다.
        // 이때, S3나 NCP의 Object Storage는 파일의 이름을 중복되지 않도록 자동으로 관리해줍니다.
        
        String imageOriginalFileName = img.getOriginalFilename();  
        // 업로드된 파일의 원본 파일 이름을 가져옵니다.
        // `getOriginalFilename()`은 사용자가 업로드한 파일의 실제 이름을 반환합니다.
        // 원본 파일 이름은 데이터베이스에 기록될 수 있으며, 나중에 파일을 구분하는 데 도움이 됩니다.
        
        File file = new File(filePath, imageOriginalFileName);  
        // `File` 객체를 생성하여, 해당 경로에 파일을 생성할 준비를 합니다.
        // `filePath`는 서버 상의 실제 경로이고, `imageOriginalFileName`은 원본 파일 이름입니다.
        // 서버의 파일 시스템에 파일을 저장할 때는 이 `File` 객체를 통해 처리합니다.
        
        try {
            img.transferTo(file);  
            // 업로드된 파일을 지정한 경로로 실제 저장합니다.
            // `transferTo` 메서드는 업로드된 파일을 지정된 경로에 저장하는 메서드입니다.
            // 여기서 `file` 경로는 위에서 지정한 서버의 실제 폴더입니다.
            // 이 과정에서 발생할 수 있는 예외는 `try-catch` 문을 통해 처리합니다.
        } catch (IllegalStateException e) {
            e.printStackTrace();
            // 파일을 저장하는 과정에서 상태가 잘못되었을 때 예외 처리.
        } catch (IOException e) {
            e.printStackTrace();
            // 파일을 저장하는 과정에서 IO 예외가 발생했을 때 처리.
        }

        // userUploadDTO 객체에 새로운 파일 이름과 원본 파일 이름을 설정합니다.
        userUploadDTO.setImageFileName(imageFileName);
        userUploadDTO.setImageOriginalFileName(imageOriginalFileName);
        // 새로운 파일 이름과 원본 파일 이름을 DTO 객체에 설정하여 이후 데이터베이스에 업데이트할 수 있게 합니다.
        // DTO에 파일 이름을 저장해 두면, 나중에 이 파일을 조회하거나 관리할 때 활용할 수 있습니다.
        
    	} else {
    		userUploadDTO.setImageFileName(dto.getImageFileName());
    		userUploadDTO.setImageOriginalFileName(dto.getImageOriginalFileName());
        } // if(img.getSize )
        	// 이미지 수정 없이 다른거만 수정해서 올린다면, Size=0, 그리고 fileName 은 없다, 그러므로
        	// getSize가 != 0 일 경우로 해두고,  == 0 일 경우에는 else 에서 처리한다.
        	// 파일을 수정하지 않고 다른 정보를 업데이트하는 경우, 이미지 정보는 그대로 유지됩니다.
        
        // DB 연동
        // 수정된 파일 이름, 설명 등을 데이터베이스에 업데이트합니다.
        userUploadDAO.uploadUpdate(userUploadDTO);
        // `uploadUpdate` 메서드는 데이터베이스에서 해당 레코드를 수정하는 역할을 합니다.
        // 최종적으로 데이터베이스에 변경된 파일 정보를 업데이트합니다.
    }
    
    @Override
    public void uploadDelete(String[] check) {
        
        // userUploadMapper.xml 에서 <forEach> 를 사용할려면 데이터를 List 에 담아야 한다.
        // MyBatis의 <forEach> 태그를 사용하려면 배열이나 리스트와 같은 컬렉션 데이터를 넘겨줘야 합니다.
        // 여기서는 check 배열(삭제할 항목들의 ID)이 전달되었고, 이를 List로 변환하여 MyBatis에 넘기기 위해 준비합니다.
        List<String> list = new ArrayList<>();
        
        // Object Storage (NCP) 의 내용도 삭제해야 한다. => imageFileName 이 필요하다., imageFileName 를 list 에 담는다.
        // NCP(Object Storage)에서 파일을 삭제하려면 해당 파일의 이름(imageFileName)이 필요합니다.
        // for문을 통해 check 배열에서 각 항목의 ID를 가져와서 해당하는 파일 이름을 얻습니다.
        for(String seq : check) {
            // userUploadDAO.getImageFileName()은 주어진 ID(seq)에 해당하는 imageFileName을 DB에서 조회하는 역할을 합니다.
            // Integer.parseInt(seq)는 String 타입의 seq를 정수형으로 변환하여, getImageFileName 메서드에 넘깁니다.
            String imageFileName = userUploadDAO.getImageFileName(Integer.parseInt(seq));
            
            // 조회된 imageFileName을 리스트에 추가합니다. 이 리스트는 나중에 Object Storage와 DB에서 삭제하는 데 사용됩니다.
            list.add(imageFileName);
            
        } // for
        
        // objectStorageService.deleteFile()은 Object Storage에서 파일을 삭제하는 메서드입니다.
        // bucketName은 S3 버킷 이름이고, "storage/"는 파일이 저장된 경로입니다. list에는 삭제할 파일 이름들이 담겨 있습니다.
        // 이 메서드는 NCP(Object Storage)에서 해당 버킷과 경로에 있는 파일들을 모두 삭제합니다.
        objectStorageService.deleteFile(bucketName, "stroage/", list);
        
        // Local DB 도 삭제 해야 한다.
        // 로컬 데이터베이스에서 역시 해당 파일들에 대한 레코드를 삭제해야 합니다.
        // userUploadDAO.uploadDelete(list)는 MyBatis를 통해 데이터베이스에서 리스트에 있는 파일 이름들을 삭제하는 메서드입니다.
        userUploadDAO.uploadDelete(list);
    }


}
