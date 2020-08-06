<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link href="css/wordcount.css" rel="stylesheet">
<html lang="en">
<head>
    <script>
        function validateForm(){
            if(document.wordCountForm.textVal.value==""){
                alert("Text can not be empty. If you inserted texts before, you can review them by clicking 'List all texts' button")
            }
        }

    </script>
</head>
<body>
<div>
    <div>
        <h1>Word Counter</h1>
        <form method="post" name="wordCountForm" onSubmit="return validateForm()">
            Inser the Text Here: <input type="text" name="textVal">
            <input type="submit" value="Words Count-Words Freq" name="orderbyFreq" id="order">
            <input type="submit" value="Words Count-Alphabetical Order" name="orderbyAlphabet">
        </form>
        <tr>
            <td>${countedWords.orderedWordsCount}</td>
        </tr>

        <form method="get" name="get all text" class="frm">
            <input type="submit" value="List all texts" name="list">
        </form>
        <form method="post" name="clean DB" class="frm">
            <input type="submit" value="Clean Database" name="clean">
        </form>
    </div>
</div>
</body>
</html>