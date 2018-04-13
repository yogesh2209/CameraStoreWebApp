/*
    Yogesh Kohli
    CS545
    SPRING 2018
    jadrn018
*/
$(document).ready(function() {
    var cart = new shopping_cart("jadrn018");
    $('#count').text(cart.size());
});
