var num;

for (num = 0; num <21; num++){
    if (num % 2 == 0){
        document.getElementById("displayNum").innerHTML = num + "is even number." + "<br>";
    } else {
        document.getElementById("displayNum").innerHTML = num + "is odd number." + "<br>";
    }
}