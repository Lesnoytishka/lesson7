let StudentsList = angular.module('StudentsList', []);

StudentsList.controller('StudentsListController', function ($scope, $http) {

    $http.get("http://localhost:8900/api/students/v1")
        .then(
            resp => {
                $scope.studentsListEntities = resp.data;
            },
            resp => {
                console.error(resp);
            }
        );

    $scope.delete = function (studentId) {
        $http.delete("http://localhost:8900/api/students/v1/" + studentId + "/remove")
            .then(
                resp => {
                    let id = $scope.studentsListEntities.map(student => student.id).indexOf(studentId);
                    $scope.studentsListEntities.splice(id, 1);
                },
                resp => {
                    console.error(resp);
                });
    }

    $scope.studentId = '';
    $scope.studentName = '';
    $scope.studentAge = '';

    $scope.createStudent = function (id, name, age) {
        if (id === '') {
            $http.post("http://localhost:8900/api/students/v1", {'name': name, 'age': age})
                .then(
                    resp => {
                        $scope.studentsListEntities.push(resp.data);
                    },
                    resp => {
                        console.error(resp);
                    });
        } else {
            $http.post("http://localhost:8900/api/students/v1", {'id': id, 'name': name, 'age': age});
            location.href = location.href;
        }

        $scope.studentId = '';
        $scope.studentName = '';
        $scope.studentAge = '';
    }

    $scope.checkStudent = function (id, name, age) {
        $scope.studentId = id;
        $scope.studentName = name;
        $scope.studentAge = age;
    }

});