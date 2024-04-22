<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 목록</title>
</head>
<body>
    <h1>게시판 목록</h1>
    
    <table border="1">
        <thead>
            <tr>
                <th>글번호</th>
                <th>작성자</th>
                <th>제목</th>
                <th>작성일자</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="board" items="${allBoardList}">
                <tr>
                    <td>${board.boardSeq}</td>
                    <td>${board.boardWriter}</td>
                    <td>${board.boardSubject}</td>
                    <td><fmt:formatDate value="${board.insDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

    $(document).ready(function(){
        // 각 행을 클릭할 때의 이벤트 핸들러
        $("table tbody tr").click(function(){
            // 선택된 행의 데이터 가져오기
            var boardSeq = $(this).find("td:eq(0)").text(); // 첫 번째 열의 데이터(글번호) 가져오기
			console.log("boardSeq=="+boardSeq);
			window.location.href = "/board/boardDetail.view?boardSeq=" + boardSeq;

        });
    });
</script>
</html>
