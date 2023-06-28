$("div").on("click", function(){


    if($(this).next("p").css("display") == "none"){

        $(this).siblings(".contents").slideUp();
        $(this).next().slideDown();

    }else{ // p가 보이고 있는 상태라면

        $(this).next().slideUp();

    }

})


