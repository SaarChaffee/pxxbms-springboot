function priceReg(value) {
  value = value.replace(/[^\d.]/g, "");  //清除“数字”和“.”以外的字符
  value = value.replace(/^\./g, "");  //验证第一个字符是数字而不是.
  value = value.replace(/\.{2,}/g, "."); //只保留第一个. 清除多余的.
  value = value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");//去掉特殊符号￥
  if (value.indexOf(".") > 0) {
    value = value.substring(0, value.indexOf(".") + 3);
  }
  return value;
}

//解决精度丢失问题
function accMul(arg1, arg2) {
  var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
  try {
    m += s1.split(".")[1].length
  } catch (e) {
  }
  try {
    m += s2.split(".")[1].length
  } catch (e) {
  }
  return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m)
}

$(() => {
  let path = $('#path').val()
  let billForm = $('#billForm')
  let billCode = $('#billCode')
  let goodCode = $('#goodCode')
  let goodName = $('#goodName')
  let goodId = $('#goodId')
  let inventory = $('#inventory')
  let goodPrice = $('#goodPrice')
  let quantity = $('#quantity')
  let totalPrice = $('#totalPrice')
  let customerCode = $('#customerCode')
  let customerId = $('#customerId')
  let customerName = $('#customerName')
  let billBtn = $('#billBtn')
  
  billCode
      .bind("blur", () => {
        if (billCode.val() != null && billCode.val() !== "") {
          $.ajax({
            type: 'GET',
            url: path + '/bill/exist',
            data: {billCode: billCode.val()},
            dataType: 'json',
            success: (data) => {
              if (data.success === true) {
                billCode.next().attr('class', 'alert alert-danger form-control')
                billCode.attr('status', 'false')
                billCode.next().text('订单编号已存在')
              } else {
                billCode.next().attr('class', 'alert alert-success form-control')
                billCode.attr('status', 'true')
                billCode.next().text('订单编号可用')
              }
            },
            error: (err) => {
              billCode.next().attr('class', 'alert alert-warning form-control')
              billCode.next().text('网络异常')
            }
          })
        } else {
          billCode.next().class = 'sr-only'
        }
      })
  
  goodCode
      .bind("blur", () => {
        if (goodCode.val() != null && goodCode.val() !== "") {
          $.ajax({
            type: 'GET',
            url: path + '/good/exist',
            data: {goodCode: goodCode.val()},
            dataType: 'json',
            success: (data) => {
              if (data.success === true) {
                goodCode.next().attr('class', 'alert alert-success form-control')
                goodCode.next().text("商品查找成功")
                goodCode.attr('status', 'true')
                goodId.val(data.data.id)
                goodName.val(data.data.goodName)
                inventory.val(data.data.inventory)
                inventory.next().attr('class', 'alert alert-info form-contro')
                inventory.next().text('商品库存：' + data.data.inventory)
              } else {
                goodCode.next().attr('class', 'alert alert-danger form-control')
                goodCode.next().text("商品不存在")
                goodCode.attr('status', 'false')
              }
            },
            error: (err) => {
              goodCode.next().attr('class', 'alert alert-warning form-control')
              goodCode.next().text("网络异常")
            }
          })
        } else {
          goodCode.next().class = 'sr-only'
        }
      })
  
  quantity
      .on("blur", () => {
        if (quantity.val() !== "" && quantity.val() !== null) {
          if (/\d+/.test(quantity.val())) {
            if (quantity.val() > inventory.val()) {
              quantity.next().attr('class', 'alert alert-danger form-control')
              quantity.next().text('库存不足')
              totalPrice.val('');
              quantity.attr('status', 'false')
            } else {
              quantity.attr('status', 'true')
              quantity.next().attr('class', 'sr-only')
              if (goodPrice.val() !== null && goodPrice.val() !== "") {
                totalPrice.val(accMul(quantity.val(), goodPrice.val()));
              }
            }
          } else {
            quantity.next().attr('class', 'alert alert-danger form-control')
            quantity.next().text('格式不正确，请输入正整数')
            totalPrice.val('');
            quantity.attr('status', 'false')
          }
        } else {
          quantity.next().attr('class', 'sr-only')
        }
      });
  
  goodPrice
      .on("blur", function () {
        goodPrice.val(priceReg(goodPrice.val()))
        if (goodPrice.val() !== "" && goodPrice.val() !== null) {
          if (/^\d+\.?\d*$/.test(goodPrice.val())) {
            goodPrice.attr('status', 'true')
            goodPrice.next().attr('class', 'sr-only')
            if (quantity.val() !== "" && quantity.val() !== null) {
              totalPrice.val(accMul(goodPrice.val(), quantity.val()));
            }
          } else {
            quantity.next().attr('class', 'alert alert-danger form-control')
            quantity.next().text('格式不正确')
            totalPrice.val('');
            quantity.attr('status', 'false')
          }
        } else {
          quantity.next().attr('class', 'sr-only')
        }
      });
  
  customerCode
      .bind('blur', () => {
        if (customerCode.val() != null && customerCode.val() !== '') {
          $.ajax({
            type: 'GET',
            url: path + '/user/exist',
            data: {userCode: customerCode.val()},
            dataType: 'json',
            success: (data) => {
              if (data.success === true) {
                customerId.val(data.data.id)
                customerName.val(data.data.userName)
                customerCode.next().attr('class', 'alert alert-success form-control')
                customerCode.next().text('顾客查找成功')
                customerCode.attr('status', 'true')
              } else {
                customerCode.next().attr('class', 'alert alert-danger form-control')
                customerCode.next().text('顾客不存在')
                customerCode.attr('status', 'false')
                customerId.val('')
                customerName.val('')
              }
            },
            error: (err) => {
              customerCode.next().attr('class', 'alert alert-warning form-control')
              customerCode.next().text("网络异常")
            }
          })
        } else {
          customerCode.next().class = 'sr-only'
        }
      })
  
  billBtn
      .bind('click', () => {
        if (billCode.attr('status') === 'true' &&
            goodCode.attr('status') === 'true' &&
            goodPrice.attr('status') === 'true' &&
            quantity.attr('status') === 'true' &&
            customerCode.attr('status') === 'true') {
          if (confirm('是否提交数据')) {
            billForm.submit()
          }
        }
      })
  
  
})
