var fruit = {
    apple: 20,
    pear: 20,
    peach: 10
};

let sum = 0;
for (let key in fruit) {
  sum += fruit[key];
}

alert(sum);