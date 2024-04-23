<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 수정</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 20px auto;
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }
        form {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .buttons {
            text-align: center;
        }
        .buttons button {
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
            border-radius: 5px;
        }
        .buttons button:hover {
            background-color: #0056b3;
        }
        .main-btn {
            text-decoration: none;
            color: #fff;
            background-color: #28a745;
            padding: 10px 20px;
            border-radius: 5px;
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>게시글 수정</h1>
        <form id="updateForm">
            <label for="boardWriter">작성자</label>
            <input type="text" id="boardWriter" name="boardWriter" value="${boardDetail[0].boardWriter}" disabled="disabled">
            <label for="boardSubject">제목</label>
            <input type="text" id="boardSubject" name="boardSubject" value="${boardDetail[0].boardSubject}">
            <label for="boardContent">내용</label>
            <textarea id="boardContent" name="boardContent">${boardDetail[0].boardContent}</textarea>
        </form>
        <div class="buttons">
        	<a href="/" class="main-btn">메인화면으로</a>
            <button onclick="updateBoard()">수정 완료</button>
        </div>
        <input type="hidden" id="boardSeq" value="${boardDetail[0].boardSeq}">
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function updateBoard() {
        	var boardWriter = $("#boardWriter").val();
        	var boardSubject = $("#boardSubject").val();
        	var boardContent = $("#boardContent").val();
        	var boardSeq = $("#boardSeq").val();
        	
        	
        	var boardInfo = {
            	    boardWriter: boardWriter,
            	    boardSubject: boardSubject,
            	    boardContent: boardContent,
            	    boardSeq: boardSeq
           };
        	
            $.ajax({
                method: "POST",
                url: "/board/boardUpdate.act",
                data: boardInfo,
                success: function(response) {
                    alert(response);
                    window.location.href = "/";
                },
                error: function(xhr, status, error) {
                    alert("게시글 수정에 실패하였습니다. 다시 시도해주세요.");
                }
            });
        }
    </script>
</body>
</html>
