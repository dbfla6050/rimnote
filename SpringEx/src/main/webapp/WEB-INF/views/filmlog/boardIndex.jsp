<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/resources/css/filmlog/boardStyle.css">
	<meta charset="UTF-8">
	<title>Filmlog</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
    <div id="container">
       <div class="containerIn">
           <section class="slide">
               <div class="slide-img">
                   	슬라이드
                   <!-- <img src="./img/slide.PNG" alt=""> -->
               </div>
           </section>
           <div class="contents">
               <h3>자유게시판</h3>
               <div class="btn_m"><a href="#">수정</a></div>
               <table>
                   <tr>
                       <th>제목 입니다.</th>
                   </tr>
                   <tr>
                       <td class="writer">
                           <span>작성자 : 한국인 </span>
                           <span class="w_r">등록일 : 2020-12-25 20:00</span>
                           <span class="w_rr">조회수 : 100</span>
                       </td>
                   </tr>
                   <tr class="con">
                       <td>
                           	내용Sed ut perspiciatis, unde omnis iste natus error s dkkdasd
                           it voluptatem accusantium doloremque laudantium, totam rem 
                           aperiam eaque ipsa, quae ab illo inventore veritatis et quasi
                           architecto beatae vitae dicta sunt, explicabo. Nemo
                           enim ipsam voluptatem, quia voluptas sit, aspernatur aut 
                           odit aut fugit, sed quia consequuntur magni dolores eos, qui 
                           ratione voluptatem sequi nesciunt, neque porro quisquam est, 
                           qui dolorem ipsum, quia dolor sit amet consectetur adipisci[ng]
                           velit, sed quia non numquam [do] eius modi tempora inci[di]dunt,
                           ut labore et dolore magnam aliquam quaerat voluptatem. Ut
                           enim ad minima veniam, quis nostrum[d] exercitationem ullam 
                           corporis suscipit laboriosam, nisi ut aliquid ex ea commodi 
                           consequatur? [D]Quis autem vel eum iure reprehenderit, qui 
                           in ea voluptate velit esse, quam nihil molestiae consequatur,
                           vel illum, qui dolorem eum fugiat, quo voluptas nulla pariatur? 
                           [33] At vero eos et accusamus et iusto odio dignissimos ducimus,
                           qui blanditiis praesentium voluptatum deleniti atque corrupti, 
                           quos dolores et quas molestias excepturi sint, obcaecati 
                           cupiditate non provident, similique sunt in culpa, qui officia 
                           deserunt mollitia animi, id est laborum et dolorum fuga. Et harum 
                           quidem rerum facilis est et expedita distinctio. Nam libero 
                           tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, 
                           quo minus id, quod maxime placeat, facere possimus, omnis 
                           voluptas assumenda est, omnis dolor repellendus. Temporibus 
                           autem quibusdam et aut officiis debitis aut rerum 
                           necessitatibus saepe eveniet, ut et voluptates repudiandae
                           sint et molestiae non recusandae. Itaque earum rerum hic 
                           tenetur a sapiente delectus, ut aut reiciendis voluptatibus 
                           maiores alias consequatur aut perferendis doloribus asperiores 
                           repellat.
                       </td>
                   </tr>
               </table>
               <div class="btn">
                   <div class="btn_r"><a href="writeIndex.html">글쓰기</a></div>
                   <div class="btn_l"><a href="#">목록보기</a></div>
               </div>
               <div class="beforeAfter">
                   <ul>
                       <li>
                           <a href="#">
                               <span class="ba_l">이전글</span>
                               <span class="ba_r">뭐시기 뭐시기 뭐시기</span>
                           </a>
                       </li>
                       <li>
                           <a href="#">
                               <span class="ba_l">다음글</span>
                               <span class="ba_r">요시기 요시기 요시기</span>
                           </a>
                       </li>
                   </ul>
               </div>
           </div>
       </div><!--containerIn-->
   </div> <!--#container-->

	<%@ include file="footer.jsp" %>
</body>
</html>