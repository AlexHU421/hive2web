var radio = document.querySelectorAll('input[name="ip_opr_params"]');//选中所有同名单选框
    function ok (check) {
        for(var i=0;i<radio.length;i++){//遍历同名单选框
            if(radio[i]==check){//如果点击的是当前单选框
                radio[i].setAttribute("data-checked","yes");//修改属性，设为标识
                radio[i].parentNode.childNodes[1].setAttribute('class',"aa bb");//修改类名
            }else if(radio[i].getAttribute('data-checked')){
                radio[i].removeAttribute('data-checked');
                radio[i].parentNode.childNodes[1].setAttribute('class',"aa");
            }
        }
    }