function exportExcel(url,name){
    var xhr = new XMLHttpRequest();
    xhr.open("POST",url);
    xhr.responseType ='blob';
    xhr.onreadystatechange=function(){
        if (xhr.readyState==4){
            if (xhr.status==200 || xhr.status==304){
                // console.log(xhr.response);
                var data = xhr.response;
                const link = document.createElement('a');
                const blob = new Blob([data], { type: 'application/vnd.ms-excel' });
                link.style.display = 'none';
                link.href = URL.createObjectURL(blob);
                link.setAttribute('download', `${name}.xls`);
                document.body.appendChild(link);
                link.click();
                document.body.removeChild(link);
            }else{
                console.log('服务器错误');
            }
        }
    };
    xhr.send();
}