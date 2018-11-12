app.controller('baseController' ,function($scope){
	//空间加载的时候，自动促发加载方法，对页面进行自动更改
	//分页控件配置 
	$scope.paginationConf = {
			 currentPage: 1,
			 totalItems: 10,
			 itemsPerPage: 10,
			 perPageOptions: [10, 20, 30, 40, 50],
			 onChange: function(){
			      $scope.reloadList();//重新加载
			 }
	}; 
	
	$scope.reloadList=function(){
	    /* //切换页码  
		$scope.findPage( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage); */
	    
	    //条件查询的页码切换与刷新
		$scope.search( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);	
		};
	
	//批量删除品牌项
	$scope.selectIds=[];//选中的ID集合 
	
	//更新复选
	$scope.updateSelection = function($event, id) {		
			if($event.target.checked){//如果是被选中,则增加到数组
					$scope.selectIds.push(id);			
			}else{
					//如果取消选中则将id移除
					var idx = $scope.selectIds.indexOf(id);
			         $scope.selectIds.splice(idx,1);//删除 
			}
	};		 
	
	//对所有传递的对象参数searchEntity进行初始化操作
	//避免初次条件访问的时候，产生未定义对象的情况
	$scope.searchEntity={};
	
	//页面显示内容的转化
	$scope.jsonToString=function(jsonString,key){
		var json=JSON.parse(jsonString);//将json字符串转换为json对象
		var value="";
		for(var i=0;i<json.length;i++){		
			if(i>0){
				value+=","
			}
			value+=json[i][key];			
		}
		return value;
	}

});
