
var proj2_data;
$(document).ready(function() {


 proj2_data = new Array();
 var ab =  $.get('http://jadran.sdsu.edu/jadrn018/servlets/servlet/GetProducts', storeData);
 var cart = new shopping_cart("jadrn018");

 $('#count').text(cart.size());

 $('#content').on('click',$('input[type="button"]'), function(e) {
     if($(e.target).val() != 'Add to Cart') return;

     });
     $(document).on('click', ".cart_button", function() {
         var sku = this.name;
         cart.add(sku,1);
         $('#count').text(cart.size());
         $(this).css('display', 'inline-block');
         $(this).next().fadeIn(50).fadeOut(3000);
    });

 //Search button action here
$(':submit').on('click', function(e) {
       e.preventDefault();
      //Get data from drop down and pass it to servlet file
    var brand  = document.getElementById("brand_id").value;
    var category =  document.getElementById("category_id").value;
    var  params = "brand=" + brand + "&category=" + category;
    var url = 'http://jadran.sdsu.edu/jadrn018/servlets/servlet/FilterProducts?'+params;
    $.get(url, getdata);
   });
});

function getdata(response) {

  proj2_data = new Array();
  var tmpArray = response.split(";");
  tmpArray.pop();
  for(var i=0; i < tmpArray.length; i++) {
      innerArray = tmpArray[i].split("|");
      innerArray.pop();
      proj2_data[i] = innerArray;
      }
      displayData(proj2_data);
}

function storeData(response) {

   proj2_data = new Array();
    var tmpArray = response.split(";");
    tmpArray.pop();
    for(var i=0; i < tmpArray.length; i++) {
        innerArray = tmpArray[i].split("|");
        innerArray.pop();
        proj2_data[i] = innerArray;
        }
        displayData(proj2_data);
  }

function displayData(arrayData) {
  tmpString = "";
  var customTitleBtn = "";
  var enabledString = "";

  for(var i=0; i < arrayData.length; i++) {

    tmpString += "<img src=\"http://jadran.sdsu.edu/~jadrn018/proj1/images/"+
                              arrayData[i][9]+"\" alt=\""+arrayData[i][9]+"\""+
                              " width=\"200px\"  />";

          for(var j=0; j < arrayData[i].length; j++)
                  {

                  if (j == 0 || j == 3 || j == 6) {
                  }
                  else{
                        if (j == 2) {
                           tmpString +=  "<h2>" + arrayData[i][j-1] + ", " + arrayData[i][j] + "</h2>";
                        }
                        else if (j == 4) {
                              tmpString +=  "<h6>" + arrayData[i][j] + "</h6>";
                        }
                        else if (j == 5) {
                              tmpString +=  "<p>" + arrayData[i][j] + "<p>";
                        }
                        else if (j == 7) {
                         tmpString +=  "<h4 id = 'price'>" + " $" + arrayData[i][j] + "</h4>";
                        }
                        else if (j == 8) {
                          if (arrayData[i][j] == 0) {
                            customTitleBtn = "COMING SOON";
                            enabledString = "disabled";
                          }
                          else {
                            customTitleBtn = "ADD TO CART";
                            enabledString = "enabled";
                          }
                        }
                      }
              }

          tmpString += "<input type='button' id = 'product_button_id' class = 'cart_button' value='" + customTitleBtn + "' " +
              "name='" + arrayData[i][0] + '%' + arrayData[i][7] + "'"  +  enabledString  +  " />";
          tmpString += "<span class='cart_span'>Added to Cart</span><br /><br /><hr />";

  var handle = document.getElementById('content');
  handle.innerHTML = tmpString;
  }
}
