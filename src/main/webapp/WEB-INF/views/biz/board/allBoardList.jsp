<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>
</head>
<body>
    <h1>게시판 목록</h1>
    
    <table border="1">
        <thead>
            <tr>
                <th>글번호</th>
                <th>작성자</th>
                <th>제목</th>
                <th>내용</th>
                <th>작성일자</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="board" items="${allBoardList}">
                <tr>
                    <td>${board.boardSeq}</td>
                    <td>${board.boardWriter}</td>
                    <td>${board.boardSubject}</td>
                    <td>${board.boardContent}</td>
                    <td>${board.insDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
