<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글</title>
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
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .buttons {
            text-align: center;
        }
        .buttons button {
            margin: 5px;
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
        <h1>${boardSeq}번 게시물</h1>
        <table>
            <thead>
                <tr>
                    <th>작성자</th>
                    <th>제목</th>
                    <th>작성일자</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="board" items="${boardDetail}">
                    <input type="hidden" id="boardPw" value="${board.boardPw}">
                    <tr>
                        <td>${board.boardWriter}</td>
                        <td>${board.boardSubject}</td>
                        <td>${board.insDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <table>
            <thead>
                <tr>
                    <th>내용</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="board" items="${boardDetail}">
                    <tr>
                        <td>${board.boardContent}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="buttons">
        	<a href="/" class="main-btn">메인화면으로</a>
            <!-- 게시글 수정 버튼 -->
            <button onclick="confirmUpdate('${boardSeq}')">게시글 수정</button>
            <!-- 게시글 삭제 버튼 -->
            <button onclick="confirmDelete('${boardSeq}')">게시글 삭제</button>
        </div>
    </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    // 게시글 수정 확인
    function confirmUpdate(boardSeq) {
        var password = prompt("게시글을 수정하시려면 비밀번호를 입력하세요:");
        if (password !== null) {
            var boardPw = $("#boardPw").val()
            if (password === boardPw) {
            	window.location.href = "/board/boardUpdate.view?boardSeq=" + boardSeq;
            } else {
                // 비밀번호 불일치하는 경우 처리
                alert("비밀번호가 일치하지 않습니다.");
            }
        } else {
            // 사용자가 취소 버튼을 눌렀을 때 처리
            alert("게시글 수정이 취소되었습니다.");
        }
    }

    // 게시글 삭제 확인
    function confirmDelete(boardSeq) {
        var password = prompt("게시글을 삭제하시려면 비밀번호를 입력하세요:");
        console.log("boardSeq="+boardSeq);
        if (password !== null) {
            var boardPw = $("#boardPw").val()
            if (password === boardPw) {
            	$.ajax({
             	   method: "POST",
                    url: "/board/boardDelete.act",
                    dataType : "text" , 
                    data: { boardSeq: boardSeq } ,
                    success: function(response) {
                        // 성공적으로 글이 작성되었을 때 처리
                        alert(response);
                        window.location.href = "/";
                    },
                    error: function(xhr, status, error) {
                        // Ajax 요청이 실패한 경우 처리
                        alert("글 삭제에 실패하였습니다. 다시 시도해주세요.");
                    }
                });
            } else {
                // 비밀번호 불일치하는 경우 처리
                alert("비밀번호가 일치하지 않습니다.");
            }
        } else {
            // 사용자가 취소 버튼을 눌렀을 때 처리
            alert("게시글 삭제가 취소되었습니다.");
        }
    }
</script>

</html>
