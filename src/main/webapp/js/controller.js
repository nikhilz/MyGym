


var app = angular.module('app', ['ngRoute']);

app.config(function($routeProvider,	$locationProvider) {
	$locationProvider.hashPrefix('');

    $routeProvider
    .when("/", {
        redirectTo : "/login"
    }) .when("/login", { 	
        templateUrl : "view/login.html"
    }).when("/Enquiry", {
        templateUrl : "view/enquiry.html"
    }).when("/Registration", {
        templateUrl : "view/registration.html"
    }).when("/ConstantManager", {
        templateUrl : "views/admin/constantManager.html"
    }).when("/CustomerInformation", {
        templateUrl : "views/admin/customerInformation.html"
    }).when("/Reports", {
        templateUrl : "views/admin/reports.html"
    }).when("/404", {
        templateUrl : "views/error/404.html"
    }).otherwise({
    	redirectTo : '/404'
	});
});


app.controller("AppController", function($rootScope,$scope,$http,$location) {
	console.log('App Controller   '+$location.path());
	return $scope.isSpecificPage = function() {
	var path=["/","/404", "/pages/500", "/pages/login", "/pages/signin"];
	var isExist=path.indexOf($location.path());
	if(isExist == -1){
		return false;
	}else{
		return true;
	}
	}
	
}).controller('loginCtrl', function($rootScope, $scope, $http, $location) {
	$scope.login = function(){
		
		$rootScope.baseURL="http://localhost:8084/MyGym/";
		var url = $rootScope.baseURL+ "enquiry.json";
		
			
		console.log("--uname--"+$scope.uname);
		
		var data = {
            name: $scope.uname,
        };
		
		$http({
			method : 'POST',
			url: url,
			data: data,
			headers : {
                'Accept': 'application/json'
            }
			
		}).then(function successCallback(response) {
	
				$location.path('/Enquiry');		
			
			
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
		
		
//		$http.post(url, data,config).then(function (response) {
//			console.log("res--"+response.data)
//			$location.path('/Home')
//		}, function error(response) {
//			alert("ERROR");
//		});
		
		$scope.uname = "";
	}
}).controller('EnquiryCtrl', function($rootScope, $scope, $http, $location) {
	
	
	
	$scope.submitDetails = function(){
		
		var url = $rootScope.baseURL+"enquiryForm.json";
		
		var data={
				name : $scope.username,
				mobile : $scope.mobile
		}
		
		$http({
			method : 'POST',
			url: "http://localhost:8080/MyGym/enquiryForm.json",
			data: data,
			headers : {
              'Accept': 'text/plain'
              }
			
		}).then(function successCallback(response) {

				
				$scope.resp="Success!"
					
				$scope.username="";
				 $scope.mobile="";
			
			
		}, function errorCallback(response) {
			$scope.resp="Erroor!"
		});
	}
	
	$scope.username="";
	$scope.mobile="";


}).controller('RegCtrl', function($rootScope, $scope, $http, $location) {
	
	$scope.EmailErr = false;
	$scope.UsernameErr = false;
	$scope.MobileErr = false;
	$scope.AddressErr= false;

	
	$scope.submitDetails = function(){
		
		if($scope.emailID==undefined || $scope.emailID==null 
				|| $scope.mobile==null || $scope.mobile=="" 
				|| $scope.username==null || $scope.username==""
				||	$scope.address==null || $scope.address==undefined ){
			
			alert("All fields are mandatory");
		}
		
	
		if($scope.emailID==undefined || $scope.emailID==null ){
			$scope.EmailErr = true;
		}else
			$scope.EmailErr = false;
		
		if($scope.mobile==null || $scope.mobile=="" )
			$scope.MobileErr = true;
		else
			$scope.MobileErr = false;
		
		if($scope.username==null || $scope.username=="" )
			$scope.UsernameErr = true;
		else
			$scope.UsernameErr = false;
		
		if($scope.address==null || $scope.address==undefined)
			$scope.AddressErr= true;
		else
			$scope.AddressErr= false;


		if($scope.emailID==undefined || $scope.emailID==null 
				|| $scope.mobile==null || $scope.mobile=="" 
				|| $scope.username==null || $scope.username==""
				||	$scope.address==null || $scope.address==undefined ){
			
			return;
		}
		

		

	
			
			
		var url = $rootScope.baseURL+ "register.json";
		
		var data={
				name : $scope.username,
				mobile : $scope.mobile,
				email: $scope.emailID,
				address: $scope.address
		}
		
		$http({
			method : 'POST',
			url: "http://localhost:8084/MyGym/register.json",
			data: data,
			headers : {
              'Accept': 'text/plain'
              }
			
		}).then(function successCallback(response) {

				
				$scope.resp="Success!"
					
				$scope.username="";
				 $scope.mobile="";
				 $scope.emailID="";
				 $scope.address="";
			
		}, function errorCallback(response) {
			$scope.resp="Error!"
		});
	}
	
	$scope.username="";
	$scope.mobile="";


});