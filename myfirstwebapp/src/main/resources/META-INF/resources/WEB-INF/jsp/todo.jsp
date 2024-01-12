		<%@ include file="common/header.jspf" %>
		<%@ include file="common/navigation.jspf" %>
		<div class="container">
			<h1>Enter Todo Details</h1>
			<!-- bean 추가를 위해 form: 추가?  todo 이름 맞춰서-->
			<!-- bean 맴버 변수에 mapping -->
			<form:form method="post" modelAttribute="todo">
				<!-- spring tag여서 class 모양이 다름  & bootstrap 에서 제공하는 css-->
				<fieldset class="mb-3">				
					<form:label path="description">Description</form:label>
					<form:input type="text" path="description" required="required"/>
					<form:errors path="description" cssClass="text-warning"/>
				</fieldset>
				
				<fieldset class="mb-3">				
					<!-- 여기서 path 는 todo에 있는 field name 과 동일하게 -->
					<form:label path="targetDate">Target Date</form:label> 
					<form:input type="text" path="targetDate" required="required"/>
					<form:errors path="targetDate" cssClass="text-warning"/>
				</fieldset>

				<form:input type="hidden" path="id"/>

				<form:input type="hidden" path="done"/>

				<input type="submit" class="btn btn-success"/>
				
			</form:form>
			
		</div>

		<%@ include file="common/footer.jspf" %>

		<script type="text/javascript">
			$('#targetDate').datepicker({
				// properties에서 설정한대로 
				format: 'yyyy-mm-dd'
			});
			</script>


