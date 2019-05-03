function fun1() {
  var result = confirm("管理员验证");
  if (result) {
    var password = prompt("请输入管理员密码：");
    if (password == "admin") {
      window.location.href = "selectAllBlog2";
    }
  } else {
    window.history.back(-1);
  }
}