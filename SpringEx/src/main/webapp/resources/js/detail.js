/**
 * ajax가 폼태그와 같은역할을 한다고 보면 된다
 * $.ajax({
 * 		url:"서버주소",
 * 		type:"get/post/put/delete",
 * 		data:JSON.stringify({변수:값,변수:값,변수:값})   //자바스크립트를 json타입으로바꿔서 자바로 넘겨준다
 * 		contentType:"application/json; charset=utf-8",
 * 		success:function(){         //정상적으로 처리됬을때
 *      },
 *      error:function(){             //정상적으로 처리되지않았을때
 * 		}
 * })
 * 
 * ex) 
 * var aaa={"mno": 100,"firstName": "정","lastName": "자바"}
 * 
 * $.ajax({
 * 		url:"/sample/mno",
 * 		type:"post",
 * 		data:JSON.stringify(aaa)        //자바스크립트를 json타입으로바꿔서 자바로 넘겨준다
 * 		contentType:"application/json; charset=utf-8",
 * 		success:function(){           //정상적으로 처리됬을때
 *      }, 
 *      error:function(){             //정상적으로 처리되지않았을때
 * 		}
 * })
 * 
 * 
 */


$(document).ready(function(){
	//상세페이지가 실행되면 댓글 글쓰기 버튼 활성화
	$("#modalRegisterBtn").show();
	//상세페이지가 실행되면 댓글 글수정 버튼 활성화
	$("#modalModBtn").show();
	//상세페이지가 실행되면 댓글 글삭제 버튼 활성화
	$("#modalRemoveBtn").show();
	
	
	//detail창에서 댓글쓰기 버튼을 클릭하면
	$("#addReplyBtn").on("click",function(){
		//댓글작성자 초기화
		$("input[name='replyer']").val("")
		//댓글내용초기화
		$("input[name='reply']").val("")
		
		//댓글쓰기 버튼을 실행되면 댓글 글쓰기 버튼 활성화
		$("#modalRegisterBtn").show();
		//댓글쓰기 버튼을 클릭하면 댓글 글수정 버튼 비활성화
		$("#modalModBtn").hide();
		//댓글쓰기 버튼을 클릭하면 댓글 글삭제 버튼 비활성화
		$("#modalRemoveBtn").hide();
		//모달창을 띄워라
		$(".modal fade").modal("show");
	});
	
	
	//bno값 가져오기
	//bno는 시작하자마자 들고오는거라서 이벤트밖에 있어야한다
	var bno=$("#bno").html();
	
	//detail.jsp을 눌렸을때 바로 화면에 댓글목록리스트가 실행되어야함,그래서 호출을여기에 해야함
	//함수로 묶으면 호출부였던게 선언부가되서 여기에 따로 호출을 해줘야한다
	showList();

	//함수선언
	//댓글리스트목록실행이 여러군데 사용되기때문에 함수로 묶어준다,
	//함수로 묶으면 호출부였던게 선언부가되서 따로 호출을 해줘야한다
	function showList(){
		//detail.jsp을 눌렸을때 바로 화면에 댓글목록리스트가 실행되어야함,그래서 호출을여기에 해야함
		replyService.getList({bno:bno},function(list){
			
			console.log(list);
			
			var str="";
			
			//for문을 이용해 댓글리스트를 뿌림
			for(var i=0; i<list.length; i++){
				//댓글번호를 가지고오기위해서 rno추가
				str+="<li data-rno='"+list[i].rno+"'><div><b>"+list[i].replyer+"</b></div>"
				str+="<div>"+list[i].reply+"</div>"
				str+="</li>"
			}
			//#relist에 html를 통해 댓글리스트를 뿌림
			$("#relist").html(str);
		});
	}

	
	

	//console.log(replyService)    //replyService 함수호출
	//모달창에서 댓글쓰기 버튼(id값이 modalRegisterBtn)을 클릭하면
	$("#modalRegisterBtn").on("click",function(){
		//사용자가 입력한 댓글내용을 저장
		//reply와 replyer은 댓글쓰기를 클릭했을때 가지고오는거라서 이벤트안에 있어야한다
		var reply=$("input[name='reply']").val()
		//사용자가 입력한 댓글작성자를 저장
		var replyer=$("input[name='replyer']").val()
		
		//add함수를 호출해라
		//replyService.add("댓글내용,"댓글작성자","게시판번호")
		//                 ajax로 보내고자하는 json타입                               ,callback함수호출(result값으로 success가 저장되어 뿌려짐)
		replyService.add({reply:reply,replyer:replyer,bno:bno},//함수호출, json타입으로 보내기
				//callback함수호출(result값으로 success가 저장되어 뿌려짐)
				function(result){  //callback함수 호출
								alert("insert 작업:"+result)
								//목록리스트를 처리
								showList();
								}); 
		
		//댓글쓰기버튼을 클릭했을때 모달창을 숨겨라
		$(".modal").modal("hide");
	})//모달창안에 댓글쓰기버튼
	
	
	
	//댓글내용을 클릭하면(수정 및 삭제를 하기 위해서)
	//"li" : 범위를 한정시켜준다, 델리게이트
	$("#relist").on("click","li",function(){
		//댓글 글쓰기 버튼 비활성화
		$("#modalRegisterBtn").hide();
		//댓글 글수정 버튼 활성화
		$("#modalModBtn").show();
		//댓글 글삭제 버튼 활성화
		$("#modalRemoveBtn").show();
		//madal창을 띄워라
		$(".modal").modal("show");
		
		
		//rno값을 가져오기
		//date-rno : data선택자에서 rno를가져온다 
		//this : 내가선택한 li클릭한것에 대한 rno들고와라
		var rno=$(this).data("rno");
		
		//댓글수정을 하기위해 댓글내용 가져오기(rno번호가져오면 내용가져올수있음) 함수호출
		replyService.reDetail(rno,function(detail){
			console.log(detail)
			
			//내용가져와서 모달창에 뿌린다
			$("input[name='rno']").val(detail.rno)
			$("input[name='replyer']").val(detail.replyer)
			$("input[name='reply']").val(detail.reply)
		})
	})
	
	
	
	
	//댓글수정버튼을 클릭하면
	$("#modalModBtn").on("click",function(){
		//alert("aa")
		var rno=$("input[name='rno']").val()
		var reply=$("input[name='reply']").val()
		//댓글수정함수를 호출해서 처리
		replyService.reupdate({rno:rno,reply:reply},function(update){
			//콜백영역(update가 정상적으로 처리된 후 조치)
			alert("update작업"+update)
			//댓글수정버튼을 클릭했을때 모달창닫기
			$(".modal").modal("hide");
			//목록리스트를 실행
			showList();
		})
	})
	
	
	
	
	//댓글삭제버튼을 클릭하면
	$("#modalRemoveBtn").on("click",function(){
		//alert("aa")
		var rno=$("input[name='rno']").val()
		//댓글삭제함수를 호출해서 처리
		replyService.remove({rno:rno},function(remove){
			//콜백영역(delete가 정상적으로 처리된 후 조치)
			alert("delete작업"+remove)
			//댓글수정버튼을 클릭했을때 모달창닫기
			$(".modal").modal("hide");
			//목록리스트를 실행
			showList();
		})
	})

	
	


})




