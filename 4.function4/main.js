function countWords(message){
    return str.split(' ').filter(function(n) { return n != '' }).length;
  }
  countWords('Good morning, I love JavaScript.'); // should return 5