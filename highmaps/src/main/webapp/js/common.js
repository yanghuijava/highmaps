function showMessager(msg) {
	$.messager.show({
        title:'提示',
        msg:msg,
        timeout:3000,
        showType:'show'
    });
}

function templateDownload(fileName){
	window.location = 'templatedownload/' + fileName + '.html';
}

