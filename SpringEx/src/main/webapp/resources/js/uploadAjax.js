
$(document).ready(function(){
	
	//파일의 크기와 확장자를 검사하는 함수선언
	//서버에서 설정해놓은 파일크기 설정
	var maxSize=5242880;
	//서버에서 허용불가능한 확장자 설정(정규식), 정규식 : 검증이 필요할때
	var regex= new RegExp("(.*?)\.(exe|sh|zip|alz)$")
	 
	function checkExtension(fileSize,fileName){
		//사용자가 선택한 파일의 크기가 서버에서 설정해놓은 파일의 크기보다 이상이면,
		if(fileSize>=maxSize){
			alert("파일사이즈초과");
			return false;
		}
		//사용자가 선택한 파일의 확장자가 서버에서 설정해놓은 파일의 확장자와 일치하면
		if(regex.test(fileName)){
			alert("해당종류의 파일은 업로드 할 수 없습니다")
			return false;
		}
		//위의 두종류가 아니면  true값을 던져라
		return true;
	}
	
	
	
	
	$("input[type='submit']").on("click",function(){
		//alert("aaa")
		//가상의 form태그,jsp의 form태그와같은 역활을해주는 객체
		var formData= new FormData();
		var inputFile=$("input[name='uploadFile']");
		var files=inputFile[0].files;
		console.log(files);
		
		for(var i=0;i<files.length;i++){
			//파일의 크기가 설정해놓은크기 이상이면
			if(!checkExtension(files[i].size,files[i].name)){
				//밑에 있는거 하지마라
				return false;
			}
			//여기서 "uploadFile"은 <input type="file" name="uploadFile">의 name과 이름이 같아야한다
			formData.append("uploadFile",files[i]);
		}
		
		//ajax를 이용해서...
		//formData자체를 데이터로 전송하고
		//formData를 데이터로 전송할 때에는
		//processData과 contentType은 반드시 false여아함
		$.ajax({
			url:"uploadAjaxAction",
			type:"post",
			data:formData,
			processData:false,
			contentType:false,
			success:function(result){
				alert("upload성공")
			}
			
		})
		
	})
	
	
	
	
	

	
	
})


