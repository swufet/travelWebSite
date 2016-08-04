//实例化编辑器
UEDITOR_CONFIG.UEDITOR_HOME_URL = 'static/ueditor/';
var ue=UE.getEditor('intr-editor',{
	initialFrameWidth:400,
	initialFrameHeight:300,
	toolbars: [[
            'source', '|', 'undo', 'redo', '|',
            'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 
            'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', 
            'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
            'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
            'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
            'directionalityltr', 'directionalityrtl', 'indent', '|',
            'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
            'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
            'simpleupload', 'insertimage', 'emotion', 'scrawl', 'attachment', 'map', 
            'gmap', 'pagebreak', 'template', 'background', '|',
            'horizontal', 'date', 'time', 'spechars',  'wordimage', '|',
            'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 
            'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 
            'splittorows', 'splittocols', 'charts', '|',
            'preview', 'searchreplace', 'help', 'drafts'
        ]],
});


$(document).ready(function(){
	$("#uploadbtn").click(function(){//上传图片
		if ($("#upfile").val() != "") {
			ajaxFileUpload();
		}
		else{
			alert("请先选择图片再点击上传！");
		}
	});
	
});

function ajaxFileUpload() {
	$.ajaxFileUpload({
		
		url : 'uploadImg.do', // 用于文件上传的服务器端请求地址
		secureuri : false, // 一般设置为false
		fileElementId : 'upfile', // 文件上传空间的id属性 <input type="file"
		// id="file"
		dataType : 'HTML', // 返回值类型 一般设置为json
		success : function(data, status) // 服务器成功响应处理函数
		{
			if (data == "") {
				alert("图片上传失败！");
			} else {
					alert("图片上传成功!");
					$("#coverImgPath").attr("value", data);
					$("#title-preview-img").css("background-image", "url("+data+")");
					var lineTitle=$("#line-title").val();
					$("#title-preview-text").html(lineTitle);
			}
			if (typeof (data.error) != 'undefined') {
				if (data.error != '') {
					alert(data.error);
				} else {
					alert(data.msg);
				}
			}
		},
		error : function(data, status, e)// 服务器响应失败处理函数
		{
			alert(e);
		}
	});

	return false;
}