<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글</title>
</head>
<body>
    <h1>${boardSeq}번 게시물</h1>
    
    <table border="1">
        <thead>
            <tr>
                <th>작성자</th>
                <th>제목</th>
                <th>내용</th>
                <th>작성일자</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="board" items="${boardDetail}">
                <tr>
                    <td>${board.boardWriter}</td>
                    <td>${board.boardSubject}</td>
                    <td>${board.boardContent}</td>
                    <td>${board.insDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

    
</script>
</html>
