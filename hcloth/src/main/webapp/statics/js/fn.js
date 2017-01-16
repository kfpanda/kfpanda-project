// 获取URL中的参数
queryUrlParam = function(key){
    var s = decodeURI(window.location.search);
    if(!s){
        return '';
    }
    s = s.replace(/^\?*/, '');
    var arr = s.split('&');
    for(var i=0; i<arr.length; i++){
        var k = '', v = '';
        if(arr[i]){
            try{
                k = arr[i].split('=')[0];
                v = arr[i].split('=')[1];
            }catch(e){ }
        }
        if(key == k){
            return v;
        }
    }
    return '';
}
// 中英文切换
$(function(){
    $('.nav .lang').on('click', 'a', function(e){
        var px = $(this).attr('la');
        location.href = location.href.replace('/en/','/' + px + '/');
    });
});