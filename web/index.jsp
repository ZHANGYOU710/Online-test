<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

  <title>欢迎进入在线答题平台</title>
  <link rel="shortcut icon" href="http://www.uu710.cn/PC-images/佑佑学习网_站标.ico" type="image/x-icon"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <style>
      *, *:before, *:after {
        box-sizing: border-box;
      }

      html {
        font-size: 18px;
        line-height: 1.5;
        font-weight: 300;
        color: #333;
        font-family: "Nunito Sans", sans-serif;
      }

      body {

        margin: 0;
        padding: 0;
        height: 100vh;
        background-color: #ecf0f9;
        background-attachment: fixed;
      }

      .content {
        display: flex;
        margin: 0 auto;
        justify-content: center;
        align-items: center;
        flex-wrap: wrap;
        max-width: 1000px;
      }

      .heading {
        width: 100%;
        margin-left: 1rem;
        font-weight: 900;
        font-size: 1.618rem;
        text-transform: uppercase;
        letter-spacing: .1ch;
        line-height: 1;
        padding-bottom: .5em;
        margin-bottom: 1rem;
        position: relative;
      }
      .heading:after {
        display: block;
        content: '';
        position: absolute;
        width: 60px;
        height: 4px;
        background: linear-gradient(135deg, #1a9be6, #1a57e6);
        bottom: 0;
      }

      .description {
        width: 100%;
        margin-top: 0;
        margin-left: 1rem;
        margin-bottom: 3rem;
      }

      .card {
        color: inherit;
        cursor: pointer;
        width: calc(33% - 2rem);
        min-width: calc(33% - 2rem);
        height: 400px;
        min-height: 400px;
        perspective: 1000px;
        margin: 1rem;
        position: relative;
      }
      @media screen and (max-width: 800px) {
        .card {
          width: calc(50% - 2rem);
        }
      }
      @media screen and (max-width: 500px) {
        .card {
          width: 100%;
        }
      }

      .front,
      .back {
        display: flex;
        border-radius: 6px;
        background-position: center;
        background-size: cover;
        text-align: center;
        justify-content: center;
        align-items: center;
        position: absolute;
        height: 100%;
        width: 100%;
        -webkit-backface-visibility: hidden;
        backface-visibility: hidden;
        transform-style: preserve-3d;
        transition: ease-in-out 600ms;
      }

      .front {
        background-size: cover;
        padding: 2rem;
        font-size: 1.618rem;
        font-weight: 600;
        color: #fff;
        overflow: hidden;
        font-family: Poppins, sans-serif;
      }
      .front:before {
        position: absolute;
        display: block;
        content: '';
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        background: linear-gradient(135deg, #1a9be6, #1a57e6);
        opacity: .25;
        z-index: -1;
      }
      .card:hover .front {
        transform: rotateY(180deg);
      }
      .card:nth-child(even):hover .front {
        transform: rotateY(-180deg);
      }

      .back {
        background: #fff;
        transform: rotateY(-180deg);
        padding: 0 2em;
      }
      .card:hover .back {
        transform: rotateY(0deg);
      }
      .card:nth-child(even) .back {
        transform: rotateY(180deg);
      }
      .card:nth-child(even):hover .back {
        transform: rotateY(0deg);
      }

      .button {
        transform: translateZ(40px);
        cursor: pointer;
        -webkit-backface-visibility: hidden;
        backface-visibility: hidden;
        font-weight: bold;
        color: #fff;
        padding: .5em 1em;
        border-radius: 100px;
        font: inherit;
        background: linear-gradient(135deg, #1a9be6, #1a57e6);
        border: none;
        position: relative;
        transform-style: preserve-3d;
        transition: 300ms ease;
      }
      .button:before {
        transition: 300ms ease;
        position: absolute;
        display: block;
        content: '';
        transform: translateZ(-40px);
        -webkit-backface-visibility: hidden;
        backface-visibility: hidden;
        height: calc(100% - 20px);
        width: calc(100% - 20px);
        border-radius: 100px;
        left: 10px;
        top: 16px;
        box-shadow: 0 0 10px 10px rgba(26, 87, 230, 0.25);
        background-color: rgba(26, 87, 230, 0.25);
      }
      .button:hover {
        transform: translateZ(55px);
      }
      .button:hover:before {
        transform: translateZ(-55px);
      }
      .button:active {
        transform: translateZ(20px);
      }
      .button:active:before {
        transform: translateZ(-20px);
        top: 12px;
      }
    </style>

  </head>
<body>

<div class="content">

  <a class="card" href="admin_login.jsp">
    <div class="front" style="background-image: url(http://www.uu710.cn/PC-images/teacher.jpg);">
      <p>I am a teacher.</p>
    </div>
    <div class="back">
      <div>
        <button class="button">Click Here</button>
      </div>
    </div>
  </a>


  <a class="card" >
    <div class="front" style="background-image: url(http://www.uu710.cn/PC-images/zhangyou.jpg);">
    </div>
    <div class="back" style="background-image: url(http://www.uu710.cn/PC-images/t-or-s.jpg);background-repeat:no-repeat ; background-size:100% 100%">
    </div>
  </a>


  <a class="card" href="student_login.jsp">
    <div class="front" style="background-image: url(http://www.uu710.cn/PC-images/student.jpg);">
      <p>I am a student.</p>
    </div>
    <div class="back">
      <div>
        <button class="button">Click Here</button>
      </div>
    </div>
  </a>

</div>

</body>
</html>