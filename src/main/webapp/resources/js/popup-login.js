$(document).ready(function(){
        //Скрыть PopUp при загрузке страницы    
        PopUpHide();
    });
    //Функция отображения PopUp
    function PopUpShow(){
        $("#popup1").show();
        $("#popup-content-id").load(appUrl + "/userDatas");
    }
    //Функция скрытия PopUp
    function PopUpHide(){
        $("#popup1").hide();
    }

$("popup1").on("click", function(e){
  e.stopPropagation();
});

$(document).on("click", function() {
  $("#popup1").hide();
});