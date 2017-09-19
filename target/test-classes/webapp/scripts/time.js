var world = {
				init:function(num,callBack){
	                this.start(num,callBack);
	                // var that = this;
	                setInterval(function(){
	                    //找不到这个函数 在定时器里边 this的指向会发生偏移
	                    // that.start(num,dom);
	                    this.start(num,callBack);
	                }.bind(this),1000)
		},
		start:function(num,callBack){
            //8 北京时间
            var time = this.getLocalTime(num);
            // var date = new Date()
            var year = time.getFullYear();
            var month = time.getMonth()+1;
            var day = time.getDate();
            var hour = time.getHours();
            var min = time.getMinutes();
            var sec = time.getSeconds();
            var html = ''+year+'-'+month+'-'+day+' '+this.toTime(hour)+':'+this.toTime(min)+':'+this.toTime(sec)+'';
            // callBack && callBack(html);
            var json = {
                html:html
            }
            if(callBack){
                callBack.call(json);
            }
            // document.getElementById(dom).innerHTML = html;
        },getLocalTime:function(num){
            var now = new Date();
            var len = now.getTime();
            var offset = now.getTimezoneOffset()*60*1000;
            //格林尼治时间毫秒数
            var utcTime = len + offset;
            //通过传入时区 来确定不同时区的时间
            return new Date(utcTime+num*60*60*1000);
        },
        toTime:function(param){
            return param<10?'0'+param:param;
        }
		}
		 world.init(8,function(){
	            document.getElementById('time1').innerHTML = this.html;
	    });