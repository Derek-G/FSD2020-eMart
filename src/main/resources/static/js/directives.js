'use strict';

/* Directives */

var myModule = angular.module('myApp.directives', []);

myModule.directive('appVersion', [ 'version', function(version) {
	return function(scope, elm, attrs) {
		elm.text(version);
	};
} ]);

myModule.directiove("appNav", function() {
	
});
