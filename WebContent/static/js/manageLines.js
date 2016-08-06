/**
 * 
 */

function deleteLine(lineId){
	if(window.confirm('删除该资料后不可恢复！您确认要删除吗？')){
		var path="delete_line_"+lineId+".do";
		$.post(path,function(data,status){
			 window.location.href=window.location.href;
		  });
    }
	else{
    	 
    }
}