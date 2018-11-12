//服务层
app.service('searchService',function($http){
	    	
	
	//搜索
	this.sorce=function(classId){
		return $http.get('http://localhost:8080/sorce?classId='+classId);
	}  
	this.search=function(classId){
		return $http.get('http://localhost:8080/getMark?classId='+classId)
	}
    this.save=function(classId){
        return $http.get('http://localhost:8080/saveClass?className='+classId)
    }
    this.delete=function(classId){
        return $http.get('http://localhost:8080/deleteClass?className='+classId)
    }
});
