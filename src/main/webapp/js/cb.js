var cbApp = angular.module('cbApp', ['http-auth-interceptor', 'ngResource', 'ngRoute']);

cbApp.config(['$routeProvider',
    function ($routeProvider) {
        "use strict";
        $routeProvider
            .when('/home', {templateUrl: 'views/home.html', controller: 'HomeController'})
            .when('/', {templateUrl: 'views/login.html', controller: 'LoginController'})
            .when('/logout', {templateUrl: 'views/login.html', controller: 'LogoutController'})
            .when('/projects', {templateUrl: 'views/project.html', controller: 'ProjectController'})
            .otherwise({redirectTo : '/home'});
    }]).run(['$rootScope', '$location', 'CbAuthService', 'UserResource',
    function ($rootScope, $location, CbAuthService, UserResource) {
        "use strict";

        //Fonction utilisée lors d'un changement d'url pour vérifier si l'utilisateur est authentifié.
        $rootScope.$on("$routeChangeStart", function (event, next, current) {
            CbAuthService.authenticate(function (data) {$rootScope.user = data;});
        });

        //Fonction utilisée lorsque le serveur renvoi le code 401
        $rootScope.$on('event:auth-loginRequired', function (rejection) {
            if ($location.path() !== '/' && $location.path() !== "") {
                $location.path('/').replace();
            }
        });

        //Fonction utilisée lorsque l'utilisateur s'est authentifié
        $rootScope.$on('event:auth-authConfirmed', function () {
            if ($location.path() === '/') { //Si la page de login est demandée alors que l'utilisateur est déjà loggé
                $location.path('/home').replace();
            }
        });

        //Fonction utilisée lorsque l'utilisateur se connecte
        $rootScope.$on('event:auth-loginConfirmed', function () {
            $location.path('/home').replace();
        });

        //Fonction utilisée lorsque l'utilisateur se déconnecte
        $rootScope.$on('event:auth-loginCancelled', function () {
            $location.path('/');
        });

    }]);