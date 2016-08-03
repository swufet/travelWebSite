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
	$("#loginbtn").click(function(){
		login();
	});
});
function login(){
	var loginForm=document.forms[0];
	$.post("login.do",
	{
		username:loginForm.username,
		password:loginForm.password
	},
	function(data,status){
		if(data==failed){
			alert("登录失败，请检查用户名和密码");
		}
	});
}