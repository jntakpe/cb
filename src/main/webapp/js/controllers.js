cbApp.controller('HomeController', ['$scope', function ($scope) {
    "use strict";
}]);

cbApp.controller('LoginController', ['$scope', '$location', 'CbAuthService',
    function ($scope, $location, CbAuthService) {
        "use strict";
        $scope.login = function () {
            CbAuthService.login($scope.username, $scope.password, $scope.rememberMe,
                function () {
                    $location.path('/home')
                },
                function () {
                    $scope.displayFailLogin = true;
                });
        };
    }]);

cbApp.controller('LogoutController', ['$scope', '$location', 'CbAuthService',
    function ($scope, $location, CbAuthService) {
        "use strict";
        CbAuthService.logout(function () {
            $location.path('')
        });
    }]);

cbApp.controller('ProjectController', ['$scope', 'ProjectResource',
    function ($scope, ProjectResource) {

    }]);