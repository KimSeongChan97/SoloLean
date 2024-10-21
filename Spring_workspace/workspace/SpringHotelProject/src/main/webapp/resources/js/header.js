$(function(){
    // 현재 화면의 상태(viewName)를 container의 data-view 속성에서 가져옴
    // 각 페이지마다 body 혹은 container에 data-view 속성으로 현재 페이지 정보를 저장해 두고, 이를 통해 적절한 메뉴에 'active' 클래스를 추가하여 강조하는 방식
    const viewName = $('.container').data('view'); 
    console.log('viewName: ' + viewName); // viewName 값이 제대로 추출되었는지 확인하기 위해 콘솔에 출력
    
    // 현재 페이지가 'index'인 경우 (메인 페이지)
    if(viewName == 'index') {
    	$('#header-1').addClass('active'); // 첫 번째 메뉴 항목에 'active' 클래스를 추가하여 강조 (홈 화면)
    
    // 현재 페이지가 'roomView' 또는 'roomDetail'인 경우 (객실 목록 또는 객실 상세 페이지)
    } else if(viewName == 'roomView' || viewName == 'roomDetail') {
    	$('#header-2').addClass('active'); // 두 번째 메뉴 항목에 'active' 클래스 추가 (객실 관련 메뉴)
    
    // 현재 페이지가 'reservation'인 경우 (예약 페이지)
    } else if(viewName == 'reservation') {
    	$('#header-3').addClass('active'); // 세 번째 메뉴 항목에 'active' 클래스 추가 (예약 관련 메뉴)
    
    // 현재 페이지가 'reservationList'인 경우 (예약 목록 페이지)
    } else if(viewName == 'reservationList') {
    	$('#header-4').addClass('active'); // 네 번째 메뉴 항목에 'active' 클래스 추가 (예약 목록 관련 메뉴)
    
    // 현재 페이지가 'login'인 경우 (로그인 페이지)
    } else if(viewName == 'login') {
    	$('#header-loginMenu').addClass('active'); // 로그인 메뉴에 'active' 클래스 추가 (로그인 관련 메뉴)
    
    // 현재 페이지가 'join'인 경우 (회원가입 페이지)
    } else if(viewName == 'join') {
    	$('#header-joinMenu').addClass('active'); // 회원가입 메뉴에 'active' 클래스 추가 (회원가입 관련 메뉴)
    
    // 현재 페이지가 'admin'인 경우 (관리자 페이지)
    } else if(viewName == 'admin') {
    	$('#header-adminMenu').addClass('active'); // 관리자 메뉴에 'active' 클래스 추가 (관리자 관련 메뉴)
    
    // 현재 페이지가 'checkUser'인 경우 (사용자 조회 페이지)
    } else if(viewName == 'checkUser') {
    	$('#header-6').addClass('active'); // 여섯 번째 메뉴 항목에 'active' 클래스 추가 (사용자 조회 관련 메뉴)
    
    // 현재 페이지가 'updateRoom'인 경우 (객실 업데이트 페이지)
    } else if(viewName == 'updateRoom') {
    	$('#header-7').addClass('active'); // 일곱 번째 메뉴 항목에 'active' 클래스 추가 (객실 업데이트 관련 메뉴)
    
    // 현재 페이지가 'checkReserve'인 경우 (예약 확인 페이지)
    } else if(viewName == 'checkReserve') {
    	$('#header-8').addClass('active'); // 여덟 번째 메뉴 항목에 'active' 클래스 추가 (예약 확인 관련 메뉴)
    
    // 현재 페이지가 'inquiryList' 또는 '#detailcomment'가 data-view 속성을 갖는 경우 (문의 목록 페이지 또는 상세 댓글 페이지)
    } else if(viewName == 'inquiryList' || $('#detailcomment').data('view')) {
    	$('#header-5').addClass('active'); // 다섯 번째 메뉴 항목에 'active' 클래스 추가 (문의 관련 메뉴)
    }
});
