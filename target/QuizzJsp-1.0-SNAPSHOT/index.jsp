<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>The Number Quiz</h1>
<p>Your currrent score: ${quiz.score}</p>
<p>Guess the next number in the sequence.</p>
<p><p>${quiz.nextQuestion}</p></p>
<form action="start" method="post">
    Your answer is:
    <input type="number" name="answer"/>
    <input type="submit" value="Submit"/>
</form>

</body>
</html>