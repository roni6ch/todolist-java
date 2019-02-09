$(function() {
$(".date").each(function() {
    $(this).html(moment($(this).html()).format('L'));
});
		$("#addNewItem").click(function() {
			$.get("webapi/Todo/AddItem", {
				note : $("#note").val(),
				date : moment().format('L')
			}, function(result) {
				console.log(result);
				if (result)
					window.location.href = "index.jsp";
			})
		});
		$(".deleteItem").click(function() {
			$self = $(this);
			console.log("deleteItem: " + $(this).parent().parent().attr("id"));
			$.get("webapi/Todo/DeleteItem", {
				id :  $(this).parent().parent().attr("id") ,
			}, function(result) {
				if (result)
				$self.parent().parent().remove();
			})
		});
		$(".updateItem").click(function() {
			$self = $(this);
			var value = $(this).parent().parent().find("textarea")[0].value;
			console.log("updateItem: " + value);
			
			$.get("webapi/Todo/UpdateItem", {
				id :  $(this).parent().parent().attr("id") ,
				note : value
			}, function(result) {
				if (result){
				$self.addClass("btn-grey").addClass("disableBT");
				$self.removeClass("btn-warning");
				}
			})
		});
		$(".doneItem").click(function() {
			var status = false;
			if ($(this).hasClass("checked")){
				$(this).removeClass("checked");
				status = 0;
			}
			else{
				$(this).addClass("checked");
				status = 1;
			}
			$.get("webapi/Todo/DoneItem", {
				id :  $(this).parent().parent().parent().attr("id"),
				status: status
			}, function(result) {
			})
		});
		
		$(".note textarea").on('change keyup paste', function() {
			var updateBT = $(this).parent().parent().find(".updateItem");
			if (updateBT.hasClass("btn-grey")){
				updateBT.removeClass("btn-grey").removeClass("disableBT");
				updateBT.addClass("btn-warning");
			}
			
		});
		
	});