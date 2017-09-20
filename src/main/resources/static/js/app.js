var app=angular.module("myApp", ['ui.router']);

app.config(function($stateProvider, $urlRouterProvider){
	$stateProvider.state("entreprises",{
		url:"/entreprises",
		templateUrl:"views/entreprises.html",
		controller:"MyController"	
	});
	$stateProvider.state("taxes",{
		url:"/taxes",
		templateUrl:"views/taxes.html",
		controller:"TaxeController"	
	});	
	$stateProvider.state("newentreprise",{
		url:"/newentreprise",
		templateUrl:"views/newentreprise.html",
		controller:"NewEntreprise"	
	});		
});

app.controller("TaxeController", function(){
	
});

app.controller("NewEntreprise", function(){
	
});

app.controller("MyController", function($scope, $http) {
	$scope.pageEntreprise =[];
	$scope.motCle="";
	$scope.pageCourante=0;
	$scope.size=5;
	$scope.pages=[];
	$scope.cherche=function(){
		$http.get("http://localhost:8082/listeentreprise?" +
				"motCle="+$scope.motCle+
				 "&page="+$scope.pageCourante+
				 "&size="+$scope.size)
		.success(function(data){
			$scope.pageEntreprise = data;
			$scope.pages= new Array (data.totalPages);
			
		})
		.error(function(err){
			Console.log(err);
		});
	}
	$scope.gotopage=function(p){
		$scope.pageCourante=p;
		$scope.cherche();
		
	}
	
	
});