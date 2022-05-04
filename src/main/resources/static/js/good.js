$(() => {
  let goodCode = $('#goodCode')
  let ownerCode = $('#ownerCode')
  let ownerName = $('#ownerName')
  let owner = $('#owner')
  let goodForm = $('#goodForm')
  let goodBtn = $('#goodBtn')
  let updBtn = $('#updBtn')
  let path = $('#path').val()
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
                goodCode.next().attr('class', 'alert alert-danger form-control')
                goodCode.next().text("商品编号已存在")
                goodCode.attr('status', 'false')
              } else {
                goodCode.next().attr('class', 'alert alert-success form-control')
                goodCode.next().text("商品编号可用")
                goodCode.attr('status', 'true')
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
  
  ownerCode
      .bind("blur", () => {
        if (ownerCode.val() != null && ownerCode.val() !== "") {
          $.ajax({
            type: 'GET',
            url: path + '/user/exist',
            data: {userCode: ownerCode.val()},
            dataType: 'json',
            success: (data) => {
              if (data.success === true) {
                ownerName.val(data.data.userName)
                owner.val(data.data.id)
                ownerCode.attr('status', 'true')
              } else {
                ownerCode.next().attr('class', 'alert alert-danger form-control')
                ownerCode.next().text("商家账号不存在")
                ownerCode.attr('status', 'false')
                ownerName.val('')
                owner.val('')
              }
            },
            error: (err) => {
              console.log(err)
              ownerCode.next().attr('class', 'alert alert-warning form-control')
              ownerCode.next().text("网络异常")
              ownerCode.attr('status', 'false')
              ownerName.val('')
              owner.val('')
            }
          })
        } else {
          ownerCode.next().class = 'sr-only'
          ownerName.val('')
          owner.val('')
        }
      })
  
  goodBtn
      .bind('click', () => {
        if (goodCode.attr('status') === 'true' &&
            ownerCode.attr('status') === 'true') {
          if (confirm("是否确认提交数据")) {
            goodForm.submit()
          }
        }
      })
  
  updBtn
      .bind('click', () => {
        if (ownerCode.attr('status') === 'true') {
          if (confirm("是否确认提交数据")) {
            goodForm.submit()
          }
        }
      })
})
