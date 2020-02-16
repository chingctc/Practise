var display="";
for(a=1;a<10;a++){
    for(b=1;b<=a;b++){
        display+=a+"x"+b+"="+(a*b)+" "
    }
    display+="<br>";
}
document.getElementById("outputDiv").innerHTML = display;