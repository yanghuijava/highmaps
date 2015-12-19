var MyHighmaps = function(id){
	this.id = id;
	MyHighmaps.prototype.draw = function(url,params){
		this.url = url;
		this.params = params;
		$.ajax({
			type:'post',
			url:url,
			data:params,
			dataType:'json',
			success: callback,
			error:errorCallback,
		});
	}
	
	function callback(data){
		var url = this.url;
        var params = this.params;
        Highcharts.setOptions({
	        lang:{drillUpText:"返回 > 中国"}
	    });
		MyHighmaps.prototype.chart = $('#' + id).highcharts('Map',{
			chart : {
	            events: {
	                drilldown: function (e) {
	                    if (!e.seriesOptions) {
	                        var chart = this;
	                        var cname = e.point.properties["cn-name"];
	                        chart.showLoading('正在加载数据,请稍后......');
	                        //加载城市数据
	                        $.ajax({
	                        	type: "GET",
	                        	url: "http://data.hcharts.cn/jsonp.php?filename=GeoMap/json/"+ e.point.drilldown+".geo.json",
	                            contentType: "application/json; charset=utf-8",
	                            dataType:'jsonp',
	                            crossDomain: true,
	                            success: function(json) {
	                            	chart.hideLoading();
	                            	var cityData = Highcharts.geojson(json);
	                            	if(params){
	                            		params['drillKey'] = e.point.properties["drill-key"];
	                            	}else {
	                            		params = {'drillKey' : e.point.properties["drill-key"]};
	                            	}
	                            	console.log(params);
	                            	$.post(url,params,function(rersult){
	                            		$.each(cityData, function(i,e) {
	                            			var value = 0;
	                                        for(var j=0;j<rersult.series.data.length;j++){
	                                        	if(e.properties.name == rersult.series.data[j].name){
	                                        		value = rersult.series.data[j].value;
	                                        		break;
	                                        	}
	                                        }
	                                        this.value = value;
	                                    });
	                            		chart.addSeriesAsDrilldown(e.point, {
				                        	data:cityData,
		                		            name: rersult.series.name,
		                                    dataLabels: {
		                                        enabled: true,
		                                        format: '{point.properties.name}'
		                                    }
		                                });
	                            	},'json');
	                            	chart.setTitle(null, { text: cname });
	                            },
	                            error: function (XMLHttpRequest, textStatus, errorThrown) {
	                            	chart.hideLoading();
	                            }
	                        });
	                    }
	                },
	                drillup: function () {
	                    this.setTitle(null, { text: '中国' });
	                }
	            }
	        },
			title : {text :data.title},
	        subtitle : {
	            text :data.subtitle,
	            floating: true,
	            align: 'right',
	            y: 50,
	            style: {
	                fontSize: '16px'
	            }
	        },
			mapNavigation: {
	            enabled: true,
	            buttonOptions: {verticalAlign: 'bottom'}
	        },
	        colorAxis: {min: 0,minColor: '#E6E7E8',maxColor: '#005645'},
	        legend:{layout: 'vertical',align: 'right',verticalAlign: 'middle'},
	        plotOptions: {map: {states: {hover: {color: '#EEDD66'}}}},
	        series : [{
	            data : data.series.data,
	            mapData: Highcharts.maps['countries/cn/custom/cn-all-china'],
	            joinBy: data.series.joinBy,
	            name: data.series.name,
	            dataLabels: {
	                enabled: true,
	                format: '{point.properties.cn-name}'
	            }
	        }],
	        drilldown: {
	            activeDataLabelStyle: {
	                color: '#FFFFFF',
	                textDecoration: 'none',
	                textShadow: '0 0 3px #000000'
	            },
	            drillUpButton: {
	                relativeTo: 'spacingBox',
	                position: {
	                    x: 0,
	                    y: 60
	                }
	            }
	        }
		});
	}
	
	function errorCallback(XMLHttpRequest, textStatus, errorThrown){
		alert('错误');
	}
}

