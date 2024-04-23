<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글 작성</title>
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
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .form-group input[type="text"],
        .form-group input[type="password"],
        .form-group textarea {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border-radius: 5px;
            border: 1px solid #ced4da;
        }
        .form-group textarea {
            resize: vertical;
            min-height: 200px;
        }
        .submit-button {
            text-align: center;
        }
        .submit-button button {
            background-color: #28a745;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }
        .submit-button button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>글 작성</h1>

        <div id="errorMessage" style="display: none; color: red;"></div>

        <div id="writeForm">
            <div class="form-group">
                <label for="boardWriter">작성자</label>
                <input type="text" id="boardWriter" name="boardWriter" maxlength="10" required>
            </div>
            <div class="form-group">
                <label for="boardPw">비밀번호</label>
                <input type="password" id="boardPw" name="boardPw" maxlength="10" required>
            </div>
            <div class="form-group">
                <label for="boardSubject">제목</label>
                <input type="text" id="boardSubject" name="boardSubject" maxlength="20" required>
            </div>
            <div class="form-group">
                <label for="boardContent">내용</label>
                <textarea id="boardContent" name="boardContent" required></textarea>
            </div>
            <div class="submit-button">
                <button type="button" onclick="submitForm()">글 작성</button>
            </div>
        </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function submitForm() {
            var boardWriter = $("#boardWriter").val();
            var boardPw = $("#boardPw").val();
            var boardSubject = $("#boardSubject").val();
            var boardContent = $("#boardContent").val();

            if (boardWriter === "" || boardPw === "" || boardSubject === "" || boardContent === "") {
                $("#errorMessage").text("모든 항목을 입력해주세요.").show();
                return;
            }

            if (boardWriter.length > 10) {
                $("#errorMessage").text("작성자는 최대 10자까지 입력 가능합니다.").show();
                return;
            }

            if (boardPw.length > 10) {
                $("#errorMessage").text("비밀번호는 최대 10자까지 입력 가능합니다.").show();
                return;
            }

            if (boardSubject.length > 20) {
                $("#errorMessage").text("제목은 최대 20자까지 입력 가능합니다.").show();
                return;
            }
			
            var boardInfo = {
            	    boardWriter: boardWriter,
            	    boardPw: boardPw,
            	    boardSubject: boardSubject,
            	    boardContent: boardContent
           };

           // Ajax를 사용하여 데이터를 서버로 전송
           $.ajax({
        	   method: "POST",
               url: "/board/boardWrite.act",
               dataType : "text" , 
               data: boardInfo , // JSON 형태로 데이터 전달
               success: function(response) {
                   // 성공적으로 글이 작성되었을 때 처리
                   alert("글이 성공적으로 작성되었습니다.");
                   window.location.href = "/";
               },
               error: function(xhr, status, error) {
                   // Ajax 요청이 실패한 경우 처리
                   alert("글 작성에 실패하였습니다. 다시 시도해주세요.");
               }
           });

        }
    </script>
</body>
</html>
