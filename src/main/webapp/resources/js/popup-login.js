$(document).ready(function(){
        //Скрыть PopUp при загрузке страницы    
        PopUpHide();
    });
    //Функция отображения PopUp
    function PopUpShow(){
        $("#popup1").show();
        var url = (appUrl == "/" ? "" : appUrl) + "/userDatas";
        console.log(url);
        $("#popup-content-id").load(url);
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