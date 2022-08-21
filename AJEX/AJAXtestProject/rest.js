function restCall()
{
    let httpRequest = new XMLHttpRequest();
    httpRequest.open("Get","http://localhost:8080/ajaxApi/call");
    httpRequest.send();
    httpRequest.onload=function(){
        alert(httpRequest.responseText);
    }
    console.log("this is .js file");
}