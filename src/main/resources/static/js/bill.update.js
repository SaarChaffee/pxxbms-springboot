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
  let goodCode = $('#goodCode')
  let goodName = $('#goodName')
  let inventory = $('#inventory')
  let goodPrice = $('#goodPrice')
  let quantity = $('#quantity')
  let totalPrice = $('#totalPrice')
  let customerCode = $('#customerCode')
  let customerName = $('#customerName')
  let billBtn = $('#upd_btn')
  $.ajax(path + '/good/get/' + goodCode.val(), {
    success: (data) => {
      goodName.val(data.data.goodName)
      inventory.val(data.data.inventory)
    }
  })
  $.ajax(path + '/user/get/' + customerCode.val(), {
    success: (data) => {
      customerName.val(data.data.userName)
    }
  })
  
  
  quantity
      .on("blur", () => {
        if (quantity.val() !== "" && quantity.val() !== null) {
          if (/\d+/.test(quantity.val())) {
            if (Number(quantity.val() )> Number(inventory.val())) {
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
  
  billBtn
      .bind('click', () => {
        if (
            goodPrice.attr('status') === 'true' &&
            quantity.attr('status') === 'true') {
          if (confirm('是否提交数据')) {
            billForm.submit()
          }
        }
      })
  
  
})
