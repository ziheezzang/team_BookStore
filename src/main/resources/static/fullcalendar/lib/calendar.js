$(document).ready(function(){
	  $('#calendar').fullCalendar({
	    header: {
	      right: 'custom2 prevYear,prev,next,nextYear'
	    },
        // 출석체크를 위한 버튼 생성
         
	    customButtons: { 
	        custom2: {
	          text: '출석체크하기',
	          id: 'check',
	          click: function() {	
                    // ajax 통신으로 출석 정보 저장하기 
                    // 통신 성공시 버튼 바꾸고, property disabled 만들기 
	          }
	        }
	    },
       // 달력 정보 가져오기 
	    eventSources: [
	    	{
				url: "/users/attendances",
				type: "POST",
				data : {userId: userId},
				dataType: "text",
				success: function (date) {
				$(".fc-custom2-button").prop('disabled', true);
				$(".fc-custom2-button").html('출석완료'); 
				},
				// ajax 통신으로 달력 정보 가져오기 
               
				url: '/users/attendances',
	    		type: 'GET',
	    		dataType: "JSON",
	    		success: function (data) { },
	    		error: function() {
	    			alert('there was an error while fetching events!');
	    		},
	    		color: 'purple',   
	    		textColor: 'white' 
	    	}
	    ]
	  }); 
});
