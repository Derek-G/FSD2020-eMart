var app = angular.module('myApp', [ 'filters','ui.router', 'toastr' ]);

app.run(function($rootScope, $state, $stateParams) {
	$rootScope.$state = $state;
	$rootScope.$stateParams = $stateParams;
});

app.config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/index');
	$stateProvider.state('index', {
		//首页
		url : '/index',
		views : {
			'' : {
				templateUrl : 'partials/index.html'
			},
			'navbar@index' : {
				//导航条部分
				templateUrl : 'partials/navbar.html',
				controller : NavbarCtrl
			},
			'home@index' : {
				//主题部分
				templateUrl : 'partials/home.html',
				controller : HomeCtrl
			}
		}
	}).state('index.store', {
		url : '/store',
		views : {
			//店铺页面
			'home@index' : {
				templateUrl : 'partials/mystore.html',
				controller : StoreCtrl
			}
		}
	}).state('index.store.item_list', {
		//商品列表
		url : '/item_list',
		templateUrl : 'partials/item_list.html',
		controller : Item_listCtrl
	}).state('index.store.order_list', {
		//出售订单列表
		url : '/order_list',
		templateUrl : 'partials/order_list.html',
		controller : Order_listCtrl
	}).state('index.order', {
		//购买订单列表
		url : '/order',
		views : {
			'home@index' : {
				templateUrl : 'partials/myorder.html',
				controller : MyOrderCtrl
			}
		}
	});
});

