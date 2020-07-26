<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>在线答题平台</title>
	<link rel="shortcut icon" href="http://www.uu710.cn/PC-images/佑佑学习网_站标.ico" type="image/x-icon"/>
<link href="main.css" rel="stylesheet" type="text/css" />
<link href="iconfont.css" rel="stylesheet" type="text/css" />
<link href="test.css" rel="stylesheet" type="text/css" />
<style>
.hasBeenAnswer {
	background: #5d9cec;
	color: #fff;
}
</style>

<script type="text/javascript">
<c:if test="${not empty tip_info}">
	alert('${tip_info}');
	window.close();
</c:if>
</script>
</head>
<body>
	<div class="main">
		<!-- start-->
		<div class="test_main">
			<div class="nr_left">
				<div class="test">
					<form action="answer.do" method="post">
						<div class="test_title">
							<p class="test_time">
								<i class="icon iconfont">&#xe6fb;</i><b class="alt-1">01:30</b>
							</p>
							<font><input type="submit" name="test_jiaojuan" value="交卷"></font>
						</div>

						<div class="test_content">
							<div class="test_content_title">
								<h2>单选题</h2>
								<p>
									<span>共</span><i class="content_lit">20</i><span>题，</span><span>合计</span><i
										class="content_fs">100</i><span>分</span>
								</p>
							</div>
						</div>
						<div class="test_content_nr">
							<ul>
							<c:forEach items="${paper_list}" var="paper" varStatus="i">
								<li id="qu_0_0">
									
										<div class="test_content_nr_tt">
										<i>${paper.questionNum}</i><span>(${paper.questionScore}分)</span><font>${paper.questionContent}</font><b class="icon iconfont">&#xe881;</b>
										</div>
							
								<div class="test_content_nr_main">
									<ul>
									<c:forEach items="${paper.optionList }" var="optioninfo">
										<li class="option"><input type="radio"
										class="radioOrCheck" name="answer_${paper.questionNum}" id="0_answer_1_option_1" value="${optioninfo.optionType}"/>
											<label for="0_answer_1_option_1"> ${optioninfo.optionType }.
													<p class="ue" style="display: inline;">${optioninfo.optionContent}</p>
											</label>
										</li>
									</c:forEach>
									
									
									</ul>
								</div>
							</li>
								
						</c:forEach>

							</ul>
						</div>
				</form>
			</div>	
		</div>
	</div>
			<div class="nr_right">
				<div class="nr_rt_main">
					<div class="rt_nr1">
						<div class="rt_nr1_title">
							<h1>
								<i class="icon iconfont">&#xe692;</i>答题卡
							</h1>
							<p class="test_time">
								<i class="icon iconfont">&#xe6fb;</i><b class="alt-1">01:30</b>
							</p>
						</div>

						<div class="rt_content">
							<div class="rt_content_tt">
								<h2>单选题</h2>
								<p>
									<span>共</span><i class="content_lit">20</i><span>题</span>
								</p>
							</div>
							<div class="rt_content_nr answerSheet">
								<ul>
								
								<c:forEach begin="1" end="20" varStatus="i">
								<li><a href="#qu_0_${i.count}">${i.count }</a></li>
								</c:forEach>
									
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--nr end-->
		<div class="foot"></div>


	<script src="jquery-1.11.3.min.js"></script>
	<script src="jquery.easy-pie-chart.js"></script>
	<!--时间js-->
	<script src="time/jquery.countdown.js"></script>
	<script>
		window.jQuery(function($) {
			"use strict";

			$('time').countDown({
				with_separators : false
			});
			$('.alt-1').countDown({
				css_class : 'countdown-alt-1'
			});
			$('.alt-2').countDown({
				css_class : 'countdown-alt-2'
			});

		});

		$(function() {
			$('li.option label').click(
					function() {
						debugger;
						var examId = $(this).closest('.test_content_nr_main')
								.closest('li').attr('id'); // 得到题目ID
						var cardLi = $('a[href=#' + examId + ']'); // 根据题目ID找到对应答题卡
						// 设置已答题
						if (!cardLi.hasClass('hasBeenAnswer')) {
							cardLi.addClass('hasBeenAnswer');
						}

					});
		});
	</script>


</body>

</html>