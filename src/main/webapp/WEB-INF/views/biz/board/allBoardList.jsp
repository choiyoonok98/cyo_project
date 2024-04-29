<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 목록</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            background-color: #f8f9fa;
            color: #212529;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        h1 {
            color: #007bff;
            margin-bottom: 20px;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            border: 1px solid #dee2e6;
            margin-bottom: 20px;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border: 1px solid #dee2e6;
        }
        th {
            background-color: #007bff;
            color: #fff;
        }
        tr:hover {
            background-color: #f8f9fa;
        }
        .pagination {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }
        .pagination a {
            margin: 0 5px;
            padding: 5px 10px;
            color: #007bff;
            text-decoration: none;
            border: 1px solid #007bff;
            border-radius: 5px;
        }
        .pagination a:hover {
            background-color: #007bff;
            color: #fff;
        }
        .write-button {
            text-align: center;
            margin-bottom: 20px;
        }
        .write-button button {
            background-color: #28a745;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }
        .write-button button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>게시글 목록</h1>
        
        <table>
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
                        <td>${board.insDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- 글쓰기 버튼 -->
        <div class="write-button">
            <button onclick="window.location.href='/board/boardWrite.view'">글쓰기</button>
        </div>
    </div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        // 각 행을 클릭할 때의 이벤트 핸들러
        $("table tbody tr").click(function(){
            // 선택된 행의 데이터 가져오기
            var boardSeq = $(this).find("td:eq(0)").text(); // 첫 번째 열의 데이터(글번호) 가져오기
            window.location.href = "/board/boardDetail.view?boardSeq=" + boardSeq;
        });
    });
</script>
</html>
