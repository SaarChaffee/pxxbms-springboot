let data_picker = $('.data-picker')
let userCode = $('#userCode')
let passWord = $('#passWord')
let resurePassword = $('#resurePassword')
data_picker.datetimepicker({
  language: 'zh-CN',
  format: 'yyyy-mm-dd',
  initialDate: data_picker.val(),
  autoclose: true,
  minView: 2,
  startDate: new Date(new Date().getFullYear() - 100, new Date().getMonth(), new Date().getDate()).toLocaleDateString(),
  endDate: new Date().toLocaleDateString(),
})
$(() => {
  userCode.bind("blur", () => {
    if (userCode.val() != null && userCode.val() !== "") {
      //ajax后台验证--userCode是否已存在
      $.ajax({
        type: "GET",//请求类型
        url: "./exist",//请求的url
        data: {userCode: userCode.val()},//请求参数
        dataType: "json",//ajax接口（请求url）返回的数据类型
        success: function (data) {//data：返回数据（json对象）
          if (data.success === true) {//账号已存在，错误提示
            userCode.next().attr('class', 'alert alert-danger form-control')
            userCode.next().text("账号已存在")
          } else {//账号可用，正确提示
            userCode.next().attr('class', 'alert alert-success form-control')
            userCode.next().text("账号可用")
          }
        },
        error: function (data) {//当访问时候，404，500 等非200的错误状态码
          userCode.next().attr('class', 'alert alert-warning form-control')
          userCode.next().text("网络异常")
        }
      });
    } else {
      userCode.next().class = 'sr-only'
    }
  })
  passWord
      .bind("focus", () => {
        passWord.next().attr('class', 'alert alert-info form-control')
        passWord.next().text('密码长度必须是大于等于3小于等于20')
      })
      .bind("blur", () => {
        if (passWord.val() != null && passWord.val() !== "" && passWord.val().length >= 3
            && passWord.val().length <= 20) {
          passWord.next().attr('class', 'sr-only')
        } else {
          passWord.next().attr('class', 'alert alert-danger form-control')
          passWord.next().text('密码输入不符合规范，请重新输入')
        }
      })
  
  resurePassword
      .bind("focus", () => {
        resurePassword.next().attr('class', 'alert alert-info form-control')
        resurePassword.next().text('再次输入密码')
      })
      .bind("blur", () => {
        if (resurePassword.val() != null && resurePassword.val() !== "" && resurePassword.val().length >= 3
            && resurePassword.val().length <= 20 && passWord.val() === resurePassword.val()) {
          resurePassword.next().attr('class', 'sr-only')
        } else {
          if (resurePassword.val() == null || resurePassword.val() == "") {
            resurePassword.next().attr('class', 'sr-only')
          } else {
            resurePassword.next().attr('class', 'alert alert-danger form-control')
            resurePassword.next().text('两次密码输入不正确，请重新输入')
          }
        }
      })
})
