
var TopLast=0;
$(document).ready(function(){
	window.onscroll = function() {
		scrollActive();
	} //滚动监听
});
function scrollActive() {
	//当前距离网页顶部的高度
	var topNow = document.documentElement.scrollTop || document.body.scrollTop;
	if(topNow>50)
	{
		if(topNow>=TopLast){//淡出动画
			$("#serch-nav").css("display","none");
		}
		if(topNow<TopLast){//淡入动画
			$("#serch-nav").css("display","block");
		}
	}
	TopLast=topNow;
}