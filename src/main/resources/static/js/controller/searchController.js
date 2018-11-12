 //控制层 
app.controller('searchController' ,function($scope,$controller,searchService){	
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.score=function(){
		searchService.sorce($scope.classId).success(
			function(response){
				$scope.result=response;
				alert($scope.result);
			}			
		);
	}
    $scope.save=function(){
        searchService.save($scope.classId).success(
            function(response){
                $scope.result=response;
                alert($scope.result);
            }
        );
    }
    $scope.delete=function(){
        searchService.delete($scope.classId).success(
            function(response){
                $scope.result=response;
                alert($scope.result);
            }
        );
    }



    //$scope.searchEntity={};//定义搜索对象
	
	//搜索
	$scope.search=function(){			
		searchService.search($scope.classId).success(
			function(response){
				$scope.list=response;	
			}			
		);
	}
	
});	
