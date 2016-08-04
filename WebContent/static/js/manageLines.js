/**
 * 
 */

function deleteLine(lineId){
	if(window.confirm('删除该路线后不可恢复！您确认要删除吗？')){
		var path="delete_line_"+lineId+".do";
		$.post(path,function(data,status){
			alert("删除成功！");
			 window.location.href=window.location.href;
		  });
    }
	else{
    	 
    }
}