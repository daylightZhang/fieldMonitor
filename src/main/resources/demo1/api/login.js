$("button").click(function(){
  $.post("/user/login",
  {
    "username":$("#userEmail").val(),
    "password":$("#userPassword").val(),

  })


});