var replyService=(function(){   //replyService 함수선언
	//댓글쓰기를 하기 위한 함수 선언
	//함수호출하면 선언부에서 데이터를 받아서 컨트롤러로 넘겨줌
	function add(reply,callback){
		console.log("reply.........")
		$.ajax({
			url:"/replies/new",         //replies/new 컨트롤러로 보냄
			type:"post",
			data:JSON.stringify(reply),  //자바스크립트를 json타입으로바꿔서 자바로 넘겨준다
			contentType:"application/json; charset=utf-8",
			success:function(result){           //통신이 정상적으로 처리됬을때
				//통신이 성공했으면 후조치로 callback함수선언해서 화면 띄울수있도록
				//만약에 callback이 있으면
				if(callback)
				//callback함수를 호출
				//컨트롤러에서 success를 불러와서 result값에 저장시켜서 호출부로  success를 보냄
					callback(result);
	         }, 
	        error:function(){             //통신이 비정상적으로 처리가 되어 error가 있으면
	        	
	 		}
		})
	}
	
	//댓글목록리스트를 하기위한 함수 선언
	function getList(param,callback){
		var bno=param.bno;
		console.log(bno);
		//타입이 get일때만 $.getJSON쓸수있다, 이렇게쓰면 축약해서 사용가능
		//게시판번호에따라 댓글이 다르기때문에 bno를 가지고와야한다,
		//bno는 위에서 var bno=$("#bno").html();으로 불러왔었어서 그대로 사용
		//callback은 컨트롤러에서 ok사인떨어지면 콜백함수로가서 호출부로 리턴시켜 function(list){}여기에서 화면으로 뿌린다
		$.getJSON(
				"/replies/list/"+bno+".json",
				function(data){
					if(callback)
						callback(data);
					
				})
	}
	//댓글수정을 하기위해 댓글내용 가져오기 함수선언
	function reDetail(rno,callback){
		var rno=rno;
		$.getJSON(
				"/replies/"+rno+".json",
				function(data){
					if(callback)
						callback(data);
				})
	}
	
	//댓글수정을 하기 위한 함수 선언
	function reupdate(reply,callback){
		$.ajax({
			url:"/replies/update",         //replies/new 컨트롤러로 보냄
			type:"put",
			data:JSON.stringify(reply),  //자바스크립트를 json타입으로바꿔서 자바로 넘겨준다
			contentType:"application/json; charset=utf-8",
			success:function(result){           //통신이 정상적으로 처리됬을때
				//통신이 성공했으면 후조치로 callback함수선언해서 화면 띄울수있도록
				//만약에 callback이 있으면
				if(callback)
				//callback함수를 호출
				//컨트롤러에서 success를 불러와서 result값에 저장시켜서 호출부로  success를 보냄
					callback(result);
	         }, 
	        error:function(){             //통신이 비정상적으로 처리가 되어 error가 있으면
	        	
	 		}
		})
	}
	
	//댓글삭제를 하기 위한 함수 선언
	function remove(reply,callback){
		$.ajax({
			url:"/replies/remove",         //replies/new 컨트롤러로 보냄
			type:"delete",
			data:JSON.stringify(reply),  //자바스크립트를 json타입으로바꿔서 자바로 넘겨준다
			contentType:"application/json; charset=utf-8",
			success:function(result){           //통신이 정상적으로 처리됬을때
				//통신이 성공했으면 후조치로 callback함수선언해서 화면 띄울수있도록
				//만약에 callback이 있으면
				if(callback)
				//callback함수를 호출
				//컨트롤러에서 success를 불러와서 result값에 저장시켜서 호출부로  success를 보냄
					callback(result);
	         }, 
	        error:function(){             //통신이 비정상적으로 처리가 되어 error가 있으면
	        	
	 		}
		})
	}
	
	//add라는 변수에 add함수넣어서 호출한곳으로  return,메모리다시회수하는것(메모리관리)
	return {add:add,
			getList:getList,
			reDetail:reDetail,
			reupdate:reupdate,
			remove:remove};
	
})()
























