
<script type="text/javascript">
	var shoppingBagList = [];

	<c:forEach var="shoppingBag" items="${shoppingBagList}">
		shoppingBagList.push({
			id:${shoppingBag.spbNo},
			amount:${shoppingBag.amount},
			price:${shoppingBag.price}
		});
	</c:forEach>

	function deleteShoppingBag(shoppingBagNo, customerNo, statusIndex) {
	
		shoppingBagDeleteRequest={
				spbNo: shoppingBagNo,
				customerNo: customerNo
		};	
		$.ajax({
			url : "${pageContext.request.contextPath}/myPage/shoppingBag",
			contentType	: "application/json; charset=utf-8;", 
			data :JSON.stringify(shoppingBagDeleteRequest),
			dataType : 'json',
			success : function (data) {
	
				if(data.isUpdateSuccess) {
					let targetShoppingBag = shoppingBagList[statusIndex];  // 쇼핑백 리스트에서 업데이트 대상 검색
					
					var shoppingBagNo = "#shoppingBag_"+shoppingBagNo;
					console.log(shoppingBagNo);
					shoppingBagNo.hide();
				}
			},
			fail : function (error) {
				alert("실패");
				console.log(error);
			}
		});

	}

	
	function DecreaseAmount(shoppingBagNo,shoppingBagAmount, statusIndex) {
	
		var spbamount = $('#shoppingBagAmount_'+shoppingBagNo).val();
		
		var ShoppingBagModifyRequest = {
				spbNo : shoppingBagNo,
				amount : spbamount,
				different : -1
		};
	
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/myPage/shoppingBag",
			contentType	: "application/json; charset=utf-8;", 
			data :JSON.stringify(ShoppingBagModifyRequest),
			dataType : 'json',
			success : function (data) {

				if(data.isUpdateSuccess) {
					// 배열에서의 번호
					let targetShoppingBag = shoppingBagList[statusIndex];  // 쇼핑백 리스트에서 업데이트 대상 검색
					targetShoppingBag["amount"]--;  // 그놈에 수량을 1증가
					
					// 페이지에 업데이트 된 수량 반영
					var spbNo = "#shoppingBagAmount_" + shoppingBagNo;
					$(spbNo).val(targetShoppingBag["amount"]);
					 var totalprice = targetShoppingBag["price"]*targetShoppingBag["amount"];
					 console.log(totalprice);
					// 전체 가격도 수정
					$('#totalPrice_'+shoppingBagNo).html(totalprice);
					
				}
			},
			fail : function (error) {
				alert("실패");
				console.log(error);
			}
		});
	}


	function IncreaseAmount(shoppingBagNo, shoppingBagAmount, statusIndex) {
		
		var spbamount = $('#shoppingBagAmount_'+shoppingBagNo).val();
		
		var ShoppingBagModifyRequest = {
				spbNo : shoppingBagNo,
				amount : spbamount,
				different : 1
		}; 
	
	
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/myPage/shoppingBag",
			contentType	: "application/json; charset=utf-8;", 
			data :JSON.stringify(ShoppingBagModifyRequest),
			dataType : 'json',
			success : function (data) {
				
				if(data.isUpdateSuccess) {
					// 배열에서의 번호
					let targetShoppingBag = shoppingBagList[statusIndex];  // 쇼핑백 리스트에서 업데이트 대상 검색
					targetShoppingBag["amount"]++;  // 그놈에 수량을 1증가
					
					// 페이지 반영을 위한 input Id 값 생성
					var spbNo = "#shoppingBagAmount_" + shoppingBagNo;
					// 페이지에 업데이트 된 수량 반영
					$(spbNo).val(targetShoppingBag["amount"]);
					
					 var totalprice = targetShoppingBag["price"]*targetShoppingBag["amount"];
					// 전체 가격도 수정
					$('#totalPrice_'+shoppingBagNo).html(totalprice);
					
				}
				
			},
			fail : function (error) {
				alert("실패");
				console.log(error);
			}
		});
	}
	
</script>